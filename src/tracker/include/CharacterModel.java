package tracker.include;

public class CharacterModel
{
	/* 
	 * info - [background][class][race][alignment]
	 * health - [ac][sp][hp][max hp]
	 * stats - [str][dex][con][int][wis][cha]
	 */
	private int index;
	private String name;
	private String[] info = new String[4];
	private int exp;
	private int[] health = new int[4];
	private int[] stats = new int[6];
	
	public CharacterModel()
	{
	}
	
	public CharacterModel(int index_in, String name_in,
			String[] info_in, int exp_in, 
			int[] health_in, int[] stats_in)
	{
		index = index_in;
		name = name_in;
		exp = exp_in;
		if(info_in.length == 4)
			info = info_in;
		if(health_in.length == 4)
			health = health_in;
		if(stats_in.length == 6)
			stats = stats_in;
	}
	
	/*******************************************
	 * SETTERS
	 *******************************************/
	
	public void setIndex(int index_in)
	{
		index = index_in;
	}
	
	public void setName(String name_in)
	{
		name = name_in;
	}
	
	public void setInfo(String[] info_in)
	{
		if(info_in.length == 4)
		{
			info = info_in;
		}
	}
	
	public void setBackground(String bkgd_in)
	{
		info[0] = bkgd_in;
	}
	
	public void setCl(String class_in)
	{
		info[1] = class_in;
	}
	
	public void setRace(String race_in)
	{
		info[2] = race_in;
	}
	
	public void setAlign(String align_in)
	{
		info[3] = align_in;
	}
	
	public void setExp(int exp_in)
	{
		exp = exp_in;
	}
	
	public void setHealth(int[] health_in)
	{
		if(health_in.length == 4)
		{
			health = health_in;
		}
	}
	
	public void setAC(int ac_in)
	{
		health[0] = ac_in;
	}
	
	public void setSpeed(int sp_in)
	{
		health[1] = sp_in;
	}
	
	public void setHP(int hp_in)
	{
		health[2] = hp_in;
	}
	
	public void setMaxHP(int maxhp_in)
	{
		health[3] = maxhp_in;
	}
	
	public void setStats(int[] stats_in)
	{
		if (stats_in.length == 6)
		{
			stats = stats_in;
		}
	}
	
	public void setStr(int str_in)
	{
		stats[0] = str_in;
	}
	
	public void setDex(int dex_in)
	{
		stats[1] = dex_in;
	}
	
	public void setCon(int con_in)
	{
		stats[2] = con_in;
	}
	
	public void setInt(int int_in)
	{
		stats[3] = int_in;
	}
	
	public void setWis(int wis_in)
	{
		stats[4] = wis_in;
	}
	
	public void setCha(int cha_in)
	{
		stats[5] = cha_in;
	}
	
	/*******************************************
	 * GETTERS
	 *******************************************/
	
	public int getIndex()
	{
		return index;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String[] getInfo()
	{
		return info;
	}
	
	public String getBackground()
	{
		return info[0];
	}
	
	public String getCl()
	{
		return info[1];
	}
	
	public String getRace()
	{
		return info[2];
	}
	
	public String getAlign()
	{
		return info[3];
	}
	
	public int getExp()
	{
		return exp;
	}
	
	public int[] getHealth()
	{
		return health;
	}
	
	public int getAC()
	{
		return health[0];
	}
	
	public int getSpeed()
	{
		return health[1];
	}
	
	public int getHP()
	{
		return health[2];
	}
	
	public int getMaxHP()
	{
		return health[3];
	}
	
	public int[] getStats()
	{
		return stats;
	}
	
	public int getStr()
	{
		return stats[0];
	}
	
	public int getDex()
	{
		return stats[1];
	}
	
	public int getCon()
	{
		return stats[2];
	}
	
	public int getInt()
	{
		return stats[3];
	}
	
	public int getWis()
	{
		return stats[4];
	}
	
	public int getCha()
	{
		return stats[5];
	}
}
