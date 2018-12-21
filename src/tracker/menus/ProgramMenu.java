package tracker.menus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class ProgramMenu extends MenuBar
{
	private Menu file = new Menu("File");
	private Menu edit = new Menu("Edit");
	private Menu party = new Menu("Party");
	private Menu init = new Menu("Initiative");
	
	private MenuItem open = new MenuItem("Open Party...");
	private MenuItem save = new MenuItem("Save");
	private MenuItem saveAs = new MenuItem("Save As...");
	
	private MenuItem newCharacter = new MenuItem("New Character");
	private MenuItem deleteCharacter = new MenuItem("Delete Character");
	
	private MenuItem longRest = new MenuItem("Long Rest");

	private MenuItem next = new MenuItem("Next in Order");
	private MenuItem clear = new MenuItem("Clear Order");
	
	public ProgramMenu()
	{	
		file.getItems().addAll(open, save, saveAs);
		edit.getItems().addAll(newCharacter, deleteCharacter);
		party.getItems().addAll(longRest);
		init.getItems().addAll(next, clear);
		
		this.getMenus().addAll(file, edit, party, init);
	}
	
	/**
	 * Attaches a handler to the Save menu option
	 * 
	 * @param handler
	 */
	public void setSaveAction(EventHandler<ActionEvent> handler)
	{
		save.setOnAction(handler);
	}
	
	/**
	 * Attaches a handler to the Save As menu option
	 * 
	 * @param handler
	 */
	public void setSaveAsAction(EventHandler<ActionEvent> handler)
	{
		saveAs.setOnAction(handler);
	}
	
	/**
	 * Attaches a handler to the Open menu option
	 * 
	 * @param handler
	 */
	public void setOpenAction(EventHandler<ActionEvent> handler)
	{
		open.setOnAction(handler);
	}
	
	/**
	 * Attaches a handler to the New Character menu option
	 * 
	 * @param handler
	 */
	public void setNewCharacterAction(EventHandler<ActionEvent> handler)
	{
		newCharacter.setOnAction(handler);
	}
	
	/**
	 * Attaches a handler to the Delete Character menu option
	 * 
	 * @param handler
	 */
	public void setDeleteCharacterAction(EventHandler<ActionEvent> handler)
	{
		deleteCharacter.setOnAction(handler);
	}
	
	/**
	 * Attaches a handler to the Long Rest menu option
	 * 
	 * @param handler
	 */
	public void setLongRestAction(EventHandler<ActionEvent> handler)
	{
		longRest.setOnAction(handler);
	}

	/**
	 * Attaches a handler to the Next Character menu option
	 * 
	 * @param handler
	 */
	public void setNextAction(EventHandler<ActionEvent> handler)
	{
		next.setOnAction(handler);
	}
	
	/**
	 * Attaches a handler to the Clear Initiative menu option
	 * 
	 * @param handler
	 */
	public void setClearAction(EventHandler<ActionEvent> handler)
	{
		clear.setOnAction(handler);
	}
}
