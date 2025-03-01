package cn.haiyinlong.smart.mirror.domain.model;

import lombok.Data;

@Data
public class TodoCountdown implements Comparable<TodoCountdown> {
    private Long id;
    private String summary;
    private Integer priority;
    private Long countdown;

    public TodoCountdown() {
        this.priority = 0;
        this.countdown = 0L;
    }

    public static TodoCountdown of(Long id, String summary, long countdownDays) {
        TodoCountdown todoCountdown = new TodoCountdown();
        todoCountdown.setId(id);
        todoCountdown.setSummary(summary);
        todoCountdown.setCountdown(countdownDays);
        return todoCountdown;
    }

    @Override
    public int compareTo(TodoCountdown o) {
        return this.id.compareTo(o.id);
    }
}
