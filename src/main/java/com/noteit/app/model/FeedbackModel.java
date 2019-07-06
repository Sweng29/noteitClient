package com.noteit.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Feedback")
public class FeedbackModel {

    @Id
    @GeneratedValue
    private Integer feedbackId;
    private String name;
    private String emailAddress;
    private String gender;
    private String feedbackMessage;

}
