// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Main;

import Controller.App.ControllerApp;
import Controller.Login.LoginUIController;
import Controller.UIClient.UIClientController;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        try{
            //MotifLookAndFeel
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.Windows");
        } catch(Exception e){
            System.out.println(e);
        }

        LoginUIController loginUIController = new LoginUIController();
        UIClientController uiClientController = new UIClientController();

        //Controlador general de la cuenta
        ControllerApp controllerApp = new ControllerApp();
        //Controlador del Login
        controllerApp.setControllerUILogin(loginUIController);
        //Controlador de la UI del cliente
        controllerApp.setControllerUIClient(uiClientController);

        //Iniciar aplicacion
        controllerApp.loginApp();

    }

}
