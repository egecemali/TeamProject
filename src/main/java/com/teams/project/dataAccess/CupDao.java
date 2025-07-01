package com.teams.project.dataAccess;

import com.teams.project.entities.Cup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CupDao extends JpaRepository<Cup, Long> {

}
