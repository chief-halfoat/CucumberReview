package steps;

import utils.CommonMethods;
import utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EmployeeLeaveSearchSteps extends CommonMethods {
    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
    openBrowserAndLaunchApplication();
    }
    @When("user enters valid admin credentials")
    public void user_enters_valid_admin_credentials() {
        sendText(login.usernameTxtField, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordTxtField, ConfigReader.getPropertyValue("password"));
    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(login.loginBtn);
    }
    @Then("user is successfully logged in as an admin")
    public void user_is_successfully_logged_in_as_an_admin() {
        System.out.println("User Logged in as Admin");
    }
    @When("the user clicks on Leave button")
    public void the_user_clicks_on_leave_button() {
        click(dashboardPage.leaveBtn);
    }
    @When("clicks on the From Calendar")
    public void clicks_on_the_from_calendar() {
        click(leaveListPage.calendarFromDate);
    }
    @When("selects a month from the dropdown menu")
    public void selects_a_month_from_the_dropdown_menu() {
        selectDdValue(leaveListPage.monthDD,4);
    }
    @When("selects a year from the dropdown menu")
    public void selects_a_year_from_the_dropdown_menu() {
        selectDdValue(leaveListPage.yearDD, "2021");
    }
    @When("selects a day from the menu")
    public void selects_a_day_from_the_menu() {
        for(WebElement day: leaveListPage.daysTableData){
            if(day.getText().equals("24")){
                day.click();
            }
        }
    }
    @When("clicks on the To Calendar")
    public void clicks_on_the_to_calendar() {
        click(leaveListPage.calendarToDate);
        sendText(leaveListPage.calendarToDate, Keys.ENTER);
    }
    @When("clicks the All checkbox")
    public void clicks_the_all_checkbox() {
        click(leaveListPage.checkboxAll);
    }
    @When("clicks on the Subunit dropdown")
    public void clicks_on_the_subunit_dropdown() {
        click(leaveListPage.subUnitDD);
    }
    @When("selects a value from the Subunit dropdown")
    public void selects_a_value_from_the_subunit_dropdown() {
        selectDdValue(leaveListPage.subUnitDD, "All");
    }
    @When("clicks the Past Employees checkbox")
    public void clicks_the_past_employees_checkbox() {
        click(leaveListPage.checkboxIncludePastEmployees);
    }
    @When("clicks the Search button")
    public void clicks_the_search_button() {
        click(leaveListPage.searchBtn);
    }
    @Then("the user should see all of the data")
    public void the_user_should_see_all_of_the_data() {
        System.out.println("Searched");
    }

}
