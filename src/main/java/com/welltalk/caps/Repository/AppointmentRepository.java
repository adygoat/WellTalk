package com.welltalk.caps.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.welltalk.caps.Entity.AppointmentEntity;
import com.welltalk.caps.Entity.UserEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Object> {
    




}
