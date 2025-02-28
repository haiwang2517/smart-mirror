package cn.haiyinlong.smart.mirror.infrastructure.dao.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 任务项
 */
@Data
@TableName(value = "TODO")
public class TodoEntity {
    /**
     *
     */
    @TableId
    private Integer id;

    private String summary;

    private Integer repeatPeriodType;

    private Integer repeatPeriodValue;

    private Integer targetDateType;

    private String targetDateYear;

    private String targetDateMonth;

    private String targetDateDay;

    private Integer delFlag;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public void delete() {
        this.delFlag = 1;
        this.updateTime = LocalDateTime.now();
    }
}
