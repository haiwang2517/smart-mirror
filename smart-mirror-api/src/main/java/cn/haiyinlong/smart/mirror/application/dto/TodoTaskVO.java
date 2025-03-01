package cn.haiyinlong.smart.mirror.application.dto;

import java.util.List;

import lombok.Data;

/**
 * TodoTaskVO
 * 
 * @author HaiYinLong
 * @version 2025/02/27 18:07
 **/
@Data
public class TodoTaskVO {
    private List<TodayTaskVO> todayTasks;
    private List<FutureTaskVO> futureTasks;
}
