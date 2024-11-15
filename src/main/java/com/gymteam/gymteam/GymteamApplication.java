package com.gymteam.gymteam;

import javax.swing.SwingUtilities;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import com.gymteam.gymteam.controladores.TrabajadorController;

@SpringBootApplication
public class GymteamApplication {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(GymteamApplication.class)
            .headless(false)
            .run(args);

        TrabajadorController trabajadorController = context.getBean(TrabajadorController.class);

        SwingUtilities.invokeLater(() -> {
            AdminWindow adminWindow = new AdminWindow(trabajadorController);
            adminWindow.setVisible(true);
        });
    }
}

