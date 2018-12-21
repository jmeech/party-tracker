package tracker.stats;

import javafx.scene.layout.GridPane;
import tracker.include.Enums.size;

public class StatBlock extends GridPane
{
	private PCStat<Integer> str;
	private PCStat<Integer> dex;
	private PCStat<Integer> con;
	private PCStat<Integer> intl;
	private PCStat<Integer> wis;
	private PCStat<Integer> cha;
	
	/**
	 * Constructs a Stat block
	 * @param statsIn
	 */
	public StatBlock(int[] statsIn)
	{
		str = new PCStat<Integer>("STR", statsIn[0], size.SINGLE);
		dex = new PCStat<Integer>("DEX", statsIn[1], size.SINGLE);
		con = new PCStat<Integer>("CON", statsIn[2], size.SINGLE);
		intl = new PCStat<Integer>("INT", statsIn[3], size.SINGLE);
		wis = new PCStat<Integer>("WIS", statsIn[4], size.SINGLE);
		cha = new PCStat<Integer>("CHA", statsIn[5], size.SINGLE);
		
		this.addRow(0, str, dex, con);
		this.addRow(1, intl, wis, cha);
	}
}