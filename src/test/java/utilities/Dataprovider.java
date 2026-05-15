package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;
public class Dataprovider {

	@DataProvider(name="logindata")
	public String[][]getdata() throws IOException{
		String path=".\\testdata\\Orangehrmsheet1.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		
		int totalrowCount = excel.getRowCount("Sheet1");
		int totalcellCount = excel.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalrowCount][totalcellCount];
		for (int i = 1; i <=totalrowCount; i++) {
			for (int j = 0; j <totalcellCount; j++) {
			 loginData[i-1][j]=excel.getCellData("Sheet1", i, j); 
			}
			
		}
		
		return loginData;
	}
}

