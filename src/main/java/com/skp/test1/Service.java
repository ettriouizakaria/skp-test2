package com.skp.test1;

import com.skp.test1.entities.Booking;
import com.skp.test1.entities.Room;
import com.skp.test1.entities.RoomType;
import com.skp.test1.entities.User;

import java.util.ArrayList;
import java.util.Date;

public class Service {
    private ArrayList<Room> rooms;
    private ArrayList<User> users;
    ArrayList<Booking> bookings;

    public Service(){
        this.rooms = new ArrayList<>();
        this.users = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room room : this.rooms) {
            if (room.getRoomNumber() == roomNumber) return;
        }
        rooms.add(0, new Room(roomNumber, roomType, roomPricePerNight));
    }

    public void setUser(int userId, int balance) {
        for (User user : users) {
            if (user.getUserId() == userId) return;
        }
        users.add(0, new User(userId, balance));
    }

    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (!checkIn.before(checkOut)) {
            System.out.println("Invalid booking dates.");
            return;
        }

        User user = null;
        for (User u : users) {
            if (u.getUserId() == userId) user = u;
        }
        Room room = null;
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) room = r;
        }

        if (user == null){
            throw new IllegalArgumentException("User not found!");
        }

        if (room == null){
            throw new IllegalArgumentException("Room not found!");
        }

        for (Booking b : bookings) {
            if (b.getRoom().getRoomNumber() == roomNumber && !(checkOut.compareTo(b.getCheckIn()) <= 0 || checkIn.compareTo(b.getCheckOut()) >= 0)) {
                System.out.println("Room is not available in this period.");
                return;
            }
        }

        long days = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
        int totalPrice = (int) days * room.getPricePerNight();

        if (user.getBalance() < totalPrice) {
            throw new IllegalArgumentException("User does not have enough balance!");
        }

        user.setBalance(user.getBalance() - totalPrice);
        bookings.add(0, new Booking(user, room, checkIn, checkOut));
        System.out.println("Booking successful.");
    }

    public void printAll() {
        System.out.println("ROOMS : ");
        for (Room room : rooms) {
            System.out.println(room);
        }

        System.out.println("BOOKINGS : ");
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    public void printAllUsers() {
        System.out.println("USERS : ");
        for (User user : users) {
            System.out.println(user);
        }
    }
}
