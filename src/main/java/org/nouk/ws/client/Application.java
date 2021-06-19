package org.nouk.ws.client;

import org.nouk.ws.client.ui.App;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;


@SpringBootApplication
public class Application {
    @Bean
    public App app(){
        App app = new App();
        app.setVisible(true);
        app.setLocationRelativeTo(null);
        app.setTitle("websocket-client");
        return app;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new SpringApplicationBuilder(Application.class)
                .headless(false).run(args);
    }

}