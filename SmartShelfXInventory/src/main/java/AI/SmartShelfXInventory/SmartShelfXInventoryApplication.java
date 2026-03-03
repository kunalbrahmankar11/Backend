package AI.SmartShelfXInventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SmartShelfXInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartShelfXInventoryApplication.class, args);
	}

}
