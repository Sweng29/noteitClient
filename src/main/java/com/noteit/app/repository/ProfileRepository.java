package com.noteit.app.repository;

import com.noteit.app.model.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, Integer> {
}
