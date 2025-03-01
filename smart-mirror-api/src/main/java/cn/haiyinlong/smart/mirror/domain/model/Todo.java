package cn.haiyinlong.smart.mirror.domain.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import cn.haiyinlong.smart.mirror.application.dto.UpdateTodo;
import cn.haiyinlong.smart.mirror.domain.factory.TodoCountdownFactory;
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

    public TodoCountdown calculateCountdown() {
        // 计算倒计日
        TargetDate targetDate = this.targetDate;
        IntervalRule repeatRule = this.repeatRule;

        if (targetDate == null || repeatRule == null) {
            throw new IllegalArgumentException("Target date and repeat rule must be set.");
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime targetDateTime = LocalDateTime.of(Integer.parseInt(targetDate.getYear()),
            Integer.parseInt(targetDate.getMonth()), Integer.parseInt(targetDate.getDay()), 0, 0);

        long countdownDays = ChronoUnit.DAYS.between(now, targetDateTime);
        PeriodEnum periodTypeEnum = repeatRule.getPeriodType();

        if (countdownDays < 0) {
            // 如果当前时间已经超过目标时间，则计算下一个周期的目标时间
            while (countdownDays < 0) {
                targetDateTime = switch (periodTypeEnum) {
                    case QUARTER -> targetDateTime.plusMonths(3L * repeatRule.getPeriodValue());
                    case WEEK -> targetDateTime.plusWeeks(repeatRule.getPeriodValue());
                    case YEAR -> targetDateTime.plusYears(repeatRule.getPeriodValue());
                    case MONTH -> targetDateTime.plusMonths(repeatRule.getPeriodValue());
                    case DAY -> targetDateTime.plusDays(repeatRule.getPeriodValue());
                    default ->
                        throw new IllegalArgumentException("Unsupported period type: " + repeatRule.getPeriodType());
                };
                countdownDays = ChronoUnit.DAYS.between(now, targetDateTime);
            }
        }
        return TodoCountdownFactory.createTodoCountdown(this.getId(), this.getSummary(), countdownDays);
    }
}
