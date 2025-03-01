package cn.haiyinlong.smart.mirror.web.controller;

import org.springframework.web.bind.annotation.*;

import cn.haiyinlong.smart.mirror.application.TodoQueryService;
import cn.haiyinlong.smart.mirror.application.TodoService;
import cn.haiyinlong.smart.mirror.application.dto.*;
import lombok.RequiredArgsConstructor;

/**
 * TodoController
 * 
 * @author HaiYinLong
 * @version 2025/02/27 18:05
 **/
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {
    private final TodoQueryService todoQueryService;
    private final TodoService todoService;

    @GetMapping("/tasks")
    public TodoTaskVO getTasks() {
        return todoQueryService.query();
    }

    @PostMapping("/todo")
    public void createTodo(@RequestBody CreateTodo createTodo) {
        todoService.createTodo(createTodo);
    }

    @PutMapping("/todo")
    public void updateTodo(@RequestBody UpdateTodo updateTodo) {
        todoService.updateTodo(updateTodo);
    }

    @DeleteMapping("/todo/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @GetMapping("/todo/{id}")
    public TodoVO getTodo(@PathVariable Long id) {
        return todoService.queryTodo(id);
    }

    @GetMapping("/todo/page")
    public PageResult<TodoVO> getPageTodo(@RequestParam("pageNum") Integer pageNum,
        @RequestParam("pageSize") Integer pageSize, @RequestParam(value = "summary", required = false) String summary) {
        return todoService.pageTodo(pageNum, pageSize, summary);
    }

}
