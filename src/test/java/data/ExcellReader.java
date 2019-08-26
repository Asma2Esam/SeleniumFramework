package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReader 
{
	static FileInputStream fis = null;
	public FileInputStream GetFileInputStream()
	{
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\data\\UserData.xlsx";
		File srcFile = new File(filePath);
		try 
		{
			fis = new FileInputStream(srcFile);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error occured: "+ e.getMessage());
			System.exit(0);
		}
		return fis;
	}
	public Object[][] GetExcellData() throws IOException
	{
		fis = GetFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int totalNumberOfRows = (sheet.getLastRowNum()+1);
		int totalNumberOfColoumns = 4;
		String[][] arrayExcellData = new String[totalNumberOfRows][totalNumberOfColoumns];
		for (int i = 0; i < totalNumberOfRows; i++) 
		{
			for (int j = 0; j < totalNumberOfColoumns; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcellData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcellData;
	}

}
