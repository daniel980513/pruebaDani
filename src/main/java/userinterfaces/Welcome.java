package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Welcome extends PageObject {

    public  static final Target A_CREATE_VACANCY = Target.the("a href donde doy clic para crear vacante").located(By.xpath(("//a[@class='analystButtons_card'])[1])")));
}
