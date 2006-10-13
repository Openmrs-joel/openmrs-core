package org.openmrs.web.dwr;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Obs;
import org.openmrs.util.Format;

public class ObsListItem {
	
	protected final Log log = LogFactory.getLog(getClass());

	private Integer obsId;
 	private String encounter = "";
 	private String encounterName = "";
 	private String patientName = "";
 	private String conceptName = "";
 	private String order = "";
 	private String location = "";
 	private Date encounterDatetime;
 	private Date datetime;
 	private String encounterDate = "";
 	private String obsDate = "";
 	private Boolean voided = false;
 	private String value = "";

	public ObsListItem() { }
		
	public ObsListItem(Obs obs, Locale locale) {
		if (obs != null) {
			obsId = obs.getObsId();
			if (obs.getEncounter() != null) {
				encounter = obs.getEncounter().getEncounterId().toString();
				encounterDatetime = obs.getEncounter().getEncounterDatetime();
				encounterDate = encounterDatetime == null ? "" : Format.format(encounterDatetime, locale);
				encounterName = obs.getEncounter().getForm() == null ? "" : obs.getEncounter().getForm().getName();
			}
			patientName = obs.getPatient().getPatientName().getFamilyName();
			patientName += ", " + obs.getPatient().getPatientName().getGivenName();
			conceptName = obs.getConcept().getName(locale).getName();
			if (obs.getOrder() != null)
				order = obs.getOrder().getOrderId().toString();
			location = obs.getLocation().getName();
			datetime = obs.getObsDatetime();
			obsDate = datetime == null ? "" : Format.format(datetime, locale);
			voided = obs.isVoided();
			value = obs.getValueAsString(locale);
		}
	}

	public Integer getObsId() {
		return obsId;
	}

	public void setObsId(Integer obsId) {
		this.obsId = obsId;
	}

	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getEncounter() {
		return encounter;
	}

	public void setEncounter(String encounter) {
		this.encounter = encounter;
	}

	public Date getEncounterDatetime() {
		return encounterDatetime;
	}

	public void setEcounterDatetime(Date encounterDatetime) {
		this.encounterDatetime = encounterDatetime;
	}	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Boolean getVoided() {
		return voided;
	}

	public void setVoided(Boolean voided) {
		this.voided = voided;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return Returns the encounterDate.
	 */
	public String getEncounterDate() {
		return encounterDate;
	}

	/**
	 * @param encounterDate The encounterDate to set.
	 */
	public void setEncounterDate(String encounterDate) {
		this.encounterDate = encounterDate;
	}

	/**
	 * @return Returns the encounterName.
	 */
	public String getEncounterName() {
		return encounterName;
	}

	/**
	 * @param encounterName The encounterName to set.
	 */
	public void setEncounterName(String encounterName) {
		this.encounterName = encounterName;
	}

	/**
	 * @return Returns the obsDate.
	 */
	public String getObsDate() {
		return obsDate;
	}

	/**
	 * @param obsDate The obsDate to set.
	 */
	public void setObsDate(String obsDate) {
		this.obsDate = obsDate;
	}

	/**
	 * @param encounterDatetime The encounterDatetime to set.
	 */
	public void setEncounterDatetime(Date encounterDatetime) {
		this.encounterDatetime = encounterDatetime;
	}

	

}
