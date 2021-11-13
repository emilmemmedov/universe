package com.lms.universe.repository;

import com.lms.universe.model.Institution;
import com.lms.universe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
