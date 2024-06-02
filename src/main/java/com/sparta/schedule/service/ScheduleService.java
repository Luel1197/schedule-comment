package com.sparta.schedule.service;


import com.sparta.schedule.dto.ScheduleResponse;
import com.sparta.schedule.model.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
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
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(()->new RuntimeException("Schedule not found"));

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



    




//    //딜리트
//
//    public Long update(Schedule request) {
//       scheduleRepository.delete();
//    }







    

}
