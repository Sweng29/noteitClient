package com.noteit.app.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Notes")
public class NoteModel {
    @Id
    @GeneratedValue
    private Integer noteId;
    private String note;
    private String title;
    private Date lastModifiedOn;
    @ManyToOne(targetEntity = NotebookModel.class, fetch = FetchType.EAGER)
    private NotebookModel notebookModel;
}
