package test01;

import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class ChannelView {
	static ChromeDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		assertSections();
		assertTitleInArticle();
		driver.quit();

	}

	private static void assertSections() {
		driver.get("https://www.hk01.com/section/%E6%B8%AF%E8%81%9E");
		String[] button = { "港聞", "全部", "兩岸", "經濟", "環保", "罪案", "政情" };
		for (int i = 0; i < button.length; i++) {
			driver.findElementByLinkText(button[i]).click();
			Assert.assertEquals(button[i], driver.findElementByClassName("current").getText());

		}

	}

	private static void assertTitleInArticle() {
		driver.get(
				"https://www.hk01.com/%E6%B8%AF%E8%81%9E/79555/-%E4%B8%80%E5%A5%91%E5%A4%9A%E4%BC%99-%E9%81%BF%E7%A8%85%E6%88%90%E9%A2%A8%E6%94%BF%E5%BA%9C%E4%B8%8D%E4%BF%AE%E4%BE%8B-%E5%AD%B8%E8%80%85-%E7%8F%BE%E9%9A%8E%E6%AE%B5%E7%84%A1%E8%A8%88%E5%8F%AF%E6%96%BD");
		String actualtext = driver.findElementByClassName("article_tit").getText();
		Assert.assertEquals("「一契多伙」避稅成風政府不修例　學者：現階段無計可施", actualtext);
	}

}
