package Utilities;

import java.io.FileInputStream;
import jxl.Sheet;
import jxl.Workbook;

public class Excelreader {
	static Workbook myworkbook;
	static Sheet mysheet;
	public static  Sheet getmysheet(String filepath,String sheetName)
	{
	   try {
		FileInputStream myfile = new FileInputStream(filepath);
		myworkbook = Workbook.getWorkbook(myfile);
		mysheet = myworkbook.getSheet(sheetName);
	} catch (Exception AllException) {
		// TODO Auto-generated catch block
		AllException.printStackTrace();
	}
	return mysheet;
	   
	}
	public static  Sheet getmysheet(String filepath,int sheetindex)
	{
	   try {
		FileInputStream myfile = new FileInputStream(filepath);
		myworkbook = Workbook.getWorkbook(myfile);
		mysheet = myworkbook.getSheet(sheetindex);
	} catch (Exception AllException) {
		// TODO Auto-generated catch block
		AllException.printStackTrace();
	}
	return mysheet;
	   
	}
	public static int getmyrowcount(String filepath,String sheetName )
	{
		mysheet = getmysheet(filepath,sheetName);
		return mysheet.getRows();
		
	}
	public static int getmyrowcount(String filepath,int sheetindex )
	{
		mysheet = getmysheet(filepath,sheetindex);
		return mysheet.getRows();
		
	}
	public static int getmycolumncount(String filepath,String sheetName )
	{
		mysheet = getmysheet(filepath,sheetName);
		return mysheet.getColumns();
		
	}
	public static int getmycolumncount(String filepath,int sheetindex )
	{
		mysheet = getmysheet(filepath,sheetindex);
		return mysheet.getColumns();
		
	}
	public static String getmycellvalue(String filepath,String sheetName,int colNum,int rowNum )
	{
		mysheet = getmysheet(filepath,sheetName);
		return mysheet.getCell(colNum, rowNum).getContents();	
	}
	public static String getmycellvalue(String filepath,int sheetindex,int colNum,int rowNum )
	{
		mysheet = getmysheet(filepath,sheetindex);
		return mysheet.getCell(colNum, rowNum).getContents();	
	}
	public static String getmycellvalue(String filepath,String sheetName,String colName,int rowNum )
	{
		mysheet = getmysheet(filepath,sheetName);
		int colindex = -1;
		int cnt = getmycolumncount(filepath,sheetName );
		for(int i=0;i<cnt;i++)
		{
			String hai = mysheet.getCell(i, 0).getContents();
			if(hai.equalsIgnoreCase(colName))
			{
				colindex=i;
				break;
			}
		}
		
		return mysheet.getCell(colindex,rowNum).getContents();
	}
	public static String getmycellvalue(String filepath,int sheetindex ,String colName,int rowNum)
	{
		mysheet = getmysheet(filepath,sheetindex);
		int colindex = -1;
		int cnt = getmycolumncount(filepath,sheetindex );
		for(int i=0;i<cnt;i++)
		{
			String hai = mysheet.getCell(i, 0).getContents();
			if(hai.equalsIgnoreCase(colName))
			{
				colindex=i;
				break;
			}
		}
		
		return mysheet.getCell(colindex, rowNum).getContents();
	}
}
