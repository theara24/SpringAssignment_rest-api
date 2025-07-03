package org.example.restapi.repository;

import lombok.Getter;
import lombok.Setter;
import org.example.restapi.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Setter
@Getter
public class CourseRepository {
    private List<Course> courses;

    public CourseRepository() {
        courses = new ArrayList<>();
        courses.add(Course.builder().id("1").code("ISTAD-101").title("Spring Framework").price(30.0).status(false).build());
        courses.add(Course.builder().id("2").code("ISTAD-102").title("NextJS").price(15.0).status(true).build());

    }
}
