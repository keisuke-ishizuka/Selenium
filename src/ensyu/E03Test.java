package ensyu;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class E03Test {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws Exception{
	//Chrome制御のためChromeDriverのパスを指定
	System.setProperty("webdriver.chrome.driver", "./exe/chromedriver");
	
	//ChromeDriverの作成
	WebDriver driver = new ChromeDriver();
	
	//get()でブラウザ起動
	driver.get("https://www.e-procurement.metro.tokyo.lg.jp/index.jsp");
	
	//処理を停止(動作確認の為)
	Thread.sleep(2000);
	
	//お知らせのOKボタンの押下
	driver.findElement(By.cssSelector("body > div.noticeofurlchange > div > button")).click();
	
	//現在のタブのハンドルを取得
	String oldTab = driver.getWindowHandle();
	
	//「入札情報サービス」の画像をクリック
	driver.findElement(By.cssSelector("#category_menu > ul > li.cat_menu_1 > a:nth-child(1) > img")).click();

	//ハンドルの切り替え
	String newTab = null;
	for(String handle : driver.getWindowHandles()) {
		if(!handle.equals(oldTab)) {
			newTab = handle;
		}
	}
	driver.switchTo().window(newTab);

	//「発注予定情報」をクリック
	driver.findElement(By.cssSelector("#topMenuBtn03 > a")).click();
	
	//開始日の入力
	driver.findElement(By.name("StartDateYY")).sendKeys("4");
	driver.findElement(By.name("StartDateMM")).sendKeys("08");
	driver.findElement(By.name("StartDateDD")).sendKeys("19");
	
	//終了日の入力
	driver.findElement(By.name("EndDateYY")).sendKeys("4");
	driver.findElement(By.name("EndDateMM")).sendKeys("09");
	driver.findElement(By.name("EndDateDD")).sendKeys("19");
	
	//「検索」をクリック
	driver.findElement(By.cssSelector("body > div.contents > div > form > table:nth-child(5) > tbody > tr:nth-child(3) > td > table:nth-child(2) > tbody > tr > td > a")).click();
	
	//取得したい情報を指定してリストに格納する
	List<WebElement> elemList
		= driver.findElements(By.cssSelector("body > div.contents > div > form > table.list-data > tbody > tr"));
	
	int count = 0;
	for(WebElement tbody : elemList) {
		if(count > 0) {
			List<WebElement> tdList
				= tbody.findElements(By.tagName("td"));
			System.out.println(tdList.get(0).getText()
								+ tdList.get(1).getText()
								+ tdList.get(2).getText()
								+ tdList.get(2).findElement(By.tagName("a")).getAttribute("href"));
		}
		count++;
	}
	}
}
