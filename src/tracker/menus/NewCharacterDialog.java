package tracker.menus;

import java.util.function.UnaryOperator;

import tracker.include.Model;
import tracker.include.CharacterModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewCharacterDialog extends Stage
{
	// Containers
	private VBox root = new VBox();
	private GridPane info = new GridPane();
	private GridPane stats = new GridPane();
	
	// Labels
	private Text windowTitle = new Text("New Character");
	private Label nameLabel = new Label("Name");
	private Label bgLabel = new Label("Background");
	private Label clLabel = new Label("Class");
	private Label raceLabel = new Label("Race");
	private Label alignLabel = new Label("Alignment");
	private Label expLabel = new Label("Experience");
	
	private Label acLabel = new Label("AC");
	private Label spLabel = new Label("Speed");
	private Label hpLabel = new Label("HP");
	
	private Label strLabel = new Label("Str");
	private Label dexLabel = new Label("Dex");
	private Label conLabel = new Label("Con");
	private Label intLabel = new Label("Int");
	private Label wisLabel = new Label("Wis");
	private Label chaLabel = new Label("Cha");
	
	// ComboBox options
	private ObservableList<String> classOptions = 
			FXCollections.observableArrayList(
		"Barbarian",
		"Bard",
		"Cleric",
		"Druid",
		"Fighter",
		"Monk",
		"Paladin",
		"Ranger",
		"Rogue",
		"Sorcerer",
		"Warlock",
		"Wizard"
	);
	
	private ObservableList<String> raceOptions = 
			FXCollections.observableArrayList(
		"Aarakocra",
		"Aasimar",
		"Bugbear",
		"Changeling",
		"Dragonborn",
		"Dwarf",
		"Eladrin",
		"Firbolg",
		"Genasi",
		"Gith",
		"Gnome",
		"Goblin",
		"Goliath",
		"Grung",
		"Half Elf",
		"Half Orc",
		"Halfling",
		"Human",
		"Hobgoblin",
		"Kenku",
		"Lizardfolk",
		"Minotaur",
		"Orc",
		"Shifter",
		"Tabaxi",
		"Tiefling",
		"Tortle",
		"Triton",
		"Warforged",
		"Yuan-ti Pureblood"
	);
	
	private ObservableList<String> alignOptions = 
			FXCollections.observableArrayList(
		"Lawful Good",
		"Neutral Good",
		"Chaotic Good",
		"Lawful Neutral",
		"True Neutral",
		"Chaotic Neutral",
		"Lawful Evil",
		"Neutral Evil",
		"Chaotic Evil"
	);
	
	// TextFormatters for integral values
	private UnaryOperator<Change> integerOnly = change -> 
	{
		String text = change.getText();
		return (text.matches("[0-9]*") ? change : null);
	};
	
	private UnaryOperator<Change> statValue = change -> 
	{
		String text = change.getControlNewText();
		return (text.matches("([1-9]|1[0-9]|20)?") ? change : null);
	};
	
	// Input Fields
	private TextField nameIn = new TextField();
	private TextField bgIn = new TextField();
	private ComboBox<String> clIn = new ComboBox<String>(classOptions);
	private ComboBox<String> raceIn = new ComboBox<String>(raceOptions);
	private ComboBox<String> alignIn = new ComboBox<String>(alignOptions);
	private TextField expIn = new TextField();
	
	private TextField acIn = new TextField();
	private TextField spIn = new TextField();
	private TextField hpIn = new TextField();
	
	private TextField strIn = new TextField();
	private TextField dexIn = new TextField();
	private TextField conIn = new TextField();
	private TextField intIn = new TextField();
	private TextField wisIn = new TextField();
	private TextField chaIn = new TextField();
	
	private Button submit = new Button("Submit");
	
	public NewCharacterDialog(Model data)
	{
		// Add TextFormatters to all integral fields
		expIn.setTextFormatter(new TextFormatter<>(integerOnly));
		
		strIn.setTextFormatter(new TextFormatter<>(statValue));
		dexIn.setTextFormatter(new TextFormatter<>(statValue));
		conIn.setTextFormatter(new TextFormatter<>(statValue));
		intIn.setTextFormatter(new TextFormatter<>(statValue));
		wisIn.setTextFormatter(new TextFormatter<>(statValue));
		chaIn.setTextFormatter(new TextFormatter<>(statValue));
		
		acIn.setTextFormatter(new TextFormatter<>(integerOnly));
		spIn.setTextFormatter(new TextFormatter<>(integerOnly));
		hpIn.setTextFormatter(new TextFormatter<>(integerOnly));
		
		// Position all elements
		info.getColumnConstraints().add(new ColumnConstraints(80));
		info.getColumnConstraints().add(new ColumnConstraints(220));
		info.add(windowTitle, 0, 0);
		info.add(nameLabel,   0, 1);
		info.add(nameIn,      1, 1);
		info.add(bgLabel,     0, 2);
		info.add(bgIn,        1, 2);
		info.add(clLabel,     0, 3);
		info.add(clIn,        1, 3);
		info.add(raceLabel,   0, 4);
		info.add(raceIn,      1, 4);
		info.add(alignLabel,  0, 5);
		info.add(alignIn,     1, 5);
		info.add(expLabel,	  0, 6);
		info.add(expIn,       1, 6);
		
		stats.getColumnConstraints().add(new ColumnConstraints(30));
		stats.getColumnConstraints().add(new ColumnConstraints(70));
		stats.getColumnConstraints().add(new ColumnConstraints(30));
		stats.getColumnConstraints().add(new ColumnConstraints(70));
		stats.getColumnConstraints().add(new ColumnConstraints(30));
		stats.getColumnConstraints().add(new ColumnConstraints(70));
		
		stats.add(acLabel,     0, 0);
		stats.add(acIn,        1, 0);
		stats.add(spLabel,     2, 0);
		stats.add(spIn,        3, 0);
		stats.add(hpLabel,     4, 0);
		stats.add(hpIn,        5, 0);
		stats.add(strLabel,    0, 1);
		stats.add(strIn,       1, 1);
		stats.add(dexLabel,    2, 1);
		stats.add(dexIn,       3, 1);
		stats.add(conLabel,    4, 1);
		stats.add(conIn,       5, 1);
		stats.add(intLabel,    0, 2);
		stats.add(intIn,       1, 2);
		stats.add(wisLabel,    2, 2);
		stats.add(wisIn,       3, 2);
		stats.add(chaLabel,    4, 2);
		stats.add(chaIn,       5, 2);
		
		root.getChildren().addAll(info, stats, submit);
		
		EventHandler<ActionEvent> submitEvent = new EventHandler<ActionEvent> ()
		{
			@Override
			public void handle(ActionEvent e)
			{
				CharacterModel newChar = new CharacterModel();
				
				newChar.setIndex(data.size());
				newChar.setName(nameIn.getText());
				newChar.setInfo(new String[] 
								{bgIn.getText(), clIn.getValue(),
								raceIn.getValue(), alignIn.getValue() });
				newChar.setExp(Integer.parseInt(expIn.getText()));
				newChar.setHealth(new int[] {Integer.parseInt(acIn.getText()),
										Integer.parseInt(spIn.getText()),
										Integer.parseInt(hpIn.getText()),
										Integer.parseInt(hpIn.getText())});
				newChar.setStats(new int[] {Integer.parseInt(strIn.getText()),
										Integer.parseInt(dexIn.getText()),
										Integer.parseInt(conIn.getText()),
										Integer.parseInt(intIn.getText()),
										Integer.parseInt(wisIn.getText()),
										Integer.parseInt(chaIn.getText())});
				
				data.add(newChar);

				closeWindow();
				e.consume();
			}
		};
		
		submit.setOnAction(submitEvent);
		
		// Display scene
		Scene scene = new Scene(root, 300, 287);
		this.setScene(scene);
	}
	
	private void closeWindow()
	{
		this.close();
	}
}
