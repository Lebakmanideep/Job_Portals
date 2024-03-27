package org.studyeasy.jobsportal.Rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.studyeasy.jobsportal.Entity.Jobs;
import org.studyeasy.jobsportal.Services.JobsService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobsRestController {

    private final JobsService jobsService;

    @Autowired
    public JobsRestController(JobsService theJobsService) {
        jobsService = theJobsService;
    }

    // return all jobs
    @GetMapping("/jobs")
    public List<Jobs> findAll() {
        return jobsService.findAll();
    }

    // add mapping for GET /jobs/{jobId}

    @GetMapping("/jobs/{jobId}")
    public Jobs getJob(int id) {
        Jobs job = jobsService.getJob(id);
        if (job == null) {
            throw new RuntimeException("Job id not found - " + id);
        }
        return job;
    }

    // add mapping for POST /jobs - add new job
    @PostMapping("/jobs")
    public Jobs addJob(@RequestBody Jobs job) {
        // also just in case the pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        job.setId(0);
        jobsService.save(job);
        return job;
    }

    // add mapping for PUT /jobs - update existing job

    @PutMapping("/jobs")
    public Jobs updateJob(@RequestBody Jobs job) {
        jobsService.save(job);
        return job;
    }

    // add mapping for DELETE /jobs/{jobId} - delete job
    @DeleteMapping
    public String deleteJob(int id) {
        Jobs job = jobsService.getJob(id);
        // throw exception if null
        if (job == null) {
            throw new RuntimeException("Job id not found - " + id);
        }
        jobsService.deleteJob(id);
        return "Deleted job id - " + id;
    }

}
