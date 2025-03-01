package cn.haiyinlong.smart.mirror.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cn.haiyinlong.smart.mirror.application.dto.FutureTaskVO;
import cn.haiyinlong.smart.mirror.application.dto.TodayTaskVO;
import cn.haiyinlong.smart.mirror.application.dto.TodoTaskVO;
import lombok.RequiredArgsConstructor;

/**
 * TodoQueryServiceImpl
 * 
 * @author HaiYinLong
 * @version 2025/02/27 18:06
 **/
@Service
@RequiredArgsConstructor
public class TodoQueryService {
    public TodoTaskVO query() {
        List<TodayTaskVO> todayTasks = new ArrayList<>();
        todayTasks.add(new TodayTaskVO("去爬南山", 1));
        todayTasks.add(new TodayTaskVO("去北站取快递", 1));
        todayTasks.add(new TodayTaskVO("晚上取看演唱会", 1));
        List<FutureTaskVO> futureTasks = new ArrayList<>();
        futureTasks.add(new FutureTaskVO("燕燕生日", " 10 天"));
        futureTasks.add(new FutureTaskVO("准备去欧洲旅游", " 15 天"));
        TodoTaskVO todoTaskVO = new TodoTaskVO();
        todoTaskVO.setFutureTasks(futureTasks);
        todoTaskVO.setTodayTasks(todayTasks);
        return todoTaskVO;
    }

}
