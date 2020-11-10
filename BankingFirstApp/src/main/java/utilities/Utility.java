package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void screenshot(WebDriver driver ,int testid,String browser) throws IOException
	{
	File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination =new File ("test-output"+File.separator+"screenShots"+File.separator+"Test_"+testid+"_"+browser+".jpg");
	FileUtils.copyFile(source,destination);
	 //FileHandler.copy(source,destination);
	}
	
	public static String dataFetchingFromExcel(int row,int col) throws IOException
	{   String s;

	File testdata = new File("src"+File.separator+"test"+File.separator+"resources"+File.separator+"Credentials.xlsx");
	
	FileInputStream input = new FileInputStream(testdata);
	
		Sheet selectSheet= WorkbookFactory.create(input).getSheet("Sheet1");
            try 
				{
					s= selectSheet.getRow(row).getCell(col).getStringCellValue();
					
				
					return s;
				}
				catch(IllegalStateException e) 
				{
				double d=selectSheet.getRow(row).getCell(col).getNumericCellValue();
		
				s=String.valueOf(d);
                return s;
				}

	}	

}
