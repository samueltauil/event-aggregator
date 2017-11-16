package com.redhat.labs.eventaggregator;

import java.util.Stack;

import javax.jms.ConnectionFactory;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class EventAggregatorApplication {

	private Stack warningsCache;
	
	public static void main(String[] args) {
		SpringApplication.run(EventAggregatorApplication.class, args);		  
	}
	
    @Bean
    public JmsListenerContainerFactory<?> myFactory(
                            ConnectionFactory connectionFactory,
                            DefaultJmsListenerContainerFactoryConfigurer configurer)
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all boot's default to this factory, including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override some of Boot's default if necessary.
        return factory;
    }
 
    @Bean
    public MessageConverter jacksonJmsMessageConverter()
    {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
    
    @Bean
    public KieSession kieSessionCached() {
	    
    		KieServices kieServices = KieServices.Factory.get();
	    KieContainer kieContainer = kieServices.getKieClasspathContainer();
	    final KieSession kieSession = kieContainer.newKieSession("ksession-rules");
	    	new Thread(new Runnable() {

	            public void run() {
	            	kieSession.fireUntilHalt();
	            }
		 }).start();
    	
    	return kieSession;
    }
    
    @Bean
    public Stack warningsCache() {
    		if (warningsCache == null) {
    			warningsCache = new Stack();
    		}
    		return warningsCache;
    }
    
}
