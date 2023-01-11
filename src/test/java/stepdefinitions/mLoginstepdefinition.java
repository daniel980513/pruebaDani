package stepdefinitions;

import cucumber.api.java.en.*;        //Import para los GivenWhenThen
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import questions.ValidateUser;
import tasks.MLogin;
import userinterfaces.HomePage;

import java.sql.SQLOutput;
import java.util.List;               //Import para uso de listas

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static userinterfaces.HomePage.STRONG_USER;

public class mLoginstepdefinition {
                                                    //Cucumber nos interpreta nuestros pasos al step

    @Managed(driver = "chrome")                     //Inyeccion de dependencia con la anotacion, me permite especificar el tipo de navegador se va  ausar
    private WebDriver navegador;
    private Actor actor = Actor.named("Daniel Andres"); //Con este tipo actor empezamos a usar screnplay, este al manejar un lenguaje BDD lenguaje guiado por comportamiento
                                                        //Este nombre se ve reflejado en nuestro reporte de serenity
    private HomePage homePage = new HomePage();        //Aqui inicializo o creo una variable de la clase homepage

   // private MLogin mLogin = new MLogin();    Esto lo evitamos con el instrumented

    @Given("^the user enter the page magneto$")    // Junto con el camelcase convierte la descripcion quitando los espacios y poniendo la primera letra de cada palabra en mayuscula
    public void theUserEnterThePageMagneto() {     // Metodo convertido en la expresion regular
        actor.can(BrowseTheWeb.with(navegador));   //Nuestro actor puede navegar en la web con este navegador, en este primer paso damos los permisos al usuario para abrir el navegador
        actor.wasAbleTo(Open.browserOn(homePage));        //Nuestro actor fue capaz de abrir el navegador en

    }


    @When("^the user enter (.*) and (.*)$")       // para que reconozca nuestra varible colocamos entre parentesis un .*
    public void theUserEnterUsernameAndPassword(String email, String password) throws InterruptedException /*throws InterruptedException */{
        actor.wasAbleTo(                          //Nuestro actor fue capaz de hacer esta serie de tareas
                MLogin.loguearse(email,password)  // clase-metodo-variable
        );
        //Thread.sleep(15000);
    }

    @Then("^the user sees (.*) magneto$")
    public void theUserSeesBienvenidoMagneto(String user) {
        //actor.should(seeThat(the(STRONG_USER), Matchers.is(user)));  //Nuestro actor deberia ver, hacemos que nuestro actor verifique una accion
        actor.should(seeThat(ValidateUser.validarNombreDeUsuario(),Matchers.is(user)));
        System.out.println("Prueba finalizada");
    }
}
