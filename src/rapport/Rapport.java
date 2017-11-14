package rapport;

import java.util.ArrayList;

import com.coins.Coin	  ;
import com.coins.CoinsGen ;

public class Rapport 
{
	private Coin coin1	 ;
	private Coin coin2   ;
	private float rapport;
	
	public Rapport()
	{
		super();
	}
	public Rapport(Coin c1, Coin c2)
	{
		float diam1 = c1.getDiameter();
		float diam2 = c2.getDiameter();
		float r     = diam1/diam2;     // WATCHOUT FROM X/0 EXCEPTION
		if(r == 1)
		{
			this.coin1   = null;
			this.coin2 	 = null;
			this.rapport = 1;
		}
		else
		{
			if(r > 1)
			{
				r = 1/r;
				CheckForCoins(c1, c2, r);
			}
			else
			{
				CheckForCoins(c1, c2, r);
			}
		}
	}
	
	public Coin getCoin1() {
		return coin1;
	}
	
	public Coin getCoin2() {
		return coin2;
	}
	
	public float getRapport() {
		return rapport;
	}
	
	public void setCoin1(Coin coin1) {
		this.coin1 = coin1;
	}
	
	public void setCoin2(Coin coin2) {
		this.coin2 = coin2;
	}
	
	public void setRapport(float rapport) {
		this.rapport = rapport;
	}
	
	public static void CheckForCoins(Coin c1, Coin c2, float rapport)
	{
		ArrayList<Rapport> ALIR = GetBaseRapports();
		for(int i = 0 ; i < ALIR.size(); i++)
		{
			Rapport aRapport = ALIR.get(i);
			if(aRapport.getRapport() == rapport)
			{
				c1 = aRapport.getCoin1();
				c2 = aRapport.getCoin2();
			}
		}
	}
	
	public static ArrayList<Rapport> GetBaseRapports()
	{
		ArrayList<Rapport> ALIR = new ArrayList<>();
		ArrayList<Coin>    ALIC = CoinsGen.GenerateBaseCoins();
		
		for(int i = 0 ; i < ALIC.size(); i++)
		{ 
			if( i+1 != ALIC.size())
			{
				Coin c1 = ALIC.get(i)          					   ;
				Coin c2 = ALIC.get(i+1)        					   ;
				Rapport rapport = new Rapport()					   ;
				rapport.coin1 = c1								   ;
				rapport.coin2 = c2								   ;
				rapport.rapport = c1.getDiameter()/c2.getDiameter();
				ALIR.add(rapport)								   ;
			}
		}
		return ALIR;
	}
	
}
