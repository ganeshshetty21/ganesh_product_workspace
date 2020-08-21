package com.ganesh.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResourceController {

	@Autowired
	private TodoHardCodedService todoService;

	@GetMapping("/users/{userName}/todos")
	public List<Todo> getAllTodos(@PathVariable String userName) {
		return todoService.findAll();
	}

	@GetMapping("/users/{userName}/todos/{id}")
	// public ResponseEntity<Todo> getTodo(@PathVariable String userName,
	// @PathVariable long id) {
	public Todo getTodo(@PathVariable String userName, @PathVariable long id) {
		Optional<Todo> todo = todoService.findById(id);
		if (todo.isPresent()) {
			// return todoService.findById(id).get();
			return todo.get();
		}
		// return ResponseEntity.notFound().build();
		return null;
	}

	@PutMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String userName, @PathVariable long id,
			@RequestBody Todo todo) {
		Todo updatedTodo = todoService.save(todo);
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}

	@PostMapping("/users/{userName}/todos")
	public ResponseEntity<Void> craeteTodo(@PathVariable String userName, @RequestBody Todo todo) {
		Todo createdTodo = todoService.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/users/{userName}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String userName, @PathVariable long id) {
		Optional<Todo> todo = todoService.deleteById(id);
		if (todo.isPresent()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
