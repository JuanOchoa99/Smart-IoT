package co.edu.usbbog.piico.piicows;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import co.edu.usbbog.piico.piicows.service.SuscribeMQTT;


@SpringBootApplication
public class PiicoWsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PiicoWsApplication.class, args);
		SuscribeMQTT suscribeMQTT = new SuscribeMQTT();
		suscribeMQTT.prueba();
	}

	

}
