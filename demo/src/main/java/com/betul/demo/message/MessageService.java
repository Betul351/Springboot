package com.betul.demo.message;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessagePrinter messagePrinter;

    public MessageService(MessagePrinter messagePrinter){
        this.messagePrinter = messagePrinter;
    }

    public String showMessage(){
        String message = messagePrinter.printMessage();
        System.out.println(message);
        return message;
    }

}
