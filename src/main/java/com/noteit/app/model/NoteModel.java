package com.noteit.app.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class NoteModel {
    private Integer noteId;
    private String note;
    private String title;
    private Date lastModifiedOn;
}
