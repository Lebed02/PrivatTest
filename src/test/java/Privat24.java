import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

public class Privat24 {

    @Test
    public void transferConfirmationTest(){
        WebDriverManager.chromedriver().setup();

        Selenide.open("https://next.privat24.ua/money-transfer/card");

        Selenide.$("[data-qa-node='numberdebitSource']").sendKeys("4552331448138217");
        Selenide.$("[data-qa-node='expiredebitSource']").sendKeys("05/24");
        Selenide.$("[data-qa-node='cvvdebitSource']").sendKeys("926");
        Selenide.$("[data-qa-node='firstNamedebitSource']").sendKeys("Firstname");
        Selenide.$("[data-qa-node='lastNamedebitSource']").sendKeys("Lastname");
        Selenide.$("[data-qa-node='numberreceiver']").sendKeys("4004159115449003");
        Selenide.$("[data-qa-node='firstNamereceiver']").sendKeys("Firstnametest");
        Selenide.$("[data-qa-node='lastNamereceiver']").sendKeys("Lastnametest");
        Selenide.$("[data-qa-node='amount']").sendKeys("123");
        Selenide.$("[data-qa-node='currency']").click();
        Selenide.$("[data-qa-value='USD']").click();
        Selenide.$("[type='submit']").doubleClick();


        Selenide.$("[data-qa-node='payer-card']").shouldHave(Condition.text("4552 3314 4813 8217"));
        Selenide.$("[data-qa-node='payer-amount']").shouldHave(Condition.text("123 USD"));
        Selenide.$("[data-qa-node='payer-currency']").shouldHave(Condition.text("5.41 USD"));
        Selenide.$("[data-qa-node='receiver-name']").shouldHave(Condition.text("FIRSTNAMETEST LASTNAMETEST"));
        Selenide.$("[data-qa-node='receiver-card']").shouldHave(Condition.text("4004 1591 1544 9003"));
        Selenide.$("[data-qa-node='receiver-amount']").shouldHave(Condition.text("123 USD"));
        Selenide.$("[data-qa-node='receiver-currency']").shouldHave(Condition.text("0 USD"));
        Selenide.$("[data-qa-node='total']").shouldHave(Condition.text("128.41"));

    }
}
