package cn.haiyinlong.smart.mirror.infrastructure.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cn.haiyinlong.smart.mirror.domain.model.Todo;
import cn.haiyinlong.smart.mirror.infrastructure.dao.entity.TodoEntity;

/**
 * TodoToTodoEntityConverter
 *
 * @author HaiYinLong
 * @version 2025/02/28 17:34
 **/
@Mapper
public interface TodoToTodoEntityConverter {
    TodoToTodoEntityConverter INSTANCE = Mappers.getMapper(TodoToTodoEntityConverter.class);

    TodoEntity convert(Todo todo);
}
