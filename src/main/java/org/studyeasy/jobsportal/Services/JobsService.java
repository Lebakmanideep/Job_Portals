package org.studyeasy.jobsportal.Services;

import org.studyeasy.jobsportal.Entity.Jobs;

import java.util.List;

public interface JobsService {
    public List<Jobs> findAll();
    public Jobs getJob(int id);
    public void save(Jobs job);
    public void updateJob(Jobs job);
    public void deleteJob(int id);



}
