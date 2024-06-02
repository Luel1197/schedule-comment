package com.sparta.schedule.dto;

import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponse {
    private String title;

    private String description;

    private String manager;

    public ScheduleResponse(String title, String description, String manager) {
        this.title = title;
        this.description = description;
        this.manager = manager;
    }
}
