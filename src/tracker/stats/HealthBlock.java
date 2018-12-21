package tracker.stats;

import javafx.scene.layout.GridPane;
import tracker.include.Enums.size;

public class HealthBlock extends GridPane
{
	private PCStat<Integer> ac;
	private PCStat<Integer> sp;
	private PCStat<Integer> hp;
	
	/**
	 * Constructs a Health block
	 * 
	 * @param healthIn
	 */
	public HealthBlock(int[] healthIn)
	{
		ac = new PCStat<Integer>("AC", healthIn[0], size.SINGLE);
		sp = new PCStat<Integer>("SPEED", healthIn[1], size.SINGLE);
		hp = new PCStat<Integer>("HP", healthIn[2], size.SINGLE);
		
		this.addRow(0, ac, sp);
		this.add(hp, 0, 1, 2, 1);
	}
}
