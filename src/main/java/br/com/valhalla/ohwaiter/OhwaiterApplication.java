package br.com.valhalla.ohwaiter;

//mport org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class OhwaiterApplication {

	public static void main(String[] args) {
		SpringApplication.run(OhwaiterApplication.class, args);
	}

}
