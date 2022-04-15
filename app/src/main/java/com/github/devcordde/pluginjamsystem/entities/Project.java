package com.github.devcordde.pluginjamsystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String projectName;
    @OneToMany
    private List<Artifact> artifacts = new ArrayList<>();


    public long id() {
        return id;
    }

    public String projectName() {
        return projectName;
    }

    public void id(long id) {
        this.id = id;
    }

    public void projectName(String projectName) {
        this.projectName = projectName;
    }

    public void artifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public List<Artifact> artifacts() {
        return artifacts;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Project) obj;
        return this.id == that.id &&
                Objects.equals(this.projectName, that.projectName) &&
                Objects.equals(this.artifacts, that.artifacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, artifacts);
    }

    @Override
    public String toString() {
        return "Project[" +
                "id=" + id + ", " +
                "projectName=" + projectName + ", " +
                "artifacts=" + artifacts + ']';
    }
}
