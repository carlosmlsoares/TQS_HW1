package com.mycompany.hw1tqs;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InterfaceTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Carlos Soares\\Downloads\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTQSHW1() throws Exception {
    driver.get("http://localhost:8080/HW1TQS/");
    driver.findElement(By.name("j_idt3:j_idt5")).click();
    driver.findElement(By.name("j_idt3:j_idt5")).clear();
    driver.findElement(By.name("j_idt3:j_idt5")).sendKeys("1");
    driver.findElement(By.name("j_idt3:j_idt7")).click();
    new Select(driver.findElement(By.name("j_idt3:j_idt7"))).selectByVisibleText("EUR");
    driver.findElement(By.name("j_idt3:j_idt7")).click();
    driver.findElement(By.name("j_idt3:j_idt177")).click();
    new Select(driver.findElement(By.name("j_idt3:j_idt177"))).selectByVisibleText("USD");
    driver.findElement(By.name("j_idt3:j_idt177")).click();
    driver.findElement(By.name("j_idt3:j_idt349")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
