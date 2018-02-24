package com.mmarin.tictactoe.core;

import org.springframework.beans.factory.annotation.Autowired;

import com.mmarin.tictactoe.ai.IComputerMoveStrategySelector;
import com.mmarin.tictactoe.storage.GameStorage;
import com.mmarin.tictactoe.storage.PlayerDataStorage;

/**
 * 
 * Implementation of game communication.
 * 
 * @author mmarin
 *
 */
public class GameServiceImpl implements GameService {

	@Override
	public Game createGame(String player1, String player2) {
		
		if ((Player.COMPUTER.equals(player1) &&
		     Player.COMPUTER.equals(player2))
				||
			(!Player.COMPUTER.equals(player1) &&
			 !Player.COMPUTER.equals(player2))) {
			
			throw new IllegalArgumentException("invalid game initialization player1: " + 
											   player1 + 
											   " player2: " + 
											   player2);
		}
		
		PlayerDataStorage.put(player1);
		PlayerDataStorage.put(player2);
		
		Game game = new Game(new Player(player1, MarkType.X), 
						     new Player(player2, MarkType.O));
		
		GameStorage.put(game);
		
		computerMove(game);
		
		return game;
		
	}

	@Override
	public Game move(Long gameId, 
					 int row, 
					 int column) {
		
		Game  game = GameStorage.get(gameId);
		
		if (!GameStatus.PLAYING.equals(game.getGameStatus())) {
			
			return game;
		}
		
		game.move(row, 
				  column);
		
		computerMove(game);
		
		updatePlayerData(game);
		
		return game;
	}
	
	
	
	@Override
	public Game status(Long gameId) {
		return GameStorage.get(gameId);
	}
	
	

	@Override
	public PlayerData stats(String username) {
		
		return PlayerDataStorage.get(username);
		
	}

	/**
	 * 
	 * Check game status and update player data.
	 * 
	 * @param game game
	 */
	private void updatePlayerData(Game game) {
		
		if (GameStatus.FINISHED.equals(game.getGameStatus())) {
			
			PlayerData playerData = PlayerDataStorage.get(game.getCurrentPlayer().getUsername());
			
			playerData.incrementWins();
			
			playerData = PlayerDataStorage.get(game.getAwaitPlayer().getUsername());
			
			playerData.incrementLosses();
			
		} else if (GameStatus.DRAW.equals(game.getGameStatus())) {
			
			PlayerData playerData = PlayerDataStorage.get(game.getPlayer1().getUsername());
			
			playerData.incrementDraws();
			
			playerData = PlayerDataStorage.get(game.getPlayer2().getUsername());
			
			playerData.incrementDraws();
		
		}
		
	}
	
	/**
	 * If its computer's turn he will play first, if not nothing happens.
	 * 
	 * @param game game
	 */
	private void computerMove(Game game) {
		
		if (Player.COMPUTER.equals(game.getAwaitPlayer().getUsername())) {
			
			return;
		}
		
		PlayerData opponent = PlayerDataStorage.get(game.getAwaitPlayer().getUsername());
		
		Cell move = iComputerMoveStrategySelector
						.select(opponent)
							.move(game.getBoard(), 
								  game.getCurrentPlayer()
								  	.getMarkType());
		
		game.move(move.getRow(), move.getColumn());
		
	}
	
	@Autowired
	private IComputerMoveStrategySelector iComputerMoveStrategySelector;
	
}
