package TestObjectRepository;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage {
	public static WebElement element=null;
public static WebDriver driver;
public static List<WebElement> hover(WebDriver driver)
{
	List<WebElement> list2= driver.findElements(By.xpath("/html/body/nav/div/div[2]/ul[2]/ul/li[2]/ul/li/a"));
	return list2;
}
/*public static WebElement from(WebDriver driver)
{
	WebElement element= driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[2]/div"));
	return element;
}
/*public static WebElement to(WebDriver driver)
{
	WebElement element= driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li[1]/div"));
	return element;
}*/
public static WebElement departon(WebDriver driver)
{
	WebElement element= driver.findElement(By.xpath("//*[@id=\"departure_date\"]"));
	return element;
}
public static List<WebElement> dates(WebDriver driver)
{
	List<WebElement> element= driver.findElements(By.xpath("/html/body/div[9]/div[1]/table/tbody/tr/td"));
	return element;
}
public static WebElement search(WebDriver driver)
{
	WebElement element= driver.findElement(By.xpath("//*[@id=\"amadeus_search\"]/div/div[1]/div[6]/button"));
	return element;
}
public static List<WebElement> price(WebDriver driver)
{
	List<WebElement> element= driver.findElements(By.xpath("//*[@id=\"list\"]/tbody/tr[1]/td/form/div[2]/span/input"));
	return element;
}

}
