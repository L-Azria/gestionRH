package fr.doandgo.gestionRH;

import fr.doandgo.gestionRH.ihm.ConsoleView;
import fr.doandgo.gestionRH.ihm.DisplayMenuCompagny;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionRhApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionRhApplication.class, args);

	}

}
