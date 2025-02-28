package cn.haiyinlong.smart.mirror.infrastructure.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cn.haiyinlong.smart.mirror.domain.model.Todo;
import cn.haiyinlong.smart.mirror.infrastructure.dao.entity.TodoEntity;

/**
 * TodoEntityToTodoConverter
 *
 * @author HaiYinLong
 * @version 2025/02/28 17:53
 **/
@Mapper
public interface TodoEntityToTodoConverter {
    TodoEntityToTodoConverter INSTANCE = Mappers.getMapper(TodoEntityToTodoConverter.class);

    Todo convert(TodoEntity todoEntity);
}
