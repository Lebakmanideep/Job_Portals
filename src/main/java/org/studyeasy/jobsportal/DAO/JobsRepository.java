package org.studyeasy.jobsportal.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.studyeasy.jobsportal.Entity.Jobs;

public interface JobsRepository extends JpaRepository<Jobs, Integer> {
}
