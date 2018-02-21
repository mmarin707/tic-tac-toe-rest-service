package com.mmarin.greeting.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmarin.greeting.Game;

/**
 *	
 * Rest controller for handling game requests. 
 * 
 * @author mmarin
 *
 */
@RestController
public class TicTacToeController {

    private final AtomicLong counter = new AtomicLong();
	
	
    @RequestMapping(method = RequestMethod.GET, value="game/new")
    public Game greeting(@RequestParam(value="first", defaultValue="computer") 
    				     String player1,
    				     @RequestParam(value="second", defaultValue="computer")
    				     String player2) {
    	
        return new Game(counter.incrementAndGet());
    
    }
    
}
