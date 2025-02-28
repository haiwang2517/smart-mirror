package cn.haiyinlong.smart.mirror.domain.model;

import lombok.Getter;

/**
 * PeriodEnum,秒、分钟、小时、日、周、月、年、季度
 * @author HaiYinLong
 * @version 2025/02/28 15:12
**/
@Getter
public enum PeriodEnum {
    SECOND(1),
    MINUTE(2),
    HOUR(3),
    DAY(4),
    WEEK(5),
    MONTH(6),
    YEAR(7),
    QUARTER(8);
    final int period;

    PeriodEnum(int period) {
        this.period = period;
    }
}
