package song.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ToolApplication {


    public static void main(String[] args) {
        SpringApplication.run(ToolApplication.class, args);
    }

}
