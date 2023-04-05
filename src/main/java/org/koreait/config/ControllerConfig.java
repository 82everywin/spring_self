package org.koreait.config;

import lombok.experimental.WithBy;
import org.koreait.controllers.BasicController;
import org.koreait.controllers.member.LoginController;
import org.springframework.context.annotation.Bean;

public class ControllerConfig {

    @Bean
    public BasicController basicController() {
        return new BasicController();
    }

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }

}
