package cn.haiyinlong.smart.mirror.domain.model;

import lombok.Data;

/**
 * 目标时间
 *
 * @author HaiYinLong
 * @version 2025/02/28 15:21
 **/
@Data
public class TargetDate {
    private CalendarEnum type;
    private String year;
    private String month;
    private String day;

    public static TargetDate of(final String targetDateType, final String targetDateYear, final String targetDateMonth,
        final String targetDateDay) {
        final TargetDate targetDate = new TargetDate();
        targetDate.setType(CalendarEnum.valueOf(targetDateType));
        targetDate.setYear(targetDateYear);
        targetDate.setMonth(targetDateMonth);
        targetDate.setDay(targetDateDay);
        return targetDate;
    }
}
