package sparta.project.realboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class RealboardApplication{

    public static void main(String[] args) {
        SpringApplication.run(RealboardApplication.class, args);
        System.out.println("확인~~");
    }

}
