package com.secure.controller;

import org.springframework.http.HttpHeaders;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.secure.entity.Employee;

@RestController
public class AppController {
	
	@GetMapping("/get")
	public String getDetails() {
		return "Get Employees";
	}

	@PostMapping("/post")
	Employee postEmployee(@RequestBody Employee newEmployee) {
	return newEmployee;
	}
	@PutMapping("/put/{name}")
	String putEmployee(@RequestBody Employee newEmployee, @PathVariable String name) {
	return newEmployee.toString() + "updated with name" + name;
	}
	
	@DeleteMapping("/delete/{name}")
	String deleteEmployee(@PathVariable String name) {
		return name;
	}
	@GetMapping("/request")
	public String getRequestParam(@RequestParam(name="name", required =true, defaultValue="nishant") String name) {
	 return "Request Param :"+ name;
	}
	@GetMapping("/requests/params")
	public String getRequestparams(@RequestHeader List<String> id ) {
		return "Request Params" +id;
	}
	
	@GetMapping("/headers")
	public ResponseEntity<String> getrequestparam(@RequestHeader HttpHeaders header){
		if (isHeaderMissing(header, "name")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
		HttpHeaders responseHeader = new HttpHeaders();
		responseHeader.setExpires(ZonedDateTime.now().plusDays(1));
		String response ="Valid Header";
		return ResponseEntity.ok().headers(responseHeader).body(response);
	}
	private boolean isHeaderMissing(final HttpHeaders header, final String headerKey) {
		if(!header.containsKey(headerKey)) {
			return true;
		}else
			return false;
	}
	
	
}
