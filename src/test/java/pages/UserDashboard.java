package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserDashboard extends AdminDashboard {

    public UserDashboard() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
























































































    //Ozgur



































































































    //Cemil



































































































    //Taha



































































































    //Gulay



































































































    //Hakan



































































































    //Hasan



































































































    //Tugce































































































    //Cagla
    @FindBy(xpath = "//a[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']") //Homepage SignIn Button
    public WebElement signInButton;
    @FindBy(xpath = "//input[@id='email']") //Homepage>> LoginLink>> Email Text Box
    public WebElement emailtextBox;
    @FindBy(xpath = "//input[@id='password']") //Homepage>> LoginLink>> Password Text Box
    public WebElement passwordTextBox;
    @FindBy(xpath = "//button[@class='btn btn-primary']")  //Homepage>> LoginLink>> Logın Butonu
    public WebElement loginButonu;
    @FindBy(xpath = "//a[@class='nav-link p-0 active']")  //Homepage>> Dashboard
    public WebElement dashboardHearderTextANT;
    @FindBy (xpath = "//span[text()='VCards']") //VCard
    public  WebElement VCardButton ;
    @FindBy (xpath = "//a[@class='btn btn-primary']")
    public  WebElement NewVCardButton;
    @FindBy (xpath = "//button[@class='btn btn-secondary']")
    public  WebElement  GenerateURLAliasButton;
    @FindBy (xpath = "//input[@id='vcardSaveBtn']")
    public  WebElement SaveButton;
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement dashboardText;
    @FindBy (xpath = "//span[text()='Languages']")
    public WebElement languagesButton ;
    @FindBy(xpath = "//div[@class='col-12 text-muted pagination-record ms-sm-3']")
    public WebElement resultsText;
    @FindBy(xpath = "//span[text()='Front CMS']")
    public WebElement FrontCMSButton;
    @FindBy (xpath = "//input[@class='form-control ps-8']")
    public WebElement searchBox;
    @FindBy (xpath = "//input[@placeholder='Enter VCard Name']")
    public  WebElement enterVCardName;
    @FindBy (xpath = "//div[@style='display: none;']")
    public  WebElement getConfirmationMessage;
    @FindBy (xpath = "//div[@class='col-12 text-muted pagination-record ms-sm-3']")
    public  WebElement getVCardCount;
    @FindBy (xpath = "(//*[@href='https://qa.smartcardlink.com/admin/vcards/888/edit'])[1]")
    public  WebElement LastCreatedVCard;
    @FindBy (xpath = "//h1[text()='Edit VCard']")
    public  WebElement isEditVCardPageDisplayed;
    @FindBy (xpath = "//a[@class='nav-link p-4 active']")
    public  WebElement isRedirectedToTemplatesLink;
    @FindBy (xpath = "(//a[@class='nav-link p-4 '])[1]")
    public  WebElement isRedirectedToBusinessHoursLink;
    @FindBy (xpath = "//*[@href='https://qa.smartcardlink.com/admin/vcards/888/edit?part=services']")
    public  WebElement isRedirectedToServicesHoursLink;
    @FindBy (xpath = "//*[@href='https://qa.smartcardlink.com/admin/vcards/888/edit?part=testimonials']")
    public  WebElement isRedirectedToTestimonialsLink;
    @FindBy (xpath = "//*[@href='https://qa.smartcardlink.com/admin/vcards/888/edit?part=social-links']")
    public  WebElement isRedirectedToSocialLinksHoursLink;
    @FindBy (xpath = "//*[@href='https://qa.smartcardlink.com/admin/vcards/888/edit?part=custom-fonts']")
    public  WebElement isRedirectedToFontsHoursLink ;
    @FindBy (xpath = "//*[@href='https://qa.smartcardlink.com/admin/vcards/888/edit?part=privacy-policy']")
    public  WebElement isRedirectedToPrivacyPolicyLink;
    @FindBy (xpath = "//*[@href='https://qa.smartcardlink.com/admin/vcards/888/edit?part=term-condition']")
    public  WebElement isRedirectedToTermsConditionsLink;













































    //Mustafa



































































































    //Ozan
}
