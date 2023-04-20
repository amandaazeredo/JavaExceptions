package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExecption;

public class Reservation {

	private String bookName;
	private Date pickUpDate;
	private Date returnDate;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(String bookName, Date pickUpDate, Date returnDate) throws DomainExecption {
	if(!returnDate.after(pickUpDate)) {
		throw new DomainExecption("Book's return date must be after book's pick up date");
	}
		this.bookName = bookName;
		this.pickUpDate = pickUpDate;
		this.returnDate = returnDate;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getPickUpDate() {
		return pickUpDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	
	public long duration() {
		long diff = returnDate.getTime() - pickUpDate.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date pickUpDate, Date returnDate) throws DomainExecption {
		Date now = new Date();
		if(pickUpDate.before(now) || returnDate.before(now)) {
			throw new DomainExecption("Reservation dates for uptade must be future dates");
		}if(!returnDate.after(pickUpDate)) {
			throw new DomainExecption("Book's return date must be after book's pick up date");
		}
		this.pickUpDate = pickUpDate;
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "Book name: " + bookName
				+ ", pick up date: "
				+ sdf.format(pickUpDate)
				+ ", return date: "
				+ sdf.format(returnDate)
				+ ". The reader has had the book for "
				+ duration() + " days";
	}
}
