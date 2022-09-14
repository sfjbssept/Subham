package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.IStudentRepository;



@RestController
public class StudentController {
	
	@Autowired
	private IStudentRepository studentRepository;
	
	
	@PostMapping("/addstudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		Student save = this.studentRepository.save(student);
		
		return ResponseEntity.ok(save);
	}
	
	@GetMapping("/getstudents")
	public ResponseEntity<?> getStudents(){
		return ResponseEntity.ok(this.studentRepository.findAll());
	}
	
//	@PutMapping("/updatestudent/{id}")
//	public ResponseEntity<?> updateStudent(@RequestBody Student student){
//		Student save = this.studentRepository.save(student);
//		return ResponseEntity.ok(save);
//	}
	@PutMapping("/updatestudent/{id}")
	 ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable("id") Integer id ){
	Student studentdetails = this.studentRepository.findById(id).get();
	studentdetails.setId(id);
	studentdetails.setName(student.getName());
	studentdetails.setCity(student.getCity());
	studentdetails.setCollege(student.getCollege());
	studentRepository.save(studentdetails);
	return ResponseEntity.ok(studentdetails);
	
	}
	@DeleteMapping("/deletestudent/{id}")
	void deleteStudent(@PathVariable Integer id) {
		
		studentRepository.deleteById(id);
	}
	
}
