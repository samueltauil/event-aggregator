package com.redhat.labs.eventaggregator.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class RigEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String creation;
	private BigDecimal pressurePumpIntake;
	private BigDecimal pressurePumpDischarge;
	private double temperatureMotor;
	private BigDecimal temperaturePumpIntake;
	private BigDecimal powerOutputAmpsPH;
	private BigDecimal powerOutputVolts;
	private BigDecimal powerMotorAmpsPH;
	private BigDecimal vibration;
	
	

	public RigEvent() {
		// TODO be happy
	}
	
	public BigDecimal getPressurePumpIntake() {
		return pressurePumpIntake;
	}

	public void setPressurePumpIntake(BigDecimal pressurePumpIntake) {
		this.pressurePumpIntake = pressurePumpIntake;
	}

	public BigDecimal getPressurePumpDischarge() {
		return pressurePumpDischarge;
	}

	public void setPressurePumpDischarge(BigDecimal pressurePumpDischarge) {
		this.pressurePumpDischarge = pressurePumpDischarge;
	}

	public double getTemperatureMotor() {
		return temperatureMotor;
	}

	public void setTemperatureMotor(double temperatureMotor) {
		this.temperatureMotor = temperatureMotor;
	}

	public BigDecimal getTemperaturePumpIntake() {
		return temperaturePumpIntake;
	}

	public void setTemperaturePumpIntake(BigDecimal temperaturePumpIntake) {
		this.temperaturePumpIntake = temperaturePumpIntake;
	}

	public BigDecimal getPowerOutputAmpsPH() {
		return powerOutputAmpsPH;
	}

	public void setPowerOutputAmpsPH(BigDecimal powerOutputAmpsPH) {
		this.powerOutputAmpsPH = powerOutputAmpsPH;
	}

	public BigDecimal getPowerOutputVolts() {
		return powerOutputVolts;
	}

	public void setPowerOutputVolts(BigDecimal powerOutputVolts) {
		this.powerOutputVolts = powerOutputVolts;
	}

	public BigDecimal getPowerMotorAmpsPH() {
		return powerMotorAmpsPH;
	}

	public void setPowerMotorAmpsPH(BigDecimal powerMotorAmpsPH) {
		this.powerMotorAmpsPH = powerMotorAmpsPH;
	}

	public BigDecimal getVibration() {
		return vibration;
	}

	public void setVibration(BigDecimal vibration) {
		this.vibration = vibration;
	}
	
	public String getCreation() {
		return creation;
	}

	public void setCreation(String creation) {
		this.creation = creation;
	}

	@Override
	public String toString() {
		return String.format(
				"RigEvent [creation=%s, pressurePumpIntake=%s, pressurePumpDischarge=%s, temperatureMotor=%s, temperaturePumpIntake=%s, powerOutputAmpsPH=%s, powerOutputVolts=%s, powerMotorAmpsPH=%s, vibration=%s]",
				creation, pressurePumpIntake, pressurePumpDischarge, temperatureMotor, temperaturePumpIntake,
				powerOutputAmpsPH, powerOutputVolts, powerMotorAmpsPH, vibration);
	}

	
}
