package com.example.jogos;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.example.jogos.config.RsaKeyProperties;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class JogosApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JogosApiApplication.class, args);
	}

	@Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
