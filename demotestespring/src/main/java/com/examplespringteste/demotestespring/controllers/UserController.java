package com.examplespringteste.demotestespring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examplespringteste.demotestespring.model.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/add")

public class UserController{

@GetMapping("/{id}/{nome}")
public User add(@PathVariable("nome") String nome,@PathVariable("id") Long id){
    User u = new User(id,nome);
    return u;
}

@PostMapping("/")
public User add2(@RequestBody User user){

    User u = new User();
    u = user; 
    return u;
}

}