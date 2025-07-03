package org.example.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.restapi.domain.Course;
import org.example.restapi.dto.CourseResponse;
import org.example.restapi.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
// @RestController = @Controller + @ResponseBody
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/filter/status")
    public ResponseEntity<?> getCoursesByStatus(
            @RequestParam Boolean status) {
        return ResponseEntity.ok(courseService.getCoursesByStatus(status));
    }

    @GetMapping("/filter/title")
    public ResponseEntity<?> getCoursesByTitle(
            @RequestParam String title) {
        return ResponseEntity.ok(courseService.getCoursesByTitle(title));
    }


    @GetMapping("/code")
    public ResponseEntity<?> getCourseByCode(@RequestParam String code) {
        CourseResponse response = courseService.getCourseByCode(code);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping("/id")
    public ResponseEntity<?> getCourseById(@RequestParam String id) {
        CourseResponse response = courseService.getCourseById(id);
        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

}
