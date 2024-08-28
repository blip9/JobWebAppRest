package com.taurus.rest.service;

import com.taurus.rest.model.Jobpost;
import com.taurus.rest.repo.Jobrepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service

public class JobService {


    Jobrepo repo;

    public JobService(Jobrepo repo) {
        this.repo = repo;
    }

    public void addJob(Jobpost jobpost) throws SQLException {
        repo.save(jobpost);

    }
    public Jobpost getJob(int postId) throws SQLException {
        return repo.findById(postId).orElse(new Jobpost());
    }

    public List<Jobpost> viewAllJobs() throws SQLException {
        return repo.findAll();
    }
    public void deleteJob(int postId) throws SQLException {
        repo.deleteById(postId);
    }
    public List<Jobpost> search(String keyword, String keyword1, String keyword2) {
        return repo.findByPostDescContainingOrPostProfileContaining(keyword,keyword2);
    }


}
