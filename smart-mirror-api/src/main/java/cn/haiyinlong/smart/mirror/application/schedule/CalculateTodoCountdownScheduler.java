package cn.haiyinlong.smart.mirror.application.schedule;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.haiyinlong.smart.mirror.domain.model.Todo;
import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;
import cn.haiyinlong.smart.mirror.domain.repository.TodoCountdownRepository;
import cn.haiyinlong.smart.mirror.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CalculateTodoCountdownScheduler {
    private final TodoRepository todoRepository;
    private final TodoCountdownRepository todoCountdownRepository;

    @Scheduled(cron = "0 0 0 * * *")
    @Transactional(rollbackFor = Exception.class)
    public void calculateTodoCountdown() {
        List<Todo> todoList = todoRepository.queryAll();
        if (CollectionUtils.isEmpty(todoList)) {
            todoCountdownRepository.clean();
            return;
        }
        List<TodoCountdown> todoCountdownList = todoList.stream().map(Todo::calculateCountdown).toList();
        todoCountdownRepository.save(todoCountdownList);
    }
}
