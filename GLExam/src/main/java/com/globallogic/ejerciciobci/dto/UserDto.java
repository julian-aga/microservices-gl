package com.globallogic.ejerciciobci.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String token;
    private LocalDate created;
    private LocalDate modified;
    private boolean isActive;
    private Set<PhonesDto> phones = new HashSet<>();

}
