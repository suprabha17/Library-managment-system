package com.app.dto;

import java.util.List;

public class BulkBookIdRequest {

      private List<Integer> bookIds;

	public List<Integer> getBookIds() {
		return bookIds;
	}

	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
	}

	@Override
	public String toString() {
		return "deleteBookDto [bookIds=" + bookIds + "]";
	}
      
      
}
