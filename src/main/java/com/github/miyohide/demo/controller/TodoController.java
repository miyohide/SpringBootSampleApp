package com.github.miyohide.demo.controller;

import com.github.miyohide.demo.domain.Todo;
import com.github.miyohide.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoRepository todoRepository;

    @GetMapping
    public String index(Model model) {
        Iterable<Todo> todos = todoRepository.findAll();

        model.addAttribute("todos", todos);
        return "todo/index";
    }

    @GetMapping("new")
    public String newTodo(Model model) {
        return "todo/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Todo> todo = todoRepository.findById(id.toString());
        if (todo.isPresent()) {
            model.addAttribute("todo", todo.get());
            return "todo/edit";
        } else {
            return "redirect:/todo";
        }
    }

    @GetMapping("{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Todo> todo = todoRepository.findById(id.toString());
        if (todo.isPresent()) {
            model.addAttribute("todo", todo.get());
            return "todo/show";
        } else {
            return "redirect:/todo";
        }
    }

    @PostMapping
    public String create(@ModelAttribute Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        todoRepository.save(todo);
        return "redirect:/todo";
    }

    @PutMapping("{id}")
    public String update(@PathVariable Integer id, @ModelAttribute Todo todo) {
        todo.setTodoId(id.toString());
        todoRepository.save(todo);
        return "redirect:/todo";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        todoRepository.deleteById(id.toString());
        return "redirect:/todo";
    }
}
