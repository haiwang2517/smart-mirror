package cn.haiyinlong.smart.mirror.dto;

import lombok.Data;

/**
 * FutureTaskVO
 * @author HaiYinLong
 * @version 2025/02/27 18:08
**/
@Data
public class FutureTaskVO {
    private String summary;
    private Integer priority;
    private String dueDate;

    public FutureTaskVO(String summary, String dueDate) {
        this.summary = summary;
        this.dueDate = dueDate;
    }
}
