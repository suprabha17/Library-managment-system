package com.app.pojo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "memberid_bookid_mapping")
public class BookIdMemberMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer issueId;

    
    private Integer bookId;

    
    private Integer memberId;
    
    
    @UpdateTimestamp
    
    private LocalDate issuedOn;

    
    private LocalDate returnDate;
    
    @Column(name = "expectedReturn")
    private LocalDate expectedReturn;
    
    
    private LocalDate renewedAt;

    @Column(name = "num_of_times_renewed")
    private Integer numOfTimesRenewed;
    
    @Column(name="fine")
    private  Float fineOnBook;
    
    @Column(name ="reservation")
    private int reservation;

	public BookIdMemberMapping() {
		super();
	}


	public BookIdMemberMapping(Integer issueId, Integer bookId, Integer memberId, LocalDate issuedOn, LocalDate returnDate,
			LocalDate expectedReturn, LocalDate renewedAt, Integer numOfTimesRenewed, Float fineOnBook,
			int reservation) {
		super();
		this.issueId = issueId;
		this.bookId = bookId;
		this.memberId = memberId;
		this.issuedOn = issuedOn;
		this.returnDate = returnDate;
		this.expectedReturn = expectedReturn;
		this.renewedAt = renewedAt;
		this.numOfTimesRenewed = numOfTimesRenewed;
		this.fineOnBook = fineOnBook;
		this.reservation = reservation;
	}

	
	public Integer getIssueId() {
		return issueId;
	}


	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}


	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public LocalDate getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(LocalDate issuedOn) {
		this.issuedOn = issuedOn;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getExpectedReturn() {
		return expectedReturn;
	}

	public void setExpectedReturn(LocalDate expectedReturn) {
		this.expectedReturn = expectedReturn;
	}

	public LocalDate getRenewedAt() {
		return renewedAt;
	}

	public void setRenewedAt(LocalDate renewedAt) {
		this.renewedAt = renewedAt;
	}

	public Integer getNumOfTimesRenewed() {
		return numOfTimesRenewed;
	}

	public void setNumOfTimesRenewed(Integer numOfTimesRenewed) {
		this.numOfTimesRenewed = numOfTimesRenewed;
	}

	public Float getFineOnBook() {
		return fineOnBook;
	}

	public void setFineOnBook(Float fineOnBook) {
		this.fineOnBook = fineOnBook;
	}

	public int getReservation() {
		return reservation;
	}

	public void setReservation(int reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "BookIdMemberMapping [Id=" + issueId + ", bookId=" + bookId + ", memberId=" + memberId + ", issuedOn="
				+ issuedOn + ", returnDate=" + returnDate + ", expectedReturn=" + expectedReturn + ", renewedAt="
				+ renewedAt + ", numOfTimesRenewed=" + numOfTimesRenewed + ", fineOnBook=" + fineOnBook
				+ ", reservation=" + reservation + "]";
	}
    
    

    

	

	

	
}
