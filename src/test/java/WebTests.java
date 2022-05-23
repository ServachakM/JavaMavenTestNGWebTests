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
    public void testMenuStartTitle() {

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

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

    @Test
    public void testLastMenuName() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit new Language";
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement lastMenu = driver.findElement(By.xpath("//body/div[@id='wrap']" +
                "/div[@id='navigation']/ul[@id='menu']" +
                "/li/a[@href='/submitnewlanguage.html']"));//ul[@id='menu']/li[last()]

        Assert.assertEquals(lastMenu.getText(), expectedResult.toUpperCase());

        driver.quit();
    }

    @Test
    public void testSubmenuLastMenu() {
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
    public void isFirstSubmenuInMenuBrowseLanguages0_9() {
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
    public void testCheckCreatorsTheSite() {
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
    public void testSubmitLanguage() {

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
                By.xpath("//div[@id='main']/p"));

        String actualResult = error.getText();
        String actualResult2 = errorMessage.getText();
        String expectedResult = "Error: Precondition failed - Incomplete Input.";


        Assert.assertTrue(true, actualResult);
        Assert.assertEquals(actualResult2, expectedResult);

        driver.quit();
    }

    @Test
    public void testSubmitLanguageErrorText() {

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

        WebElement errorMessage = driver.findElement(
                By.xpath("//div[@id='main']/p"));

        String actualResult = errorMessage.getText();

        String expectedResult1 = "Error";
        String expectedResult2 = "Precondition";
        String expectedResult3 = "Incomplete";
        String expectedResult4 = "Input";
        String expectedResult5 = "failed";
        String expectedResult6 = ":";
        String expectedResult7 = "-";
        String expectedResult8 = ".";

        Assert.assertTrue(actualResult.contains(expectedResult1));
        Assert.assertTrue(actualResult.contains(expectedResult2));
        Assert.assertTrue(actualResult.contains(expectedResult3));
        Assert.assertTrue(actualResult.contains(expectedResult4));
        Assert.assertTrue(actualResult.contains(expectedResult5));
        Assert.assertTrue(actualResult.contains(expectedResult6));
        Assert.assertTrue(actualResult.contains(expectedResult7));
        Assert.assertTrue(actualResult.contains(expectedResult8));

        driver.quit();
    }

    @Test
    public void testSubmitLanguageFirstPointOfSubmenu() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        driver.get(url);

        WebElement firstPointSubmenu = driver.findElement(
                By.xpath("//div[@id='main']/ul/li[1]"));

        String actualResult = firstPointSubmenu.getText();
        String expectedResult = "IMPORTANT: Take your time! The more carefully " +
                "you fill out this form " +
                "(especially the language name and description), " +
                "the easier it will be for us and the faster your language " +
                "will show up on this page. We don't have the time to mess " +
                "around with fixing your descriptions etc. " +
                "Thanks for your understanding.";

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testIsNameColumnInBrowseLanguagesEqual() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath("//ul[@id='menu']//a[@href='/abc.html']"));

        menuBrowseLanguages.click();

        WebElement column1 = driver.findElement(
                By.xpath("//table[@id='category']//tr/th[@style='width: 40%;']"));
        WebElement column2 = driver.findElement(
                By.xpath("//table[@id='category']//tr/th[@style='width: 30%;']"));

        String actualResult1 = column1.getText();
        String actualResult2 = column2.getText();

        String expectedResult1 = "Language";
        String expectedResult2 = "Author";

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

        driver.quit();
    }

    @Test
    public void testTopListsNewComments() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement menuTopLists = driver.findElement(
                By.xpath("//ul[@id='menu']//a[@href='/toplist.html']"));
        menuTopLists.click();

        WebElement submenuNewComments = driver.findElement(
                By.xpath("//ul[@id='submenu']//a[@href='./newcomments.html']"));
        submenuNewComments.click();

        String actualResult = driver.findElement(
                By.xpath("//div[@id='main']/p")).getText();


        Assert.assertSame(actualResult, "");

        driver.quit();
    }

    @Test
    public void testIsWordInMenuSubmitNewLanguageMeetsTheRequirements() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "D:\\IntelliJ IDEA Community Edition 2021.3.2" +
                "\\chromedriver_win32\\chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        System.setProperty(chromeDriver, driverPath);

        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement wordImportant = driver.findElement(
                By.xpath("//div[@id='main']//li[1]/span/b"));
        WebElement wordImportantStyle = driver.findElement(
                By.xpath("//div[@id='main']//li[1]/span"));

        String expectedResult1 = "rgba(255, 255, 255, 1)";
        String expectedResult2 = "700"; //bold
        //Полужирное начертание. То же, что и 700
        String expectedResult3 = "rgba(255, 0, 0, 1)";
        String expectedResult4 = "IMPORTANT:";

        String actualResult1 = wordImportantStyle.getCssValue("color");
        String actualResult2 = wordImportant.getCssValue("font-weight");
        String actualResult3 = wordImportantStyle.getCssValue("background-color");
        String actualResult4 = wordImportant.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);
        Assert.assertEquals(actualResult4, expectedResult4.toUpperCase());

        driver.quit();
    }
}