package com.redhat.labs.eventaggregator;

import java.math.BigDecimal;
import java.text.ParseException;

import com.google.gson.Gson;
import com.redhat.labs.eventaggregator.model.RigEvent;


public class Playground {

	public static void main(String[] args) throws ParseException {
		
		
		RigEvent event = new RigEvent();
		event.setPowerMotorAmpsPH(new BigDecimal("10.3"));
		event.setPowerOutputAmpsPH(new BigDecimal("33.4"));
		event.setPowerOutputVolts(new BigDecimal("56.8"));
		event.setPressurePumpDischarge(new BigDecimal("33.7"));
		event.setPressurePumpIntake(new BigDecimal("555.6"));
		event.setTemperatureMotor(420.6);
		event.setTemperaturePumpIntake(new BigDecimal("78.9"));
		event.setVibration(new BigDecimal("333.4"));
		Gson gson = new Gson();
		System.out.println(gson.toJson(event));

	    
	    
	
	}
}
