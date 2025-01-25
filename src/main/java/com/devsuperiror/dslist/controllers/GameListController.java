package com.devsuperiror.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperiror.dslist.dto.GameListDTO;
import com.devsuperiror.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListServie;
	
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
}
