package cn.haiyinlong.smart.mirror.domain.repository;

import java.util.List;
import java.util.Set;

import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;

public interface TodoCountdownRepository {
    void save(TodoCountdown todoCountdown);

    void save(List<TodoCountdown> todoCountdownList);

    Set<TodoCountdown> queryTodoCountdown();

    void clean();
}
