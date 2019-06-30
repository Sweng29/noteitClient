import {Component, OnInit} from '@angular/core';
import {NotesModel} from '../models/notes-model';
import {NoteService} from "../shared/note.service";

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})
export class NotesComponent implements OnInit {

  notes: NotesModel = [];

  constructor(private noteService: NoteService) {
  }

  ngOnInit() {
    this.getAllNotes();
  }

  getAllNotes() {
    this.noteService.getAllNotes();
  }

}
