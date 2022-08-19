package ensyu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class E01Test {

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
		driver.get("https://www.google.com/");
		//処理を停止(動作確認の為)
		Thread.sleep(3000);
		//ブラウザの要素を指定（なぜ？）
		WebElement element = driver.findElement(By.name("q"));
		//検索テキストボックスに"ChromeDriver"を入力
		element.sendKeys("selenium");
		//Enterキーを押下して検索を実行
		element.submit();
		//処理を停止(動作確認の為)
		Thread.sleep(3000);
		//検索結果の1番上のリンクの文言を取得
		WebElement element2 = driver.findElement(By.cssSelector(".LC20lb"));	
		//ページのテキストを取得して表示
	    System.out.println(element2.getText());
		
	}

}
