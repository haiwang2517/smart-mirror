package cn.haiyinlong.smart.mirror.application.assmber;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cn.haiyinlong.smart.mirror.application.dto.TodoVO;
import cn.haiyinlong.smart.mirror.domain.model.Todo;

@Mapper
public interface TodoVoAssembly {
    TodoVoAssembly INSTANCE = Mappers.getMapper(TodoVoAssembly.class);

    @Mapping(source = "targetDate.type", target = "targetDateType")
    @Mapping(source = "targetDate.year", target = "targetDateYear")
    @Mapping(source = "targetDate.month", target = "targetDateMonth")
    @Mapping(source = "targetDate.day", target = "targetDateDay")
    @Mapping(source = "repeatRule.periodType", target = "repeatPeriodType")
    @Mapping(source = "repeatRule.periodValue", target = "repeatPeriodValue")
    TodoVO assembly(Todo todo);

    List<TodoVO> assembly(List<Todo> todos);
}
