package cn.haiyinlong.smart.mirror.infrastructure.converter;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

    @Mapping(target = "targetDate.type", source = "targetDateType")
    @Mapping(target = "targetDate.year", source = "targetDateYear")
    @Mapping(target = "targetDate.month", source = "targetDateMonth")
    @Mapping(target = "targetDate.day", source = "targetDateDay")
    @Mapping(target = "repeatRule.periodType", source = "repeatPeriodType")
    @Mapping(target = "repeatRule.periodValue", source = "repeatPeriodValue")
    Todo convert(TodoEntity todoEntity);

    List<Todo> convert(List<TodoEntity> records);
}
