package com.redhat.labs.eventaggregator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.redhat.labs.eventaggregator.model.RigWarning;

@Component
public class WarningListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WarningListener.class);
	
	 @JmsListener(destination = "jms.message.warnings")
	 public void receiveMessage(Message<RigWarning> msg) {
		 	
		 	RestTemplate restTemplate = new RestTemplate();
		 	LOGGER.debug("Message delivered to Order management");
			HttpEntity<RigWarning> request = new HttpEntity<>(msg.getPayload());
			String ab = restTemplate.postForObject("http://machinealertservice-sampleproject.apps.c7.core.rht-labs.com/alerts/equipmentalerts", request, String.class);
	 }
}
