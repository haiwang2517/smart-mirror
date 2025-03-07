package cn.haiyinlong.smart.mirror.infrastructure.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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

    @Mapping(source = "targetDate.type", target = "targetDateType")
    @Mapping(source = "targetDate.year", target = "targetDateYear")
    @Mapping(source = "targetDate.month", target = "targetDateMonth")
    @Mapping(source = "targetDate.day", target = "targetDateDay")
    @Mapping(source = "repeatRule.periodType", target = "repeatPeriodType")
    @Mapping(source = "repeatRule.periodValue", target = "repeatPeriodValue")
    TodoEntity convert(Todo todo);

}