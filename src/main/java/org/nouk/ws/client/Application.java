package org.nouk.ws.client;

import org.nouk.ws.client.data.AutoIntervalListModel;
import org.nouk.ws.client.data.AutoListModel;
import org.nouk.ws.client.data.ConnectModel;
import org.nouk.ws.client.data.ManualListModel;
import org.nouk.ws.client.ui.App;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.io.File;


@SpringBootApplication
public class Application {
    @Bean
    public App app(ManualListModel manualListModel, AutoListModel autoListModel, ConnectModel connectModel, AutoIntervalListModel autoIntervalListModel){
        App app = new App(manualListModel,autoListModel,connectModel,autoIntervalListModel);
        app.setVisible(true);
        app.setLocationRelativeTo(null);
        String userDir = System.getProperty("user.dir");
        app.setTitle(userDir.substring(userDir.lastIndexOf(File.separator)+1));
        return app;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new SpringApplicationBuilder(Application.class)
                .headless(false).run(args);
    }

}