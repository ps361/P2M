package com.carwaletest;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UserAccount extends Config {

	/*
	 * @Test public void signup() throws InterruptedException {
	 * driver.findElement(By.xpath("//div[@class=\"o-fzptZU o-cONQOm\"]")).click();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 * driver.findElement(By.xpath("//span[text()=\"Sign Up\"]")).click();
	 * driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Pranay");
	 * driver.findElement(By.xpath("//input[@placeholder=\"Enter Your Email Id\"]"))
	 * .sendKeys("psppatil33@gmail.com");
	 * driver.findElement(By.xpath("//input[@id=\"mobile\"]")).sendKeys("9432942540"
	 * ); driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(
	 * "Pa@@123456");
	 * driver.findElement(By.xpath("//button[text()=\"Sign Up\"]")).click();
	 * Thread.sleep(5000); }
	 */

	@Test
	public void login() throws InterruptedException {
		signin_code();
	}

	public static void signin_code() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class=\"o-fzptZU o-cONQOm\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Your Email Id\"]")).sendKeys("psppatil33@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Pa@@123456");
		driver.findElement(By.xpath("//button[text()=\"Login\"]")).click();
		Thread.sleep(5000);
	}

	@Test
	public void changePass() throws InterruptedException {
		signin_code();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class=\"o-fzptZU o-cONQOm\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()=\"Change Password\"]")).click();
		driver.findElement(By.id("currentPassword")).sendKeys("Pa@@123456");
		driver.findElement(By.id("newPassword")).sendKeys("Pa@@1234567");
		driver.findElement(By.id("confirmPassword")).sendKeys("Pa@@1234567");
		driver.findElement(By.id("butChange")).sendKeys("Pa@@1234567");
		Thread.sleep(5000);

	}

	/*
	 * @Test public void changePass() throws InterruptedException {
	 * 
	 * driver.findElement(By.cssSelector("div.o-fzptZU o-cONQOm")).click(); }
	 */

	@Test(description="Low to high price cars selected")
	public void SelectCar() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//div[text()=\"NEW CARS\"]"));
		Actions mouse = new Actions(driver);
		mouse.moveToElement(element).perform();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()=\"View More Brands\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Maruti Suzuki\"]")).click();
		Thread.sleep(5000);
		WebElement sorting = driver.findElement(By.xpath("//div[@class=\"o-brXWGL o-cpnuEd o-dsiSgT\"]/select"));
		Thread.sleep(5000);
		Select price = new Select(sorting);
		price.selectByValue("price-asc");
		Thread.sleep(2000);
		List<WebElement> low_To_High_Price = driver
				.findElements(By.xpath("//span[@class=\"o-eZTujG o-byFsZJ o-bkmzIL o-bVSleT\"]"));
		Iterator<WebElement> itr = low_To_High_Price.iterator();
		System.out.println("low to high price cars ==>");
		while (itr.hasNext()) {
			System.out.println(itr.next().getText());
		}

	}

	@Test
	public void SelectLocation() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class=\"o-cKuOoN \"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title=\"Pune\"]")).click();
		Thread.sleep(5000);
	}
}
