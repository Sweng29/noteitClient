package com.noteit.app.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "profiles")
public class ProfileModel {

    @Id
    @GeneratedValue
    private Integer profileId;
    private String userName;
    private String password;
    private Boolean isActive;

}
