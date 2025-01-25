package com.devsuperiror.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperiror.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
