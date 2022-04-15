package com.github.devcordde.pluginjamsystem.repositories;

import com.github.devcordde.pluginjamsystem.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Override
    List<Project> findAll();
}
