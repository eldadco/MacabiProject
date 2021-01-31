package Tests;

import Pages.HomePage.HomePageActions;
import Pages.MacabiDentPage.MacabiDentActions;
import Pages.ResultsPage.ResultsPageActions;
import Pages.Scheduler.SchedulerActions;
import Pages.ServiceLocationPage.ServiceLocationsActions;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePageActions homePageActions;
    MacabiDentActions macabiDentActions;
    ServiceLocationsActions serviceLocationsActions;
    ResultsPageActions resultsPageActions;
    SchedulerActions schedulerActions ;
    public HomePageTest()
    {
        this.homePageActions = new HomePageActions();
        this.macabiDentActions = new MacabiDentActions();
        this.serviceLocationsActions = new ServiceLocationsActions();
        this.resultsPageActions = new ResultsPageActions();
        this.schedulerActions = new SchedulerActions();
    }

    @Test
    public void macabiDentTest() throws InterruptedException {
        this.homePageActions.enterToMacabiDent();

        this.macabiDentActions.enterToGoldMacabiTab();
        this.macabiDentActions.enterToServiceLocationLink();

        this.serviceLocationsActions.searchAddress("תל אביב יפו");
        this.resultsPageActions.moveSlider();

        this.resultsPageActions.chooseDays(new int[]{1,3,6});

        this.resultsPageActions.chooseClinic("נס ציונה");
        this.schedulerActions.requestService("תור לבדיקת רופא שיניים","1 במרץ 2021");

    }
}