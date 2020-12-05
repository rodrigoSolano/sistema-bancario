// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package Controller.App;

import Controller.Login.LoginUIController;
import Controller.UIClient.UIClientController;
import Model.cuentas.Cuenta;
import UI.LoginUI;
import UI.UIClient;

public class ControllerApp {

    private UIClientController controllerUIClient;
    private LoginUIController controllerUILogin;
    private LoginUI loginUI;
    private UIClient clientGUI;

    //Inica la aplicacion creando una ventana de login y le asigna su controlador
    public void loginApp() {
        loginUI = new LoginUI(controllerUILogin);
        controllerUILogin.setUI(loginUI);
        controllerUILogin.setControllerApp(this);
    }

    //Inicia la interfaz de usuario para interactuar con el cliente y realizar operaciones sobre su cuenta
    public void startApp(Cuenta cuenta) {

        controllerUIClient = new UIClientController();
        clientGUI = new UIClient(cuenta, controllerUIClient);
        controllerUIClient.setControllerApp(this);
        controllerUIClient.setUiCliente(clientGUI);
        clientGUI.updateGUI();
    }

    public void logOut() {

        clientGUI = null;
        loginApp();

    }

    public void setControllerUIClient(UIClientController controllerUIClient) {
        this.controllerUIClient = controllerUIClient;
    }

    public void setControllerUILogin(LoginUIController controllerUILogin) {
        this.controllerUILogin = controllerUILogin;
    }
}
