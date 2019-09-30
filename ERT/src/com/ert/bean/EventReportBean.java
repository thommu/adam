/**
 * 
 * This class is the Bean that is used to 
 * generate Event Report Objects
 * 
 * @author Thommu
 *
 */

package com.ert.bean;

import java.sql.Timestamp;

public class EventReportBean {

	private int incidentId;
	private String department;
	private String category;
	private String latitude;
	private String longitude;
	private String locationText;
	private String description;
	private Timestamp reportingTime;
	private String status;

	public EventReportBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the incidentId
	 */
	public int getIncidentId() {
		return incidentId;
	}

	/**
	 * @param incidentId the incidentId to set
	 */
	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the locationText
	 */
	public String getLocationText() {
		return locationText;
	}

	/**
	 * @param locationText the locationText to set
	 */
	public void setLocationText(String locationText) {
		this.locationText = locationText;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the reportingTime
	 */
	public Timestamp getReportingTime() {
		return reportingTime;
	}

	/**
	 * @param reportingTime the reportingTime to set
	 */
	public void setReportingTime(Timestamp reportingTime) {
		this.reportingTime = reportingTime;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EventReportBean [incidentId=" + incidentId + ", department=" + department + ", category=" + category
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", locationText=" + locationText
				+ ", description=" + description + ", reportingTime=" + reportingTime + ", status=" + status + "]";
	}

}
