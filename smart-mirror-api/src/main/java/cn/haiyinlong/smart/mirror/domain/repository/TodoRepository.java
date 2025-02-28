package cn.haiyinlong.smart.mirror.domain.repository;

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
}
