package com.noteit.app.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeedbackModel {

    private String name;
    private String emailAddress;
    private String gender;
    private String feedbackMessage;

}
