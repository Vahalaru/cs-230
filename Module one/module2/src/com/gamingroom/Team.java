package src.com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */

//To derive from Entity class, Team must extend to Entity
public class Team extends Entity {

	// A list of the active teams
	private static List<Player> players = new ArrayList<Player>();
	
	// Constructor with an identifier and name
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Construct a new player instance
	 * 
	 * @param name the unique name of the player
	 * @return the player instance (new or existing)
	 */
	public Player addPlayer(String name) {

		// a local Player instance
		Player player = null;

		// iterate over players to look for existing players with the same name and if found return the existing instance
		for (int i = 0; i < players.size() - 1; i++) {
			// looks through players list to see if name exists
			if (players.get(i).getName() == name) {
				player = players.get(i);
			}
		}
		
		// if not found, make a new player instance and add to list of teams
		if (player == null) {
			// Get a reference to the GameService singleton instance
			GameService service = GameService.getInstance();
			
			//  Use the GameService Reference to call the getNextPlayerId() to get the Id to designate the player.
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
		}

		// return the new/existing game instance to the caller
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
