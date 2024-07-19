package com.espncricinfo;

public class Locators {
//    public static final String CHROME_DRIVER_PATH = "D:\\Profile Data\\E Drive data\\My Records\\Testing\\ChromeDrivers\\ChromeDriver 126\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	public static final String CHROME_DRIVER_PATH = "drivers/chromedriver.exe";
	public static final String LIVE_SCORES_LINK = "//a[@title='Live Cricket Score']";
	public static final String LIVE_SCORES_SECTION = "//h2[text()='Live Cricket Matches']/ancestor::div[contains(@class, 'content-prime')]";
	public static final String MATCH_SCORE = "//p[@title]";
}
