package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Configproperties {
	static FileInputStream myfile;
	static Properties myprop;
	public static String readvalue(String key)
	{
		try
		{
			myfile = new FileInputStream("C://Users//96917466//workspace//PrimusBank2//src//test//java//Utilities//config.properties");
			myprop = new Properties();
			myprop.load(myfile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
		}
		return myprop.getProperty(key);
		
	}

}
