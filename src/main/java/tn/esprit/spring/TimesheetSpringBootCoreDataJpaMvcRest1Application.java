package tn.esprit.spring;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TimesheetSpringBootCoreDataJpaMvcRest1Application {
	private static final Logger logger = LogManager.getLogger(TimesheetSpringBootCoreDataJpaMvcRest1Application.class);
	
	


	public static void main(String[] args) {
		SpringApplication.run(TimesheetSpringBootCoreDataJpaMvcRest1Application.class, args);
		logger.info("started ... ///");
		
	}

}
