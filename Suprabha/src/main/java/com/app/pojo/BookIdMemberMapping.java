package com.app.pojo;

import org.hibernate.annotations.Columns;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "memberid_bookid_mapping")
public class BookIdMemberMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @NotEmpty(message = "bookId cannot be null")
    private Integer bookId;

    @NotEmpty(message = "scholarId cannot be null ")
    private Integer memberId;

    @NotEmpty(message = "issuedon cannot be null ")
    private Date issuedOn;

    @LastModifiedDate
    private Date returnDate;
    
    @Column(name = "expectedReturn")
    private LocalDate expectedReturn;
    
    @LastModifiedDate
    private Date renewedAt;

    @Column(name = "num_of_times_renewed")
    private Integer numOfTimesRenewed;
    
    @Column(name="fine")
    private  Float fineOnBook;
    
    

    public BookIdMemberMapping(Integer id, @NotEmpty(message = "bookId cannot be null") Integer bookId,
			@NotEmpty(message = "scholarId cannot be null ") Integer memberId,
			@NotEmpty(message = "issuedon cannot be null ") Date issuedOn, Date returnDate, LocalDate expectedReturn,
			Date renewedAt, Integer numOfTimesRenewed,Float fine) {
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

	@Override
	public String toString() {
		return "BookIdMemberMapping [Id=" + Id + ", bookId=" + bookId + ", memberId=" + memberId + ", issuedOn="
				+ issuedOn + ", returnDate=" + returnDate + ", expectedReturn=" + expectedReturn + ", renewedAt="
				+ renewedAt + ", numOfTimesRenewed=" + numOfTimesRenewed + ", fineOnBook=" + fineOnBook + "]";
	}

	
}
