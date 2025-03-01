package cn.haiyinlong.smart.mirror.application.assmber;

import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import cn.haiyinlong.smart.mirror.application.dto.TodoTaskVO;
import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;

public class TodoTaskVoAssembly {
    public static TodoTaskVO assembly(Set<TodoCountdown> todoCountdownList) {
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
