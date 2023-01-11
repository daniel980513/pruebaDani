package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateUser implements Question {

    @Override
    public Object answeredBy(Actor actor) {
        return actor.recall("user logs");
    }

    public static ValidateUser validarNombreDeUsuario(){
        return  new ValidateUser();
    }
}
