package steps;

import utils.CommonMethods;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetCalendarDataSteps extends CommonMethods {
    @Then("user should see calendar info")
    public void user_should_see_calendar_info() {
        List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
        for(WebElement day:days){
            System.out.println(day);
        }
    }
}
