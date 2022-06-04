package pe.edu.upc.clientsboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableWebMvc
@SpringBootApplication()
public class ClientsBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientsBootApplication.class, args);
	}
}
