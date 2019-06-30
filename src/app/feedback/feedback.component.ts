import {Component, OnInit} from '@angular/core';
import {FeedbackModule} from './feedback-module';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {

  url = 'http://localhost:8080/api/feedback';

  feedbackModel: FeedbackModule = {
    name: '',
    emailAddress: '',
    gender: '',
    feedbackMessage: ''
  };

  constructor(private httpClient: HttpClient) {
  }

  ngOnInit() {
  }

  sendFeedback() {
    this.httpClient.post(this.url, this.feedbackModel).subscribe(
      success => {
        alert('Thank you for your feedback!');
      },
      error => {
        alert('Error occured during feedback submittion');
      }
    );
  }

}
