package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;                   // Nos ayuda con la interpretacion de ejecucion

@RunWith(CucumberWithSerenity.class)               // Para especificar con que lo vamos a correr
@CucumberOptions(                                  // Opciones o donde vamos a encontrar cada uno de nuestros pasos
        features = "src/test/resources/features/mLogin.feature", //Ruta del feature
        glue = "stepdefinitions",                 // Nuestro steps
        tags = "",                                // Especifico subconjunto de scenarios
        snippets = SnippetType.CAMELCASE          //Como va a realizar la conversion de los pasos de mis casos de prueba a metodos de java
        //Camelcase es una accion  que coje un texto completo, quita los espacios y pone en mayuscula cada una de las palabras
)
public class mLoginrunner {
}
