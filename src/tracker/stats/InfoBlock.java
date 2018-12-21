package tracker.stats;

import javafx.scene.layout.GridPane;
import tracker.include.Enums.size;

public class InfoBlock extends GridPane
{
	private PCStat<String> name;
	private PCStat<String> bkgd;
	private PCStat<String> cl;
	private PCStat<String> race;
	private PCStat<String> align;
	private PCStat<Integer> exp;
	
	/**
	 * Constructs an Info block
	 * 
	 * @param nameIn
	 * @param infoIn
	 * @param expIn
	 */
	public InfoBlock(String nameIn, String[] infoIn, int expIn)
	{
		name = new PCStat<String>("NAME", nameIn, size.WIDE);
		bkgd = new PCStat<String>("BACKGROUND", infoIn[0], size.WIDE);
		cl = new PCStat<String>("CLASS", infoIn[1], size.MEDIUM);
		race = new PCStat<String>("RACE", infoIn[2], size.WIDE);
		align = new PCStat<String>("ALIGNMENT", infoIn[3], size.WIDE);
		exp = new PCStat<Integer>("EXP", expIn, size.MEDIUM);
		
		this.addRow(0, name, bkgd, cl);
		this.addRow(1, race, align, exp);
	}
}
