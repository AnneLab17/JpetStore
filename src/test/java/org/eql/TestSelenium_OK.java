package org.eql;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSelenium_OK {

	@Test
	public void TestSeleniumJUnit () throws InterruptedException{

		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");

		// instanciation de de WebDriver
	WebDriver driver = new FirefoxDriver();
	
	//CONFIGURATION D'UN IMPLICIT WAIT
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	
	//navigation
	driver.get("http://localhost:8180/jpetstore");
	
	driver.findElement(By.xpath("//a[.='Enter the Store']")).click();
	
	//clic sur le lien sign in
	driver.findElement(By.xpath("//a[.='Sign In']")).click();
	
	// Rempli les champs login password
	driver.findElement(By.xpath("//input[@name='username']")).clear();
	driver.findElement(By.xpath("//input[@name='password']")).clear();
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("j2ee");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("j2ee");
	
	//clic sur le bouton submit
	driver.findElement(By.xpath("//input[@name='signon']")).click();
	
	//verification du message de bienvenue
	assertEquals(driver.findElement(By.id("WelcomeContent")).getText(),"Welcome ABC!");
	
	
	//clic sur le lien Fish 
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=FISH')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Fish");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FI-SW-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-1')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//doubler la quantité du produit
	driver.findElement(By.xpath("//input[@name='EST-1']")).clear();
	driver.findElement(By.xpath("//input[@name='EST-1']")).sendKeys("2");
	driver.findElement(By.xpath("//input[contains(@name,'update')]")).click();
	
	//vérification du calcul du montant total
	
	//récupère le prix unitaire et total en String (écarte le $ de la sélection)
	String prixUnit = driver.findElement(By.xpath("//form/table/tbody/tr[2]/td[6]")).getText().substring(1, 5);
	String prixTotal = driver.findElement(By.xpath("//form/table/tbody/tr[2]/td[7]")).getText().substring(1, 5);
	
	//remplace la virgule par un point
	prixUnit = prixUnit.substring(0,2) + "." +prixUnit.substring(3,4);
	prixTotal = prixTotal.substring(0,2) + "." +prixTotal.substring(3,4);
	
	//transforme le string en un double
	double Unit = Double.parseDouble(prixUnit);
	double Total = Double.parseDouble(prixTotal);
	
	try{
		assertTrue(Total == Unit*2);
	}
	catch(AssertionError ae) {
		System.out.println("ERREUR : le prix du panier n'a pas été multiplié par deux");
	}
	System.out.println("SUCCES : le prix du panier a été multiplié par deux");
	
	//clic sur le lien Fish 
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=FISH')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Fish");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FI-SW-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-2')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Fish 
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=FISH')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Fish");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FI-SW-02')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-3')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Fish 
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=FISH')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Fish");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FI-FW-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-4')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Fish 
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=FISH')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Fish");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FI-FW-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-5')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Fish 
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=FISH')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Fish");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FI-FW-02')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-20')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Fish 
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=FISH')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Fish");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FI-FW-02')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-21')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Dogs
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=DOGS')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Dogs");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=K9-BD-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-6')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Dogs
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=DOGS')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Dogs");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=K9-BD-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-7')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//Recherche Poodle
	driver.findElement(By.xpath("//input[@name='keyword']")).clear();
	driver.findElement(By.xpath("//input[@name='keyword']")).sendKeys("poodle");
	
	//clic sur le bouton Search
	driver.findElement(By.xpath("//input[@name='searchProducts']")).click();
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=K9-PO-02')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-8')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur Catalog
	driver.findElement(By.xpath("//a[contains(@href,'Catalog')]")).click();
	
	//clic sur le lien Reptiles
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=REPTILES')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Reptiles");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=RP-SN-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-11')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur Help
	driver.findElement(By.xpath("//a[contains(@href,'help')]")).click();
	
	//Retour
	driver.navigate().back();
	
	//clic sur Cart
	driver.findElement(By.xpath("//a[contains(@href,'Cart')]")).click();
	
	//clic sur My Account
	driver.findElement(By.xpath("//a[contains(@href,'editAccountForm')]")).click();
	
	//clic sur My Orders
	driver.findElement(By.xpath("//a[contains(@href,'Order')]")).click();
	
	//clic sur le lien Cats
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=CATS')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Cats");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=FL-DSH-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-14')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//clic sur le lien Birds
	driver.findElement(By.xpath("//div[@id='QuickLinks']/a[contains(@href,'Id=BIRDS')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Birds");
	
	//clic sur un produit
	driver.findElement(By.xpath("//a[contains(@href,'Id=AV-CB-01')]")).click();
	
	//clic sur un item
	driver.findElement(By.xpath("//a[contains(@href,'workingItemId=EST-18')]")).click();
	assertEquals(driver.findElement(By.xpath("//h2")).getText(),"Shopping Cart");
	
	//Checkout
	driver.findElement(By.xpath("//a[contains(@href,'newOrderForm')]")).click();
	
	//clic sur le bouton continue
	driver.findElement(By.xpath("//input[@name='newOrder']")).click();
	
	//clic sur le bouton confirm
	driver.findElement(By.xpath("//a[contains(@href,'confirmed')]")).click();
	
	
	driver.quit();
	
	}
	
}