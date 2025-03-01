package cn.haiyinlong.smart.mirror.application.dto;

import java.util.List;

import lombok.Data;

@Data
public class PageResult<T> {
    private Long totalPage;
    private Long totalCount;

    private List<T> data;

    public static PageResult<TodoVO> of(long pages, long total, List<TodoVO> todoVOList) {
        PageResult<TodoVO> pageResult = new PageResult<>();
        pageResult.setTotalPage(pages);
        pageResult.setTotalCount(total);
        pageResult.setData(todoVOList);
        return pageResult;
    }
}
