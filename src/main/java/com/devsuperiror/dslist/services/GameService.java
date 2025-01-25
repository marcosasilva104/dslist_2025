package com.devsuperiror.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiror.dslist.dto.GameDTO;
import com.devsuperiror.dslist.dto.GameMinDTO;
import com.devsuperiror.dslist.entities.Game;
import com.devsuperiror.dslist.projections.GameMinProjection;
import com.devsuperiror.dslist.repositories.GameRepository;

@Service //componentizando um serviço
public class GameService {

	@Autowired //injetando uma instância dentro do Service
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
	    return  new GameDTO(result); 
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
}
