package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import static userinterfaces.Welcome.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToCreateVacancy implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(A_CREATE_VACANCY)
        );

    }

    public static GoToCreateVacancy createVacancy(){
        return instrumented(GoToCreateVacancy.class);
    }
}
