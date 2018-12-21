package tracker;

import tracker.include.CharacterModel;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Detail extends VBox
{
	private Text charName = new Text();
	private Text charDesc = new Text();
	private VBox charHP = new VBox();
	private Label hp = new Label("HIT POINTS");
	private ProgressBar hpBar = new ProgressBar();
	private VBox charXP = new VBox();
	private Label xp = new Label("EXPERIENCE POINTS");
	private ProgressBar xpBar = new ProgressBar();
	
	/**
	 * Constructs a Detail pane
	 * 
	 */
	public Detail()
	{
		charHP.getChildren().addAll(hp, hpBar);
		charXP.getChildren().addAll(xp, xpBar);
		this.getChildren().addAll(charName, charDesc, charHP, charXP);
	}
	
	/**
	 * Change the character being displayed
	 * 
	 * @param in
	 */
	public void setCharacter(CharacterModel in)
	{
		charName.setText(in.getName());
		charDesc.setText(in.getRace() + " " + in.getClass());
		hpBar.setProgress((double)in.getHP() / (double)in.getMaxHP());
	}
}
