package com.globallogic.ejerciciobci.repository;

import com.globallogic.ejerciciobci.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{


}
