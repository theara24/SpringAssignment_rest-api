package org.example.restapi.service;

import org.example.restapi.domain.Course;
import org.example.restapi.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    /***
     * ទាញព័ត៌មានវគ្គសិក្សាទាំងអស់
     */
    List<CourseResponse> getCoursesByStatus(Boolean status);
    List<CourseResponse> getCoursesByTitle(String title);
    CourseResponse getCourseByCode(String code);
    CourseResponse getCourseById(String id);
}
