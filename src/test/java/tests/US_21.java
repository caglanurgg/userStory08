package tests.cagla;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_21 extends TestBaseRapor {
    //* admin ve kullanıcı farkından dolayı adminDashboard olarak değiştirdim
    private UserDashboard userDashboard = new UserDashboard();
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

        userDashboard.signInButton.click();
        extentTest.info("Sign In butonuna tıklanılır.");

        userDashboard.emailtextBox.sendKeys(ConfigReader.getProperty("scAdminEmail"));
        extentTest.info("login  pagede email textbox'ına Admin email girilir.");

        userDashboard.passwordTextBox.sendKeys(ConfigReader.getProperty("scAdminPassword"));
        extentTest.info("login  pagede password textbox'ına Admin password girilir");

        userDashboard.loginButonu.click();
        extentTest.info("log in butonuna basılır.");
    }



    @Test //US21_T02 -->Admin olarak  kullanıcıların oluşturduğu kartları görüntüleyin.
    public void testAdminViewUserCards() {

        userDashboard.vCardButton.click();
        extentTest.info("VCard butonuna basılır.");

        // 2.7. Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.
        String userCardName = "Kullanıcıya Ait VCard İsmi"; // İsim buraya eklenir
        userDashboard.searchBox.sendKeys(userCardName);
        extentTest.info("Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.");

        //2.8 VCARD NAME başlığı altında arama yapılan ismin mevcut olduğu doğrulanır.
        // Burada sayfada kullanıcının kartlarını görüntülemek ve doğrulamak için gerekli adımları ekleyebilirsiniz.
        // Örnek: Kartları görüntüleme ve doğrulama işlemleri
        // Örnek: Kartların görüntülendiği bir liste veya tablo kontrol edilir
        WebElement cardList = userDashboard.cardList; // Bu, kartları içeren liste veya tablo elementini temsil eder

        // Kartların görüntülendiği bir liste veya tablo kontrol edilir
        boolean areCardsDisplayed = cardList.isDisplayed(); // Kartlar görüntüleniyorsa true döner
        extentTest.info("Kartlar görüntülendi mi? " + areCardsDisplayed);

        // SoftAssert ile kartları doğrulama işlemleri
        SoftAssert softAssert = new SoftAssert();

        // Kartların başlık ve açıklama içerdiğini kontrol etme örneği
        WebElement cardTitle = userDashboard.cardList.findElement(By.className("card-title"));
        WebElement cardDescription = userDashboard.cardList.findElement(By.className("card-description"));

        softAssert.assertTrue(areCardsDisplayed, "Kartlar görüntülenmiyor.");
        softAssert.assertTrue(/* İlgili kartları doğrulama koşulları buraya eklenir */);

        // Tüm işlemleri doğrulamak için assertAll kullanılır
        softAssert.assertAll();

    }


    @Test //US21_T03-->Admin olarak  kullanıcıların oluşturduğu kartların sayfalarına ulaşın.
    public void testAdminViewUserCardPages() {
        // 3.6. Açılan sayfada dashboard yazısı doğrulanır.
        boolean isDashboardVisible = userDashboard.isDashboardVisible(); // Dashboard yazısını kontrol eden bir metod kullanılabilir
        softAssert.assertTrue(isDashboardVisible, "Açılan sayfadaki dashboard yazısı doğrulandı.");

        // 3.7. VCard butonuna basılır.
        userDashboard.vCardButton.click();
        extentTest.info("VCard butonuna basılır.");

        // 3.8. Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.
        String userCardName = "Kullanıcıya Ait VCard İsmi"; // İsim buraya eklenir
        userDashboard.searchBox.sendKeys(userCardName);
        extentTest.info("Search Box'a daha önceden var olan bir kullanıcıya ait VCard ismi girilir.");

        // 3.9 PREVIEW URL başlığı altındaki link tıklanır.
        userDashboard.previewURLLink.click();
        extentTest.info("PREVIEW URL başlığı altındaki link tıklanır.");

        // 3.10. Açılan sayfadaki ilgili VCard'ın ismi doğrulanır.
        boolean isCardNameVisible = userDashboard.isCardNameVisible(); // VCard ismini kontrol eden bir metod kullanılabilir
        softAssert.assertTrue(isCardNameVisible, "Açılan sayfadaki VCard ismi doğrulandı.");

        // Tüm işlemleri doğrulamak için assertAll kullanılır
        softAssert.assertAll();

    }

    @Test //  US21_T04--> Admin olarak  kullanıcıların oluşturduğu kartların istatistiklerini görüntüleyin
    public void testAdminViewUserCardStatistics() {
        // 4.9 STATS başlığı altındaki ilgili vcards istatistik iconu tıklanır.
        userDashboard.statsIcon.click();
        extentTest.info("STATS başlığı altındaki ilgili vcards istatistik iconu tıklanır.");

        // 4.10. Açılan sayfada Vcard Analytic başlığı doğrulanır.
        boolean isAnalyticTitleVisible = userDashboard.isAnalyticTitleVisible(); // Vcard Analytic başlığını kontrol eden bir metod kullanılabilir
        softAssert.assertTrue(isAnalyticTitleVisible, "Açılan sayfadaki Vcard Analytic başlığı doğrulandı.");

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


    @AfterMethod
    public void tearDown() {
        // Bu metod, her test metodu çalıştırıldıktan sonra çalışır.
        // Tarayıcıyı kapatma veya oturumu sonlandırma gibi temizleme işlemleri burada yapılabilir.
    }

}
