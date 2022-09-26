package com.secure.controller;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
//import org.objectweb.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.secure.entity.Employee;

@RunWith(SpringRunner.class)
@WebMvcTest({AppController.class})
@ActiveProfiles(value = "true")
public class AppControllerTest {

	
	@Autowired
	private MockMvc mocMvc;
	
	@Value("${employee.get.url}")
	String geturl;
	@Value("${employee.post.url}")
	String posturl;
	@Value("${employee.put.url}")
	String puturl;
	@Value("${employee.delete.url}")
	String deleteurl;
	
	@Value("${user.user1.username}")
	String username1;
	
	@Value("${user.user1.password}")
	String password1;
	
	@Value("${admin.user1.username}")
	String admin_name1;
	
	@Value("${admin.user1.password}")
	String admin_password1;
	
	@Test
	public void testEmployeeGet() throws Exception {
		ResultActions responseEntity = processApiRequest(geturl, HttpMethod.GET,null,null, username1, password1);
		responseEntity.andExpect(status().isOk());
		//ObjectMapper mapper = new ObjectMapper();
		String result = responseEntity.andReturn().getResponse().getContentAsString();
		assertEquals("Get Employees", result);
	}
	
	@Test
	public void testEmployeePost() throws Exception {
		Employee employee = createEmployee("test", "dev");
		ResultActions responseEntity =processApiRequest(posturl, HttpMethod.POST,null,employee, admin_name1, admin_password1 ) ;
		responseEntity.andExpect(status().isOk());
		ObjectMapper mapper = new ObjectMapper();
		Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
					new TypeReference<Employee>() {
			
		});
		assertEquals("test", result.getName());
		assertEquals("dev", result.getRole());
		
	}
	

	private ResultActions processApiRequest(String api, HttpMethod methodtype, String name,  Employee employee, String username, String password) {
		ResultActions response = null;
		String secret = "Basic " + Base64Utils.encodeToString((username+":"+password).getBytes());
		try {
			switch(methodtype) {
			case GET :
				 response = mocMvc.perform(get(api).header(HttpHeaders.AUTHORIZATION, secret));
				// response = mocMvc.perform(get(api).with(user(username).password(password).roles("USER")));
				break;
			case POST:
				response = mocMvc.perform(post(api).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			fail();
			
		}
		return response;
	}
	private Employee createEmployee(String name, String role) {
		Employee empEmployee = new Employee(name, role);
		return empEmployee;
	}
	private String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
