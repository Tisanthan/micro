package com.example.CourseCatalog;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatalogController {
    @Autowired
    EurekaClient client;
    @RequestMapping("/")
    @HystrixCommand(fallbackMethod = "resolveBreak")
    public  String getCatalogHome() {
        String courseMessage = "";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("tisu-courseApp-Service",false);
        String CourseURL = instanceInfo.getHomePageUrl();
        RestTemplate restTemplate = new RestTemplate();
        courseMessage = restTemplate.getForObject(CourseURL,String.class);
        return ("this is a catalog home "+ courseMessage);
    }

    @RequestMapping("/Catalog")
    public String getCourses() {
        String courses = "";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("tisu-courseApp-Service",false);
        String coursesUrl = instanceInfo.getHomePageUrl();
        RestTemplate restTemplate = new RestTemplate();
        courses = restTemplate.getForObject(coursesUrl+"/Course",String.class);
        return("These are the course of your required: "+ courses);
    }
    @RequestMapping("/FirstCourse")
    public String GetSpecificourse(){
        Course course = new Course();
        users users = new users();
        InstanceInfo instanceInfo = client.getNextServerFromEureka("tisu-CourseApp-Service",false );
        String courseAppURL = instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL + "/1";
        RestTemplate  restTemplate = new RestTemplate();
        course = restTemplate.getForObject(courseAppURL,Course.class);
        instanceInfo =client.getNextServerFromEureka("tisu-UserApp-Service",false);
        String userAppURL = instanceInfo.getHomePageUrl();
        userAppURL = userAppURL + "/" + course.getCourseId();
        String usersList = restTemplate.getForObject(userAppURL,String.class);
        return ("our First Course is "+ course.getCourseName() + "and  enrolled users are " + usersList);
    }

    public String resolveBreak() {
        return ("please try again");
    }
}
