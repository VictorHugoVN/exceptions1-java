package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.setRoomNumber(roomNumber);
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Integer getRoomNumber() {
		return this.roomNumber;
	}
	
	
	public Date getCheckIn() {
		return this.checkIn;
	}
	
	public Date getCheckOut() {
		return this.checkOut;
	}
	
	public long duration() {
		long diff = this.getCheckOut().getTime() - this.getCheckIn().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDate(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates.";
		}
		if(!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date.";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " +
				this.getRoomNumber() + 
				", Check-in: " +
				sdf.format(this.getCheckIn()) +
				", Check-out: " +
				sdf.format(this.getCheckOut()) + 
				", " + this.duration() +
				" nights.";
	}
	
	
	
}
