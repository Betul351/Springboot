package com.betul.demo.message;

import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    public String printMessage(){
        return "Hoş geldiniz." ;
    }

}
