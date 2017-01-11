package com.oneToOne;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Embeddable 表示一个非Entity类可以嵌入到另一个Entity类中作为属性而存在。
@Entity
@Table(name = "T_Students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sid;
	private String gender;
	// @Temporal(TemporalType.DATE)
	// @Temporal(TemporalType.TIME)
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private String major;
	private double salary;
	private String isActive;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid", unique = true)
	private IdCard idCard;

	public Student() {

	}

	public Student(Long sid, String gender, Date birthday, String major,
			IdCard idCard) {
		// super();
		this.sid = sid;
		this.gender = gender;
		this.birthday = birthday;
		this.major = major;
		this.idCard = idCard;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public IdCard getIdCard() {
		return idCard;
	}

	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
}
