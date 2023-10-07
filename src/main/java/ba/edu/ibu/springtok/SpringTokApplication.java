package ba.edu.ibu.springtok;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringTokApplication {

    /* Right */
    public static void main(String[] args) {
        // SpringApplication.run(SpringTokApplication.class, args);

        // Container that manages DI, configuration of all classes we say Spring we care about
        ConfigurableApplicationContext app = SpringApplication.run(SpringTokApplication.class, args);

        // Let us see which beans are managed by the Spring
        Arrays.stream(app.getBeanDefinitionNames()).forEach(System.out::println);
    }

    // Method level annotation, if the method will return us a Java object
    // This will be managed by the Spring because of the @Bean annotation
    @Bean
    public CommandLineRunner commandLineRunner(){
        // Lambda function
        return args -> {
            System.out.println("Hello from the command line runner");
        };
    }

    /* Wrong
    public static void main(String[] args) {
        var videoRepository = new VideoRepository();
        var controller = new VideoController(videoRepository); // What  if it depends of another class

        System.out.println(controller.next());
        SpringApplication.run(SpringTokApplication.class, args);
    }
    */
}
