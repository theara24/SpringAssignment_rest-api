package org.example.restapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.restapi.domain.Course;
import org.example.restapi.dto.CourseResponse;
import org.example.restapi.repository.CourseRepository;
import org.example.restapi.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;

    // Filter ដោយ Status
    @Override
    public List<CourseResponse> getCoursesByStatus(Boolean status) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getStatus().equals(status))
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();
    }

    // Filter ដោយ Title
    @Override
    public List<CourseResponse> getCoursesByTitle(String title) {
        return courseRepository.getCourses().stream()
                .filter(course -> course.getTitle().toLowerCase().contains(title.toLowerCase()))
                .map(course -> CourseResponse.builder()
                        .code(course.getCode())
                        .title(course.getTitle())
                        .price(course.getPrice())
                        .status(course.getStatus())
                        .build())
                .toList();
    }

    // Find ដោយ Code
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

    // Find ដោយ ID
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
