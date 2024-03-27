package org.studyeasy.jobsportal.Rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.studyeasy.jobsportal.Entity.Jobs;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobsRestController {

    private JobsService JobsService;

    @Autowired
    public JobsRestController(JobsService theJobsService) {
        JobsService = theJobsService;
    }

    // return all jobs
    @GetMapping("/jobs")
    public List<Jobs> findAll() {
        return JobsService.findAll();
    }

    // add mapping for GET /jobs/{jobId}

    @GetMapping("/jobs/{jobId}")
    public Jobs getJob(int id) {
        Jobs job = JobsService.getJob(id);
        if (job == null) {
            throw new RuntimeException("Job id not found - " + id);
        }
        return job;
    }

    // add mapping for POST /jobs - add new job
    @GetMapping("/jobs")
    public Jobs addJob(@RequestBody Jobs job) {
        // also just in case the pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        job.setId(0);
        JobsService.save(job);
        return job;
    }

    // add mapping for PUT /jobs - update existing job

    @GetMapping("/jobs")
    public Jobs updateJob(@RequestBody Jobs job) {
        JobsService.save(job);
        return job;
    }

    // add mapping for DELETE /jobs/{jobId} - delete job

    public String deleteJob(int id) {
        Jobs job = JobsService.getJob(id);
        // throw exception if null
        if (job == null) {
            throw new RuntimeException("Job id not found - " + id);
        }
        JobsService.deleteJob(id);
        return "Deleted job id - " + id;
    }

}
