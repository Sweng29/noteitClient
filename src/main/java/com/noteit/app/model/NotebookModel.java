package com.noteit.app.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Notebooks")
public class NotebookModel {

    @Id
    @GeneratedValue
    private Integer notebookId;
    @NotNull(message = "notebook name should not be null.")
    private String notebookName;
    private Integer noOfNotes;
    @OneToMany(targetEntity = NoteModel.class, mappedBy = "notebookModel")
    private List<NoteModel> notesList;

}
