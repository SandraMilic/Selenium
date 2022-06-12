package d09_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
//    Napisati program koji vrsi dodavanje 5 reda u tabelu.
//    Maksimizirati prozor
//    Ucitati stranicu https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php
//    Dodati 5 redova sa istim podacima.Jedan red u jednoj iteraciji
//    Klik na dugme Add New
//    Unesite name,departmant i phone (uvek iste vrednost)
//    Trazenje po name atributu
//    Kliknite na zeleno Add dugme.
//            PAZNJA: Pogledajte strukturu stranice i videcete da se u svakom redu poslednje kolone javljaju dugmici edit,
//    add, delete ali zbog prirode reda neki dugmici se vide a neki ne.
//    Morate da dohvatite uvek Add dugme iz poslednjeg reda tabele. Mozete koristeci index iz petlje, a mozete koristeci i
//    last() fukncionalnost za xpath. Koristan link last mehnizma
//    Cekanje od 0.5s
//    Na kraju programa ugasite pretrazivac.


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        String url = "https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php";
        String name = "Sandra";
        String department = "IT";
        String phone = "0642254355";

        driver.get(url);

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//button[contains(@class, 'btn btn-info add-new')]")).click();
            driver.findElement(By.name("name")).sendKeys(name);
            driver.findElement(By.name("department")).sendKeys(department);
            driver.findElement(By.name("phone")).sendKeys(phone);
            driver.findElement(By.xpath("//a[@style = 'display: inline;']")).click();
            Thread.sleep(500);
        }
        driver.quit();
    }
}
