package com.globallogic.ejerciciobci.repository;

import com.globallogic.ejerciciobci.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
