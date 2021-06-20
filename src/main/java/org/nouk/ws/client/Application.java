package org.nouk.ws.client;

import org.nouk.ws.client.data.AutoListModel;
import org.nouk.ws.client.data.ConnectModel;
import org.nouk.ws.client.data.ManualListModel;
import org.nouk.ws.client.ui.App;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;


@SpringBootApplication
public class Application {
    @Bean
    public App app(ManualListModel manualListModel, AutoListModel autoListModel, ConnectModel connectModel){
        App app = new App(manualListModel,autoListModel,connectModel);
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