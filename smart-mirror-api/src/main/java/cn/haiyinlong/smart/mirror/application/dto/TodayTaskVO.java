package cn.haiyinlong.smart.mirror.application.dto;

import lombok.Data;

/**
 * TodayTaskVO
 * @author HaiYinLong
 * @version 2025/02/27 18:08
**/
@Data
public class TodayTaskVO {
    private String summary;
    private Integer priority;

    public TodayTaskVO(String summary, Integer priority) {
        this.summary = summary;
        this.priority = priority;
    }
}
