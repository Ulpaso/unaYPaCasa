package com.g.rest.gestorArkham;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class passJoker extends JFrame {

	//variables conexion
	private static ClientConfig config = new ClientConfig();
    private static Client client;
    private static WebTarget target;
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String pass = "hola";
	private String pass1 = "hola1";
	private String pass2 = "hola2";
	private String pass3 = "hola3";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					passJoker frame = new passJoker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public passJoker() {
		config.property(ClientProperties.CONNECT_TIMEOUT, 100000);
		config.property(ClientProperties.READ_TIMEOUT, 100000);
		
		client = ClientBuilder.newClient(config);
		
		target = client.target(getBaseURI("localhost:8080"));
		
		//setDefaultCloseOperation();
		setBounds(200, 600, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscapa = new JLabel("Escapa!!!!");
		lblEscapa.setBounds(182, 97, 86, 14);
		contentPane.add(lblEscapa);
		
		textField = new JTextField();
		textField.setBounds(18, 159, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(114, 159, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 159, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(306, 159, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAceptar = new JButton("JAJaja...");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println(textField.getText());
				if (textField.getText().contentEquals(pass) & textField_1.getText().contentEquals(pass1) & textField_2.getText().contentEquals(pass2) & textField_3.getText().contentEquals(pass3)){
					String respuesta;
					respuesta = target.path("arkham").path("joker").request().accept(MediaType.TEXT_PLAIN).get(String.class);
					System.out.println(respuesta);
					
				}
				dispose();
			}
		});
		btnAceptar.setBounds(303, 212, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	private static URI getBaseURI(String ip) { // Pasar por argumento
	    return UriBuilder.fromUri("http://"+ ip + "/UYPCServer").build();
	}
}
