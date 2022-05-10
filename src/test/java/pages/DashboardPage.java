package pages;

import utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonMethods {
    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminBtn;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimBtn;

    @FindBy(id = "menu_leave_viewLeaveModule")
    public WebElement leaveBtn;

    @FindBy(id = "menu_time_viewTimeModule")
    public WebElement timeBtn;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    public WebElement recruitmentBtn;

    @FindBy(id = "menu__Performance")
    public WebElement performanceBtn;

    @FindBy(id = "menu_dashboard_index")
    public WebElement dashboardBtn;

    @FindBy(id = "menu_directory_viewDirectory")
    public WebElement directoryBtn;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }
}
