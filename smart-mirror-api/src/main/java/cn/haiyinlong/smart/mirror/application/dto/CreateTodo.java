package cn.haiyinlong.smart.mirror.application.dto;

import lombok.Data;

/**
 * CreateTodo
 *
 * @author HaiYinLong
 * @version 2025/02/28 15:06
 **/
@Data
public class CreateTodo {
    private String summary;
    /**
     * SOLAR(1), LUNAR(2)
     */
    private String targetDateType;
    private String targetDateYear;
    private String targetDateMonth;
    private String targetDateDay;
    /**
     * 秒、分钟、小时、日、周、月、年、季度
     */
    private String repeatPeriodType;
    /**
     * 周期值， 每1周
     */
    private Integer repeatPeriodValue;
}
