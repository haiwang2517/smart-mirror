package cn.haiyinlong.smart.mirror.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.haiyinlong.smart.mirror.application.schedule.CalculateTodoCountdownScheduler;
import lombok.RequiredArgsConstructor;

@RequestMapping("/schedule")
@RequiredArgsConstructor
@RestController
public class ScheduleController {
    private final CalculateTodoCountdownScheduler calculateTodoCountdownScheduler;

    @GetMapping("/trigger")
    public void trigger() {
        calculateTodoCountdownScheduler.calculateTodoCountdown();
    }
}
