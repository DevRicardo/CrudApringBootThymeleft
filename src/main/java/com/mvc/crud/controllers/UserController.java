package com.mvc.crud.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import com.mvc.crud.entities.Role;
import com.mvc.crud.entities.User;
import com.mvc.crud.repositories.RoleRepository;
import com.mvc.crud.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = this.userService.list();

        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        List<Role> roles = this.roleRepository.findAll();

        model.addAttribute("roles", roles);
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/save")
    public String save(@Valid User requestUser, Model model ){
        this.userService.save(requestUser);

        return "redirect:/user/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        List<Role> roles = this.roleRepository.findAll();

   

        User user = this.userService.get(id).
                                orElseThrow(()-> new EntityNotFoundException("No se encuentra el usuario"));

        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "update-user";
        
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, User user , Model model) {
        List<Role> roles = this.roleRepository.findAll();

        this.userService.save(user);

        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "update-user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {

        User user = this.userService.get(id).orElseThrow(()->
            new EntityNotFoundException("El usuario no fue encontrado")
        );

        this.userService.delete(user);
        
        return "redirect:/user/index";
    }

}