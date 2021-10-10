package com.demo.desafio.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5, max=60, message = "Deve ter entre 3 e 50 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String title;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@NotBlank(message = "Campo obrigatório")
	@Column(columnDefinition = "TEXT")
	private String body;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;

	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;
	
	

	

	
	public Post() {
		
	}

	public Post(Long id, String title, String description, String body) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.body = body;
	
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

	
	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
	}

	
	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}

