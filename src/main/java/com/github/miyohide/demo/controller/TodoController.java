package com.github.miyohide.demo.controller;

import com.github.miyohide.demo.domain.Todo;
import com.github.miyohide.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    @GetMapping("index")
    public String index(Model model) {
        Iterable<Todo> todos = todoRepository.findAll();

        model.addAttribute("todos", todos);
        return "todos/index";
    }
}
