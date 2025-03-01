package cn.haiyinlong.smart.mirror.application.dto;

import java.util.ArrayList;
import java.util.List;

import cn.haiyinlong.smart.mirror.domain.model.TodoCountdown;
import lombok.Data;

/**
 * TodoTaskVO
 * 
 * @author HaiYinLong
 * @version 2025/02/27 18:07
 **/
@Data
public class TodoTaskVO {
    private List<TodoCountdown> todayTasks;
    private List<TodoCountdown> futureTasks;

    public TodoTaskVO() {
        this.todayTasks = new ArrayList<>();
        this.futureTasks = new ArrayList<>();
    }
}
