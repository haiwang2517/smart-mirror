package cn.haiyinlong.smart.mirror.domain.repository;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.haiyinlong.smart.mirror.domain.model.Todo;

/**
 * TodoRepository
 *
 * @author HaiYinLong
 * @version 2025/02/28 16:13
 **/
public interface TodoRepository {
    void delete(Long id);

    void save(Todo todo);

    Todo getTodo(Long id);

    void update(Todo todo);

    Page<Todo> pageTodo(Integer pageNum, Integer pageSize, String summary);

    List<Todo> queryAll();
}
