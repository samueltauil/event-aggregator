package com.redhat.labs.eventaggregator.model;

import java.util.Date;

public class RigWarning {

	private String warningMessage;
	private String attributeRelated;
	private Date warningDate;

	public RigWarning() {}
	
	public RigWarning(String attr, String msg, Date date) {
		this.attributeRelated = attr;
		this.warningMessage = msg;		
		this.warningDate = date;
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

	public Date getWarningDate() {
		return warningDate;
	}

	public void setWarningDate(Date warningDate) {
		this.warningDate = warningDate;
	}

	@Override
	public String toString() {
		return String.format("RigWarning [warningMessage=%s, attributeRelated=%s, warningDate=%s]", warningMessage,
				attributeRelated, warningDate);
	}
	
	
}
