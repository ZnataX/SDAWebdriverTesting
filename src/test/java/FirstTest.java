import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {
    static WebDriver driver;
    String headTitle = "Odważ się. Dokonaj zmiany.";

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\liber\\Desktop\\cd\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @AfterAll
    public static void tearUp(){
        driver.quit();
    }


    @Test
    public void sdaWebPageTesting(){

        driver.get("https://sdacademy.pl");

        System.out.println(driver.findElement(By.className("heading-1")).getText());
        String headerTitle = "Odważ się. Dokonaj zmiany.";
        Assertions.assertEquals(headerTitle ,driver.findElement(By.className("heading-1")).getText());


    }
    /*
    1. wejsc na strone google
    2. wyszukac wpisujac fraze " software development academy"
    4.spr tytuł strony czy jest poprawny
     */
    @Test
    public void sdaFromGoogleTest(){
        driver.get("https://www.google.pl");
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("software development academy");
        driver.findElement(By.name("btnK")).submit();
        driver.findElement(By.xpath("//*[@id=\"tads\"]/div[1]/div/div/div[1]/a")).click();
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Wydarzenia - SDA Polska",driver.getTitle());


    }
    /*
    1.wejdz na strone logowanie do poczty poczta.wp.pl
    2. w polu username wpisz login sdatesting
    3. w polu haslo SDAtesting123
    4. kliknij przycisk login
    5. upewnij się ze uzytkownik się zalogował

     */
    @Test
    public void pocztaWp(){
        driver.get("https://poczta.wp.pl");
        driver.findElement(By.id("login")).sendKeys("sdatesting");
        driver.findElement(By.id("password")).sendKeys("SDAtesting123!");
        driver.findElement(By.xpath("//*[@id=\"stgMain\"]/div/div/div[1]/form/button")).click();
        Assertions.assertEquals("Odebrane",driver.findElement(By.xpath("//*[@id=\"folder-1\"]/div[2]")).getText());

    }

    @Test
    public void openSource(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("wrongUser");
        driver.findElement(By.id("txtPassword")).sendKeys("wrongPassword");
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
        Assertions.assertEquals("Invalid credentials",driver.findElement(By.xpath("//*[@id=\"spanMessage\"]")).getText());


    }
}
