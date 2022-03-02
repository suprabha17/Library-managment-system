package com.app.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "memberid_bookid_mapping")
public class BookIdMemberMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotEmpty(message = "bookId cannot be null")
    private Integer bookId;

    @NotEmpty(message = "scholarId cannot be null ")
    private Integer memberId;
    
    
    @UpdateTimestamp
    @NotEmpty(message = "issuedon cannot be null ")
    private Date issuedOn;

    
    private Date returnDate;
    
    @Column(name = "expectedReturn")
    private LocalDate expectedReturn;
    
    
    private Date renewedAt;

    @Column(name = "num_of_times_renewed")
    private Integer numOfTimesRenewed;
    
    @Column(name="fine")
    private  Float fineOnBook;
    
    @Column(name ="reservation")
    private int reservation;
    
    

    public BookIdMemberMapping(Integer id, @NotEmpty(message = "bookId cannot be null") Integer bookId,
			@NotEmpty(message = "scholarId cannot be null ") Integer memberId,
			@NotEmpty(message = "issuedon cannot be null ") Date issuedOn, Date returnDate, LocalDate expectedReturn,
			Date renewedAt, Integer numOfTimesRenewed,Float fine,Integer reservation) {
		super();
		Id = id;
		this.bookId = bookId;
		this.memberId = memberId;
		this.issuedOn = issuedOn;
		this.returnDate = returnDate;
		this.expectedReturn = expectedReturn;
		this.renewedAt = renewedAt;
		this.numOfTimesRenewed = numOfTimesRenewed;
		fineOnBook=fine;
		this.reservation=reservation;
	}

	public BookIdMemberMapping() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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
    public Date getIssuedOn() {
        return issuedOn;
    }

    public void setIssuedOn(Date issuedOn) {
        this.issuedOn = issuedOn;
    }
   

    public Date getrenewedAt() {
        return renewedAt;
    }

    public void setrenewedAt(Date renewedAt) {
        this.renewedAt = renewedAt;
    }
    
    
    public Date getreturnDate() {
        return returnDate;
    }

    public void setreturnDate(Date returnAt) {
        this.returnDate = returnAt;
    }

    public Integer getNumOfTimesRenewed() {
        return numOfTimesRenewed;
    }

    public void setNumOfTimesRenewed(Integer numOfTimesRenewed) {
        this.numOfTimesRenewed = numOfTimesRenewed;
    }
   

    public LocalDate getExpectedReturn() {
		return expectedReturn;
	}

	public void setExpectedReturn(LocalDate expectedReturn) {
		this.expectedReturn = expectedReturn;
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
		return "BookIdMemberMapping [Id=" + Id + ", bookId=" + bookId + ", memberId=" + memberId + ", issuedOn="
				+ issuedOn + ", returnDate=" + returnDate + ", expectedReturn=" + expectedReturn + ", renewedAt="
				+ renewedAt + ", numOfTimesRenewed=" + numOfTimesRenewed + ", fineOnBook=" + fineOnBook
				+ ", reservation=" + reservation + "]";
	}

	

	
}
