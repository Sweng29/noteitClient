package com.noteit.app.controllers;

import com.noteit.app.model.NotebookModel;
import com.noteit.app.service.NotebookService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/notebooks")
@CrossOrigin("*")
public class NotebookController {

    private NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public ResponseEntity getAllNotebooks() {
        return new ResponseEntity("200", "success", notebookService.getAll());
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity addNotebook(@RequestBody NotebookModel notebookModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("201", "error", null);
        }
        this.notebookService.addOrUpdate(notebookModel);
        return new ResponseEntity("200", "success", notebookService.getAll());
    }

    @RequestMapping(value = {"/{id}",})
    public ResponseEntity updateNotebook(@RequestParam(name = "id") Integer notebookId, @RequestBody NotebookModel notebookModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors() && notebookId != null && notebookId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        notebookModel.setNotebookId(notebookId);
        notebookService.addOrUpdate(notebookModel);
        return new ResponseEntity("200", "success", notebookService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteNotebook(@RequestParam(name = "id") Integer notebookId) {
        if (notebookId != null && !notebookId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        notebookService.deleteById(notebookId);
        return new ResponseEntity("200", "success", notebookService.getAll());
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity getNotebooksById(@RequestParam(name = "id") Integer notebookId) {
        if (notebookId != null && notebookId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        NotebookModel notebookModel = notebookService.getById(notebookId);
        return new ResponseEntity("200", "success", new ArrayList<>(Arrays.asList(notebookModel)));
    }
}
