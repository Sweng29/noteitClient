import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NotebookModel} from "../models/notebook-model";

@Injectable({
  providedIn: 'root'
})
export class NotebookService {

  URL = 'http://localhost:8080/api/notebooks/';
  private const;

  constructor(private httpClient: HttpClient) {
  }

  getAllNotes() {
    return this.httpClient.get<NotebookModel[]>(this.URL).subscribe(
      success => {
        alert("success");
        console.log("Result");
      },
      error => {
        alert("Error occured while fatching notebook records.");
      }
    );
  }

}
