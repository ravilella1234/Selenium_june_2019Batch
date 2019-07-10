package com.project.MavenProject.pageobjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectClass2
{
	@FindBy(linkText="Sign in")WebElement signIn;
	@FindBy(id="email_create")WebElement customerEmail;
	@FindBy(xpath="//button[@id='SubmitCreate']")WebElement submitCreate;
	@FindBy(id="id_gender1")WebElement mr;
	@FindBy(id="customer_firstname")WebElement firstName;
	@FindBy(id="customer_lastname")WebElement lastName;
	@FindBy(id="passwd")WebElement  password;
	@FindBy(id="days")WebElement day;
	@FindBy(id="months")WebElement month;
	@FindBy(id="years")WebElement year;
	@FindBy(id="address1")WebElement address;
	@FindBy(id="city")WebElement city;
	@FindBy(id="id_state")WebElement state;
	@FindBy(id="postcode")WebElement postalCode;
	@FindBy(id="id_country")WebElement country;
	@FindBy(id="phone_mobile")WebElement phone;
	@FindBy(id="submitAccount")WebElement submitAccount;
	
	public PageObjectClass2(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void customerRegistration() throws InterruptedException
	{
		signIn.click();
		customerEmail.sendKeys("qatest876596@gmail.com");
		submitCreate.click();
		Thread.sleep(3000);
		mr.click();
		firstName.sendKeys("qa");
		lastName.sendKeys("test");
		password.sendKeys("test1234");
		day.sendKeys("15");
		month.sendKeys("April");
		year.sendKeys("2002");
		address.sendKeys("hyderabad");
		city.sendKeys("hyderabad");
		state.sendKeys("California");
		postalCode.sendKeys("34567");
		country.sendKeys("United States");
		phone.sendKeys("1234567898");
		
	}
	
	
}

