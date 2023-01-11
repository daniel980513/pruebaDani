package userinterfaces;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://oauth2-stage.magneto365.com/")    //Por defecto hago que tenga eesta url, cuando abramos el navegador se usar esta url, entonces usando este
                                                       // pageObject centralizamos la url de inicio y cada vez que la necesitemos la llamamos
public class HomePage extends PageObject {            //Con esta extension hago que mi clase se convierta en una page object

    public static final Target INPUT_USER = Target.the("Imnput donde ingreso mi usuario").located(By.id("email"));
    public static final Target INPUT_PASSWORD = Target.the("Imnput donde ingreso mi contraseña").located(By.id("password"));
    public static final Target BUTTON_SIGN_IN = Target.the("Button donde doy clic para loguearme").
            locatedBy("//button[@class='ant-btn ant-btn-primary card__container__button--primary']");
    public static final Target STRONG_USER = Target.the("Strong donde encontrare el nombre del usuario asociado a user/password").
            locatedBy("(//strong)[1]");
}
