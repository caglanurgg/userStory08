package tests.cagla;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class US_21 extends TestBaseRapor {

    private AdminDashboard adminDashboard = new AdminDashboard();

    private SoftAssert softAssert = new SoftAssert();

    // Kullanıcı girişi yapmadan önce bu metot çalışır
    @BeforeMethod
    public void login() {
        // Burada kullanıcı girişi işlemleri yapılır
        // Örnek: Kullanıcı adı ve şifre ile giriş yapmak için kodlar burada olabilir

        extentTest = extentReports.createTest("Admin Kart İşlevselliği Doğrulama",
                "Admin kullanıcısı olarak sisteme giriş yaparak kart işlevselliğini doğrulama.");

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLinkUrl"));
        extentTest.info("Admin SmartCardLink sayfasina gider");

        adminDashboard.signInButton.click();
        extentTest.info("Sign In butonuna tıklanılır.");

        adminDashboard.emailtextBox.sendKeys(ConfigReader.getProperty("scAdminEmail"));
        extentTest.info("login  pagede email textbox'ına Admin email girilir.");

        adminDashboard.passwordTextBox.sendKeys(ConfigReader.getProperty("scAdminPassword"));
        extentTest.info("login  pagede password textbox'ına Admin password girilir");

        adminDashboard.loginButonu.click();
        extentTest.info("log in butonuna basılır.");
    }



    @Test //US21_T02 -->Admin olarak  kullanıcıların oluşturduğu kartları görüntüleyin.
    public void testAdminViewUserCards() {

        adminDashboard.vCardButton.click();
        extentTest.info("VCard butonuna basılır.");

        // 2.7. Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.
        String userCardName = "cagla"; // İsim buraya eklenir
        adminDashboard.searchBox.sendKeys(userCardName);
        extentTest.info("Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.");

        //2.8 VCARD NAME başlığı altında arama yapılan ismin mevcut olduğu doğrulanır.
        // Burada sayfada kullanıcının kartlarını görüntülemek ve doğrulamak için gerekli adımları ekleyebilirsiniz.
        // Örnek: Kartları görüntüleme ve doğrulama işlemleri
        // Örnek: Kartların görüntülendiği bir liste veya tablo kontrol edilir

        SoftAssert softAssert = new SoftAssert(); // SoftAssert ile kartları doğrulama işlemleri
        // Kartların görüntülendiği bir liste veya tablo kontrol edilr
        for (WebElement each : adminDashboard.cardList
        ) {
            System.out.println(each.getText());
            softAssert.assertTrue(each.isDisplayed());
        }
        softAssert.assertAll();  // Tüm işlemleri doğrulamak için assertAll kullanılır
    }


    @Test //US21_T03-->Admin olarak  kullanıcıların oluşturduğu kartların sayfalarına ulaşın.
    public void testAdminViewUserCardPages() {
        adminDashboard.vCardButton.click();
        extentTest.info("VCard butonuna basılır.");

        // 2.7. Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.
        String userCardName = "cagla"; // İsim buraya eklenir
        adminDashboard.searchBox.sendKeys(userCardName);
        extentTest.info("Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.");

        String ilkSayfaWindowHandleDegeri=Driver.getDriver().getWindowHandle(); // click'ten once yapılır.
        // 3.6 PREVIEW URL başlığı altındaki link tıklanır.
        adminDashboard.previewURLLink.click();
        extentTest.info("PREVIEW URL başlığı altındaki link tıklanır.");

        //3.7 yeni sekmeye geçti
        ReusableMethods.switchToWindow("    VCards | Smart Card Link");
        extentTest.info("Yeni window'da acilan sayfaya gecer");

        Set<String> windowHandleDegerleriSet=Driver.getDriver().getWindowHandles();

        /*
        String ikinciSayfaWindowHandleDegeri="";

        for (String eachWHD: windowHandleDegerleriSet
        ) {
            if (!eachWHD.equals(ilkSayfaWindowHandleDegeri)) {
                ikinciSayfaWindowHandleDegeri=eachWHD;
            }
        }
        // Artik ikinci sayfaninda windowHandleDeger'ine sahibiz
        Driver.getDriver().switchTo().window(ikinciSayfaWindowHandleDegeri); // driver'da artik ikinci window'da
        96-97.satir calismazsa kullanirsin.
         */

        //3.8.  Açılan sayfadaki ilgili VCard'ın resmi doğrulanır.
        assertTrue(adminDashboard.cagla3Image.isDisplayed());

    }

    @Test //  US21_T04--> Admin olarak  kullanıcıların oluşturduğu kartların istatistiklerini görüntüleyin
    public void testAdminViewUserCardStatistics() {
        adminDashboard.vCardButton.click();
        extentTest.info("VCard butonuna basılır.");

        // 4.7. Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.
        String userCardName = "cagla"; // İsim buraya eklenir
        adminDashboard.searchBox.sendKeys(userCardName);
        extentTest.info("Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.");

        // 4.9 STATS başlığı altındaki ilgili vcards istatistik iconu tıklanır.
        adminDashboard.statsIcon.click();
        extentTest.info("STATS başlığı altındaki ilgili vcards istatistik iconu tıklanır.");

        // 4.10. Açılan sayfada Vcard Analytic grafigi dogrulanır.
        boolean isAnalyticTitleVisible = adminDashboard.isAnalyticTitleVisible.isDisplayed(); // Vcard Analytic başlığını kontrol eden bir metod kullanılabilir
        softAssert.assertTrue(isAnalyticTitleVisible, "Açılan sayfadaki Vcard Analytic grafigi doğrulandı.");

        // Tüm işlemleri doğrulamak için assertAll kullanılır
        softAssert.assertAll();
    /*
    1.5'e kadar aynı adımlar
            4.6.açılan sayfada dashboard yazısı doğrulanır.
    4.7. vcard butonuna basılır.
4.8. Search Box' a daha önceden var olan bir kullanıcıya ait vcard ismi girilir.
            4.9 STATS başlığı altındaki ilgili vcards istatistik iconu tıklanır.
            4.10 açılan sayfada  Vcard Analytic başlığı doğrulanır.
     */


    }



       /*
       US21_T01 --> Admin olarak sisteme giriş yapın.
    1.1 ilgili url'e gidilir.
    1.2.log in butonuna tıklanılır.
    1.3.login  pagede email textbox'ına geçerli email girilir.
    1.4.login  pagede password textbox'ına geçerli password girilir
    1.5. log in butonuna basılır.
    1.6.açılan sayfada dashboard yazısı doğrulanır.

    US21_T02 -->Admin olarak  kullanıcıların oluşturduğu kartları görüntüleyin.
    2.1 ilgili url'e gidilir.
    2.2.log in butonuna tıklanılır.
    2.3.login  pagede email textbox'ına geçerli email girilir.
    2.4.login  pagede password textbox'ına geçerli password girilir
    2.5. log in butonuna basılır.
    2.6. vcard butonuna basılır.
    2.7. Search Box' a daha önceden var olan bir kullanıcıya ait vcard ismi girilir.
    2.8 VCARD NAME başlığı altında arama yapılan ismin mevcut olduğu doğrulanır.




US21_T03-->Admin olarak  kullanıcıların oluşturduğu kartların sayfalarına ulaşın.
    1.5'e kadar aynı adımlar
    3.6.açılan sayfada dashboard yazısı doğrulanır.
    3.7. Vcard butonuna basılır.
    3.8. Search Box' a daha önceden var olan bir kullanıcıya ait vcard ismi girilir.
    3.9 PREVIEW URL başlığı altındaki link tıklanır.
    3.10 Açılan sayfadaki ilgili vcard'ın ismi doğrulanır.


   US21_T04--> Admin olarak  kullanıcıların oluşturduğu kartların istatistiklerini görüntüleyin
    1.5'e kadar aynı adımlar
    4.6.açılan sayfada dashboard yazısı doğrulanır.
    4.7. vcard butonuna basılır.
4.8. Search Box' a daha önceden var olan bir kullanıcıya ait vcard ismi girilir.
4.9 STATS başlığı altındaki ilgili vcards istatistik iconu tıklanır.
4.10 açılan sayfada  Vcard Analytic başlığı doğrulanır.


     */

    @AfterMethod   // Her test sonrası oturumu kapatma
    public void teardown(){ // Oturumu kapatma işlemleri burada yapılır
        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");
    }

    // Bu metod, her test metodu çalıştırıldıktan sonra çalışır.
    // Tarayıcıyı kapatma veya oturumu sonlandırma gibi temizleme işlemleri burada yapılabilir.
}


