package com.globallogic.ejerciciobci.service;

import com.globallogic.ejerciciobci.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "user-service", url = "localhost:8002/")
public interface UserServiceClient {


    @GetMapping(value = "user/users")
    public List<UserDto> getUsers();

    @PostMapping(value = "user/save")
    public UserDto userSave(UserDto userDto);

}
