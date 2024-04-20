package com.dailycodework.lakeSidehotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String roomType;

    private BigDecimal roomPrice;

    private boolean isBooked = false;
    @Lob //"Large Object" ใช้สำหรับการเก็บข้อมูลขนาดใหญ่ เช่น รูปภาพ ไฟล์เสียง หรือข้อมูลไบนารีอื่น ๆ
    private Blob photo; //(Binary Large Object) เป็นอินเทอร์เฟซที่อยู่ในแพ็คเกจ java.sql แทนสตรีมข้อมูลไบนารี มักใช้ในการจัดการข้อมูลขนาดใหญ่ เช่น รูปภาพหรือไฟล์ เมื่อทำการจัดเก็บในฐานข้อมูล

    @OneToMany(mappedBy="room", fetch = FetchType.LAZY,cascade = CascadeType.ALL) //เมื่อมีการทำการเปลี่ยนแปลง (บันทึก, ลบ, อัปเดต, ดึงข้อมูล) ที่เกิดขึ้นกับ Entity Room
    private List<BookedRoom> bookings;

    public Room() {
        this.bookings = new ArrayList<>();
    }
    public void addBooking(BookedRoom booking){
        if(bookings == null){
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
    }
}
