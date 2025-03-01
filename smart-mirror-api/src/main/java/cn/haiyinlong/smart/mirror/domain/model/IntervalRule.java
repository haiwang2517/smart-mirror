package cn.haiyinlong.smart.mirror.domain.model;

import lombok.Data;

/**
 * 重复规则<br>
 * 每日、每周、每月、每月几号、每周几、每3天
 *
 * @author HaiYinLong
 * @version 2025/02/28 15:00
 **/
@Data
public class IntervalRule {
    /**
     * 日、周、月、年、季度
     */
    private PeriodEnum periodType;

    /**
     * 周期值， 每1周
     */
    private Integer periodValue;

    public static IntervalRule of(final String repeatPeriodType, final Integer repeatPeriodValue) {
        final IntervalRule intervalRule = new IntervalRule();
        intervalRule.setPeriodType(PeriodEnum.valueOf(repeatPeriodType));
        intervalRule.setPeriodValue(repeatPeriodValue);
        return intervalRule;
    }
}
