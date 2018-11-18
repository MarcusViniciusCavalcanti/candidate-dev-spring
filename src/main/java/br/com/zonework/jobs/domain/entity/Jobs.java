package br.com.zonework.jobs.domain.entity;

import br.com.zonework.members.domain.entity.Members;
import br.com.zonework.structure.JPA.EntityApplication;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Jobs extends EntityApplication {
    @Column private String title;
    @Column private String description;
    @Column private LocalDate initDate;
    @Column private Boolean isActive;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "jobs_candidate",
            joinColumns = @JoinColumn(name = "jobs_id"),
            inverseJoinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<Members> candidates;

    public Jobs() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<Members> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Members> candidates) {
        this.candidates = candidates;
    }
}
