package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static org.junit.Assert.assertTrue;


public class StepDefinition {
    WebDriver driver;
    String link;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        driver.get("https://adactinhotelapp.com/");
    }
    @When("User enter {string} as the Username")
    public void userEnterAsTheUsername(String Uname) {
        driver.findElement(By.id("username")).sendKeys(Uname);
    }

    @And("User enter {string} as the Password")
    public void userEnterAsThePassword(String pwd) {
        driver.findElement(By.id("password")).sendKeys(pwd);
       //driver.findElement(By.xpath("//input[@value='login_button']")).click();
        driver.findElement(By.id("login")).click();
        //driver.quit();
        link = driver.getCurrentUrl();
        System.out.print(link);
        driver.quit();
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {

        //WebElement element = driver.findElement(By.xpath("//a[@href='SearchHotel.php']"));
        //element.click();
        driver.get("https://adactinhotelapp.com/");
        driver.findElement(By.id("username")).sendKeys("TiisetsoMadi");
        driver.findElement(By.id("password")).sendKeys("Ora#20042018");
        //driver.findElement(By.xpath("//input[@value='login_button']")).click();
        driver.findElement(By.id("login")).click();

    }

   // @When("user selects\\/enter {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} as the search options")
   @When("user selects\\/enter {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} as the search options")
   public void userSelectsEnterAsTheSearchOptions(String location, String hotel, String room_type, String NOR, String CID, String COD, String APR, String CPR) {
       WebElement dropdownlocation = driver.findElement(By.id("location"));
       dropdownlocation.click();
       WebElement option = driver.findElement(By.xpath("//option[text()='"+location+"']"));
       option.click();

       WebElement dropdownhotels = driver.findElement(By.id("hotels"));
       dropdownhotels.click();
       option = driver.findElement(By.xpath("//option[text()='"+hotel+"']"));
       option.click();

       WebElement dropdownRT = driver.findElement(By.id("room_type"));
       dropdownRT.click();
       option = driver.findElement(By.xpath("//option[text()='"+room_type+"']"));
       option.click();

       WebElement dropdownNOR = driver.findElement(By.id("room_nos"));
       dropdownNOR.click();
       option = driver.findElement(By.xpath("//option[text()='"+NOR+"']"));
       option.click();

       WebElement inputBoxDPI = driver.findElement(By.id("datepick_in"));
       inputBoxDPI.sendKeys(CID);

       WebElement inputBoxDPO = driver.findElement(By.id("datepick_out"));
       inputBoxDPO.sendKeys(COD);

       WebElement dropdownAR = driver.findElement(By.id("adult_room"));
       dropdownAR.click();
       option = driver.findElement(By.xpath("//option[text()='"+APR+"']"));
       option.click();

       WebElement dropdownCR = driver.findElement(By.id("child_room"));
       dropdownCR.click();
       option = driver.findElement(By.xpath("//option[text()='"+CPR+"']"));
       option.click();
   }

    @When("User clicks search button")
    public void userClicksSearchButton() {
        driver.findElement(By.id("Submit")).click();
    }


    @Then("Select hotel page should open")
    public void selectHotelPageShouldOpen() {
    }

    @And("User select hotel details")
    public void userSelectHotelDetails() {
        WebElement radioButton = driver.findElement(By.id("radiobutton_0"));
        radioButton.click();
    }

    @When("User clicks Continue")
    public void userClicksContinue() {
        WebElement Continue = driver.findElement(By.id("continue"));
        Continue.click();
    }


    @And("User selects\\/enter {string}, {string}, {string}, {string} , {string}, {string}, {string}, {string} as the booking details")
    public void userSelectsEnterAsTheBookingDetails(String FirstName, String LastName, String Address, String CCNo, String CCT, String CEM, String CEY, String CVV) {
        WebElement inputBoxFN = driver.findElement(By.id("first_name"));
        inputBoxFN.sendKeys(FirstName);

        WebElement inputBoxLN = driver.findElement(By.id("last_name"));
        inputBoxLN.sendKeys(LastName);

        WebElement inputBoxAdd = driver.findElement(By.id("address"));
        inputBoxAdd.sendKeys(Address);

        WebElement inputBoxCC = driver.findElement(By.id("cc_num"));
        inputBoxCC.sendKeys(CCNo);

        WebElement dropdownCCT = driver.findElement(By.id("cc_type"));
        dropdownCCT.click();
        WebElement option = driver.findElement(By.xpath("//option[text()='"+CCT+"']"));
        option.click();

        WebElement dropdownCEM = driver.findElement(By.id("cc_exp_month"));
        dropdownCEM.click();
        option = driver.findElement(By.xpath("//option[text()='"+CEM+"']"));
        option.click();

        WebElement dropdownCEY = driver.findElement(By.id("cc_exp_year"));
        dropdownCEY.click();
        option = driver.findElement(By.xpath("//option[text()='"+CEY+"']"));
        option.click();

        WebElement inputBoxCVV = driver.findElement(By.id("cc_cvv"));
        inputBoxCVV.sendKeys(CVV);
    }

    @And("user clicks book now")
    public void userClicksBookNow() {
        WebElement Continue = driver.findElement(By.id("book_now"));
        Continue.click();
    }

    @Then("User logs out")
    public void userLogsOut() throws InterruptedException {
        long seconds;
        Thread.sleep( 10000);
        WebElement logout = driver.findElement(By.id("logout"));
        logout.click();
    }
}
