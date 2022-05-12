package com.globallogic.ejerciciobci.controller;

import com.globallogic.ejerciciobci.dto.UserDto;
import com.globallogic.ejerciciobci.restUtils.RestUtils;
import com.globallogic.ejerciciobci.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> users() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> user(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> user(@RequestParam String phone) {
        return new ResponseEntity<>(userService.addPhone(phone), HttpStatus.OK);
    }

    @GetMapping("/{id}/phones/{phoneId}")
    public ResponseEntity<Object> user(@PathVariable("id") Long id, @PathVariable("phoneId") Long phoneId) {
        return new ResponseEntity<>(userService.findPhone(id,phoneId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> userSave(@RequestBody UserDto userDto) {
        return ResponseEntity.created(RestUtils.getUserLocation(userService.userSave(userDto))).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> userUpdate(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.update(userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity userDelete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
