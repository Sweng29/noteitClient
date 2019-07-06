package com.noteit.app.service;

import com.noteit.app.model.FeedbackModel;
import com.noteit.app.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import utils.GenericDAO;

import java.util.List;

@Service
public class FeedbackService implements GenericDAO<FeedbackModel> {

    private FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public FeedbackModel addOrUpdate(FeedbackModel entity) {
        return feedbackRepository.save(entity);
    }

    @Override
    public boolean deleteById(Integer id) {
        feedbackRepository.deleteById(id);
        return true;
    }

    @Override
    public FeedbackModel getById(Integer id) {
        FeedbackModel feedbackModel = feedbackRepository.findById(id).get();
        return feedbackModel;
    }

    @Override
    public List<FeedbackModel> getAll() {
        List<FeedbackModel> feedbackModelList = feedbackRepository.findAll();
        return feedbackModelList;
    }
}
