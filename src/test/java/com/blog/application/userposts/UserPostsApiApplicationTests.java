package com.blog.application.userposts;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.blog.application.userposts.services.UserService;


@WebMvcTest
class UserPostsApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	void setAdminAccess() throws Exception{		
		mockMvc.perform(post("/user/login")
				.content("{\"admin\": \"true\"}")
				.contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))			
				.andExpect(status().isOk()); 
	}
	
	@Test
	public void getUserPostsByID() throws Exception 
	{	
		userService.admin = true;		
		mockMvc.perform( MockMvcRequestBuilders
	      .get("/user/posts/{id}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(MockMvcResultHandlers.print())
	      .andExpect(status().isOk());
	}
}
