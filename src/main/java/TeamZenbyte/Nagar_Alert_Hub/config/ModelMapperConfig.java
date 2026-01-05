package TeamZenbyte.Nagar_Alert_Hub.config;

import TeamZenbyte.Nagar_Alert_Hub.util.Priorty_determiner;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public Priorty_determiner priorty_determiner(){
        return new Priorty_determiner();
    }
}

