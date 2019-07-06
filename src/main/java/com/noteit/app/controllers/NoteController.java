package com.noteit.app.controllers;

import com.noteit.app.model.NoteModel;
import com.noteit.app.service.NoteService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/api/notes/")
@CrossOrigin("*")
public class NoteController {

    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public ResponseEntity addNote(@RequestBody NoteModel noteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity("201", "error", null);
        }
        noteService.addOrUpdate(noteModel);
        return new ResponseEntity("200", "success", noteService.getAll());
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.PUT)
    public ResponseEntity updateNote(@RequestParam(name = "id") Integer noteId, @RequestBody NoteModel noteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors() && noteId != null && noteId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        noteModel.setNoteId(noteId);
        noteService.addOrUpdate(noteModel);
        return new ResponseEntity("200", "success", noteService.getAll());
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteNote(@RequestParam(name = "id") Integer noteId) {
        if (noteId != null && noteId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        noteService.deleteById(noteId);
        return new ResponseEntity("200", "success", noteService.getAll());
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.GET)
    public ResponseEntity getNoteById(@RequestParam(name = "id") Integer noteId) {
        if (noteId != null && noteId.toString().trim().equals("")) {
            return new ResponseEntity("201", "error", null);
        }
        NoteModel noteModel = noteService.getById(noteId);
        return new ResponseEntity("200", "success", new ArrayList<>(Arrays.asList(noteModel)));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAllNotes() {
        return new ResponseEntity("200", "success", noteService.getAll());
    }

/*    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity getAllNotesByNotebookId(@RequestParam(name = "id") Integer noteId) {
        if (noteId != null && noteId.toString().trim().equals("")) {
            return null;
        }
        return null;
    }*/

}
