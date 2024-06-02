package com.sparta.schedule.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String password;

    @Column
    private String manager;

    @Column
    private String createAt;







    public Schedule(String title, String description, String password, String manager) {
        this.title = title;
        this.description = description;
        this.password = password;
        this.manager = manager;
        this.createAt = LocalDateTime.now().toString();
    }



}
