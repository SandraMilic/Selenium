package d09_06_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadatak3_ZaVezbanje {
//    Napisati program koji matematicku formulu koju korisnik unese izvrsaav na stranici:
//    Ucitati stranicu https://www.calculatorsoup.com/calculators/math/basic.php
//    Korisnik unosi formulu, samo osnovne matematicke operacija, npr:
//            1243+329=
//            21912-4=
//            12913÷4=
//    U programu se formula unosi kao jedan string i potrebno je razbiti formulu na karaktere.
//    Za to imate metodu https://www.geeksforgeeks.org/convert-a-string-to-a-list-of-characters-in-java/
//    Zatim u odnosu na karakter uradite odredjenu logiku


    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Scanner s = new Scanner(System.in);

        String url = "https://www.calculatorsoup.com/calculators/math/basic.php";
        driver.get(url);

        String formula = "";

        for (int i = 0; i < 3; i++) {
            System.out.println("Unesite formulu:");
            formula = s.next();
            List<Character> nizKaraktera = convertStringToCharList(formula);

            for (int j = 0; j < nizKaraktera.size(); j++) {
                driver.findElement(By.xpath("//input[contains(@id, 'display')]"))
                        .sendKeys(nizKaraktera.get(j).toString());
                Thread.sleep(500);
            }
            driver.findElement(By.xpath("//input[contains(@value, 'CE')]")).click();
        }
        driver.quit();
    }

    public static List <Character> convertStringToCharList(String string) {
        List <Character> chars = new ArrayList<>();

        for (char ch : string.toCharArray()) {
            chars.add(ch);
        }
        return chars;
    }
}
