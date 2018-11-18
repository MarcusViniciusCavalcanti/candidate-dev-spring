package br.com.zonework.jobs.domain.repository;

import br.com.zonework.jobs.domain.entity.Jobs;
import br.com.zonework.structure.JPA.Repository;
import br.com.zonework.structure.PaginateAndSortedQuery;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

public class JobsRepository extends Repository<Jobs> {

    public JobsRepository() {
        super(Jobs.class);
    }

    public PaginateAndSortedQuery<Jobs> findAllActive(int numberPage) {
        CriteriaBuilder  criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> contQuery = criteriaBuilder.createQuery(Long.class);
        contQuery.select(criteriaBuilder.count(contQuery.from(Jobs.class)));

        Long count = entityManager.createQuery(contQuery).getSingleResult();

        CriteriaQuery<Jobs> jobsCriteriaQuery = criteriaBuilder.createQuery(Jobs.class);

        Root<Jobs> jobsRoot = jobsCriteriaQuery.from(Jobs.class);
        CriteriaQuery<Jobs> select = jobsCriteriaQuery.select(jobsRoot);

        TypedQuery<Jobs> jobsTypedQuery = entityManager.createQuery(select);

        return new PaginateAndSortedQuery<Jobs>(jobsTypedQuery, count, numberPage);
    }

    public List<Jobs> findAllActive() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Jobs> criteriaQuery = criteriaBuilder.createQuery(Jobs.class);
        Root<Jobs> root = criteriaQuery.from(Jobs.class);

        criteriaQuery.select(root).where(criteriaBuilder.isTrue(root.get("isActive")));

        TypedQuery<Jobs> query = entityManager.createQuery(criteriaQuery);
        return Collections.unmodifiableList(query.getResultList());
    }
}
