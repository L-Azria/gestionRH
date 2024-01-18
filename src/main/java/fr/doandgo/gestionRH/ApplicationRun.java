package fr.doandgo.gestionRH;

import fr.doandgo.gestionRH.ihm.ConsoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRun implements CommandLineRunner {

    private final ConsoleView consoleView;

    @Autowired
    public ApplicationRun(ConsoleView consoleView) {
        this.consoleView = consoleView;
    }
    @Override
    public void run(String... args) throws Exception {
        consoleView.consoleView();

    }

}
