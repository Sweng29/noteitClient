package com.noteit.app.repository;

import com.noteit.app.model.NotebookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotebookRepository extends JpaRepository<NotebookModel, Integer> {
}
