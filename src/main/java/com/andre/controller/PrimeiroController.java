package com.andre.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;


@RestController
@RequestMapping("/primeiroController")
public class PrimeiroController {

    @GetMapping("/primeiroMetodo")
    public String getPrimeiroMetodo() {
        return "Hello World! My fisrt method, rest api on spring boot.";
    }

    @GetMapping("/primeiroParametro/{id}")
    public String getPrimeiroParametro(@PathVariable String id) {
        return "The param is " + id;
    }
    
    @GetMapping("/metodoComQueryParams")
    public String getMetodoComQueryParams(@RequestParam String name) {
        return "Method whith query params, the query is " + name;
    }

    @GetMapping("/metodoComQueryParams2")
    public String getMetodoComQueryParams2(@RequestParam Map<String, String> allParams) {
        return "Method whith query params, the query is " + allParams.entrySet();
    }

    @PostMapping("/metodoComBodyParams")
    public String postMetodoComBodyParams(@RequestBody String entity) {
        return"Method with params " + entity;
    }

    @PostMapping("/metodoComBodyParams2")
    public String postMetodoComBodyParams2(@RequestBody User entity) {        
        return"Method with params " + entity.username;
    }

    @PostMapping("/metodoComHeaders")
    public String postMetodoComHeaders(@RequestHeader("name") String entity) {        
        return"Method with headers " + entity;
    }

    @PostMapping("/metodoComHeadersList")
    public String postMetodoComHeadersList(@RequestHeader Map<String, String> entity) {
         
        return "Method with headers list " + entity.entrySet();
    }

    @GetMapping("/metodoResposneEntity/{id}")
    public ResponseEntity<Object> getmetodoResposneEntity(@PathVariable Long id) {
        var user = new User("Andre");
        
        if(id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.badRequest().body("Numero menor que 5");
    }
    
    record User(String username) {
    }
    
}
