package stormtechio.handshake.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import stormtechio.handshake.interfaces.ChatInterface;
import stormtechio.handshake.interfaces.ContactInterface;
import stormtechio.handshake.interfaces.UserInterface;

@SpringBootApplication
public class HandshakeApi implements ContactInterface, ChatInterface, UserInterface {
  
    public static void main(String[] args) {
    	SpringApplication.run(HandshakeApi.class, args);
 
    }
  
    
  
}
