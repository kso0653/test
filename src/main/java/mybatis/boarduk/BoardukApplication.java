package mybatis.boarduk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"mybatis.boarduk.controller"})
@SpringBootApplication
public class BoardukApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardukApplication.class, args);
	}

}
