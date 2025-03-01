package cn.haiyinlong.smart.mirror.infrastructure.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.haiyinlong.smart.mirror.domain.model.Todo;
import cn.haiyinlong.smart.mirror.infrastructure.converter.TodoEntityToTodoConverter;
import cn.haiyinlong.smart.mirror.infrastructure.converter.TodoToTodoEntityConverter;
import cn.haiyinlong.smart.mirror.infrastructure.dao.TodoMapper;
import cn.haiyinlong.smart.mirror.infrastructure.dao.entity.TodoEntity;
import lombok.RequiredArgsConstructor;

/**
 * TodoRepository
 *
 * @author HaiYinLong
 * @version 2025/02/28 16:13
 **/
@Repository
@RequiredArgsConstructor
public class TodoRepository implements cn.haiyinlong.smart.mirror.domain.repository.TodoRepository {
    private final TodoMapper todoMapper;

    @Override
    public void delete(final Long id) {
        final TodoEntity todoEntity = todoMapper.selectById(id);
        if (!ObjectUtils.isEmpty(todoEntity)) {
            todoEntity.delete();
            todoMapper.updateById(todoEntity);
        }
    }

    @Override
    public void save(final Todo todo) {
        final TodoEntity todoEntity = TodoToTodoEntityConverter.INSTANCE.convert(todo);
        todoMapper.insert(todoEntity);
    }

    @Override
    public Todo getTodo(final Long id) {
        final TodoEntity todoEntity = todoMapper.selectById(id);
        if (!ObjectUtils.isEmpty(todoEntity)) {
            return TodoEntityToTodoConverter.INSTANCE.convert(todoEntity);
        }
        return null;
    }

    @Override
    public void update(final Todo todo) {
        final TodoEntity todoEntity = TodoToTodoEntityConverter.INSTANCE.convert(todo);
        todoMapper.updateById(todoEntity);
    }

    @Override
    public Page<Todo> pageTodo(Integer pageNum, Integer pageSize, String summary) {
        Page<TodoEntity> page = new Page<>(pageNum, pageSize);
        Page<TodoEntity> pageList = todoMapper.queryList(page, summary);
        Page<Todo> result = new Page<>(pageList.getCurrent(), pageList.getSize(), pageList.getTotal());
        result.setRecords(TodoEntityToTodoConverter.INSTANCE.convert(pageList.getRecords()));
        return result;
    }
}
