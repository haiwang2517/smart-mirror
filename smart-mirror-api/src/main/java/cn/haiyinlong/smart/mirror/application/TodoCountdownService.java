package cn.haiyinlong.smart.mirror.application;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.haiyinlong.smart.mirror.application.dto.TodoTaskVO;
import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;
import cn.haiyinlong.smart.mirror.domain.repository.TodoCountdownRepository;
import cn.haiyinlong.smart.mirror.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

/**
 * TodoCountdownService
 * 
 * @author HaiYinLong
 * @version 2025/02/27 18:06
 **/
@Service
@RequiredArgsConstructor
public class TodoCountdownService {
    private final TodoCountdownRepository todoCountdownRepository;
    private final TodoRepository todoRepository;

    public TodoTaskVO query() {
        Set<TodoCountdown> todoCountdownList = todoCountdownRepository.queryTodoCountdown();
        TodoTaskVO todoTaskVO = new TodoTaskVO();
        if (CollectionUtils.isEmpty(todoCountdownList)) {
            return todoTaskVO;
        }
        List<TodoCountdown> todayCountDownList =
            todoCountdownList.stream().filter(countdownItem -> countdownItem.getCountdown() == 0).toList();
        List<TodoCountdown> futureCountDownList =
            todoCountdownList.stream().filter(countdownItem -> countdownItem.getCountdown() > 0).toList();
        todoTaskVO.setFutureTasks(futureCountDownList);
        todoTaskVO.setTodayTasks(todayCountDownList);
        return todoTaskVO;
    }

}
