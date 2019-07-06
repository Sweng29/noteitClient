import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NotebookModel} from "../models/notebook-model";
import {Observable} from "rxjs/index";

@Injectable({
  providedIn: 'root'
})
export class NotebookService {

  URL = 'http://localhost:8080/api/notebooks/';
  private const;
  private notebookList: NotebookModel[] = [];

  constructor(private httpClient: HttpClient) {
  }

  getAllNotebooks(): Observable<NotebookModel[]> {
    return this.httpClient.get<NotebookModel[]>(this.URL + '/all');
  }

  addNewNotebook(notebookModel: NotebookModel) {
    return this.httpClient.post(this.URL, notebookModel);
  }

}
