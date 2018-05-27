package com.chik.chik.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="peerreviews")
public class PeerReviewsBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@Column(name="peerId")
	@ManyToOne(targetEntity = PeerMSTBean.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "peerid", referencedColumnName = "PID")
	private int peerId;
	
	@Id
	//@Column(name="reviewerId")
	@ManyToOne(targetEntity = PeerMSTBean.class, cascade = CascadeType.ALL )
    @JoinColumn(name = "reviewerid", referencedColumnName = "PID")
	private int reviewerId;
	
	@Column(name="review1")
	private int review1;
	
	@Column(name="review2")
	private int review2;
	
	@Column(name="review3")
	private int review3;
	
	@Column(name="review4")
	private int review4;
	
	@Column(name="review5")
	private int review5;
	
	@Column(name="review6")
	private int review6;
	
	@Column(name="feedback")
	private String feedback;
	
	public int getPeerId() {
		return peerId;
	}
	public void setPeerId(int peerId) {
		this.peerId = peerId;
	}
	public int getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}
	public int getReview1() {
		return review1;
	}
	public void setReview1(int review1) {
		this.review1 = review1;
	}
	public int getReview2() {
		return review2;
	}
	public void setReview2(int review2) {
		this.review2 = review2;
	}
	public int getReview3() {
		return review3;
	}
	public void setReview3(int review3) {
		this.review3 = review3;
	}
	public int getReview4() {
		return review4;
	}
	public void setReview4(int review4) {
		this.review4 = review4;
	}
	public int getReview5() {
		return review5;
	}
	public void setReview5(int review5) {
		this.review5 = review5;
	}
	public int getReview6() {
		return review6;
	}
	public void setReview6(int review6) {
		this.review6 = review6;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.peerId+" "+this.reviewerId+" "+this.review1;
	}
}
