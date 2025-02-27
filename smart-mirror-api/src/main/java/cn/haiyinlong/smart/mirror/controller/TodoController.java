package cn.haiyinlong.smart.mirror.controller;

import cn.haiyinlong.smart.mirror.dto.TodoTaskVO;
import cn.haiyinlong.smart.mirror.service.TodoQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TodoController
 * @author HaiYinLong
 * @version 2025/02/27 18:05
**/
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TodoController {
    private final TodoQueryService todoQueryService;

    @GetMapping("/tasks")
    public TodoTaskVO getTasks(){
        return todoQueryService.query();
    }
}
