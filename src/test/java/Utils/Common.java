package Utils;

import java.util.Properties;
import java.util.Random;


public class Common {

//	public String getRandomMail(String domain)
//	{
//		String regex = "\\w{10}@"+domain+"\\.com";
//		return new Generex(regex).random();
//	}
	Properties config;
	public void setConfigProp()
	{
		config =  ConfigUtil.getConfig();
	}

	public Properties getConfigProp()
	{
		return config ;
	}
	public int getRandomNumber(int min, int max)
	{
		 Random rand = new Random();
		 return  rand.nextInt((max - min) + 1) + min;
	}
	
	public  String returnRandomString(String[] pool) {
        int idx = new Random().nextInt(pool.length);
        String rand = (pool[idx]);
        return rand.toString();
    }
	
	public String getRandomState()
	{
		 return returnRandomString(new String[]{"North Carolina","North Dakota","Iowa","Kansas","Alaska","California","Colorado","Kentucky","Mississippi","Oklahoma","Oregon","Virginia","Washington"});
	}
	
	   public String getRandomString(int size){
	        RandomString gen = new RandomString();
	        return String.valueOf(gen.randnum(size));
	    }
}
