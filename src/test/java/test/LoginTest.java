package test;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainDeckGeneralPage;

import static com.codeborne.selenide.Selenide.sleep;

public class LoginTest extends BaseTest {


    @Test(priority=1)
    public void loginWithWrongLogin()
    {
        LoginPage loginPage =new LoginPage();
        loginPage.login(user.getWrongLogin(),user.getPassword());
        loginPage.LabelLoginError().shouldBe(Condition.matchText(user.getWrongLogin()+" not exist"));
    }
    @Test(priority=2)
    public void loginWithWrongPass()
    {
        LoginPage loginPage =new LoginPage();
        loginPage.login(user.getEmail(),user.getWrongPassword());
        loginPage.LabelPasswordError().shouldBe(Condition.matchText("\"password\" is not correct"));

    }
    @Test (priority = 3)
    public void loginWithNotValue(){
        LoginPage loginPage=new LoginPage();
        loginPage
                .openPage()
                .clickSignIn();
        loginPage
                .openMenuLogout()
                .loginButton().should(Condition.visible);


    }

    @Test(priority=4)
    public void loginWithValidData()
    {
        LoginPage loginPage =new LoginPage();
        loginPage
                .login(user.getEmail(),user.getPassword())
                .openMenu()
                .getLabelEmail()
                .shouldHave(Condition.matchText(user.getEmail()));
    }

}
