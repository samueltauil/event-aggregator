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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + ((powerMotorAmpsPH == null) ? 0 : powerMotorAmpsPH.hashCode());
		result = prime * result + ((powerOutputAmpsPH == null) ? 0 : powerOutputAmpsPH.hashCode());
		result = prime * result + ((powerOutputVolts == null) ? 0 : powerOutputVolts.hashCode());
		result = prime * result + ((pressurePumpDischarge == null) ? 0 : pressurePumpDischarge.hashCode());
		result = prime * result + ((pressurePumpIntake == null) ? 0 : pressurePumpIntake.hashCode());
		long temp;
		temp = Double.doubleToLongBits(temperatureMotor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((temperaturePumpIntake == null) ? 0 : temperaturePumpIntake.hashCode());
		result = prime * result + ((vibration == null) ? 0 : vibration.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RigEvent other = (RigEvent) obj;
		if (creation == null) {
			if (other.creation != null)
				return false;
		} else if (!creation.equals(other.creation))
			return false;
		if (powerMotorAmpsPH == null) {
			if (other.powerMotorAmpsPH != null)
				return false;
		} else if (!powerMotorAmpsPH.equals(other.powerMotorAmpsPH))
			return false;
		if (powerOutputAmpsPH == null) {
			if (other.powerOutputAmpsPH != null)
				return false;
		} else if (!powerOutputAmpsPH.equals(other.powerOutputAmpsPH))
			return false;
		if (powerOutputVolts == null) {
			if (other.powerOutputVolts != null)
				return false;
		} else if (!powerOutputVolts.equals(other.powerOutputVolts))
			return false;
		if (pressurePumpDischarge == null) {
			if (other.pressurePumpDischarge != null)
				return false;
		} else if (!pressurePumpDischarge.equals(other.pressurePumpDischarge))
			return false;
		if (pressurePumpIntake == null) {
			if (other.pressurePumpIntake != null)
				return false;
		} else if (!pressurePumpIntake.equals(other.pressurePumpIntake))
			return false;
		if (Double.doubleToLongBits(temperatureMotor) != Double.doubleToLongBits(other.temperatureMotor))
			return false;
		if (temperaturePumpIntake == null) {
			if (other.temperaturePumpIntake != null)
				return false;
		} else if (!temperaturePumpIntake.equals(other.temperaturePumpIntake))
			return false;
		if (vibration == null) {
			if (other.vibration != null)
				return false;
		} else if (!vibration.equals(other.vibration))
			return false;
		return true;
	}

	
}
