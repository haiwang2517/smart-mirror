package cn.haiyinlong.smart.mirror.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.haiyinlong.smart.mirror.application.assmber.TodoVoAssembly;
import cn.haiyinlong.smart.mirror.application.dto.CreateTodo;
import cn.haiyinlong.smart.mirror.application.dto.PageResult;
import cn.haiyinlong.smart.mirror.application.dto.TodoVO;
import cn.haiyinlong.smart.mirror.application.dto.UpdateTodo;
import cn.haiyinlong.smart.mirror.application.valid.CreateTodoValid;
import cn.haiyinlong.smart.mirror.application.valid.UpdateTodoValid;
import cn.haiyinlong.smart.mirror.domain.factory.TodoFactory;
import cn.haiyinlong.smart.mirror.domain.model.Todo;
import cn.haiyinlong.smart.mirror.domain.repository.TodoRepository;
import lombok.RequiredArgsConstructor;

/**
 * TodoService
 *
 * @author HaiYinLong
 * @version 2025/02/28 15:05
 */
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional(rollbackFor = Exception.class)
    public void createTodo(final CreateTodo createTodo) {
        // 验证参数
        CreateTodoValid.valid(createTodo);
        final Todo todo = TodoFactory.createTodo(createTodo);
        todoRepository.save(todo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateTodo(final UpdateTodo updateTodo) {
        UpdateTodoValid.valid(updateTodo);
        final Todo todo = todoRepository.getTodo(updateTodo.getId());
        todo.modify(updateTodo);
        todoRepository.update(todo);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteTodo(final Long id) {
        todoRepository.delete(id);
    }

    public TodoVO queryTodo(Long id) {
        Todo todo = todoRepository.getTodo(id);
        return TodoVoAssembly.INSTANCE.assembly(todo);
    }

    public PageResult<TodoVO> pageTodo(Integer pageNum, Integer pageSize, String summary) {
        Page<Todo> page = todoRepository.pageTodo(pageNum, pageSize, summary);
        List<TodoVO> todoVOList = TodoVoAssembly.INSTANCE.assembly(page.getRecords());
        return PageResult.of(page.getPages(), page.getTotal(), todoVOList);
    }
}
