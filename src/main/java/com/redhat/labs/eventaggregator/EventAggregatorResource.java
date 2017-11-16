package com.redhat.labs.eventaggregator;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.redhat.labs.eventaggregator.model.RigEvent;
import com.redhat.labs.eventaggregator.model.RigWarning;


@RestController
@RequestMapping("/")
public class EventAggregatorResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EventAggregatorResource.class);
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("warningsCache")
	private Stack warningsCache;
	
	@RequestMapping(value = "/insertevent", method = RequestMethod.POST)
	public ResponseEntity insertEvent(@RequestBody RigEvent rigEvent) {

	jmsTemplate.convertAndSend("jms.message.endpoint", rigEvent);
	
	LOGGER.debug("Event sent to the queue: "+ rigEvent.toString());
	
	if (!warningsCache.empty()) {
		RigWarning warn = (RigWarning) warningsCache.pop();
		return new ResponseEntity<RigWarning>(warn, HttpStatus.OK);
	}
	
	return new ResponseEntity<String>("{}", HttpStatus.OK);
	
	}	
	
}
