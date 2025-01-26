package com.devsuperiror.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperiror.dslist.dto.GameListDTO;
import com.devsuperiror.dslist.dto.GameMinDTO;
import com.devsuperiror.dslist.dto.ReplacementDTO;
import com.devsuperiror.dslist.services.GameListService;
import com.devsuperiror.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListServie;
	
	@Autowired
	private GameService gameServie;
	
	@GetMapping(value = "/{id}")
	public GameListDTO findById(@PathVariable Long id){
		GameListDTO result = gameListServie.findById(id);	
		return result;
	}
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListServie.findAll();	
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameServie.findByList(listId);	
		return result;
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		gameListServie.move(listId, body.getSourceIndex(), body.getDestinationIndex());		
	}
	
}
