package br.com.zonework.jobs.application.service;

import br.com.zonework.jobs.domain.entity.Jobs;
import br.com.zonework.jobs.domain.repository.JobsRepository;
import br.com.zonework.structure.PaginateAndSortedQuery;

import java.util.List;

public class JobsService {
    private JobsRepository repository;

    public JobsService() {
        this.repository = new JobsRepository();
    }

    public PaginateAndSortedQuery<Jobs> getAllJobsActive(int numberMaxResult) {
        return repository.findAllActive(numberMaxResult);
    }

    public List<Jobs> getAllJobsActive() {
        return repository.findAllActive();
    }

}
