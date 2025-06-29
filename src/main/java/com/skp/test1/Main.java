package com.skp.test1;

import com.skp.test1.entities.RoomType;
import com.skp.test1.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Service s = new Service();

        s.setRoom(1, RoomType.STANDARD_SUITE, 1000);
        s.setRoom(2, RoomType.JUNIOR_SUITE, 2000);
        s.setRoom(3, RoomType.MASTER_SUITE, 3000);

        //s.setUser(1, 5000);
        s.setUser(1, 50000);
        s.setUser(2, 10000);

        s.bookRoom(1, 2, DateUtil.toDate("30/06/2026"), DateUtil.toDate("07/07/2026"));
        s.bookRoom(1, 2, DateUtil.toDate("07/07/2026"), DateUtil.toDate("30/06/2026"));
        s.bookRoom(1, 1, DateUtil.toDate("07/07/2026"), DateUtil.toDate("08/07/2026"));
        s.bookRoom(2, 1, DateUtil.toDate("07/07/2026"), DateUtil.toDate("09/07/2026"));
        s.bookRoom(2, 3, DateUtil.toDate("07/07/2026"), DateUtil.toDate("08/07/2026"));

        s.setRoom(1, RoomType.MASTER_SUITE, 10000);

        s.printAll();
        s.printAllUsers();
    }
}