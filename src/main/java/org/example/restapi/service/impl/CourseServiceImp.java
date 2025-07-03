package org.example.restapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.CourseResponse;
import org.example.restapi.repository.CourseRepository;
import org.example.restapi.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<CourseResponse> getCourses(Boolean status, String title) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getStatus().equals(status))
                .filter(course -> course.getTitle().toLowerCase().contains(title.toLowerCase()))
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();
    }

    @Override
    public CourseResponse getCourseByCode(String code) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst()
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .orElse(null);
    }

    @Override
    public CourseResponse getCourseById(String id) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .orElse(null);
    }

}
