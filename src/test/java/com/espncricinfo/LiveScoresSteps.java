package com.espncricinfo;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class LiveScoresSteps {
	private WebDriver driver;
	private WebDriverWait wait;
	private Properties config;

	public LiveScoresSteps() {
		config = new Properties();

		try {
			FileInputStream configFile = new FileInputStream("src/test/resources/config.properties");
			config.load(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@Given("I am on the homepage")
	public void onHomepage() throws InterruptedException {		

		System.setProperty("webdriver.chrome.driver", Locators.CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(config.getProperty("homepage.url"));

	}

	@When("I go to the live scores section")
	public void goToLiveScores() throws InterruptedException {

		WebElement liveScoresLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.LIVE_SCORES_LINK)));
		liveScoresLink.click();

	}

	@Then("I should see all ongoing matches")
	public void verifyLiveScores() throws InterruptedException {

		WebElement liveScores = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(Locators.LIVE_SCORES_SECTION)));

		Assert.assertTrue(liveScores.isDisplayed());

		List<WebElement> matches = liveScores.findElements(By.xpath(Locators.MATCH_SCORE));
		int matchCount = matches.size();
		System.out.println("Total number of matches displayed are " + matchCount + " as below:");
		System.out.println();
		for (WebElement match : matches) {
			Assert.assertTrue(match.isDisplayed());
			String matchName = match.getAttribute("title");
			System.out.println(matchName);

		}
		System.out.println();
		System.out.println("---Test Completed---");
		driver.quit();
	}
}
