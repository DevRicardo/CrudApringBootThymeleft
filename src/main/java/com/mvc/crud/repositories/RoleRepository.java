package com.mvc.crud.repositories;

import java.util.List;

import com.mvc.crud.entities.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();

}