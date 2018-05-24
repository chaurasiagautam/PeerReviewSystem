package com.chik.chik.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PeerMST")
public class PeerMSTBean {

	@Id
	@Column(name = "PID")
	int peerID;
	@Column(name = "LASTNAME")
	String lastName;
	@Column(name = "FIRSTNAME")
	String firstName;
	@Column(name = "GENDER")
	String gender;
	@Column(name = "PWD")
	String password;
	@Column(name = "SEQ1")
	String seq1;
	@Column(name = "SEQ2")
	String seq2;

	public int getPeerID() {
		return peerID;
	}

	public void setPeerID(int peerID) {
		this.peerID = peerID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSeq1() {
		return seq1;
	}

	public void setSeq1(String seq1) {
		this.seq1 = seq1;
	}

	public String getSeq2() {
		return seq2;
	}

	public void setSeq2(String seq2) {
		this.seq2 = seq2;
	}

	@Override
	public String toString() {
	    return this.firstName+"-"+this.lastName;
	}
}

