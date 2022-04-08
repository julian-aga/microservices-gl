package com.globallogic.ejerciciobci.restUtils;

import com.globallogic.ejerciciobci.dto.UserDto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class RestUtils {

    public static URI getUserLocation(UserDto user) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
    }

}
