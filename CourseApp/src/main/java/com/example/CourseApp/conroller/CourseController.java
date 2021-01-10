package com.example.CourseApp.conroller;

import com.example.CourseApp.entity.Course;
import com.example.CourseApp.repocitoty.CourseRepocitory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.jdi.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CourseController {
    @Autowired
    private CourseRepocitory courseRepocitory;
    @RequestMapping("/")
    public String getCourseAppHome() {
        return ("Course App Home");
    }
    @RequestMapping("/Course")
    public List<Course> getCourses() {
        return courseRepocitory.findAll();
    }
    @RequestMapping("/{id}")
    public Course getSpecificCourse(@PathVariable("id")BigInteger id) {
        return courseRepocitory.getOne(id);
    }
//    @RequestMapping("/{id}")
//    public Course getSpecificCourse(@PathVariable("id") BigInteger id){
//    return courseRepocitory.findById(id).get();
//    }
    @RequestMapping(method=RequestMethod.POST,value ="/Course")
    public void saveCourse(@RequestBody Course course) {
        courseRepocitory.save(course);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
    public void deleteCourse(@PathVariable ("id") BigInteger id) {
        courseRepocitory.deleteById(id);
    }
    @RequestMapping("/done")
    public String  done() {
        return "done";
    }
}
