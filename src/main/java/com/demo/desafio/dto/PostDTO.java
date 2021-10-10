package com.demo.desafio.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotBlank;

import com.demo.desafio.model.Post;


public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String title;
	
	@NotBlank(message = "Campo obrigatório")
	private String description;
	
	@NotBlank(message = "Campo obrigatório")
	private String body;
	
 	private Instant createdAt;
	
	public PostDTO() {
	}


	
	
	
	
	public PostDTO(Long id, String title, String description, String body, Instant createdAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.body = body;
		this.createdAt = createdAt;
	}


	public PostDTO(Post entity) {
		
		id = entity.getId();
		title = entity.getTitle();
		description = entity.getDescription();
		body = entity.getBody();
		createdAt= entity.getCreatedAt();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}






	public Instant getCreatedAt() {
		return createdAt;
	}


	
	
}
