package d09_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Zadatak1 {
//    Maksimizirati prozor
//    Ucitati stranicu https://s.bootsnipp.com/iframe/WaXlr
//    Dohvatite dugmice za rejting kao listu. XPath za trazenje treba da bude preko id atributa i za ovo trebace vam
//    contains u xpath-u
//    Od korisnika ucitati broj (preko scannera) na koju zvezdicu je potrebno kliknuti (u rasponu od 1 do 5)
//    I izvrsite akciju klik na odgovarajuci element preko indeksa
//    Na kraju programa ugasite pretrazivac.


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Scanner s = new Scanner(System.in);

        driver.manage().window().maximize();
        String url = "https://s.bootsnipp.com/iframe/WaXlr";
        driver.get(url);

        List<WebElement> nizZvezdica =
                driver.findElements(By.xpath("//button[contains(@id, 'rating-star')]"));

        System.out.println("Unesite broj zvezdice (u rasponu od 1 do 5): ");
        int n = s.nextInt();

        for (int i = 0; i < nizZvezdica.size(); i++) {
            nizZvezdica.get(n-1).click();
        }
        Thread.sleep(2000);

        driver.quit();
    }
}
