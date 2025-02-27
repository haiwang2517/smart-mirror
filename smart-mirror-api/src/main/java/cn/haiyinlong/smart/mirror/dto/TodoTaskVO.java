package cn.haiyinlong.smart.mirror.dto;

import lombok.Data;

import java.util.List;

/**
 * TodoTaskVO
 * @author HaiYinLong
 * @version 2025/02/27 18:07
**/
@Data
public class TodoTaskVO {
    private List<TodayTaskVO> todayTasks;
    private List<FutureTaskVO> futureTasks;
}
