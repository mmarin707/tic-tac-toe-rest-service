package com.mmarin.tictactoe.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mmarin.tictactoe.ai.ComputerMoveStrategySelector;
import com.mmarin.tictactoe.ai.IComputerMoveStrategy;
import com.mmarin.tictactoe.ai.IComputerMoveStrategySelector;
import com.mmarin.tictactoe.ai.WeakComputerMoveStrategy;
import com.mmarin.tictactoe.core.GameService;
import com.mmarin.tictactoe.core.GameServiceImpl;


/**
 * 
 * 
 * @author mmarin
 *
 */
@SpringBootApplication
@ComponentScan("com.mmarin.tictactoe")
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	

	@Bean
	public GameService gameService() {
		return new GameServiceImpl();
	}
	
	@Bean
	public IComputerMoveStrategy weakComputerMoveStrategy() {
		return new WeakComputerMoveStrategy();
	}
	
	@Bean
	public IComputerMoveStrategySelector iComputerMoveStrategySelector() {
		
		ComputerMoveStrategySelector computerMoveStrategySelector 
											= new ComputerMoveStrategySelector();
		
		List<IComputerMoveStrategy> strategys = new ArrayList<IComputerMoveStrategy>();
		strategys.add(weakComputerMoveStrategy());
		
		computerMoveStrategySelector.setiComputerMoveStrategies(strategys);
	
		return computerMoveStrategySelector;
	}
	

}
