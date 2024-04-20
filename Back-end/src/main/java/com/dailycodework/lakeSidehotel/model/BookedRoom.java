package com.dailycodework.lakeSidehotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "check_In")
    private LocalDate checkInDate;

    @Column(name = "check_Out")
    private LocalDate checkOutDate;

    @Column(name = "guest_FullName")
    private String guestFullName;

    @Column(name = "guest_Email")
    private String guestEmail;

    @Column(name = "adults")
    private int NumOfAdults;

    @Column(name = "children")
    private int NumOfChildren;

    @Column(name = "total_guest")
    private int totalNumOfGuest;

    @Column(name = "confirmation_Code")
    private String BookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY) // Entity ที่เป็น target จะถูกดึงมาใช้งานเมื่อจำเป็นเท่านั้น, ไม่ในทุกครั้งที่ Entity ปัจจุบันถูกดึงขึ้นมา.
    @JoinColumn(name = "room_id")
    private Room room;

    public void calculateTotalNumOfGuest(){
        this.totalNumOfGuest = this.NumOfAdults + NumOfChildren;
    }
    public void setNumOfAdults(int numOfAdults) {
        NumOfAdults = numOfAdults;
        calculateTotalNumOfGuest();
    }
    public void setNumOfChildren(int numOfChildren) {
        NumOfChildren = numOfChildren;
        calculateTotalNumOfGuest();
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        BookingConfirmationCode = bookingConfirmationCode;
    }
}
