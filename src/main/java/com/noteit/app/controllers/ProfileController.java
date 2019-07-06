package com.noteit.app.controllers;

import com.noteit.app.model.ProfileModel;
import com.noteit.app.service.ProfileService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/profiles")
@CrossOrigin("*")
public class ProfileController {

    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public ResponseEntity addProfile(@RequestBody ProfileModel profileModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("201", "error", null);
        }
        profileService.addOrUpdate(profileModel);
        return new ResponseEntity("200", "success", profileService.getAll());
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.PUT)
    public ResponseEntity updateProfile(@RequestParam(name = "id") Integer profileId, @RequestBody ProfileModel profileModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors() && profileId != null && profileId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        profileModel.setProfileId(profileId);
        profileService.addOrUpdate(profileModel);
        return new ResponseEntity("200", "success", profileService.getAll());
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteProfile(@RequestParam(name = "id") Integer profileId) {
        if (profileId != null && profileId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        profileService.deleteById(profileId);
        return new ResponseEntity("200", "success", profileService.getAll());
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.GET)
    public ResponseEntity getProfileById(@RequestParam(name = "id") Integer profileId) {
        if (profileId != null && profileId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        ProfileModel profileModel = profileService.getById(profileId);
        return new ResponseEntity("200", "success", new ArrayList<>(Arrays.asList(profileModel)));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAllProfiles() {
        return new ResponseEntity("200", "success", profileService.getAll());
    }

}
