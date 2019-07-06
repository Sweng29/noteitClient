package com.noteit.app.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfileModel {

    private Integer profileId;
    private String userName;
    private String password;
    private Boolean isActive;

}
