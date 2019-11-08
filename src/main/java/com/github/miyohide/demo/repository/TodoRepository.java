package com.github.miyohide.demo.repository;

import com.github.miyohide.demo.domain.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, String> {
}
