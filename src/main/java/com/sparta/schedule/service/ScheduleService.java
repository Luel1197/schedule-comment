package com.sparta.schedule.service;


import com.sparta.schedule.dto.ScheduleDeleteRequest;
import com.sparta.schedule.dto.ScheduleResponse;
import com.sparta.schedule.dto.ScheduleUpdateRequest;
import com.sparta.schedule.model.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional()
public class ScheduleService {

    //서비스 부분 좀 공부해야 할듯
    private final ScheduleRepository scheduleRepository;

    //할일 생성
    public Long create(Schedule request) {
        Schedule schedule = new Schedule(request.getTitle(),
            request.getDescription(),
            request.getPassword(),
            request.getManager());

        return scheduleRepository.save(schedule).getId();
    }

    //할일 조회
    public ScheduleResponse findById(Long id) {
        Schedule schedule = findScheduleById(id);

        return new ScheduleResponse(schedule.getTitle(),
        schedule.getDescription(),
        schedule.getManager());
    }

    //할일 전체 조회
    public List<ScheduleResponse> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponse> scheduleResponses = new ArrayList<>();

        for (Schedule schedule : schedules) {
            ScheduleResponse response = new ScheduleResponse(schedule.getTitle(),
                schedule.getDescription(), schedule.getManager());

            scheduleResponses.add(response);
        }

        return scheduleResponses;

    }

    //업데이트
    @Transactional
    public void update(Long id, ScheduleUpdateRequest request) {
        Schedule schedule = findScheduleById(id);


        //1번
        if(!schedule.validatePassword(request.getPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        schedule.update(request.getTitle(), request.getDescription(), request.getManager());
            //@Transactional 이걸 걸어두면 jpa가 자동으로 저장? 해줌 저걸 걸어두면 이 메서드를 한 @Transactional이라고 한다.
//        scheduleRepository.save(schedule);
    }
    


    //딜리트
    @Transactional
    public void deleteById(Long id, ScheduleDeleteRequest request) {
        Schedule schedule = findScheduleById(id);


        //1번
        if(!schedule.validatePassword(request.getPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

//        //2번
//        schedule.validatePassword2(request.getPassword());

        scheduleRepository.deleteById(id);

    }


    private Schedule findScheduleById(Long id) {
        return scheduleRepository.findById(id).orElseThrow(()->new RuntimeException("Schedule not found"));
    }





    

}
