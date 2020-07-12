package stormtechio.handshake.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class ChatController {
	
	@PostMapping("chat/send")
	public String sendMessage(@RequestParam String message, @RequestParam String fromAddress , @RequestParam String toAddress) {
		return "Message Sent";
	}
	
}
