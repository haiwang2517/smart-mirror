package cn.haiyinlong.smart.mirror.infrastructure.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TodoCountdownRepository implements cn.haiyinlong.smart.mirror.domain.repository.TodoCountdownRepository {
    private static final Set<TodoCountdown> TODO_COUNTDOWN_SET = new HashSet<>();

    @Override
    public void save(TodoCountdown todoCountdown) {
        TODO_COUNTDOWN_SET.add(todoCountdown);
    }

    @Override
    public void save(List<TodoCountdown> todoCountdownList) {
        TODO_COUNTDOWN_SET.addAll(todoCountdownList);
    }

    @Override
    public Set<TodoCountdown> queryTodoCountdown() {
        return TODO_COUNTDOWN_SET;
    }

    @Override
    public void clean() {
        TODO_COUNTDOWN_SET.clear();
    }
}
