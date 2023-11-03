package tests.cagla;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_33  extends TestBaseRapor {
    private AdminDashboard adminDashboard = new AdminDashboard();
    private SoftAssert softAssert = new SoftAssert();

    // Kullanıcı girişi yapmadan önce bu metot çalışır
    @BeforeMethod
    public void login() {
        // Burada kullanıcı girişi işlemleri yapılır
        // Örnek: Kullanıcı adı ve şifre ile giriş yapmak için kodlar burada olabilir

        extentTest = extentReports.createTest("Admin Girişi ve About Us Sayfası Görüntüleme",
                "Admin kullanıcısı olarak sisteme giriş yaparak 'About Us' sayfasının başlık ve alt metnini görüntüleme");

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

        // 1.6 - Açılan sayfada dashboard yazısı doğrulanır.
        WebElement dashboardText = adminDashboard.dashboardText;
        softAssert.assertTrue(dashboardText.isDisplayed(), "Dashboard yazısı görüntüleniyor mu?");
        softAssert.assertEquals(dashboardText.getText(), "dashboard", "Dashboard yazısı doğrulandı.");
    }

    @Test //US33_T02 -->Admin olarak Front CMS butonuna tıklayarak front CMS sayfasındaki zorunlu alanların başlıklarının (Banner Image,Title,Sub Text ) görünür olduğu doğrulanır.
    public void testFrontCMSPage() {
        //2.6  Front CMS  butonuna basılır.
        adminDashboard.FrontCMSButton.click();


        //2.7. Front CMS  sayfasında Banner Image,Title,Sub Text başlıklarının görüntülendiği doğrulanır.
        // Giriş yapıldıktan sonra, gerekli alanların görünür olduğunu doğrula
        softAssert.assertTrue(adminDashboard.frontCMSPage.isDisplayed(), "Front CMS görünür mü?");
        softAssert.assertTrue(adminDashboard.isBannerImageVisible.isDisplayed(), "Banner Image görünür mü?");
        softAssert.assertTrue(adminDashboard.isTitleVisible.isDisplayed(), "Title görünür mü?");
        softAssert.assertTrue(adminDashboard.isSubTextVisible.isDisplayed(), "Sub Text görünür mü?");

        /*
        title doldurulması zorunlu ama bir sey yazamıyorum
        sub text de ayni sekilde ve
        save butonu aktif degil abine sor.
         */
        // Doğrulamaları tamamla
        softAssert.assertAll();
    }

    @Test // US33_T03 --> Admin olarak Subscribers butonuna tıklayarak Subscribers sayfasındaki başlıkları (EMAIL, ACTION) görünür olduğu doğrulanır.
    public void testSubscribersPage() {
        //3.7. Subscribers butonuna basılır.
        adminDashboard.SubscribersButton.click();
        adminDashboard.languagesButton.click();
        //3.8. Subscribers sayfasında EMAIL,ACTION  başlıklarının görüntülendiği doğrulanır.
        // Giriş yapıldıktan sonra, gerekli başlıkların görünür olduğunu doğrula
        softAssert.assertTrue(adminDashboard.isEmailTitleVisible.isDisplayed(), "EMAIL başlığı görünür mü?");
        softAssert.assertTrue(adminDashboard.isActionTitleVisible.isDisplayed(), "ACTION başlığı görünür mü?");

        // Doğrulamaları tamamla
        softAssert.assertAll();
    }

    @Test // US33_T04 --> Admin olarak Features butonuna tıklayarak Features sayfasındaki başlıkları (NAME, IMAGE, DESCRIPTION, ACTION) görünür olduğu doğrulanır.
    public void testFeaturesPage() {
        //4.7. Features butonuna basılır.
        adminDashboard.FeaturesButton.click();

        //  4.8. Features sayfasında NAME,IMAGE,DESCRIPTION,ACTION  başlıklarının görüntülendiği doğrulanır.
        // Giriş yapıldıktan sonra, gerekli başlıkların görünür olduğunu doğrula
        softAssert.assertTrue(adminDashboard.isNameTitleVisible.isDisplayed(), "NAME başlığı görünür mü?");
        softAssert.assertTrue(adminDashboard.isImageTitleVisible.isDisplayed(), "IMAGE başlığı görünür mü?");
        softAssert.assertTrue(adminDashboard.isDescriptionTitleVisible.isDisplayed(), "DESCRIPTION başlığı görünür mü?");
        softAssert.assertTrue(adminDashboard.isActionTitleVisible.isDisplayed(), "ACTION başlığı görünür mü?");

        // Doğrulamaları tamamla
        softAssert.assertAll();
    }

    @Test // US33_T05 --> Admin olarak About Us butonuna tıklayarak About Us sayfasındaki başlıkları (About Image, Title, Description) görünür olduğu doğrulanır.
    public void testAboutUsPage() {
        //5.7. About Us butonuna basılır.
        adminDashboard.AboutUsButton.click();

        //5.8. About Us sayfasında About Image, Title, Description başlıklarının görüntülendiği doğrulanır.
        // Giriş yapıldıktan sonra, gerekli başlıkların görünür olduğunu doğrula
        softAssert.assertTrue(adminDashboard.isAboutImageTitleVisible.isDisplayed(), "About Image başlığı görünür mü?");
        softAssert.assertTrue(adminDashboard.isTitleTitleVisible.isDisplayed(), "Title başlığı görünür mü?");
        softAssert.assertTrue(adminDashboard.isDescriptionTitleVisible.isDisplayed(), "Description başlığı görünür mü?");

        // Doğrulamaları tamamla
        softAssert.assertAll();
    }

    /*
    kendime not
    Testimonials ve Enquiries kısmına bakmamışsın.abine sorarsın gerek var mı diye
     */
    @AfterMethod   // Her test sonrası oturumu kapatma
    public void teardown(){ // Oturumu kapatma işlemleri burada yapılır
        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");
    }
/*
    USER STORY: Admin bilgileri ile giriş yaptıktan sonra Başlık ve Alt Metni,
 özellikleri, about us sayfası metinlerini görüntüleyebildiğimi doğrulayabilmeliyim

 US33_T01 --> Admin olarak sisteme giriş yapın.
    1.1 ilgili url'e gidilir.
    1.2.log in butonuna tıklanılır.
    1.3.login  pagede email textbox'ına geçerli email girilir.
    1.4.login  pagede password textbox'ına geçerli password girilir
    1.5. log in butonuna basılır.
    1.6.açılan sayfada dashboard yazısı doğrulanır.

    US33_T02 -->Admin olarak Front CMS butonuna tıklayarak front CMS sayfasındaki zorunlu alanların başlıklarının (Banner Image,Title,Sub Text ) görünür olduğu doğrulanır.
    2.1 ilgili url'e gidilir.
    2.2.log in butonuna tıklanılır.
    2.3.login  pagede email textbox'ına geçerli email girilir.
    2.4.login  pagede password textbox'ına geçerli password girilir
    2.5. log in butonuna basılır.
    2.6  Front CMS  butonuna basılır.
    2.7.  Front CMS  sayfasında Banner Image,Title,Sub Text başlıklarının görüntülendiği doğrulanır.

US33_T03 --> Admin olarak Subscribers butonuna tıklayarak Subscribers sayfasındaki başlıkları (EMAIL, ACTION) görünür olduğu doğrulanır.
    3.1 ilgili url'e gidilir.
    3.2.log in butonuna tıklanılır.
    3.3.login  pagede email textbox'ına geçerli email girilir.
    3.4.login  pagede password textbox'ına geçerli password girilir
    3.5. log in butonuna basılır.
    3.6 Front CMS  butonuna basılır.
    3.7. Subscribers butonuna basılır.
    3.8. Subscribers sayfasında EMAIL,ACTION  başlıklarının görüntülendiği doğrulanır.



US33_T04 -->Admin olarak Features butonuna tıklayarak Features sayfasındaki başlıkları (NAME,IMAGE,
DESCRIPTION,ACTION) görünür olduğu doğrulanır.
    4.1 ilgili url'e gidilir.
    4.2.log in butonuna tıklanılır.
    4.3.login  pagede email textbox'ına geçerli email girilir.
    4.4.login  pagede password textbox'ına geçerli password girilir
    4.5. log in butonuna basılır.
    4.6 Front CMS  butonuna basılır.
    4.7. Features butonuna basılır.
    4.8. Features sayfasında NAME,IMAGE,DESCRIPTION,ACTION  başlıklarının görüntülendiği doğrulanır.


US33_T05 -->Admin olarak About Us butonuna tıklayarak About Us  sayfasındaki başlıkları (About Image,
            Title, Description) görünür olduğu doğrulanır.
5.1 ilgili url'e gidilir.
5.2.log in butonuna tıklanılır.
5.3.login  pagede email textbox'ına geçerli email girilir.
5.4.login  pagede password textbox'ına geçerli password girilir
5.5. log in butonuna basılır.
5.6 Front CMS  butonuna basılır.
5.7. About Us butonuna basılır.
5.8. About Us sayfasında About Image, Title, Description başlıklarının görüntülendiği doğrulanır.
 */
}
