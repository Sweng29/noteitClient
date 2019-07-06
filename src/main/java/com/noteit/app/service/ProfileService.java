package com.noteit.app.service;

import com.noteit.app.model.ProfileModel;
import com.noteit.app.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import utils.GenericDAO;

import java.util.List;

@Service
public class ProfileService implements GenericDAO<ProfileModel> {

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public ProfileModel addOrUpdate(ProfileModel entity) {
        return profileRepository.save(entity);
    }

    @Override
    public boolean deleteById(Integer id) {
        profileRepository.deleteById(id);
        return true;
    }

    @Override
    public ProfileModel getById(Integer id) {
        ProfileModel profileModel = profileRepository.findById(id).get();
        return profileModel;
    }

    @Override
    public List<ProfileModel> getAll() {
        List<ProfileModel> profileModelList = profileRepository.findAll();
        return profileModelList;
    }
}
