package com.redhat.labs.eventaggregator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.labs.eventaggregator.model.RigEvent;

@RestController
@RequestMapping("/")
public class EventAggregatorResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventAggregatorResource.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@RequestMapping(value = "/insertevent", method = RequestMethod.POST)
	public ResponseEntity<RigEvent> insertEvent(@RequestBody RigEvent rigEvent) {

	jmsTemplate.convertAndSend("jms.message.endpoint", rigEvent);
	
	LOGGER.debug("Event sent to the queue: "+ rigEvent.toString());
	
	return new ResponseEntity<RigEvent>(rigEvent, HttpStatus.OK);
	
	}	
	
}
