package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static com.sun.java.swing.action.ActionManager.utilities;

public class HomePage extends UserDashboard {
    public HomePage(){PageFactory.initElements(Driver.getDriver(),this);}

   // Header/Features Link
    @FindBy(xpath="//a[text()='Features']")
    public WebElement FeaturesTextLink;

    //Homepage SignIn Button
    @FindBy(xpath = "//a[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement signInButton;

    //Homepage>> LoginLink>> Email Text Box // ayse
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailtextBox;

    //Homepage>> LoginLink>> Password Text Box // ayse
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;

   //Homepage>> LoginLink>> Logın Butonu // ayse
   @FindBy(xpath = "//button[@class='btn btn-primary']")
   public WebElement loginButonu;

    //Homepage>> Dashboard
    @FindBy(xpath = "//a[@class='nav-link p-0 active']")
    public WebElement dashboardHearderTextANT;

    //Homepage>> LoginLink>> Basarısız Giris Texti
    @FindBy(xpath = "//span[text()='These credentials do not match our records.']")
    public WebElement basarisizGirisTextiANT;






























































  //Ozgur



































































































    //Cemil



































































































    //Taha



































































































    //Gulay
    // Homepage >> Log in sayfasında Create an account link // Gulay
    @FindBy (xpath = "//a[@href='https://qa.smartcardlink.com/register']" )
    public WebElement createAnAccountLinkgg;
    // Home page >> Resgister sayfasında Create an account text'i // Gulay
    @FindBy(xpath = "//h1[@class='text-center mb-7']")
    public WebElement createAnAccountTextgg;
    // Home page >> Create an Acount >>  First Name Alani// Gulay
    @FindBy (xpath ="//input[@name='first_name']" )
    public WebElement cAfirstNameAlanigg;
    // Home page >> Create an Account >>  Last Name Alani// Gulay
    @FindBy (xpath ="//input[@name='last_name']" )
    public WebElement cAlastNameAlanigg;
    // Home page >> Create an Account >>  Email Alani// Gulay
    @FindBy (xpath = "//input[@name='email'] ")
    public WebElement cAEMailalanigg;
    // Home page >> Create an Account >>  Password Alani// Gulay
    @FindBy (xpath ="(//input[@type='password'])[1]" )
    public WebElement cAPasswordAlanigg;
    // Home page >> Create an Account >>  Confirm Password Alani// Gulay
    @FindBy (xpath = "(//input[@type='password'])[2]")
    public WebElement cAConfirmPasswordAlanigg;
    //Home page >> Create an Account >>  By signing up you agree to our Terms & Conditions & Privacy Policy  // Gulay
    @FindBy (xpath = "//input[@type='checkbox']")
    public WebElement cABySigningUpgg;
    // Home page >> Create an Account >> Submit Butonu // Gulay
    @FindBy(xpath = "//button[@type='submit'] ")
    public WebElement cASubmitButonugg;
    @FindBy (xpath = "//h1[@class='text-center mb-7']")
    public  WebElement basarliCreatAccountSignInText_gg;






































































    //Hakan



































































































    //Hasan



































































































    //Tugce



































































































    //Cagla



































































































    //Mustafa



































































































//Ozan
    //Homepage Get Started butonu
    @FindBy(xpath = "//a[@class='btn btn-orange ']")
    public WebElement getStartedButton;
    //Home page standart Choose Plan butonu
    @FindBy(xpath = "//a[@data-id='1']")
    public WebElement choosePlan10;
    //Home page Choose plan bölümündeki Standart yazı elementi
    @FindBy(xpath = "(//h3[@class='mb-1 mt-3 fw-6'])[5]")
    public WebElement chosePlanStandardText;
    //Home page Choose plan bölümündeki Gold yazi elementi
    @FindBy(xpath = "(//h3[@class='mb-1 mt-3 fw-6'])[7]")
    public  WebElement choosePlanGoldText;
    //Home page Choose plan seçenek kaydırma butonu
    @FindBy(xpath = "//button[@class='slick-next slick-arrow']")
    public WebElement choosePlanKaydirma;

}
