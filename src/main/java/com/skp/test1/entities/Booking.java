package com.skp.test1.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private User user;
    private Room room;
    private Date checkIn;
    private Date checkOut;

    public Booking(User user, Room room, Date checkIn, Date checkOut) {
        this.user = new User(user.getUserId(), user.getBalance());
        this.room = new Room(room.getRoomNumber(), room.getType(), room.getPricePerNight());
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {

        String checkInDate = new SimpleDateFormat("dd/MM/yyyy").format(checkIn);
        String checkOutDate = new SimpleDateFormat("dd/MM/yyyy").format(checkOut);

        return "Booking{" +
                "user=" + user +
                ", room=" + room +
                ", checkIn=" + checkInDate +
                ", checkOut=" + checkInDate +
                '}';
    }
}
