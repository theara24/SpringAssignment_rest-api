package org.example.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Course {
    private String id;
    private String code;
    private String title;
    private Double price;
    private Boolean status;
}
