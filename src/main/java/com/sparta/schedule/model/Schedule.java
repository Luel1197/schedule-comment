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
import lombok.Setter;

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


    //책임을 서비스말고 DB로 넘긴다.
    public boolean validatePassword(String password) {

        return this.password.equals(password);
    }


    public void validatePassword2(String password) {
        if (!this.password.equals(password)) {
            throw new IllegalArgumentException("잘못된 입력");
        }
    }

    public void update(String title, String description, String manager) {
        this.title = title;
        this.description = description;
        this.manager = manager;
    }

}
