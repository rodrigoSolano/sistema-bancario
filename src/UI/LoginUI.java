// This is a personal academic project. Dear PVS-Studio, please check it.

// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: http://www.viva64.com
package UI;

import Controller.Login.LoginUIController;
import Model.components.MotionPanel;
import Model.components.PlaceholderTextField;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    /**
     * Atributos de la clase
     */
    private  final LoginUIController controller;

    /**
     * Atributos del Frame
     */
    private final Dimension size_frame = new Dimension(300, 350);
    private JTextField numeroCuentaField;
    private JPasswordField nipField;
    private JPanel Panel;
    private JLabel imageBank;
    private JLabel imageCuenta;
    private JButton exitButton;
    private JButton loginButton;
    private JButton buttonCerrar;
    private JButton buttonMinimizar;
    private JPanel panelButton;
    private JPanel panelMoved;
    private JLabel labelMover;

    public LoginUI(LoginUIController loginUIController) {
        super("Login");
        setUndecorated(true);
        setSize(size_frame);
        setContentPane(Panel);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setStyles();

        this.controller = loginUIController;
        exitButton.addActionListener(this.controller);
        loginButton.addActionListener(this.controller);
        exitButton.setActionCommand("exit");
        loginButton.setActionCommand("login");
        buttonCerrar.addActionListener(controller);
        buttonCerrar.setActionCommand("exit");

        buttonMinimizar.addActionListener(controller);
        buttonMinimizar.setActionCommand("minimizar");
    }

    private void setStyles() {
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/login.png"));
        setIconImage(image);
    }

    public JTextField getNumeroCuentaField() {
        return numeroCuentaField;
    }

    public JPasswordField getNipField() {
        return nipField;
    }

    private void createUIComponents() {
        final PlaceholderTextField numeroCuentaField = new PlaceholderTextField();
        numeroCuentaField.setPlaceholder("numero cuenta");
        this.numeroCuentaField = numeroCuentaField;
        panelMoved = new MotionPanel(this);
        buttonCerrar = new JButton("");
        buttonMinimizar = new JButton("");
        buttonCerrar.setBorder(null);
        buttonMinimizar.setBorder(null);
        buttonCerrar.setContentAreaFilled(false);
        buttonCerrar.setBorderPainted(false);
    }
}
