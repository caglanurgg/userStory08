package tests.cagla;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_08 extends TestBaseRapor {
    //* Kullanıcıydı o yüzden tek buna dokunmadım

    private UserDashboard userDashboard = new UserDashboard();
    private SoftAssert softAssert = new SoftAssert();

    // Kullanıcı girişi yapmadan önce bu metot çalışır
    @BeforeMethod
    public void login() {
        // Burada kullanıcı girişi işlemleri yapılır
        // Örnek: Kullanıcı adı ve şifre ile giriş yapmak için kodlar burada olabilir

        extentTest = extentReports.createTest("VCard Islevselligi Dogrulama Testi",
                "Kullanici olarak SmartCardLink giris yapabilmeli, VCard olusturabilmeli ve dogrulayabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLinkUrl"));
        extentTest.info("Kullanici SmartCardLink sayfasina gider");

        userDashboard.signInButton.click();
        extentTest.info("Sign In butonuna tıklanılır.");

        userDashboard.emailtextBox.sendKeys(ConfigReader.getProperty("scGecerliEmail"));
        extentTest.info("login  pagede email textbox'ına geçerli email girilir.");

        userDashboard.passwordTextBox.sendKeys(ConfigReader.getProperty("scGecerliPassword"));
        extentTest.info("login  pagede password textbox'ına geçerli password girilir");

        userDashboard.loginButonu.click();
        extentTest.info("log in butonuna basılır.");


    }


    @Test //US08_T02 -->Kullanıcı olarak giriş yaptıktan sonra yeni bir vcard oluşturun.
    public void testCreateNewVCard() {

        // Yeni vCard oluşturma işlemleri burada yapılır
        // Örnek: VCard oluşturma adımları burada kodlanır

        userDashboard.VCardButton.click();
        extentTest.info("VCard butonuna tıklanılır.");

        userDashboard.NewVCardButton.click();
        extentTest.info("New Vcard butonuna tıklanılır.");

        userDashboard.GenerateURLAliasButton.click();
        extentTest.info("Generate URL alias butonuna tıklanılır.");

        // 2.9. VCard Name textbox'ına geçerli isim girilir.
        String vCardName = "Geçerli VCard İsmi";
        userDashboard.enterVCardName(vCardName);
        extentTest.info("VCard Name textbox'ına geçerli isim girilir: " + vCardName);

        userDashboard.SaveButton.click();
        extentTest.info("Save butonuna tıklanılır.");

        String expectedMessage = "VCard created successfully.";
        String actualMessage = userDashboard.getConfirmationMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "VCard oluşturma başarılı mesajı doğrulandı.");

         /*
        1.5'e kadar aynı adımlar
        2.6. vcard butonuna basılır.
        2.7.New Vcard butonuna basılır.
        2.8.generate url alias butonuna basılır.
        2.9.VCard Name textbox'ina gecerli isim girilir
        2.10.Save butonuna basilir.
        2.11." VCard created successfully." yazısını  dogrulanir.
        */


    }


    @Test // US08_T03--> Kullancı olarak oluşturulan yeni vcard'ın sayısını görüntüleyin.
    public void testViewVCardCount() {
        // VCard sayısını görüntüleme işlemleri burada yapılır
        /*
        1.5'e kadar aynı adımlar
        3.6. vcard butonuna basılır.
        3.7 New Vcard butonuna basılır.
        3.8. generate url alias butonuna basılır.
        3.9.VCard Name textbox'ina gecerli isim girilir
        3.10.Save butonuna basilir.
        3.11." VCard created successfully." yazısını  dogrulanir.
        3.12. vcard butonuna basılır.
        3.13.Vcard sayfasında en altta bulunan "Showing (x) results" yazısındaki x sayısının arttığı doğrulanır.
        */

        userDashboard.VCardButton.click();
        extentTest.info("VCard butonuna tıklanılır.");

        // 3.13. Vcard sayfasında en altta bulunan "Showing (x) results" yazısındaki x sayısının arttığı doğrulanır.
        int initialVCardCount = userDashboard.getVCardCount();
        userDashboard.createNewVCard(); // Yeni VCard oluşturulur
        extentTest.info("Yeni VCard oluşturuldu.");
        int updatedVCardCount = userDashboard.getVCardCount();
        extentTest.info("VCard sayısı görüntülendi: " + updatedVCardCount);
        Assert.assertEquals(updatedVCardCount, initialVCardCount + 1, "VCard sayısı doğrulandı.");

    }


    @Test //US08_T04--> Kullancı olarak oluşturan yeni vcard ile ilgili
    //tüm fonksiyon/işlem butonlarının aktif olduğunu doğrulayın.
    public void testVerifyVCardActions() {
        // VCard ile ilgili işlem butonlarının aktif durumda olduğunu doğrulama işlemleri burada yapılır

        // 4.12. VCard butonuna basılır.
        userDashboard.VCardButton.click();
        extentTest.info("VCard butonuna tıklanılır.");

        // 4.13. En son üretilen kartın name'i tıklanır.
        userDashboard.LastCreatedVCard.click();
        extentTest.info("En son oluşturulan VCard'ın adına tıklanılır.");

        // 4.14. Edit Vcard sayfasının geldiği doğrulanır.
        boolean isEditVCardPageDisplayed = userDashboard.isEditVCardPageDisplayed();
        Assert.assertTrue(isEditVCardPageDisplayed, "Edit VCard sayfasının geldiği doğrulandı.");

        // 4.15. Vcard Templates butonuna basılır ve ilgili linke yönlendirdiği doğrulanır
        userDashboard.ActionButton.click("Vcard Templates");
        extentTest.info("Vcard Templates butonuna tıklanılır.");
        boolean isTemplatesLinkRedirected = userDashboard.isRedirectedToTemplatesLink();
        Assert.assertTrue(isTemplatesLinkRedirected, "Vcard Templates butonunun ilgili linke yönlendirdiği doğrulandı.");

        // 4.16. Business Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır
        userDashboard.ActionButton.click("Business Hours");
        extentTest.info("Business Hours butonuna tıklanılır.");
        boolean isBusinessHoursLinkRedirected = userDashboard.isRedirectedToBusinessHoursLink();
        Assert.assertTrue(isBusinessHoursLinkRedirected, "Business Hours butonunun ilgili linke yönlendirdiği doğrulandı.");

        // 4.17. Services Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır
        userDashboard.ActionButton.click("Services Hours");
        extentTest.info("Services Hours butonuna tıklanılır.");
        boolean isServicesHoursLinkRedirected = userDashboard.isRedirectedToServicesHoursLink();
        Assert.assertTrue(isServicesHoursLinkRedirected, "Services Hours butonunun ilgili linke yönlendirdiği doğrulandı.");

        // 4.18. Testimonials Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır
        userDashboard.ActionButton.click("Testimonials Hours");
        extentTest.info("Testimonials Hours butonuna tıklanılır.");
        boolean isTestimonialsHoursLinkRedirected = userDashboard.isRedirectedToTestimonialsHoursLink();
        Assert.assertTrue(isTestimonialsHoursLinkRedirected, "Testimonials Hours butonunun ilgili linke yönlendirdiği doğrulandı.");

        // 4.19. Social-Links Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır
        userDashboard.ActionButton.click("Social-Links Hours");
        extentTest.info("Social-Links Hours butonuna tıklanılır.");
        boolean isSocialLinksHoursLinkRedirected = userDashboard.isRedirectedToSocialLinksHoursLink();
        Assert.assertTrue(isSocialLinksHoursLinkRedirected, "Social-Links Hours butonunun ilgili linke yönlendirdiği doğrulandı.");

        // 4.20. Fonts Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır
        userDashboard.ActionButton.click("Fonts Hours");
        extentTest.info("Fonts Hours butonuna tıklanılır.");
        boolean isFontsHoursLinkRedirected = userDashboard.isRedirectedToFontsHoursLink();
        Assert.assertTrue(isFontsHoursLinkRedirected, "Fonts Hours butonunun ilgili linke yönlendirdiği doğrulandı.");

        // 4.21. Privacy-policy Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır
        userDashboard.ActionButton.click("Privacy-policy Hours");
        extentTest.info("Privacy-policy Hours butonuna tıklanılır.");
        boolean isPrivacyPolicyLinkRedirected = userDashboard.isRedirectedToPrivacyPolicyLink();
        Assert.assertTrue(isPrivacyPolicyLinkRedirected, "Privacy-policy Hours butonunun ilgili linke yönlendirdiği doğrulandı.");

        // 4.15 - 4.22 arasındaki işlem butonlarına basılır ve ilgili linke yönlendirdiği doğrulanır
        String[] buttonNames = {"Vcard Templates", "Business Hours", "Services Hours", "Testimonials Hours", "Social-Links Hours", "Fonts Hours", "Privacy-policy Hours", "Terms & Conditions Hours"};
        for (String buttonName : buttonNames) {
            userDashboard.ActionButton.click(buttonName);
            extentTest.info(buttonName + " butonuna tıklanılır.");
            boolean isRedirected = userDashboard.isRedirectedToLinkForButton(buttonName);
            Assert.assertTrue(isRedirected, buttonName + " butonunun ilgili linke yönlendirdiği doğrulandı.");
        }


    }


    @AfterMethod   // Her test sonrası oturumu kapatma
    public void teardown(){ // Oturumu kapatma işlemleri burada yapılır
        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");
    }





    /*
    1.1 ilgili url'e gidilir.
    1.2.log in butonuna tıklanılır.
    1.3.login  pagede email textbox'ına geçerli email girilir.
    1.4.login  pagede password textbox'ına geçerli password girilir
    1.5. log in butonuna basılır.
    1.6.açılan sayfada dashboard yazısı doğrulanır.

    US08_T02 -->Kullanıcı olarak giriş yaptıktan sonra yeni bir vcard oluşturun.
    1.5'e kadar aynı adımlar
    2.6. vcard butonuna basılır.
    2.7.New Vcard butonuna basılır.
    2.8.generate url alias butonuna basılır.
    2.9.VCard Name textbox'ina gecerli isim girilir
    2.10.Save butonuna basilir.
    2.11." VCard created successfully." yazısını  dogrulanir.

US08_T03--> Kullancı olarak oluşturulan yeni vcard'ın sayısını görüntüleyin.
    1.5'e kadar aynı adımlar
    3.6. vcard butonuna basılır.
    2.7., 3.7 New Vcard butonuna basılır.
    2.8., 3.8. generate url alias butonuna basılır.
    2.9.VCard Name textbox'ina gecerli isim girilir
    2.10.Save butonuna basilir.
    2.11." VCard created successfully." yazısını  dogrulanir.
    3.12. vcard butonuna basılır.
    3.13.Vcard sayfasında en altta bulunan "Showing (x) results" yazısındaki x sayısının arttığı doğrulanır.

   US08_T04--> Kullancı olarak oluşturan yeni vcard ile ilgili tüm fonksiyon/
              işlem butonlarının aktif olduğunu doğrulayın.
1.5'e kadar aynı adımlar
    4.6. vcard butonuna basılır.
    4.7., 3.7 New Vcard butonuna basılır.
    4.8., 3.8. generate url alias butonuna basılır.
    4.9.VCard Name textbox'ina gecerli isim girilir
    4.10.Save butonuna basilir.
    4.11." VCard created successfully." yazısını  dogrulanir.
    4.12. vcard butonuna basılır.
    4.13.En son üretilen kartın name'i tıklanır.
    4.14.Edit Vcard sayfasının geldiği doğrulanır.
    4.15.Vcard Templates butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.
    4.16.Business Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.
    4.17.Services Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.
    4.18.Testimonials Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.
    4.19.Social-Links Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.
    4.20.Fonts Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.
    4.21.Privacy-policy Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.
    4.22.Terms & Conditions Hours butonuna basılır ve ilgili linke yönlendirdiği doğrulanır.





     */


}
