package seleniumpratcise;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	private static final String TakesScreenshot = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.astroved.com/");
        driver.manage().window().maximize();
        Thread.sleep(9000);
      driver.findElement(By.id("webpushr-deny-button")).click();
       driver.findElement(By.id("Label4")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//input[@id='MyAccountPhp_LoginView2_defaultLogin_UserName']")).sendKeys("gowthammyr2021@gmail.com");
       driver.findElement(By.xpath("//input[@id='MyAccountPhp_LoginView2_defaultLogin_Password']")).sendKeys("Astroved@108");
       driver.findElement(By.xpath("//input[@id='MyAccountPhp_LoginView2_defaultLogin_LoginButton']")).click();
       Thread.sleep(2000);
       Actions action=new Actions(driver);
       WebElement special=driver.findElement(By.xpath("//a[@href='https://www.astroved.com/horoscopes/daily-horoscope/Aries']"));
       action.moveToElement(special).build().perform();
       special.click();
      //  driver.findElement(By.xpath("//span[@class='wk-cookie-close']")).click();    
      ArrayList<String> windows=new ArrayList<String> (driver.getWindowHandles());
       driver.switchTo().window(windows.get(0));
       Thread.sleep(6000);
      driver.findElement(By.xpath("//div[@class='astrospe-astimg']")).click();
      driver.switchTo().window(windows.get(1));
      Thread.sleep(6000);
    // Alert alert=driver.switchTo().alert();
    // alert.accept();
     
     //  driver.findElement(By.xpath("//span[@class='wk-cookie-close']")).click();
       driver.switchTo().window(windows.get(0));
       TakesScreenshot ts=(TakesScreenshot)driver;
       File scr=ts.getScreenshotAs(OutputType.FILE);
       File trg=new File("/seleniumpratcise/src/test/resources/screenshot.png");
       FileUtils.copyFile(scr, trg);
        
}
}