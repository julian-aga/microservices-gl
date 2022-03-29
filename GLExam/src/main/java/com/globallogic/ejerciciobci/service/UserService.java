package com.globallogic.ejerciciobci.service;

import com.globallogic.ejerciciobci.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto userSave(UserDto userDto);
    UserDto update(UserDto userDto);
    List<UserDto> findAll();
    UserDto findById(Long id);
    void deleteById(Long id);

}
