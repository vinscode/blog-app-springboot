package com.blog.application.userposts.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.blog.application.userposts.exceptions.UserAuthException;
import com.blog.application.userposts.resources.Post;
import com.blog.application.userposts.resources.User;

@Service
public class UserService {

	public static boolean admin ;
	
	public UserService() {
		// TODO Auto-generated constructor stub		
	}
	
	/**
	 * Consuming REST Api to list users
	 * @param id
	 * @return
	 */
	public List<Object> getUser(int id){
		RestTemplate template = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/users";
		
		User[] response = template.getForObject(url, User[].class, new Object[]{ id });

		List<Object> list = Arrays.stream(response)
			.filter(user -> user.getId().equals(id))
			.collect(Collectors.toList());
		
		return list;
	}
	
	/**
	 * Consuming REST api to list posts
	 * @param id
	 * @return
	 */
	public List<Object> getPosts(int id) {
		RestTemplate template = new RestTemplate();
		String url = "https://jsonplaceholder.typicode.com/posts";
		
		Post[] response = template.getForObject(url, Post[].class, new Object[]{ id });

		List<Object> posts = Arrays.stream(response)
			.filter(post -> post.getUserId().equals(id))
			.collect(Collectors.toList());
		
		return posts;
	}
}
