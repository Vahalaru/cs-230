package src.com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	// A list of the active games
	private static List<Game> games = new ArrayList<Game>();

	// Holds the next game identifier
	private static long nextGameId = 1;
	
	// Holds the next team identifier
	private static long nextTeamId = 1;
	
	// Holds the next player identifier
	private static long nextPlayerId = 1;

	// The Private Static makes it so the instance of GameService 
	// is stored in service if it doesn't already exist
	private static GameService service = null;
	
	// Make class a singleton
	
	// Empty constructor
	private GameService() {}
	
	/**
	 * Checks if an existing GameService instance
	 * exists. If not it makes one, if so then it 
	 * returns the instance.
	 * 
	 * @return the gameservice instance (new or existing)
	 */
	public static GameService getInstance() {
		
		if (service == null) {
			service = new GameService();
		}
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// iterate Games to look for existing game with the same name and if found return the existing instance
		if (getGame(name) != null) {
			game = getGame(name);
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// looks through games to see if id exists
		for (int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getId() == id) {
				game = games.get(i);
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		
		// looks through games to see if name exists
		for (int i = 0; i < getGameCount(); i++) {
			
			if (games.get(i).getName() == name) {
				game = games.get(i);
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	/**
	 * Returns the id for the current index of Teams
	 * list then after returning the long value it
	 * adds one to the value
	 * 
	 * @return the id of the index of current team
	 * in Teams
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
	
	/**
	 * Returns the id for the current index of Players
	 * list then after returning the long value it
	 * adds one to the value
	 * 
	 * @return the Id of the index of current player
	 * in Players
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}
}
