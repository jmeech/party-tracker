package tracker.include;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import tracker.include.CharacterModel;

import java.io.File;
import java.util.List;

public class Model
{	
	private ObservableList<CharacterModel> characters;
	
	/**
	 * Constructs a Model object
	 * 
	 */
	public Model()
	{
		characters = FXCollections.observableArrayList();
	}
	
	/**
	 * Adds a listener to the Character list
	 * 
	 * @param listener
	 */
	public void addListener(ListChangeListener<CharacterModel> listener)
	{
		characters.addListener(listener);
	}
	
	/**
	 * Returns the character model stored at index i
	 * 
	 * @param i
	 * @return Character Model object
	 */
	public CharacterModel get(int i)
	{
		if(i >= 0 && i < characters.size())
			return characters.get(i);
		return null;
	}
	
	/**
	 * Adds a new character model to the party
	 * 
	 * @param newCharacter
	 * @return the index of the new character model
	 */
	public int add(CharacterModel newCharacter)
	{
		int i = characters.size();
		if(characters.add(newCharacter))
			return i;
		return -1;
	}
	
	/**
	 * Returns the size of the character list
	 * 
	 * @return
	 */
	public int size()
	{
		return characters.size();
	}

	/**
	 * Empties out the list of characters
	 * 
	 */
	public void clear()
	{
		characters.clear();
	}
	
	/**
	 * Saves the party to the given file
	 * 
	 * @param file
	 */
	public void save(File file)
	{
		XMLWriter writer = new XMLWriter();
    writer.setFile(file);
    try
    {
        writer.saveConfig(characters);
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
	}
	
	/**
	 * Loads a saved party from the given file
	 * 
	 * @param file
	 */
	public void load(File file)
	{
		clear();
		XMLParser loader = new XMLParser();
		List<CharacterModel> party = loader.readFile(file);
		for(CharacterModel new_character : party)
		{
			add(new_character);
		}
	}
}
