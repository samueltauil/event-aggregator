package com.redhat.labs.eventaggregator.model;

public class RigWarning {

	private String warningMessage;
	private String attributeRelated;

	public RigWarning() {}
	
	public RigWarning(String attr, String msg) {
		this.attributeRelated = attr;
		this.warningMessage = msg;		
	}

	public String getWarningMessage() {
		return warningMessage;
	}

	public void setWarningMessage(String warningMessage) {
		this.warningMessage = warningMessage;
	}

	public String getAttributeRelated() {
		return attributeRelated;
	}

	public void setAttributeRelated(String attributeRelated) {
		this.attributeRelated = attributeRelated;
	}

	@Override
	public String toString() {
		return String.format("RigWarning [warningMessage=%s, attributeRelated=%s]", warningMessage, attributeRelated);
	}
	
	
}
