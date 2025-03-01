package cn.haiyinlong.smart.mirror.infrastructure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.haiyinlong.smart.mirror.infrastructure.dao.entity.TodoEntity;

@Mapper
public interface TodoMapper extends BaseMapper<TodoEntity> {

    Page<TodoEntity> queryList(Page<TodoEntity> page, @Param("summary") String summary);

    List<TodoEntity> queryAll();

}
