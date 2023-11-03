package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminDashboard {


    public AdminDashboard(){PageFactory.initElements(Driver.getDriver(),this);}

    //Admin Dashboard >> Menü >> Para Birimleri
    @FindBy(xpath = "(//span[@class='aside-menu-title'])[12]")
    public WebElement paraBirimleriElementi;





    //Admin Dashboard >> Menü >> Users
    @FindBy(xpath = "//span[text()='Users']")
    public WebElement usersElementi;


   //Admin Dashboard >> Menü >> Withdraw Transactions
    @FindBy (xpath = "//span[text()='Withdraw Transactions']")
    public WebElement paraCekmeIslemleriElementiANT;

    //Admin Dashboard >> Menü >> Currencies
    @FindBy (xpath = "//span[text()='Currencies']")
    public WebElement paraBirimleriElementiANT;

    //Admin Dashboard >> Menü >> Currencies >> SonucYaziElementi
    @FindBy (xpath = "//*[@class='text-muted ms-sm-3 pagination-record']")
    public WebElement paraBirimleriSonucYaziElementiANT;

    //Admin Dashboard >> Menü >> Currencies >> ParaBirimleriSayisi
    @FindBy (xpath = "//strong[text()='135']")
    public WebElement paraBirimleriSayisiElementiANT;



























































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
    public  WebElement vCardButton ;
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
    public WebElement FrontCMSButton; //Search'un altindakiler
    @FindBy (xpath = "//input[@class='form-control ps-8']")
    public WebElement searchBox;
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement frontCMSPage;
    @FindBy (xpath = "//tr/td/div")
    public List<WebElement> cardList;
    @FindBy (xpath = "//a[@id='vcardUrl407']")
    public WebElement previewURLLink;
    @FindBy (xpath = "//img[@src='https://qa.smartcardlink.com/assets/images/default_cover_image.jpg']")
    public WebElement cagla3Image;
    @FindBy (xpath = "//div[@class='card-body pt-0']")
    public WebElement isAnalyticTitleVisible;
    @FindBy (xpath = "(//*[@role='img'])[29]")
    public WebElement statsIcon ;
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement SubscribersButton;
    @FindBy (xpath = "//a[@class='nav-link p-0 active']")
    public WebElement FeaturesButton;
    @FindBy (xpath = "//*[@href='https://qa.smartcardlink.com/sadmin/about-us']")
    public WebElement AboutUsButton;
    @FindBy (xpath = "//span[@class='required']")
    public WebElement isBannerImageVisible;
    @FindBy (xpath = "(//label[@class='form-label required'])[1]")
    public WebElement isTitleVisible;
    @FindBy (xpath = "(//label[@class='form-label required'])[2]")
    public WebElement isSubTextVisible;
    // @FindBy (xpath = "(//span[text()='Email']") nolur nolmaz dursun*isEmailTitleVisible
    @FindBy (xpath = "(//div[@class='d-flex align-items-center']")
    public WebElement isEmailTitleVisible;
    @FindBy (xpath = "(//th[@class='d-flex justify-content-center']")
    public WebElement isActionTitleVisible;
    @FindBy (xpath = "(//div[@class='d-flex align-items-center'])[1]")
    public WebElement isNameTitleVisible;
    @FindBy (xpath = "(//div[@class='d-flex align-items-center'])[2]")
    public WebElement isDescriptionTitleVisible;
    //public WebElement isImageTitleVisible;
    public WebElement aboutUsPage;
    @FindBy (xpath = "(//div[@class='card-body']")
    public WebElement FeaturesPageScreen;
    //@FindBy (xpath = "(//div[@class='d-flex flex-row flex-column-fluid']")

































//Mustafa



































































































//Ozan
}
