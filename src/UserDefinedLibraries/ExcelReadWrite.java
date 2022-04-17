package UserDefinedLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
                public static File src;
                public static String exfilepath = "C:\\Users\\825627\\eclipse-workspace\\Phptravels\\src\\DataTables\\Phpdata.xlsx";
                public static FileInputStream fileip;
                public static FileOutputStream fileop;
                public static XSSFWorkbook workbook; 
                public static XSSFSheet sheet;
                public static String val1;
                public static int row;
                public static XSSFCell cell;
                public static XSSFRow Row;
                public static String category1,category2,category3,category4;
                
                public static int readexcel() throws IOException {
                                try
                    {
                                                src=new File(exfilepath);
                                                fileip = new FileInputStream(src);
                                    workbook = new XSSFWorkbook(fileip); 
                                    sheet = workbook.getSheetAt(0);
                                    
                                for(int i=0; i<=sheet.getLastRowNum(); i++)
                        {
                            if(i==0)
                            {
                                 category1 = sheet.getRow(i).getCell(0).getStringCellValue();
                                 category2 = sheet.getRow(i).getCell(1).getStringCellValue();
                                 category3 = sheet.getRow(i).getCell(2).getStringCellValue();
                                 category4 = sheet.getRow(i).getCell(3).getStringCellValue();
                                 System.out.println(category1);
                                 System.out.println(category2);
                                 System.out.println(category3);
                                 System.out.println(category4);
                                 row=6;                  
                                 break;
                            }
                        }                     
                    }catch (FileNotFoundException e) 
               {
                                                e.printStackTrace();
               }catch (IOException e)
                                                {
                               e.printStackTrace();
                                                }
                                return row;
                }
                
                public static void writeexcel() {                  
                  try
                  {                              
                                //Close input stream
                      fileip.close();
                    //Create an object of FileOutputStream class to create write data in excel file
                      fileop =new FileOutputStream(new File(exfilepath));
                    //write data in the excel file
                      workbook.write(fileop);
                    //close output stream
                      fileop.close();                                      
                  } catch (FileNotFoundException e){
                         e.printStackTrace();
                     } catch (IOException e){
                         e.printStackTrace();
                     }
                  }

}

