package d10_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Zadatak1 {
//    Napisati program koji:
//    Ucitava stranicu https://s.bootsnipp.com/iframe/Dq2X
//    Klikce na svaki iks da ugasi obavestenje i proverava da li se nakon klika element obrisao sa stranice i ispisuje
//    odgovarajuce poruke (OVO JE POTREBNO RESITI KORISCENJEM PETLJE)
//    POMOC: Brisite elemente odozdo.
//            (ZA VEZBANJE)Probajte da resite da se elemementi brisu i odozgo


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String url = "https://s.bootsnipp.com/iframe/Dq2X";
        driver.get(url);

        List<WebElement> nizIkseva = driver.findElements(By.className("close"));

        for (int i = 0; i < nizIkseva.size(); i++) {
            nizIkseva.get(i).click();
            Thread.sleep(1000);

            try {
                driver.findElement(By.className("close" + i));
                System.out.println("Element nije obrisan");
            } catch (Exception e) {
                System.out.println("Element je obrisan");
            }
        }

        driver.quit();
    }
}
