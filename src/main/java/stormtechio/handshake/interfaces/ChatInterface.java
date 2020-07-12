package stormtechio.handshake.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ChatInterface {

	@PostMapping("chat/send")
	default String sendMessage(@RequestBody String body) {
		return "Message Sent";
	}
	
}
