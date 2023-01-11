package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;   //El metodo instrumented me crea la instancia de la clase
import static net.serenitybdd.screenplay.actions.Hit.the;
import static userinterfaces.HomePage.*;

//Las task son las clases que van a contener todas nuestras tareas que se van a encargar de ejecutar cada uno de los pasos
//que realizaremos en nuestro script de pruebas

public class MLogin implements Task {    // 1) Para hacer que nuestra clase funcione debemos implementar la interfaz task de serenity

    private String email,password;                       // 6) Creo mis varibles para esta clase que me va a recibir lo que se envie desde el step

    public MLogin(String email, String password) {      // 7) Creo mi constructor y recibo lo que me estan entregando
        this.email = email;
        this.password = password;
    }

    // 8) El overrite me hereda el actor que ya trabajamos en el step , es como si fuera mi lugar de trabajo
    @Override                // 2) Y para que no nos arroje un error debemos implementar los metodos de la interfaz task
                             //con esto hacemos la creacion de nuestro metodo, el cual se va a ejecutar apenas lancemos nuestra clase
    public <T extends Actor> void performAs(T actor) {
                                                              // 9) Aqui el actor va  ajecutar las acciones, el metodo attemptsTo recibe unas acciones o performables
                                                              //que son las interacciones en si con la aplicacion de magneto
        actor.attemptsTo(
                //Click.on(),
                Enter.theValue(email).into(INPUT_USER),          //Diligenciar campo de busqueda
                //Click.on(),                                    //Selecciona un campo
                Enter.theValue(password).into(INPUT_PASSWORD),
                Click.on(BUTTON_SIGN_IN),
                WaitUntil.the(STRONG_USER, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
                //Hit.the(Keys.ENTER).into(INPUT_PASSWORD)        //Presiona la tecla enter
        );

        actor.remember("user logs",STRONG_USER.resolveFor(actor).getText());

    }

    // 4) Convertimos nuestra task en un performable que me retorne, aqui aplicamos un principio solid substitution of liskov un hijo puede reemplazar al padre
    //En este caso nosotros necesitamos que se haga una implmentacion de nuestra clase MLogin, llamamos el metodo en nuestro step y este va a reemplazar al padre
    //por lo tanto podemos sustituirlo por la clase MLogin, la clase Mlogin al implementar una interfaz task se convierte en un performable
    public static MLogin loguearse(String email, String password) {
                                                                            // 3) Por defecto se me crea un metodo perfomable, se encarga de realizar la ejecucion de una
                                                                           // cadena de tarea, en nuestro caso seran las acciones que vamos a realizar dentro de las tasks,
                                                                          //esto lo hace para que el retorne la accion o la ejecucion de esas tareas al actor

        return  instrumented(MLogin.class,email,password);               // 5) retornamos una instancia de la clase MLogin con sus variables
                                                                         //Serenity nos provee esa herramienta para hacer el instanciamiento de la clase en esta linea
    }
}
