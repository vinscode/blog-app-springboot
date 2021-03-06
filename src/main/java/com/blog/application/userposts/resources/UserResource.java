package com.blog.application.userposts.resources;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.blog.application.userposts.services.UserService;

@RestController
@RequestMapping(path = "/")
public class UserResource {

	
	private UserService service;
	
	public UserResource(UserService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}

	/**
	 * End point for user login
	 * @param userMap
	 * @return
	 */
	@PostMapping("/user/login")
	public ResponseEntity<String> userLogin(@RequestBody Map<String, String> userMap) {
		service.admin = userMap.get("admin").equals("true") ? true : false;
		
		if(service.admin) {			
			return new ResponseEntity<>("Admin logged in successfully.", HttpStatus.OK);
		}else {
			return new ResponseEntity<>("User logged in successfully.", HttpStatus.OK);
		}		
	}
	
	/**
	 * End point for user logout
	 * @return
	 */
	@PostMapping("/user/logout")
	public ResponseEntity<String> userLogout() {
		service.admin = false;
		return new ResponseEntity<>("User logged out successfully.", HttpStatus.OK);		
	}
	
	/**
	 * End point to return all users registered to blog app
	 * @return
	 */
	@GetMapping("/users")
	public ResponseEntity<String> getUsers() {
		if(service.admin) {
			RestTemplate template = new RestTemplate();
			String url = "https://jsonplaceholder.typicode.com/users";
			String response = template.getForObject(url, String.class);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} 
		else
			return new ResponseEntity<String>("Unauthorized user", HttpStatus.UNAUTHORIZED);
	}
	
	/**
	 * End point to get user and related posts
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/user/posts/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, List<Object>>> getSpecificUser(@PathVariable("id") int id) {		
		if(service.admin) {
			List<Object> posts = new ArrayList<Object>();
			List<Object> user = service.getUser(id);
			if(user != null) {
				posts  = service.getPosts(id);
			}

			Map<String, List<Object>> data = new HashMap<String, List<Object>>();			
			
			data.put("User", user);
			data.put("Posts", posts);
			
			return new ResponseEntity<Map<String, List<Object>>>(data, HttpStatus.OK);
		} 
		else
			return new ResponseEntity<Map<String, List<Object>>>(new HashMap<String, List<Object>>(),HttpStatus.UNAUTHORIZED);
	}
	
}

	