package com.noteit.app.service;

import com.noteit.app.model.NotebookModel;
import com.noteit.app.repository.NotebookRepository;
import org.springframework.stereotype.Service;
import utils.GenericDAO;

import java.util.List;

@Service
public class NotebookService implements GenericDAO<NotebookModel> {

    private NotebookRepository notebookRepository;

    public NotebookService(NotebookRepository notebookRepository) {
        this.notebookRepository = notebookRepository;
    }

    @Override
    public NotebookModel addOrUpdate(NotebookModel entity) {
        return notebookRepository.save(entity);
    }

    @Override
    public boolean deleteById(Integer id) {
        notebookRepository.deleteById(id);
        return true;
    }

    @Override
    public NotebookModel getById(Integer id) {
        NotebookModel notebookModel = notebookRepository.findById(id).get();
        return notebookModel;
    }

    @Override
    public List<NotebookModel> getAll() {
        List<NotebookModel> notebookModelList = notebookRepository.findAll();
        return notebookModelList;
    }
}
