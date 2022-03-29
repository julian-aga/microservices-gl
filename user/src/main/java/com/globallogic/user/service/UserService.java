package com.globallogic.user.service;

import com.globallogic.user.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto userSave(UserDto userDto);
    UserDto update(UserDto userDto);
    List<UserDto> findAll();
    UserDto findById(Long id);
    void deleteById(Long id);

}
