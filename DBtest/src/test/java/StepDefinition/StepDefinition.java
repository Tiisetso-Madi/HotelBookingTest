package StepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.*;

public class StepDefinition {

    WebDriver driver;
    String link;
    String dbUrl = "jdbc:postgresql://localhost:5432/BookingData";
    String dbUsername = "postgres";
    String dbPassword = "password";
    @Before
    public void setUp() {

        driver = new ChromeDriver();
    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {

        driver.get("https://adactinhotelapp.com/");
    }

    @When("User adds login credentials")
    public void dbtest() throws SQLException {


        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username, passwords FROM UserDetails");
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("passwords");
                driver.findElement(By.id("username")).sendKeys(username);
                driver.findElement(By.id("password")).sendKeys(password);
            }

    }


    @Then("User clicks login button")
    public void userClicksLoginButton() {
        driver.findElement(By.id("login")).click();
    }

    @And("Users searches for a hotel")
    public void usersSearchesForAHotel() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM SearchDetails");
        if (resultSet.next()) {
            String location = resultSet.getString("locations");
            String hotel = resultSet.getString("hotel");
            String room_type = resultSet.getString("room_type");
            String NOR = resultSet.getString("number_of_rooms");
            String CID = resultSet.getString("check_in_date");
            String COD = resultSet.getString("check_out_date");
            String APR = resultSet.getString("adult_per_room");
            String CPR = resultSet.getString("children_per_room");

            //driver.findElement(By.id("username")).sendKeys(username);
            //driver.findElement(By.id("password")).sendKeys(password);

            driver.findElement(By.id("location")).click();
            driver.findElement(By.xpath("//option[text()='"+location+"']")).click();


            driver.findElement(By.id("hotels")).click();
            driver.findElement(By.xpath("//option[text()='"+hotel+"']")).click();


            driver.findElement(By.id("room_type")).click();
            driver.findElement(By.xpath("//option[text()='"+room_type+"']")).click();


          driver.findElement(By.id("room_nos")).click();
          driver.findElement(By.xpath("//option[text()='"+NOR+"']")).click();


          driver.findElement(By.id("datepick_in")).sendKeys(CID);


           driver.findElement(By.id("datepick_out")).sendKeys(COD);

           driver.findElement(By.id("adult_room")).click();
          driver.findElement(By.xpath("//option[text()='"+APR+"']")).click();

          driver.findElement(By.id("child_room")).click();

          driver.findElement(By.xpath("//option[text()='"+CPR+"']")).click();

        }
    }


    @And("User clicks search button")
    public void userClicksSearchButton() {
        driver.findElement(By.id("Submit")).click();
    }


    @Then("Select hotel page should open and select hotel details")
    public void selectHotelPageShouldOpenAndSelectHotelDetails() {
        WebElement radioButton = driver.findElement(By.id("radiobutton_0"));
        radioButton.click();

    }
    @And("User clicks Continue")
    public void userClicksContinue() {
        WebElement Continue = driver.findElement(By.id("continue"));
        Continue.click();
    }

    @When("User enter remaining booking details")
    public void userEnterRemainingBookingDetails() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM BookingDetails");
        if (resultSet.next()) {
            String FirstName = resultSet.getString("first_name");
            String LastName = resultSet.getString("last_name");
            String Address = resultSet.getString("address");
            String CCNo = resultSet.getString("cc_number");
            String CCT = resultSet.getString("cc_type");
            String CEM = resultSet.getString("cc_exp_month");
            String CEY = resultSet.getString("cc_exp_year");
            String CVV= resultSet.getString("cc_cvv");

            driver.findElement(By.id("first_name")).sendKeys(FirstName);
            driver.findElement(By.id("last_name")).sendKeys(LastName);

            driver.findElement(By.id("address")).sendKeys(Address);

            driver.findElement(By.id("cc_num")).sendKeys(CCNo);

          driver.findElement(By.id("cc_type")).click();

          driver.findElement(By.xpath("//option[text()='"+CCT+"']")).click();

          driver.findElement(By.id("cc_exp_month")).click();

           driver.findElement(By.xpath("//option[text()='"+CEM+"']")).click();

           driver.findElement(By.id("cc_exp_year")).click();

          driver.findElement(By.xpath("//option[text()='"+CEY+"']")).click();

          driver.findElement(By.id("cc_cvv")).sendKeys(CVV);

        }


    }

    @And("user clicks book now")
    public void userClicksBookNow() {

            WebElement Continue = driver.findElement(By.id("book_now"));
            Continue.click();

    }

    @Then("User logs out")
    public void userLogsOut() throws InterruptedException {
            Thread.sleep( 10000);

            //String expectedTitle = "Adactin.com - Hotel Booking Comfirmation";
            // String actualTitle = driver.getTitle();
            //Assert.assertEquals("Page match", expectedTitle, actualTitle);


            WebElement logout = driver.findElement(By.id("logout"));
            logout.click();
            driver.quit();
    }
}
