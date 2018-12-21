package tracker;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tracker.include.Enums.size;
import tracker.stats.PCStat;

public class Initiative extends ScrollPane
{
	
	public class InitiativePanel extends HBox
	{
		private Label number = new Label();
		private Text name = new Text();
		private TextField nameIn = new TextField();
		private HBox numberWrap = new HBox();
		private HBox nameWrap = new HBox();
		
		public InitiativePanel(int index)
		{
			number.getStyleClass().add("initNumber");
			name.getStyleClass().add("initName");
			numberWrap.getStyleClass().add("initNumber");
			nameWrap.getStyleClass().add("initName");
			nameIn.getStyleClass().add("initNameIn");
			
			number.setText(String.valueOf(index));
			numberWrap.getChildren().add(number);
			nameWrap.getChildren().add(name);
			this.getChildren().addAll(number, nameWrap);
			
			this.setOnMouseClicked(new EventHandler<MouseEvent> ()
			{
				@Override
				public void handle(MouseEvent me)
				{
					if(me.getButton() == MouseButton.PRIMARY
							&& me.getClickCount() == 2)
					{
						nameWrap.getChildren().clear();
						nameWrap.getChildren().add(nameIn);
						nameWrap.setOnKeyPressed(new EventHandler<KeyEvent> ()
						{
							@Override
							public void handle(KeyEvent ke)
							{
								if(ke.getCode() == KeyCode.ENTER)
								{
									name.setText(nameIn.getText());
									nameWrap.getChildren().clear();
									nameWrap.getChildren().add(name);
									ke.consume();
								}
							}
						});
						nameIn.requestFocus();
						if(!nameIn.isFocused())
						{
							name.setText(nameIn.getText());
							nameWrap.getChildren().clear();
							nameWrap.getChildren().add(name);
						}
						me.consume();
					}
				}
			});
			
		}
		
		public boolean isEmpty()
		{
			return(name.getText().isEmpty() || name.getText() == "");
		}
		
		public void setName(String nameIn)
		{
			name.setText(nameIn);
		}
		
		public String getName()
		{
			return name.getText();
		}
		
		public void clear()
		{
			name.setText(null);
			nameIn.clear();
		}
	}
	
	
	private InitiativePanel[] panels = new InitiativePanel[31];
	private PCStat<String> next = new PCStat<String>("NEXT IN INITIATIVE", null, size.WIDE);
	private VBox init = new VBox();
	private HBox control = new HBox();
	private Button nextButton = new Button("Next");
	private Button clearButton = new Button("Clear");
	private int current = 0;
	
	public Initiative()
	{
		control.getChildren().addAll(nextButton, clearButton);
		nextButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				next();
				e.consume();
			}
		});
		
		clearButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent e)
			{
				clear();
				e.consume();
			}
		});
		
		nextButton.getStyleClass().add("medium");
		clearButton.getStyleClass().add("medium");
		init.getChildren().add(next);
		
		for(int i = 0; i <= 30; ++i)
		{
			panels[i] = new InitiativePanel(25 - i);
			panels[i].getStyleClass().add("initPanel");
			init.getChildren().add(panels[i]);
		}
		init.getChildren().add(control);
		init.getStyleClass().addAll("init");
		this.getStyleClass().addAll("pad", "initDisplay");
		this.setContent(init);
	}
	
	public void setInitiative(int index, String nameIn)
	{
		panels[25 - index].setName(nameIn);
	}
	
	public void clearInitiative(int index)
	{
		panels[25 - index].clear();
	}
	
	public void clear()
	{
		current = 0;
		next.setStat(null);
		for(InitiativePanel panel : panels)
		{
			panel.clear();
		}
	}
	
	public void next()
	{
		int empty = current;
		++current;
		while(current != empty)
		{
			++current;
			if(current > 30) current = 0;
			if(!panels[current].isEmpty())
			{
				next.setStat(panels[current].getName());
				return;
			}
		}
		next.setStat(null);
	}
}