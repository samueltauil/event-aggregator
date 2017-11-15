package com.redhat.labs.eventaggregator;

import java.util.Collection;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.redhat.labs.eventaggregator.model.RigEvent;
import com.redhat.labs.eventaggregator.model.RigWarning;

@Component
public class RigEventListener {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(RigEventListener.class);

	@Autowired
	@Qualifier("kieSessionCached")
	private KieSession kieSession;
	private EntryPoint ep;
	Collection<RigWarning> warnings;
	private static final String CEP_STREAM = "RigEventMonitor";

	 @JmsListener(destination = "jms.message.endpoint")
	    public void receiveMessage(Message<RigEvent> msg) {
			
			ep = kieSession.getEntryPoint(CEP_STREAM);
			ep.insert(msg.getPayload());

			warnings = (Collection<RigWarning>) kieSession.getObjects( (Object object) -> { return object.getClass().getSimpleName().equals("RigWarning"); });
			for (RigWarning warn : warnings) {
				LOGGER.info(warn.toString());
			}
						
	    }
}
