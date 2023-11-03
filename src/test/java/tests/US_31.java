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

public class US_31 extends TestBaseRapor {
    //* admin ve kullanıcı farkından dolayı adminDashboard olarak değiştirdim

    private UserDashboard userDashboard = new UserDashboard();
    private SoftAssert softAssert = new SoftAssert();

    // Kullanıcı girişi yapmadan önce bu metot çalışır
    @BeforeMethod
    public void login() {
        // Burada kullanıcı girişi işlemleri yapılır
        // Örnek: Kullanıcı adı ve şifre ile giriş yapmak için kodlar burada olabilir

        extentTest = extentReports.createTest("Admin Girişiyle Dil Sayısını Görüntüleme Doğrulaması",
                "Admin kullanıcısı olarak sisteme giriş yaparak kullanılan dil sayısını görüntüleyip doğrulama.");

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

        // 1.6 - Açılan sayfada dashboard yazısı doğrulanır.
        WebElement dashboardText = userDashboard.dashboardText;
        softAssert.assertTrue(dashboardText.isDisplayed(), "Dashboard yazısı görüntüleniyor mu?");
        softAssert.assertEquals(dashboardText.getText(), "dashboard", "Dashboard yazısı doğrulandı.");
    }

    @Test // US31_T02 -->Admin olarak  Languages sayfasında en altta bulunan "Showing (x) results" yazısındaki x sayısının göründüğü doğrulanır
    public void testAdminViewLanguageCount() {
        // 2.6 - Languages butonuna tıklanır.
        userDashboard.languagesButton.click();
        extentTest.info("Languages butonuna basılır.");

        // 2.7 - Languages sayfasında en altta bulunan "Showing (x) results" yazısındaki x sayısının görüntülendiği doğrulanır.
        WebElement resultsText = userDashboard.resultsText;
        String results = resultsText.getText();
        int languageCount = Integer.parseInt(results.replaceAll("[^0-9]", ""));
        softAssert.assertTrue(languageCount > 0, "Dil sayısı görüntüleniyor mu?");
    }

    @AfterMethod
    public void tearDown() {
        // Bu metod, her test metodu çalıştırıldıktan sonra çalışır.
        // Tarayıcıyı kapatma veya oturumu sonlandırma gibi temizleme işlemleri burada yapılabilir.
    }

/*
    US31_T01 --> Admin olarak sisteme giriş yapın.
    1.1 ilgili url'e gidilir.
            1.2.log in butonuna tıklanılır.
            1.3.login  pagede email textbox'ına geçerli email girilir.
            1.4.login  pagede password textbox'ına geçerli password girilir
            1.5. log in butonuna basılır.
            1.6.açılan sayfada dashboard yazısı doğrulanır.

            US31_T02 -->Admin olarak  Languages sayfasında en altta bulunan "Showing (x) results" yazısındaki x sayısının göründüğü doğrulanır
             2.1 ilgili url'e gidilir.
            2.2.log in butonuna tıklanılır.
            2.3.login  pagede email textbox'ına geçerli email girilir.
            2.4.login  pagede password textbox'ına geçerli password girilir
            2.5. log in butonuna basılır.
            2.6 Languages  butonuna basılır.
    2.7. Languages sayfasında en altta bulunan "Showing (x) results" yazısındaki x sayısının görüntülendiği doğrulanır.

 */

}
