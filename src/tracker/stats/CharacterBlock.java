package tracker.stats;

import javafx.scene.layout.HBox;
import tracker.include.CharacterModel;

public class CharacterBlock extends HBox
{
	private InfoBlock info;
	private HealthBlock health;
	private StatBlock stats;
	
	/**
	 * Constructs a Character Block
	 * 
	 * @param charIn
	 */
	public CharacterBlock(CharacterModel charIn)
	{
		info = new InfoBlock(charIn.getName(), charIn.getInfo(), charIn.getExp());
		health = new HealthBlock(charIn.getHealth());
		stats = new StatBlock(charIn.getStats());
		
		this.getStyleClass().addAll("characterBlock");
		this.getChildren().addAll(info, health, stats);
	}
}
