package cn.haiyinlong.smart.mirror.application.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.haiyinlong.smart.mirror.domain.service.CalculateTodoCountdownService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CalculateTodoCountdownScheduler {

    private final CalculateTodoCountdownService calculateTodoCountdownService;

    @Scheduled(cron = "0 0 0 * * *")
    public void calculateTodoCountdown() {
        calculateTodoCountdownService.calculate();
    }
}
