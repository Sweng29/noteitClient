import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavigationComponent} from './navigation/navigation.component';
import {FeedbackComponent} from './feedback/feedback.component';
import {NotesComponent} from './notes/notes.component';
import {ProfileComponent} from './profile/profile.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {FormsModule} from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import {NotebookService} from "./shared/notebook.service";
import {NoteService} from "./shared/note.service";
import {FeedbackService} from "./shared/feedback.service";

const routes: Routes = [
  {
    path: '',
    component: NotesComponent,
    pathMatch: 'full'
  },
  {
    path: 'notes',
    component: NotesComponent
  },
  {
    path: 'feedback',
    component: FeedbackComponent
  },
  {
    path: 'profile',
    component: ProfileComponent
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    FeedbackComponent,
    NotesComponent,
    ProfileComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)

  ],
  providers: [
    NotebookService,
    NoteService,
    FeedbackService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
