package org.studyeasy.jobsportal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.studyeasy.jobsportal.DAO.JobsRepository;
import org.studyeasy.jobsportal.Entity.Jobs;

import java.util.List;
import java.util.Optional;

@Service
public class JobsServiceImpl implements JobsService{
    private final JobsRepository JobsRepository;
    @Autowired
    public JobsServiceImpl(JobsRepository theJobsRepository) {
        this.JobsRepository = theJobsRepository;
    }
    @Override
    public List<Jobs> findAll() {
        return JobsRepository.findAll();
    }

    @Override
    public Jobs getJob(int id) {
        Optional<Jobs> result = JobsRepository.findById(id);
        Jobs job = null;
        if (result.isPresent()) {
            job = result.get();
        }
        else {
            throw new RuntimeException("Did not find job id - " + id);
        }

        return job;
    }

    @Override
    public void save(Jobs job) {
        JobsRepository.save(job);
    }

    @Override
    public void updateJob(Jobs job) {
        JobsRepository.save(job);
    }

    @Override
    public void deleteJob(int id) {
        JobsRepository.deleteById(id);
    }
}
