import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTests {

    // Тест кейс
    // 1. Открыть страницу http://www.99-bottles-of-beer.net/
    // 2. Нажать пункт меню Browse Languages
    // 3. Нажать пункт меню Start
    // 4. Подтвердить, что пользователь видит загодовок Welcome to 99 Bottles of Beer
    // 5. Закрыть браузер.

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id ='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/abc.html']")
        );

        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/']")
        );

        menuStart.click();

        WebElement h2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h2"));
        String actualResult = h2.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();

    }

    @Test
    public void testLastMenuName(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "SUBMIT NEW LANGUAGE";
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastMenu = driver.findElement(By.xpath("//body/div[@id='wrap']" +
                "/div[@id='navigation']/ul[@id='menu']" +
                "/li/a[@href='/submitnewlanguage.html']"));

        Assert.assertEquals(lastMenu.getText(),expectedResult);

        driver.quit();
    }

    @Test
    public void testSubmenuLastMenu(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastMenu = driver.findElement(By.xpath("//body/div[@id='wrap']" +
                "/div[@id='navigation']/ul[@id='menu']" +
                "/li/a[@href='/submitnewlanguage.html']"));
        lastMenu.click();

        WebElement subLastmenu = driver.findElement(By.xpath("//body/" +
                "div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']" +
                "/li/a[@href='./submitnewlanguage.html']"));

        String actualResult = subLastmenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void isFirstSubmenuInMenuBrowseLanguages0_9(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/abc.html";
        String expectedResult = "0-9";
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submenu = driver.findElement(By.xpath("//body/div[@id='wrap']" +
                "/div[@id='navigation']/ul[@id='submenu']" +
                "/li/a[@href='0.html']"));

        String actualResult = submenu.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testCheckCreatorsTheSite(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";

        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='menu']/li/a[@href='/']")
        );

        menuStart.click();

        WebElement subMenu = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                        "/ul[@id='submenu']/li/a[@href='team.html']"));

        subMenu.click();

        WebElement creator1 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]"));

        WebElement creator2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));

        WebElement creator3 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));


        String actualResult1 = creator1.getText();
        String actualResult2 = creator2.getText();
        String actualResult3 = creator3.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }

    @Test
    public void testIsTitleInTopListTopRated() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuTopLists = driver.findElement(By.xpath("//ul[@id='menu']" +
                "/li/a[@href='/toplist.html']"));
        menuTopLists.click();

        WebElement title = driver.findElement(By.xpath("//div[@id='main']/h2"));

        String expectedResult = "Top Rated";
        String actualResult = title.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    @Test
    public void testSubmitLanguage(){

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        driver.get(url);

        WebElement buttonSubmit = driver.findElement(
                By.xpath("//form[@id='addlanguage']//input[@type='submit']"));

        buttonSubmit.click();

        WebElement error = driver.findElement(
                By.xpath("//div[@id='main']//b/u[contains(text(), 'Error')]"));

        WebElement errorMessage = driver.findElement(
                By.xpath("//div[@id='main']//p[@style]"));

        String actualResult = error.getText();
        String actualResult2 = errorMessage.getText();
        String expectedResult = "Error: Precondition failed - Incomplete Input.";


        Assert.assertTrue(true, actualResult);
        Assert.assertEquals(actualResult2, expectedResult);

        driver.quit();
    }
}
