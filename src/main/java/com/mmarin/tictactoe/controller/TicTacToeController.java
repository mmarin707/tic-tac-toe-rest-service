package com.mmarin.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmarin.tictactoe.core.Game;
import com.mmarin.tictactoe.core.GameService;
import com.mmarin.tictactoe.core.PlayerData;

/**
 *	
 * Rest controller for handling game requests. 
 * 
 * @author mmarin
 *
 */
@RestController
public class TicTacToeController {
	
	
    @RequestMapping(method = RequestMethod.GET, value = "/game/new")
    public Game initGame(@RequestParam(value="first", defaultValue="computer") 
				         String player1,
				         @RequestParam(value="second", defaultValue="computer")
				         String player2) {
    	
        return gameService.createGame(player1, player2);
    
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/game/play")
    public Game play(@RequestParam(value="gameId")
				     long gameId,
				     @RequestParam(value="row")
				     int row,
				     @RequestParam(value="column")
    				 int column) {
    	
    	return gameService.move(gameId, 
    						    row, 
    						    column);
    	
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/game/status")
    public Game status(@RequestParam(value="gameId") 
					   long gameId) {
    	
    	return gameService.status(gameId);
    	
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/game/stats")
    public PlayerData status(@RequestParam(value="player") 
					   		 String username) {
    	
    	return gameService.stats(username);
    	
    }
    
        
    @Autowired
    private GameService gameService;
    
}
