package org.koreait.config;

import org.koreait.controllers.BasicController;
import org.koreait.controllers.members.LoginController;
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
