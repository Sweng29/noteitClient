package com.noteit.app.service;

import com.noteit.app.model.NoteModel;
import com.noteit.app.repository.NoteRepository;
import org.springframework.stereotype.Service;
import utils.GenericDAO;

import java.util.List;

@Service
public class NoteService implements GenericDAO<NoteModel> {

    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public NoteModel addOrUpdate(NoteModel entity) {
        return noteRepository.save(entity);
    }

    @Override
    public boolean deleteById(Integer id) {
        noteRepository.deleteById(id);
        return true;
    }

    @Override
    public NoteModel getById(Integer id) {
        NoteModel noteModel = noteRepository.findById(id).get();
        return noteModel;
    }

    @Override
    public List<NoteModel> getAll() {
        List<NoteModel> noteModelList = noteRepository.findAll();
        return noteModelList;
    }
}
