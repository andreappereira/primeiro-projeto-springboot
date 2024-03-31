package com.andre.ioc_di;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/component")
public class MyComponentController {

    @Autowired
    MyComponent myComponent;
    
    @GetMapping("/")
    public String getMethodNamComponent() {
        var response = myComponent.myComponent();
        return response;
    }
    
}
