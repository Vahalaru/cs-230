package src.com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */

// To inherit Entity class, Game must extend to Entity
public class Game extends Entity {
	
	// A list of the active teams
	private static List<Team> teams = new ArrayList<Team>();
	
	// Constructor with an identifier and name
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Construct a new team instance
	 * 
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Team addTeam(String name) {

		// a local Team instance
		Team team = null;

		// iterate over teams to look for existing team with the same name and if found return the existing instance
		for (int i = 0; i < teams.size() - 1; i++) {
			// looks through teams list to see if name exists
			if (teams.get(i).getName() == name) {
				team = teams.get(i);
			}
		}
		
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			GameService service = GameService.getInstance();
			
			// Get a reference to the GameService instance and then call the getNextTeamId() to get the Id to designate the team.
			team = new Team(service.getNextPlayerId(), name);
			teams.add(team);
		}

		// return the new/existing game instance to the caller
		return team;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + "]";
	}
	
}
