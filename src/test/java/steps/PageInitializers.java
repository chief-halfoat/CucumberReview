package steps;

import pages.DashboardPage;
import pages.LeaveListPage;
import pages.LoginPage;

public class PageInitializers {
    public static LoginPage login;
    public static DashboardPage dashboardPage;
    public static LeaveListPage leaveListPage;
    public static void initializePageObjects(){
        login = new LoginPage();
        dashboardPage = new DashboardPage();
        leaveListPage = new LeaveListPage();
    }
}
