package com.noteit.app.controllers;

import com.noteit.app.model.NotebookModel;
import com.noteit.app.model.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/notebooks")
@CrossOrigin("*")
public class NotebookController {

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public ResponseEntity getAllNotebooks() {
        List<NotebookModel> notebookModelList = new ArrayList<>();
        NotebookModel notebookModel = new NotebookModel();
        notebookModel.setNotebookId(1);
        notebookModel.setNoOfNotes(0);
        notebookModel.setNotebookName("Default");
        notebookModelList.add(notebookModel);

        notebookModel = new NotebookModel();
        notebookModel.setNotebookName("Kashif's Notes");
        notebookModel.setNotebookId(2);
        notebookModelList.add(notebookModel);
        notebookModel.setNoOfNotes(0);
        return new ResponseEntity("200", "success", notebookModelList);
    }
}
