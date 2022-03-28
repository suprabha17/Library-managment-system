package com.app.dto;

public class IssueBook {
	
	Integer bookId;
	Integer memberId;
	public IssueBook(Integer bookId, Integer memberId) {
		super();
		this.bookId = bookId;
		this.memberId = memberId;
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
	@Override
	public String toString() {
		return "IssueBook [bookId=" + bookId + ", memberId=" + memberId + "]";
	}
	
}
