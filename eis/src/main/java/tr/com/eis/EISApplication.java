package tr.com.eis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class EISApplication { 
	public static void main(String[] args) { 
        SpringApplication.run(EISApplication.class, args);
	}

}
