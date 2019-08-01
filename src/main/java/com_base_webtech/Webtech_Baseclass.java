package com_base_webtech;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com_testutill_webtech.Testutill;

public class Webtech_Baseclass {
	public static WebDriver driver;
	public static Properties prop;

	public Webtech_Baseclass() {

		try {

			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Aakanksha\\eclipse-workspace\\Automatiom\\src\\main\\resources\\congifg.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void browser_initialization() {

		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakanksha\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver(options);

		} else if (browsername.equals("FF")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakanksha\\Desktop\\chromedriver.exe");
	
				 driver = new ChromeDriver();
				
				
			}
			
			driver.manage().window().maximize();
		
			driver.manage().timeouts().pageLoadTimeout(com_testutill_webtech.Testutill.Page_load_Time, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Testutill.Implicity_Wait, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			
			

		}
	}


