package com.github.devcordde.pluginjamsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "artifact")
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private ArtifactType artifactType;
    @ManyToOne
    private Project project;

    public long id() {
        return id;
    }

    public ArtifactType artifactType() {
        return artifactType;
    }

    public Project project() {
        return project;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Artifact) obj;
        return this.id == that.id &&
                Objects.equals(this.artifactType, that.artifactType) &&
                Objects.equals(this.project, that.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artifactType, project);
    }

    @Override
    public String toString() {
        return "Artifact[" +
                "id=" + id + ", " +
                "artifactType=" + artifactType + ", " +
                "project=" + project + ']';
    }

    public void id(long id) {
        this.id = id;
    }

    public void artifactType(ArtifactType artifactType) {
        this.artifactType = artifactType;
    }

    public void project(Project project) {
        this.project = project;
    }
}
