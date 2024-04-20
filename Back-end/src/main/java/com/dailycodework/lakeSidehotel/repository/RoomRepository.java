package com.dailycodework.lakeSidehotel.repository;

import com.dailycodework.lakeSidehotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "SELECT DISTINCT r.roomType FROM Room r") //DISTINCT เพื่อให้ได้รายการที่มีค่าไม่ซ้ำกันจากฟิลด์ที่เราระบุ
    List<String> findDistinctRoomTypes();
}
