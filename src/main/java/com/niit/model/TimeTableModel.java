package com.niit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tbl_Time_Table_master")
public class TimeTableModel {
	
	private int id,facultyid;
	private String classnumber;
	private String status;
	private String datetime;
	private String starttime,endtime,mondaydetails,tuesdaydetails,wednesdaydetails,thursdaydetails,fridaydetails,saturdaydetails,sundaydetails;
	
	public TimeTableModel() {
		
	}
	
	
	@Column(name = "saturdaydetails")
	public String getSaturdaydetails() {
		return saturdaydetails;
	}



	public void setSaturdaydetails(String saturdaydetails) {
		this.saturdaydetails = saturdaydetails;
	}


	@Column(name = "sundaydetails")
	public String getSundaydetails() {
		return sundaydetails;
	}



	public void setSundaydetails(String sundaydetails) {
		this.sundaydetails = sundaydetails;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="facultyid")
	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}



	@Column(name="status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="datetime")
	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
   
	@Column(name="starttime")
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	
	@Column(name="classnumber")
	public String getClassnumber() {
		return classnumber;
	}

	public void setClassnumber(String classnumber) {
		this.classnumber = classnumber;
	}

	@Column(name="endtime")
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	@Column(name="mondaydetails")
	public String getMondaydetails() {
		return mondaydetails;
	}

	public void setMondaydetails(String mondaydetails) {
		this.mondaydetails = mondaydetails;
	}

	@Column(name="tuesdaydetails")
	public String getTuesdaydetails() {
		return tuesdaydetails;
	}

	public void setTuesdaydetails(String tuesdaydetails) {
		this.tuesdaydetails = tuesdaydetails;
	}

	@Column(name="wednesdaydetails")
	public String getWednesdaydetails() {
		return wednesdaydetails;
	}

	public void setWednesdaydetails(String wednesdaydetails) {
		this.wednesdaydetails = wednesdaydetails;
	}

	@Column(name="thursdaydetails")
	public String getThursdaydetails() {
		return thursdaydetails;
	}

	public void setThursdaydetails(String thursdaydetails) {
		this.thursdaydetails = thursdaydetails;
	}

	@Column(name="fridaydetails")
	public String getFridaydetails() {
		return fridaydetails;
	}

	public void setFridaydetails(String fridaydetails) {
		this.fridaydetails = fridaydetails;
	}
	
}
