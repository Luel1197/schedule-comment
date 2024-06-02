package com.sparta.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleCreatedRequest {
    private String title;

    private String description;

    private String manager;

    private String password;


}
