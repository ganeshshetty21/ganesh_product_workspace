package com.ganesh.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TodoHardCodedService {

	private static List<Todo> todos = new ArrayList<>();
	private static long idCounter = 0;

	{
		todos.add(new Todo(++idCounter, "Ganesh", "Playing Cricket", LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "Ganesh", "Learn Swimming", LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "Ganesh", "Reading Books", LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "Ganesh", "Singing Songs", LocalDate.now(), false));
		todos.add(new Todo(++idCounter, "Ganesh", "Listening to Songs", LocalDate.now(), false));

	}

	public List<Todo> findAll() {
		return todos;
	}

	public Optional<Todo> deleteById(long id) {
		Optional<Todo> todo = findById(id);
		if (todo.isPresent()) {
			todos.remove(todo.get());
			return todo;
		}
		return todo;
	}

	public Todo save(Todo todo) {
		long id = todo.getId();
		if (id == -1 || id == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(id);
			todos.add(todo);
		}
		return todo;
	}

	public Optional<Todo> findById(long id) {
		return todos.parallelStream().filter(todo -> todo.getId() == id).findFirst();
	}
}
