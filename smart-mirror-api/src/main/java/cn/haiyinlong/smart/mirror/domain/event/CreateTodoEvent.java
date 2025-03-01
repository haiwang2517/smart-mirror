package cn.haiyinlong.smart.mirror.domain.event;

import org.springframework.context.ApplicationEvent;

import cn.haiyinlong.smart.mirror.domain.model.Todo;
import lombok.Getter;

@Getter
public class CreateTodoEvent extends ApplicationEvent {
    private final Todo todo;

    public CreateTodoEvent(Object source, Todo todo) {
        super(source);
        this.todo = todo;
    }
}
