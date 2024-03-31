package com.andre.ioc_di;

import org.springframework.stereotype.Service;

@Service
public class MyComponent {
    
    public String myComponent() {
        return "Chamou o componente.";
    }
}
