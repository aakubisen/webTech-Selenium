package webtech_search_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_base_webtech.Webtech_Baseclass;

public class webtech_etsy extends Webtech_Baseclass {

	@FindBy(id = "search-query")
	WebElement searchbox;

	@FindBy(xpath = "//button[contains(@class,'btn btn-primary')]")
	WebElement searchbutton;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div[2]/div[3]/div/ul/li[1]/div/a")
	WebElement anchorTag;

	public webtech_etsy() {

		PageFactory.initElements(driver, this);

	}

	public void searchresult() {

		searchbox.click();
		searchbox.sendKeys("cloud pillow");
		searchbutton.click();
		searchresultname();

	}

	public void searchresultname() {

		String xpath1 = "//*[@id='content']/div/div[1]/div/div/div[2]/div[2]/div[3]/div/ul/li[";
		String xpath2 = "]/div/a/div[2]/div/h2";

		String anchXpath2 = "]/div/a";

		for (int i = 1; i <= 20; i++) {

			String xapth_resulttext = xpath1 + i + xpath2;

			String finalsearchresult = driver.findElement(By.xpath(xapth_resulttext)).getText();
			System.out.println(finalsearchresult);

			String anchor_xapth_resulttext = xpath1 + i + anchXpath2;

			if (finalsearchresult.toLowerCase().contains("pillow")) {
				driver.findElement(By.xpath(anchor_xapth_resulttext)).click();
				break;
			}

		}

	}
}
