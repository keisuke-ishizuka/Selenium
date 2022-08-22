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

class E02Test {

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
		driver.get("https://rakuplus.jp/");
		//処理を停止(動作確認の為)
		Thread.sleep(2000);
		
		//ログインメールアドレスの入力
		driver.findElement(By.name("log")).sendKeys("");
		//ログインパスワードの入力
		driver.findElement(By.name("pwd")).sendKeys("");
		//ログインボタンの押下
		driver.findElement(By.name("wp-submit")).click();
		//処理を停止(動作確認の為)
		Thread.sleep(2000);
		
		//「社員紹介」押下
		driver.findElement(By.id("menu-item-6532")).click();
		//処理を停止(動作確認の為)
		Thread.sleep(2000);
		
		//QAエンジニアの紹介ページに遷移
		driver.findElement(By.cssSelector("#main > div.cardtype.cf > article:nth-child(1)")).click();
		//処理を停止(動作確認の為)
		Thread.sleep(2000);
		
		//取得したいクラス内のdivタブを指定してリストに格納する
		List<WebElement> webElementList
			= driver.findElements(By.cssSelector("section.entry-content > div"));
		//同期全員の、「名前(漢字)、名前( ひらがな)、 写真のURL(絶対パス)」を取得（繰り返し？）
		int count = 0;
		for(WebElement div : webElementList) {
			if(count > 0) {
				//名前の取得
				WebElement nameElem = div.findElement(By.cssSelector(".big"));
				//なまえの取得
				WebElement kanaElem = div.findElement(By.cssSelector(".has-text-align-center.has-text-color"));
				//写真のURLの取得
				WebElement imgElem = div.findElement(By.tagName("img"));
				//それぞれの出力
				System.out.println(nameElem.getText());
				System.out.println(kanaElem.getText());
				System.out.println(imgElem.getAttribute("outerHTML"));
			}
			count++;
		}
	}

}
