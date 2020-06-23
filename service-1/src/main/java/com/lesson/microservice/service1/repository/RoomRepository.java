package com.lesson.microservice.service1.repository;

import com.lesson.microservice.service1.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
    Room findByRoomNumber(String roomNumber);

}
