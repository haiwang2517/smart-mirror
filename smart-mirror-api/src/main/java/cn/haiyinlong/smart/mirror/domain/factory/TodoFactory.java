package cn.haiyinlong.smart.mirror.domain.factory;

import cn.haiyinlong.smart.mirror.application.dto.CreateTodo;
import cn.haiyinlong.smart.mirror.domain.model.IntervalRule;
import cn.haiyinlong.smart.mirror.domain.model.TargetDate;
import cn.haiyinlong.smart.mirror.domain.model.Todo;

/**
 * TodoFactory
 *
 * @author HaiYinLong
 * @version 2025/02/28 17:04
 **/
public class TodoFactory {
    public static Todo createTodo(final CreateTodo createTodo) {
        final Todo todo = new Todo();
        todo.setSummary(createTodo.getSummary());
        final TargetDate targetDate = TargetDate.of(createTodo.getTargetDateType(), createTodo.getTargetDateYear(),
            createTodo.getTargetDateMonth(), createTodo.getTargetDateDay());
        todo.setTargetDate(targetDate);

        final IntervalRule repeatRule =
            IntervalRule.of(createTodo.getRepeatPeriodType(), createTodo.getRepeatPeriodValue());
        todo.setRepeatRule(repeatRule);
        return todo;
    }
}
