package com.sparta.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleUpdateRequest {
    private String title;

    private String description;

    private String manager;

    private String password;
}
