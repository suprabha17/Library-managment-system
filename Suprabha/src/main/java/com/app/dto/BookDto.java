package com.app.dto;

public class BookDto {

    
    private String title;

    
    private Integer availabilityCount;

    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAvailabilityCount() {
        return availabilityCount;
    }

    public void setAvailabilityCount(Integer availabilityCount) {
        this.availabilityCount = availabilityCount;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

	/*
	 * @Override public String toString() { return new Gson().toJson(this); }
	 */
}
