package d10_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Zadatak2 {
//    Napisati program koji ucitava stranicu https://geodata.solutions/
//    Bira proizvoljan Country, State i City
//    Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//    I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//    Izabrerit Country, State i City tako da imate podatke da selektujete!


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Random r = new Random();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://geodata.solutions/";
        driver.get(url);

        Select country = new Select(driver.findElement(By.id("countryId")));
        List<WebElement> optionsCountry = country.getOptions();
        int randomCountryOptions = r.nextInt(optionsCountry.size());
        country.selectByIndex(randomCountryOptions);
        Thread.sleep(2000);
        System.out.println("Country: " + country.getFirstSelectedOption().getText());

        Select state = new Select (driver.findElement(By.id("stateId")));
        List<WebElement> optionsState = state.getOptions();
        int randomStateOptions = r.nextInt(optionsState.size());
        state.selectByIndex(randomStateOptions);
        Thread.sleep(2000);
        System.out.println("State: " + state.getFirstSelectedOption().getText());

        Select city = new Select (driver.findElement(By.id("cityId")));
        List<WebElement> optionsCity = city.getOptions();
        int randomCityOptions = r.nextInt(optionsCity.size());
        city.selectByIndex(randomCityOptions);
        Thread.sleep(3000);
        System.out.println("City: " + city.getFirstSelectedOption().getText());







        driver.quit();
    }
}
