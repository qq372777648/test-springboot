package net.lzw.test.springboot.testspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import net.lzw.test.springboot.testspringboot.pojo.WiselyMessage;
import net.lzw.test.springboot.testspringboot.pojo.WiselyResponse;

@Controller
public class WsController {

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyResponse say(WiselyMessage message) throws Exception {
		return new WiselyResponse("Welcome, " + message.getName() + "!");
	}

	@Autowired
	private SimpMessagingTemplate messagingTemplate;//1

	@MessageMapping("/chat")
//	@SendTo({"/user/wisely/queue/notifications","/topic/getResponse"})
	//@SendTo("/user/wisely/queue/notifications")
	public WiselyResponse handleChat( String msg) { //2
		messagingTemplate.convertAndSend("/queue/user/wisely", msg);
		messagingTemplate.convertAndSend("/topic/getResponse", msg);
		messagingTemplate.convertAndSendToUser("wisely",
					"/queue/notifications",  "xx-send:"  //  /user/wisely/queue/notifications
							+ msg);
			return new WiselyResponse("chat, " + msg + "!");
	}
	
	
	//http://localhost/test-springboot/chatpage?userName=lzw
	@RequestMapping("/chatpage")
	public String toChatPage(Model m, String userName) { //2
		m.addAttribute("userName", userName+"3");
			return "chat";
	}
	
	public static void main(String[] args) {
System.out.println("/user/"+ StringUtils.replace("wisely", "/", "%2F") + "/queue/notifications");

	}
}