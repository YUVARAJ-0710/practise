package TestScenarios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import TestObjectRepository.HomePage;
import UserDefinedLibraries.DriverInstantiate;
import UserDefinedLibraries.ExcelReadWrite;
import UserDefinedLibraries.Screenshot;

public class php {
	 public static FileInputStream fileip;
     public static FileOutputStream fileop;
     public static XSSFWorkbook workbook; 
     public static XSSFSheet sheet;
     public static XSSFCell cell;
     public static XSSFRow Row;
     public static WebDriver driver;
     public static File src;
     public static int t;
     public static List<WebElement> listofvalues,list1,list2,list3,list4;
     public static String val1;
     public static WebElement a,x,y;
     
     @Parameters("browser")
     @BeforeClass
     public static void driverop(String browser)
     {
    	  driver=DriverInstantiate.driverinstant(browser);
     }
     @Test(priority=0)
     public static void testread() throws IOException
     {
    	 ExcelReadWrite.readexcel();
     }
     @Test(priority=1)
     public static void currency()
     {
    	 Actions actions = new Actions(driver);
    	 WebElement e=driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[2]/a"));
    	 actions.moveToElement(e).perform();
    	 list2 = HomePage.hover(driver);
    	 int k=0;
    	 categ:
    		 for(WebElement a : list2)
    		 {
    			 k++;
    			 System.out.println("Category list options: "+ a.getText());
                 
                 if(a.getText().equalsIgnoreCase(ExcelReadWrite.category1))
                 {
                     a.click();
                     break categ;
    		 }
    		 }
    	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	 }
    	 @Test(priority=2) 
    		public void from() throws IOException,InterruptedException
    		{
    		 Actions actions = new Actions(driver);
    		 System.out.println(ExcelReadWrite.category2);
    			x=driver.findElement(By.xpath("//*[@id=\"s2id_origin\"]/a/span[1]"));
    			actions.moveToElement(x).click();
    			x.sendKeys(ExcelReadWrite.category2);
    			/*HomePage.from(driver).click();
    			Thread.sleep(100);
    	    	 list3= HomePage.hover(driver);
    	    	 int l=0;
    	    	 categ:
    	    		 for(WebElement a : list3)
    	    		 {
    	    			 l++;
    	    			 System.out.println("From options: "+a.getText());
    	                 
    	                 if(a.getText().equalsIgnoreCase(ExcelReadWrite.category2))
    	                 {
    	                    HomePage.from(driver).click();
    	                     break categ;
    	    		 }
    	    		 }*/
    			Screenshot.screenShotTC(driver);
    		}
    	 @Test(priority=3) 
 		public void to() throws IOException,InterruptedException
 		{
 			System.out.println(ExcelReadWrite.category3);
 			y=driver.findElement(By.xpath("//*[@id=\"s2id_destination\"]/a/span[1]"));
 			y.click();
 			y.sendKeys(ExcelReadWrite.category3);	
 			Thread.sleep(100);
 	    	 /*list4= HomePage.hover(driver);
 	    	 int m=0;
 	    	 categ:
 	    		 for(WebElement a : list3)
 	    		 {
 	    			 m++;
 	    			 System.out.println("To options: "+a.getText());
 	                 
 	                 if(a.getText().equalsIgnoreCase(ExcelReadWrite.category3))
 	                 {
 	                    HomePage.to(driver).click();
 	                     break categ;
 	    		 }
 	    		 }*/
 			Screenshot.screenShotTC(driver);
 		}
    	 
    	 public void date() throws IOException,InterruptedException
  		{
    		 ExcelReadWrite.readexcel();
    			  String dot = new String();
    			    for(int i=0; i<=sheet.getLastRowNum(); i++)
    			    {
    			         if(i==0)
    			         {
    			              cell = sheet.getRow(i).getCell(3);
    			               dot = cell.getStringCellValue();
    			              break;
    			         }
    			    }
    			   

    			   String dateArray1[]= dot.split("/");
    			    String date = dateArray1[0];
    			    String monthyear = dateArray1[1];
    			    
    			      
    			 String calmonthyear = driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[1]/th[2]")).getText();;
    			 

    			   WebElement cal1=driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr/td"));
    			    
    			    List<WebElement> rows1,cols1;
    			    rows1=cal1.findElements(By.tagName("tr"));
    			    first:
    			    for (int i = 1; i < rows1.size(); i++) 
    			    {
    			         cols1=rows1.get(i).findElements(By.tagName("td"));
    			         for (int j = 0; j < cols1.size(); j++) 
    			         {
    			              String caldt = cols1.get(j).getText();
    			              if (caldt.equals(date)) 
    			              {
    			            	  while (!calmonthyear.contains(monthyear)) 
    			            	    {
    			            	         driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr[4]/td[4]")).click();
    			            	         calmonthyear=driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[1]/th[2]")).getText();
    			            	         System.out.println("Selected Year::" +    calmonthyear);
    			            	    }
    			                 
    			                   cols1.get(j).click();
    			                   break first;
    			                   
    			              }
    			              
    			         }
    			    }
    			Screenshot.screenShotTC(driver);
  		}
  
    	 @Test(priority=4) 
     static void readlistofProds()
     {
                     /*
                     for(int i = 0; i < HomePage.price(driver).size();i++) {
                                     listofvalues.add(HomePage.price(driver).get(i));
                     }
                     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                     */
                     val1 =  HomePage.price(driver).get(0).getText();
                     System.out.println(val1);             
     }
    	 @Test(priority=5) 
     public static void testwrite() throws IOException, FileNotFoundException
     {
                   t=ExcelReadWrite.row;
                   System.out.println("Current Row no. to write : " + t);
                   
                    cell = ExcelReadWrite.sheet.getRow(t).getCell(6);
                   System.out.println(cell);
                     if (cell == null)
                                       cell = ExcelReadWrite.sheet.getRow(t).createCell(6);
                     cell.setCellValue(val1);
                   ExcelReadWrite.writeexcel();
     } 
    	 @Test(priority=6) 
     public static void search() throws Exception
     {
                     HomePage.search(driver).click();
                     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                     System.out.println("clicked searchicon");
                     Screenshot.screenShotTC(driver);
     }
     @AfterClass
     public void driverexit()
     {
                 DriverInstantiate.driverClose();    
     }  
}
