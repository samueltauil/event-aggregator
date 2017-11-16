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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeRelated == null) ? 0 : attributeRelated.hashCode());
		result = prime * result + ((warningDate == null) ? 0 : warningDate.hashCode());
		result = prime * result + ((warningMessage == null) ? 0 : warningMessage.hashCode());
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
		RigWarning other = (RigWarning) obj;
		if (attributeRelated == null) {
			if (other.attributeRelated != null)
				return false;
		} else if (!attributeRelated.equals(other.attributeRelated))
			return false;
		if (warningDate == null) {
			if (other.warningDate != null)
				return false;
		} else if (!warningDate.equals(other.warningDate))
			return false;
		if (warningMessage == null) {
			if (other.warningMessage != null)
				return false;
		} else if (!warningMessage.equals(other.warningMessage))
			return false;
		return true;
	}
	
	
}
