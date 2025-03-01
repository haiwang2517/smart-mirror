package cn.haiyinlong.smart.mirror.application.valid;

import cn.haiyinlong.smart.mirror.application.dto.UpdateTodo;

/**
 * UpdateTodoValid
 *
 * @author HaiYinLong
 * @version 2025/02/28 17:49
 **/
public class UpdateTodoValid {
    public static void valid(UpdateTodo updateTodo) {
        if (updateTodo.getId() == null) {
            throw new IllegalArgumentException("id不能为空");
        }
        if (updateTodo.getSummary() == null || updateTodo.getSummary().isEmpty()) {
            throw new IllegalArgumentException("summary不能为空");
        }
        if (updateTodo.getTargetDateType() == null || updateTodo.getTargetDateType().isEmpty()) {
            throw new IllegalArgumentException("targetDateType不能为空");
        }
        if (updateTodo.getTargetDateYear() == null || updateTodo.getTargetDateYear().isEmpty()) {
            throw new IllegalArgumentException("targetDateYear不能为空");
        }
        if (updateTodo.getTargetDateMonth() == null || updateTodo.getTargetDateMonth().isEmpty()) {
            throw new IllegalArgumentException("targetDateMonth不能为空");
        }
        if (updateTodo.getTargetDateDay() == null || updateTodo.getTargetDateDay().isEmpty()) {
            throw new IllegalArgumentException("targetDateDay不能为空");
        }
        if (updateTodo.getRepeatPeriodValue() != null
            && (updateTodo.getRepeatPeriodType() == null || updateTodo.getRepeatPeriodType().isEmpty())) {
            throw new IllegalArgumentException("repeatPeriodType不能为空");
        }
        if (updateTodo.getRepeatPeriodType() != null
            && (updateTodo.getRepeatPeriodValue() == null || updateTodo.getRepeatPeriodValue() <= 0)) {
            throw new IllegalArgumentException("repeatPeriodValue不能为空");
        }
    }
}
