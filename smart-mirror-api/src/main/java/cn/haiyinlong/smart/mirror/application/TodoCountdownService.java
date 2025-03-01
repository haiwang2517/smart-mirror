package cn.haiyinlong.smart.mirror.application;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.haiyinlong.smart.mirror.application.assmber.TodoTaskVoAssembly;
import cn.haiyinlong.smart.mirror.application.dto.TodoTaskVO;
import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;
import cn.haiyinlong.smart.mirror.domain.repository.TodoCountdownRepository;
import cn.haiyinlong.smart.mirror.domain.service.CalculateTodoCountdownService;
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
    private final CalculateTodoCountdownService calculateTodoCountdownService;

    public TodoTaskVO query() {
        Set<TodoCountdown> todoCountdownList = todoCountdownRepository.queryTodoCountdown();
        if (CollectionUtils.isEmpty(todoCountdownList)) {
            todoCountdownList = new HashSet<>(calculateTodoCountdownService.calculate());
        }
        return TodoTaskVoAssembly.assembly(todoCountdownList);
    }

}
