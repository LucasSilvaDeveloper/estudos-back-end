package projeto.academia;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationAcademia {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationAcademia.class, args);
        System.out.println("Aplicação rodando com a imagem DOCKER");
    }

}
