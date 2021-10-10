package com.demo.desafio.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.desafio.dto.PostDTO;
import com.demo.desafio.model.Post;
import com.demo.desafio.repositories.PostRepository;
import com.demo.desafio.services.exceptions.DatabaseException;
import com.demo.desafio.services.exceptions.ResourceNotFoundException;



@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	@Transactional(readOnly = true)
	public Page<PostDTO> findAllPaged(PageRequest pageRequest) {
		Page<Post> list = repository.findAll(pageRequest);
		return list.map(x -> new PostDTO(x));
	}

	@Transactional(readOnly = true)
	public PostDTO findById(Long id) {
		Optional<Post> obj = repository.findById(id);
		Post entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PostDTO(entity);
	}

	@Transactional
	public PostDTO insert(PostDTO dto) {
		Post entity = new Post();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setBody(dto.getBody());
		entity = repository.save(entity);
		return new PostDTO(entity);
	}

	@Transactional
	public PostDTO update(Long id, PostDTO dto) {
		try {
			Post entity = repository.getOne(id);
			entity.setTitle(dto.getTitle());
			entity.setDescription(dto.getDescription());
			entity.setBody(dto.getBody());
			entity = repository.save(entity);
			return new PostDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	
}
