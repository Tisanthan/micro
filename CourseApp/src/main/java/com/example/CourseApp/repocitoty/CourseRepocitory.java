package com.example.CourseApp.repocitoty;

import com.example.CourseApp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CourseRepocitory extends JpaRepository<Course, BigInteger> {
}
