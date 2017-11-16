package com.redhat.labs.eventaggregator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Stack;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.EntryPoint;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

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
	private static final String CEP_STREAM = "RigEventMonitor";
	
	@Autowired
	@Qualifier("warningsCache")
	private Stack warningsCache;
	
	private RestTemplate restTemplate;

	 @JmsListener(destination = "jms.message.endpoint")
	    public void receiveMessage(Message<RigEvent> msg) {
			
			ep = kieSession.getEntryPoint(CEP_STREAM);
			ep.insert(msg.getPayload());
			
			QueryResults res = kieSession.getQueryResults("findWarnings");
			
			for (QueryResultsRow queryResultsRow : res) {
				RigWarning warn = (RigWarning) queryResultsRow.get("warning");
				
//				GregorianCalendar gc = new GregorianCalendar();
//			    Date  warningDate = gc.getTime();
//
//			    String pattern = "yyyy-MM-dd'T'HH:mm:ss";
//
//			    SimpleDateFormat simpleFormatter  = new SimpleDateFormat(pattern);
//			    simpleFormatter.format(warningDate);
			    
			    //TODO change that in the bean 
				
				warningsCache.push(warn);
				restTemplate = new RestTemplate();
				
				HttpEntity<RigWarning> request = new HttpEntity<>(warn);
				RigWarning returnedRigWarning = restTemplate.postForObject("http://machinealertservice-sampleproject.apps.c7.core.rht-labs.com/alerts/equipmentalerts", request, RigWarning.class);
				
			}
	    }
}
