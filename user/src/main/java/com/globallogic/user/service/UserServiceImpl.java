package com.globallogic.user.service;

import com.globallogic.user.dto.UserDto;
import com.globallogic.user.entity.User;
import com.globallogic.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.ZoneOffset.UTC;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;
    final ModelMapper mapper;

    @Override
    public UserDto userSave(UserDto userDto) {

        User user = mapper.map(userDto, User.class);
        user.setToken(this.createToken(user.getEmail()));
        return mapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto update(UserDto userDto) {
        User user2 = mapper.map(userDto, User.class);
        return mapper.map(userRepository.save(user2), UserDto.class);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user->mapper.map(user,UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return mapper.map(user,UserDto.class);
    }
    @Override
    public void deleteById(Long id) {
        userRepository.findById(id);
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
