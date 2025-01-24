package com.devsuperiror.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiror.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
