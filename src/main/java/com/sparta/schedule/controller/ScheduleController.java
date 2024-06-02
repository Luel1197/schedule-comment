package com.sparta.schedule.controller;


import com.sparta.schedule.dto.ScheduleResponse;
import com.sparta.schedule.model.Schedule;
import com.sparta.schedule.service.ScheduleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor

public class ScheduleController {

    private final ScheduleService scheduleService;

    //404보내기위한 엔티티 (리스폰스 엔티티) 할일 생성
    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody Schedule request) {

        Long id = scheduleService.create(request);

        return ResponseEntity.ok(id + "Schedule created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponse> findById(@PathVariable Long id) {

        ScheduleResponse response = scheduleService.findById(id);
        return ResponseEntity.ok(response);

    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> findAll() {
        List<ScheduleResponse> responses = scheduleService.findAll();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteById(id);
        return ResponseEntity.ok(id+"Schedule deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long id, @RequestBody Schedule request) {
        scheduleService.update(id, request);
        return ResponseEntity.ok(id+"Schedule updated");
    }





}
