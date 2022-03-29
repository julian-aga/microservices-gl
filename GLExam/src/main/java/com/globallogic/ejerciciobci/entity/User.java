package com.globallogic.ejerciciobci.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String token;

    private LocalDate created;

    private LocalDate modified;

    private boolean isActive = true;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Phone> phones = new HashSet<>();

    @PrePersist
    private void prePersist(){
        this.created=LocalDate.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.modified=LocalDate.now();
    }


}
