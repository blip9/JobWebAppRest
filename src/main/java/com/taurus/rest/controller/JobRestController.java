package com.taurus.rest.controller;

import com.taurus.rest.model.Jobpost;
import com.taurus.rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    public JobService service;
    public JobService getService() {
        return service;
    }
    @Autowired
    public void setService(JobService service) {
        this.service = service;
    }
    @GetMapping("jobPosts")
    public List<Jobpost> getAllJobs() throws SQLException {

        return service.viewAllJobs();
    }

    @PostMapping("addJob")
    public void addJob(@RequestBody Jobpost jobpost) throws SQLException {
        service.addJob(jobpost);
    }
    @GetMapping("getJob/{postId}")
    public Jobpost getJob(@PathVariable("postId") int postId) throws SQLException {
        return service.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<Jobpost> search(@PathVariable("keyword")String keyword){
        return service.search(keyword,keyword,keyword);
    }
    @DeleteMapping("delete/{id}")
    public void deleteJob(@PathVariable("id") int postId) throws SQLException {
        service.deleteJob(postId);
    }
    @PutMapping("addJob")
    public void updateJob(@RequestBody Jobpost jobpost) throws SQLException {
        service.addJob(jobpost);
    }



}


