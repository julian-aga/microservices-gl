package com.globallogic.ejerciciobci.service;

import com.globallogic.ejerciciobci.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static java.time.ZoneOffset.UTC;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    final UserRepository userRepository;
    final UserServiceClient userServiceClient;
    final ModelMapper mapper;

    @Override
    public UserDto userSave(UserDto userDto) {
        userDto.setToken(this.createToken(userDto.getEmail()));
        return userServiceClient.userSave(userDto);
    }

    @Override
    public UserDto update(UserDto userDto) {
        return userServiceClient.userUpdate(userDto);
    }

    @Override
    public List<UserDto> findAll() {
        return userServiceClient.getUsers();
    }

    @Override
    public UserDto findById(Long id) {
        return userServiceClient.userById(id);
    }

    @Override
    public void deleteById(Long id) {
        userServiceClient.userDelete(id);
    }

    @Override
    public Object addPhone(String phone) {
        return null;
    }

    @Override
    public Object findPhone(Long id, Long phoneId) {
        return null;
    }

    private String createToken(String username) {
        Claims claims = Jwts.claims().setSubject(username);
        Date expiration = Date.from(LocalDateTime.now(UTC).plusMinutes(60).toInstant(UTC));
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, "secretKey")
                .compact();
    }
}
