package tracker.stats;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tracker.include.Enums.size;

public class PCStat<T> extends VBox
{	
	private T stat;
	private Text disp = new Text();
	private Text label = new Text();
	private size width;
	
	public PCStat(String labelIn, T statIn, size sizeIn)
	{
		width = sizeIn;
		stat = statIn;
		
		disp.setText(stat != null ? String.valueOf(stat) : null);
		label.setText(labelIn);
		
		disp.getStyleClass().add("statDisplay");
		label.getStyleClass().add("statLabel");
		
		switch(width)
		{
			case SINGLE : this.getStyleClass().add("single"); break;
			case DOUBLE : this.getStyleClass().add("double"); break;
			case MEDIUM : this.getStyleClass().add("medium"); break;
			case WIDE   : this.getStyleClass().add("wide");   break;
		};
		
		this.getStyleClass().addAll("stat");
		this.getChildren().addAll(disp, label);
	}
	
	public void setStat(T statIn)
	{
		stat = statIn;
		disp.setText(stat != null ? String.valueOf(stat) : null);
	}
	
	public T getStat()
	{
		return stat;
	}
}
