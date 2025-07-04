import org.ds.constant.TypeOfJourney;
import org.ds.pageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class DemoTest {
    WebDriver driver;

    @Test
    public void flightTest() throws InterruptedException {

        String URL =  "https://rahulshettyacademy.com/dropdownsPractise/";

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        TravelHomePage homePage = new TravelHomePage(driver);
        homePage.goTo();
        System.out.println(homePage.getFooterNav().getText());
        System.out.println("links count : "+ homePage.getFooterNav().getLinksCount());
        Thread.sleep(1000);

        System.out.println(homePage.getNavigationBar().getText());
        System.out.println("links count : "+ homePage.getNavigationBar().getLinksCount());
        Thread.sleep(5000);

        homePage.setJourneyType(TypeOfJourney.OneWay).checkAvailability("DEL", "BLR");
        homePage.setJourneyType(TypeOfJourney.RoundTrip).checkAvailability("DEL", "BLR");
        homePage.setJourneyType(TypeOfJourney.MultiTrip).checkAvailability("DEL", "BLR");

    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }


}
