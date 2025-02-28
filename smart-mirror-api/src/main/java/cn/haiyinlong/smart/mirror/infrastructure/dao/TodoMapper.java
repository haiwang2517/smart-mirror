package cn.haiyinlong.smart.mirror.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.haiyinlong.smart.mirror.infrastructure.dao.entity.TodoEntity;

@Mapper
public interface TodoMapper extends BaseMapper<TodoEntity> {

}
