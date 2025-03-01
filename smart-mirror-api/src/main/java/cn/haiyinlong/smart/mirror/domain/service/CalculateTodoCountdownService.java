package cn.haiyinlong.smart.mirror.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.haiyinlong.smart.mirror.domain.model.Todo;
import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;
import cn.haiyinlong.smart.mirror.domain.repository.TodoCountdownRepository;
import cn.haiyinlong.smart.mirror.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CalculateTodoCountdownService {
    private final TodoRepository todoRepository;
    private final TodoCountdownRepository todoCountdownRepository;

    @Transactional(rollbackFor = Exception.class)
    public List<TodoCountdown> calculate() {
        List<Todo> todoList = todoRepository.queryAll();
        if (CollectionUtils.isEmpty(todoList)) {
            todoCountdownRepository.clean();
            return new ArrayList<>();
        }
        List<TodoCountdown> todoCountdownList = todoList.stream().map(Todo::calculateCountdown).toList();
        todoCountdownRepository.save(todoCountdownList);
        return todoCountdownList;
    }
}
