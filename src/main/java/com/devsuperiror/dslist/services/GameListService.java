package com.devsuperiror.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperiror.dslist.dto.GameListDTO;
import com.devsuperiror.dslist.dto.GameMinDTO;
import com.devsuperiror.dslist.entities.GameList;
import com.devsuperiror.dslist.projections.GameMinProjection;
import com.devsuperiror.dslist.repositories.GameListRepository;
import com.devsuperiror.dslist.repositories.GameRepository;

@Service //componentizando um serviço
public class GameListService {

	@Autowired //injetando uma instância dentro do Service
	private GameListRepository gameListRepository;
	
	@Autowired //injetando uma instância dentro do Service
	private GameRepository gameRepository;
	
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
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destination) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destination, obj);
		
		int min = sourceIndex < destination ? sourceIndex : destination;
		int max = sourceIndex < destination ? destination : sourceIndex;
		
		for(int i = min; i < max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
