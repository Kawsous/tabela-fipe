package br.com.fipe.FIPE;

import br.com.fipe.FIPE.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        View view = new View();
        view.exibirView();
    }
}
