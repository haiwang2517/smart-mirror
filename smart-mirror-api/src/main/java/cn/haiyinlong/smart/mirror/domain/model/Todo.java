package cn.haiyinlong.smart.mirror.domain.model;

import java.time.LocalDateTime;

import cn.haiyinlong.smart.mirror.application.dto.UpdateTodo;
import lombok.Data;

/**
 * 待提醒事项
 *
 * @author HaiYinLong
 * @version 2025/02/28 14:59
 **/
@Data
public class Todo {
    private Long id;

    private String summary;
    /**
     * 目标时间
     */
    private TargetDate targetDate;
    /**
     * 重复规则
     */
    private IntervalRule repeatRule;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Todo() {
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

    public void modify(final UpdateTodo updateTodo) {
        this.summary = updateTodo.getSummary();
        this.targetDate = TargetDate.of(updateTodo.getTargetDateType(), updateTodo.getTargetDateYear(),
            updateTodo.getTargetDateMonth(), updateTodo.getTargetDateDay());
        this.repeatRule = IntervalRule.of(updateTodo.getRepeatPeriodType(), updateTodo.getRepeatPeriodValue());
        this.updateTime = LocalDateTime.now();
    }
}
