package com.mvc.crud.services;

import java.util.List;

import com.mvc.crud.entities.Role;
import com.mvc.crud.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public Role save(Role role) {
        return this.roleRepository.save(role);
    }

    public List<Role> list() {
        return this.roleRepository.findAll();
    }

    public void delete(Role role){
        this.roleRepository.delete(role);
    }

}