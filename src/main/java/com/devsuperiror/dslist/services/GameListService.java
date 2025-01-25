package com.devsuperiror.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiror.dslist.dto.GameListDTO;
import com.devsuperiror.dslist.entities.Game;
import com.devsuperiror.dslist.entities.GameList;
import com.devsuperiror.dslist.repositories.GameListRepository;

@Service //componentizando um serviço
public class GameListService {

	@Autowired //injetando uma instância dentro do Service
	private GameListRepository gameListRepository;
	
	
	@Transactional(readOnly = true)
	public GameListDTO findById(Long id) {
		GameList result = gameListRepository.findById(id).get();
	    return  new GameListDTO(result); 
	}
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
		
	}
}
