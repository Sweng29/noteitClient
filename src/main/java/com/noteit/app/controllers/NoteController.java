package com.noteit.app.controllers;

import com.noteit.app.model.NoteModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import utils.ResponseEntity;

@RestController
@RequestMapping(value = "/api/notes/")
public class NoteController {

    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public ResponseEntity addNote(@RequestBody NoteModel noteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return null;
        }
        return null;
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.PUT)
    public ResponseEntity updateNote(@RequestParam(name = "id") Integer noteId, @RequestBody NoteModel noteModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors() && noteId != null && noteId.toString().trim().equals("")) {
            return null;
        }
        return null;
    }

    @RequestMapping(value = {"{id}"}, method = RequestMethod.DELETE)
    public ResponseEntity deleteNote(@RequestParam(name = "id") Integer noteId) {
        if (noteId != null && noteId.toString().trim().equals("")) {
            return null;
        }
        return null;
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity getNoteById(@RequestParam(name = "id") Integer noteId) {
        if (noteId != null && noteId.toString().trim().equals("")) {
            return null;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllNotes() {
        return null;
    }

/*    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public ResponseEntity getAllNotesByNotebookId(@RequestParam(name = "id") Integer noteId) {
        if (noteId != null && noteId.toString().trim().equals("")) {
            return null;
        }
        return null;
    }*/

}
