package com.welltalk.caps.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.welltalk.caps.Entity.AppointmentEntity;
import com.welltalk.caps.Entity.UserEntity;
import com.welltalk.caps.Repository.AppointmentRepository;
import com.welltalk.caps.Repository.UserRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Iterable<AppointmentEntity> getRequest(){
		return appointmentRepository.findAll();
	}
	
	public ResponseEntity deleteRequest(int makeappointmentid) {
		appointmentRepository.deleteById(makeappointmentid);
		return ResponseEntity.ok("Request deleted successfully");
	}
	
	public ResponseEntity updateAppointment(int makeappointmentid, String stringToken) {
		AppointmentEntity appointmentUpdate = appointmentRepository.findById(makeappointmentid).get();
		
		if(appointmentUpdate.getDecision() == false) {
			appointmentUpdate.setDecision(true);
			appointmentRepository.save(appointmentUpdate);
			return ResponseEntity.ok("Request Accepted");
		}else {
			return ResponseEntity.ok("Request Already Accepted");
		}
	}
	 public void createAppointment(Long userid, AppointmentEntity appointment) {
	       
	        UserEntity user = userRepository.findById(userid).get();

	        AppointmentEntity newAppointment = new AppointmentEntity();

	        newAppointment.setUser(user);
            newAppointment.setDate(appointment.getDate());
            newAppointment.setTime(appointment.getTime());
            newAppointment.setMessage(appointment.getMessage());
            newAppointment.setDecision(false);

	        appointmentRepository.save(newAppointment);
	   

	 }
}
