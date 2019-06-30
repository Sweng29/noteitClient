import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NotesModel} from "../models/notes-model";

@Injectable({
  providedIn: 'root'
})
export class NoteService {

  URL = 'http://localhost:8080/api/notebooks/';
  private const;
  private notes: NotesModel = [];

  constructor(private httpClient: HttpClient) {
  }

  getAllNotes() {
    this.URL += 'all';
    return this.httpClient.get<NotesModel[]>(this.URL).subscribe(
      result => {
        this.notes = result;
      },
      error => {
        alert('Not found.');
      }
    );
  }

}
