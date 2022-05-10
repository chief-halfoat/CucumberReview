package pages;

import utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeaveListPage extends CommonMethods {
    @FindBy(id = "calFromDate")
    public WebElement calendarFromDate;

    @FindBy(xpath = "//select[@class='ui-datepicker-month']")
    public WebElement monthDD;

    @FindBy(xpath = "//select[@class='ui-datepicker-year']")
    public WebElement yearDD;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> daysTableData;

    @FindBy(id = "calToDate")
    public WebElement calendarToDate;

    @FindBy(id = "leaveList_chkSearchFilter_checkboxgroup_allcheck")
    public WebElement checkboxAll;

    @FindBy(id = "leaveList_chkSearchFilter_-1")
    public WebElement checkboxRejected;

    @FindBy(id = "leaveList_chkSearchFilter_0")
    public WebElement checkboxCancelled;

    @FindBy(id = "leaveList_chkSearchFilter_1")
    public WebElement checkboxPendingApproval;

    @FindBy(id = "leaveList_chkSearchFilter_2")
    public WebElement checkboxScheduled;

    @FindBy(id = "leaveList_chkSearchFilter_3")
    public WebElement checkboxTaken;

    @FindBy(id = "leaveList_cmbSubunit")
    public WebElement subUnitDD;

    @FindBy(id = "leaveList_cmbWithTerminated")
    public WebElement checkboxIncludePastEmployees;

    @FindBy(id = "btnSearch")
    public WebElement searchBtn;

    @FindBy(id = "btnReset")
    public WebElement resetBtn;

    @FindBy(id = "btnSave")
    public WebElement saveBtn;

    public LeaveListPage(){
        PageFactory.initElements(driver,this);
    }
}
