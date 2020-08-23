package src.com.gamingroom;

/**
 * A simple class to hold the required attributes
 * for children classes
 * 
 * @author Jeremy Stotts
 *
 */
public class Entity {
	
	// Ensure that all Entities have an id and a name
	protected long id;
	protected String name;

	// Protect the default constructor to allow children classes to view constructor.
	protected Entity() {}
	
	// Constructor with an identifier and name
	public Entity(long id, String name) {
		this.id = id;
		this.name = name;
	}

	// Method to allow returning the id
	public long getId() {
		return id;
	}
	
	// Method to allow returning the name
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}