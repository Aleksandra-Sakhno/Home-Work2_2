package test2_2.mavenproject2_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main( String[] args) throws InterruptedException{
    WebDriver driver=initDriver();
    driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    driver.manage().window().maximize();
    findKeys(driver, "email", "webinar.test@gmail.com");
    findKeys(driver, "passwd", "Xcg7299bnSmMuRLp9ITw");
    WebElement button=driver.findElement(By.name("submitLogin"));
    button.click();
    
    Thread.sleep(4000);
    
    String elements[] ={"Dashboard", "Заказы", "Каталог", "Клиенты", "Служба поддержки", "Статистика",
                        "Modules", "Design","Доставка","Способ оплаты","International","Shop Parameters","Конфигурация"};
    
    int i=0; 
    Thread.sleep(4000);
    
    for (String el:elements){
        driver.findElement(By.linkText(el)).click();
        Thread.sleep(3000);
        i++;
        String Title=driver.getTitle();
        if ("prestashop-automation".equals(Title)) System.out.println("Title"+ i+" not found");
        else System.out.println("Title"+ i+": "+ Title); 
        driver.navigate().refresh();
        Thread.sleep(3000);
        String newTitle=driver.getTitle();
        if (newTitle.equals(Title)) System.out.println("     Section has not changed");
        else System.out.println("     Section has changed");
        }
    driver.quit();
    }
      
    public static WebDriver initDriver() {
        String drPath=System.getProperty("user.dir")+"/Drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", drPath);
        return new ChromeDriver();
        }   
    
    static void findKeys (WebDriver dr, String name,String keys)
        {dr.findElement(By.name(name)).sendKeys(keys); }
     
} 