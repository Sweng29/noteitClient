package com.noteit.app.controllers;

import com.noteit.app.model.FeedbackModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResponseEntity;

@RestController
@RequestMapping(value = "/api/feedback")
@CrossOrigin("*")
public class FeedbackController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity sendFeedback(@RequestBody FeedbackModel feedbackModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("201", "error", null);
        }
        System.out.println(feedbackModel);
        return new ResponseEntity("200", "success", null);
    }

}
