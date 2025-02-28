package cn.haiyinlong.smart.mirror.application.valid;

import cn.haiyinlong.smart.mirror.application.dto.CreateTodo;

/**
 * CreateTodoValid
 *
 * @author HaiYinLong
 * @version 2025/02/28 17:36
 **/
public class CreateTodoValid {
    public static void valid(final CreateTodo createTodo) {
        if (createTodo == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        if (createTodo.getSummary() == null || createTodo.getSummary().isEmpty()) {
            throw new IllegalArgumentException("summary不能为空");
        }
        if (createTodo.getTargetDateType() == null || createTodo.getTargetDateType().isEmpty()) {
            throw new IllegalArgumentException("targetDateType不能为空");
        }
        if (createTodo.getTargetDateYear() == null || createTodo.getTargetDateYear().isEmpty()) {
            throw new IllegalArgumentException("targetDateYear不能为空");
        }
        if (createTodo.getTargetDateMonth() == null || createTodo.getTargetDateMonth().isEmpty()) {
            throw new IllegalArgumentException("targetDateMonth不能为空");
        }
        if (createTodo.getTargetDateDay() == null || createTodo.getTargetDateDay().isEmpty()) {
            throw new IllegalArgumentException("targetDateDay不能为空");
        }
        if (createTodo.getRepeatPeriodValue() != null
            && (createTodo.getRepeatPeriodType() != null || createTodo.getRepeatPeriodType().isEmpty())) {
            throw new IllegalArgumentException("repeatPeriodType不能为空");
        }
        if (createTodo.getRepeatPeriodType() != null
            && (createTodo.getRepeatPeriodValue() == null || createTodo.getRepeatPeriodValue() <= 0)) {
            throw new IllegalArgumentException("repeatPeriodValue不能为空");
        }
    }
}
