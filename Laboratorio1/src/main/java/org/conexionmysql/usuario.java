package org.conexionmysql;

import com.formdev.flatlaf.FlatDarkLaf;
import controller.UsuarioController;
import view.ConsoleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class usuario {
    private JPanel panel1;
    private JTextField textUsuario;
    private JButton registrarUsuarioButton;
    private JLabel UsuarioLabel;
    private JLabel CorreoLabel;
    private JLabel ContrasennaLabel;
    private JPasswordField textContrasenna;
    private JTextField textCorreo;
    private JTextField textCedula;
    private JTextField textApellido;
    private JLabel ApellidoLabel;
    private JLabel CedulaLabel;
    private JLabel telefonoLabel;
    private JTextField textTelefono;
    ConsoleView consoleView = new ConsoleView();
    UsuarioController usuarioController = new UsuarioController(consoleView);

    public usuario() {
        FlatDarkLaf.setup();

        panel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        Font font = new Font("Arial", Font.PLAIN, 16);

        UsuarioLabel = new JLabel("Nombre:");
        UsuarioLabel.setFont(font);
        textUsuario = new JTextField(15);
        textUsuario.setFont(font);
        textUsuario.setPreferredSize(new Dimension(200, 30));

        ApellidoLabel = new JLabel("Apellido:");
        ApellidoLabel.setFont(font);
        textApellido = new JTextField(15);
        textApellido.setFont(font);
        textApellido.setPreferredSize(new Dimension(200, 30));

        CorreoLabel = new JLabel("Correo:");
        CorreoLabel.setFont(font);
        textCorreo = new JTextField(15);
        textCorreo.setFont(font);
        textCorreo.setPreferredSize(new Dimension(200, 30));

        CedulaLabel = new JLabel("Cédula:");
        CedulaLabel.setFont(font);
        textCedula = new JTextField(15);
        textCedula.setFont(font);
        textCedula.setPreferredSize(new Dimension(200, 30));

        telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setFont(font);
        textTelefono = new JTextField(15);
        textTelefono.setFont(font);
        textTelefono.setPreferredSize(new Dimension(200, 30));

        ContrasennaLabel = new JLabel("Contraseña:");
        ContrasennaLabel.setFont(font);
        textContrasenna = new JPasswordField(15);
        textContrasenna.setFont(font);
        textContrasenna.setPreferredSize(new Dimension(200, 30));

        registrarUsuarioButton = new JButton("Registrar");
        registrarUsuarioButton.setFont(font);
        registrarUsuarioButton.setPreferredSize(new Dimension(200, 40));

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(UsuarioLabel, gbc);

        gbc.gridx = 1;
        panel1.add(textUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(ApellidoLabel, gbc);

        gbc.gridx = 1;
        panel1.add(textApellido, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(CorreoLabel, gbc);

        gbc.gridx = 1;
        panel1.add(textCorreo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(CedulaLabel, gbc);

        gbc.gridx = 1;
        panel1.add(textCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel1.add(telefonoLabel, gbc);

        gbc.gridx = 1;
        panel1.add(textTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel1.add(ContrasennaLabel, gbc);

        gbc.gridx = 1;
        panel1.add(textContrasenna, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        panel1.add(registrarUsuarioButton, gbc);

        registrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUsuario();
            }
        });
    }

    private void registerUsuario() {
        String usuario = textUsuario.getText();
        String contrasenna = new String(textContrasenna.getPassword());
        String correo = textCorreo.getText();
        String cedula = textCedula.getText();
        String apellido = textApellido.getText();
        String telefonoStr = textTelefono.getText().trim();

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de texto de usuario está vacío");
            return;
        } else if (contrasenna.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de texto de contraseña está vacío");
            return;
        } else if (correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de texto de correo está vacío");
            return;
        } else if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo de la cedula está vacío");
            return;
        } else if (apellido.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo del apellido está vacío");
            return;
        } else if (telefonoStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo del telefono está vacío");
            return;
        }


        int telefono;
        try {
            telefono = Integer.parseInt(telefonoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo del telefono debe ser un número válido");
            return;
        }


        usuarioController.agregarUsuario(apellido, cedula, usuario, correo, telefono, contrasenna);
        JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
    }

    public static void main(String[] args) {

        FlatDarkLaf.setup();

        JFrame frame = new JFrame("Registro usuarios");
        frame.setContentPane(new usuario().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setVisible(true);
    }
}
