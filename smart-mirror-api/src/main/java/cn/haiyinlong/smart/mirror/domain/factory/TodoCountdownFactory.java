package cn.haiyinlong.smart.mirror.domain.factory;

import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;

public class TodoCountdownFactory {
    public static TodoCountdown createTodoCountdown(Long id, String summary, long countdownDays) {
        return TodoCountdown.of(id, summary, countdownDays);
    }
}
