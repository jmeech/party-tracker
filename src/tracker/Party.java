package tracker;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import tracker.stats.CharacterBlock;

public class Party extends ScrollPane
{	
	VBox partyDisplay = new VBox();
	
	/**
	 * Constructs a party display object
	 * 
	 */
	public Party()
	{	
		partyDisplay.getStyleClass().add("pad");
		this.setContent(partyDisplay);
	}
	
	/**
	 * Adds a new character to the party display
	 * 
	 * @param characterIn
	 * @return true if the add was successful, otherwise false
	 */
	public boolean add(CharacterBlock characterIn)
	{
		return partyDisplay.getChildren().add(characterIn);
	}
	
	/**
	 * Clears the display of characters
	 * 
	 */
	public void clearCharacters()
	{
		partyDisplay.getChildren().clear();
	}
}
