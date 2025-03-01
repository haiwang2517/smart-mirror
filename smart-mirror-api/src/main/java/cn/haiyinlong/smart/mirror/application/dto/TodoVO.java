package cn.haiyinlong.smart.mirror.application.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TodoVO {
    private Long id;
    private String summary;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
