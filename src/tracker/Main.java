package tracker;

import tracker.stats.CharacterBlock;
import tracker.include.CharacterModel;
import tracker.menus.NewCharacterDialog;

import java.io.File;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import tracker.include.Model;
import tracker.menus.ProgramMenu;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application
{
	private Model data = new Model();
	
	private Party partyPanel = new Party();
	private ProgramMenu topBar = new ProgramMenu();
	private Detail characterDetail = new Detail();
	private Initiative initiativePanel = new Initiative();
	private BorderPane root = new BorderPane();
	
	private Stage ref;
	
	private File currentFile;
	
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			// MODEL
			data.addListener(getCharacterListener());
			ref = primaryStage;
			
			// VIEW
			root.setTop(topBar);
			root.setLeft(initiativePanel);
			root.setCenter(characterDetail);
			root.setRight(partyPanel);
			
			topBar.setNewCharacterAction(getNewCharEvent());
			topBar.setOpenAction(getLoadEvent());
			topBar.setSaveAction(getSaveEvent());
			topBar.setSaveAsAction(getSaveAsEvent());

			Scene scene = new Scene(root, 1280, 856);
			scene.getStylesheets().add(getClass().getResource("include/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Listens to the Character List for changes, then propogates them.
	 *  
	 * @return ListChangeListener<CharacterModel>
	 */
	private ListChangeListener<CharacterModel> getCharacterListener()
	{
		return new ListChangeListener<CharacterModel> ()
		{
			@Override
			public void onChanged(Change<? extends CharacterModel> c)
			{
				while (c.next())
				{
					if (c.wasAdded())
					{
						for (CharacterModel newCharacter : c.getAddedSubList())
						{
							CharacterBlock newBlock = new CharacterBlock(newCharacter);
							newBlock.getStyleClass().add("characterBlock");
							partyPanel.add(newBlock);
						}
					}
					else if(c.wasRemoved())
					{
						//for (CharacterModel deleted : c.getRemoved())
						//{
						// TODO
						//}
					}
				}
			}
		};
	}

	/**
	 * Generates an EventHandler to add a new character to the current party
	 * 
	 * @return	EventHandler<ActionEvent> handler 
	 */
	private EventHandler<ActionEvent> getNewCharEvent()
	{
		return new EventHandler<ActionEvent> ()
		{
			@Override
			public void handle(ActionEvent e)
			{
				NewCharacterDialog dialog = new NewCharacterDialog(data);
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.show();
				e.consume();
			}
		};
	}
	
	/**
	 * Saves the changes made to the currently loaded party
	 */
	private void save()
	{
		data.save(currentFile);
	}
	
	/**
	 * Opens a file chooser, then saves the current party to the chosen file
	 * 
	 */
	private void saveAs()
	{
		FileChooser dialog = new FileChooser();
		dialog.setTitle("Save file...");
		File file = dialog.showSaveDialog(ref);
		if (file != null)
		{
			data.save(file); 
		}
	}
	
	/**
	 * Opens a file chooser, then loads the selected file
	 * 
	 */
	private void load()
	{
		FileChooser dialog = new FileChooser();
		dialog.setTitle("Open UML file...");
		currentFile = dialog.showOpenDialog(ref);

		if (currentFile != null) 
		{
			partyPanel.clearCharacters();
			data.clear();
			data.load(currentFile);
		}
	}
	
	/**
	 * Generates an EventHandler to save the current party
	 * 
	 * @return	EventHandler<ActionEvent> handler 
	 */
	private EventHandler<ActionEvent> getSaveEvent()
	{
		return new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				save();
				e.consume();
			}
		};
	}
	
	/**
	 * Generates an EventHandler to save the current party
	 * 
	 * @return	EventHandler<ActionEvent> handler 
	 */
	private EventHandler<ActionEvent> getSaveAsEvent()
	{
		return new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				saveAs();
				e.consume();
			}
		};
	}

	/**
	 * Generates an EventHandler to load a previously saved party
	 * 
	 * @return	EventHandler<ActionEvent> handler 
	 */
	private EventHandler<ActionEvent> getLoadEvent()
	{
		return new EventHandler<ActionEvent> ()
		{
			@Override
			public void handle(ActionEvent e)
			{
				load();
				e.consume();
			}
		};
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
