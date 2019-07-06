package com.noteit.app.controllers;

import com.noteit.app.model.NotebookModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
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

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity addNotebook(@RequestBody NotebookModel notebookModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("201", "error", null);
        }
        return new ResponseEntity("200", "success", new ArrayList<>(Arrays.asList(1)));
    }

    @RequestMapping(value = {"/{id}",})
    public ResponseEntity updateNotebook(@RequestParam(name = "id") Integer notebookId, @RequestBody NotebookModel notebookModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors() && notebookId != null && notebookId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }


        return new ResponseEntity();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteNotebook(@RequestParam(name = "id") Integer notebookId) {
        if (notebookId != null && !notebookId.toString().trim().equals("")) {
            return null;
        }
        return null;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity getNotebooksById(@RequestParam(name = "id") Integer notebookId) {
        if (notebookId != null && notebookId.toString().trim().equals("")) {
            return null;
        }
        return null;
    }
}
