package com.noteit.app.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotebookModel {

    private Integer notebookId;
    @NotNull(message = "notebook name should not be null.")
    private String notebookName;
    private Integer noOfNotes;

}
