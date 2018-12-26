package com.k8.demo.networkTests.k8Demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.k8.demo.networkTests.k8Demo.model.HostDetails;
import com.k8.demo.networkTests.k8Demo.model.PongMessage;

@CrossOrigin
@RestController
@RequestMapping(value="/ping")
public class pingController {
	
	InetAddress ip;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ResponseEntity<PongMessage> sendPongWithHostDetails() {
		String hostname = null;
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
		} catch (UnknownHostException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		HostDetails host = HostDetails.builder()
							.hostname(hostname)
							.build();
		PongMessage message = PongMessage.builder()
								.message("pong")
								.host(host)
								.build();
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
