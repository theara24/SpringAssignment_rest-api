package org.example.restapi.service;

import org.example.restapi.domain.Course;
import org.example.restapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    /**
     * Get All Course Data
     * @author Theara
     * @return List<CourseResponse>
     */
    List<CourseResponse> getCourses(Boolean status, String title);
    /**
     * Get Course By Code
     * @author Theara
     * @return CourseResponse
     */
    CourseResponse getCourseByCode(String code);
    /**
     * Get Course By id
     * @author Theara
     * @return CourseResponse
     */
    CourseResponse getCourseById(String id);
}
