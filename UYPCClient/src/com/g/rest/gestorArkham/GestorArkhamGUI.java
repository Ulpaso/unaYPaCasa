package com.g.rest.gestorArkham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Random;

import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;


//TODO: Hacer bucle control de actualizacion controlar por un id que se actualiza


public class GestorArkhamGUI extends JFrame {

	private JPanel contentPane;
	
	//variables conexion
	private static ClientConfig config = new ClientConfig();
    private static Client client;
    private static WebTarget target;
    
	
	//estado puertas // true = abiertas; false = cerradas
	public static boolean dGuardias;
	public static boolean dCeldas;
	public static boolean dLaboratorio;
	public static boolean dTaller;
	public static boolean dJardin;
	public static boolean dEnfermeria;
	public static boolean dPuente;
	
	public static int nivHack = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		config.property(ClientProperties.CONNECT_TIMEOUT, 100000);
		config.property(ClientProperties.READ_TIMEOUT, 100000);
		
		client = ClientBuilder.newClient(config);
		
		target = client.target(getBaseURI("localhost:8080"));
		
		updateState();
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorArkhamGUI frame = new GestorArkhamGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void updateState() {
		// TODO Auto-generated method stub
		/*
		dCeldas = false;
		dLaboratorio = false;
		dTaller = false;
		dJardin = false;
		dEnfermeria = true;
		dPuente = false;*/
		String respuesta;
		respuesta = target.path("arkham").path("guardias").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if(respuesta.contentEquals("0")){
			dGuardias = true;
		} else{
			dGuardias = false;
		}
		System.out.println(respuesta);
		respuesta = target.path("arkham").path("celdas").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if(respuesta.contentEquals("0")){
			dCeldas = true;
		} else{
			dCeldas = false;
		}
		respuesta = target.path("arkham").path("laboratorio").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if(respuesta.contentEquals("0")){
			dLaboratorio = true;
		} else{
			dLaboratorio = false;
		}
		respuesta = target.path("arkham").path("taller").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if(respuesta.contentEquals("0")){
			dTaller = true;
		} else{
			dTaller = false;
		}
		respuesta = target.path("arkham").path("enfermeria").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if(respuesta.contentEquals("0")){
			dEnfermeria = true;
		} else{
			dEnfermeria = false;
		}
		respuesta = target.path("arkham").path("jardin").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if(respuesta.contentEquals("0")){
			dJardin = true;
		} else{
			dJardin = false;
		}
		respuesta = target.path("arkham").path("puente").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		if(respuesta.contentEquals("0")){
			dPuente = true;
		} else{
			dPuente = false;
		}
		
		respuesta = target.path("arkham").path("estado").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		
		nivHack = Integer.parseInt(respuesta);
		System.out.println(nivHack);
		
		
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public GestorArkhamGUI() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1644, 872);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		BufferedImage myPicture = ImageIO.read(new File("planta1.jpeg"));
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		contentPane.add(panel);
		
		panel.setLayout(new BorderLayout(0, 0));
		
		
		panel.add(picLabel, BorderLayout.CENTER);
		JPanel panelButton = new JPanel();
		contentPane.add(panelButton, BorderLayout.WEST);
		panelButton.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton plantaB = new JButton("Planta Baja");
		plantaB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.removeAll();
				try {
					BufferedImage myPicture0 = ImageIO.read(new File("planta0.jpeg"));
					JLabel picLabel0 = new JLabel(new ImageIcon(myPicture0));
					panel.add(picLabel0, BorderLayout.CENTER);
					panel.repaint();
					panel.revalidate();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		panelButton.add(plantaB);
		
		JButton plantaP = new JButton("Planta Primera");
		plantaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
					try {
						BufferedImage myPicture1 = ImageIO.read(new File("planta1.jpeg"));
						JLabel picLabel1 = new JLabel(new ImageIcon(myPicture1));
						panel.add(picLabel1, BorderLayout.CENTER);
						panel.repaint();
						panel.revalidate();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}
		});
		panelButton.add(plantaP);
		
		////////////////////////////////////////////////////////////////////////////
		//*****************puertas***************************************************//
		/*dGuardias = true;
		dCeldas = false;
		dLaboratorio = false;
		dTaller = false;
		dJardin = false;
		dEnfermeria = true;
		dPuente = false;*/
		
		
		JPanel panelDoors = new JPanel();
		panelButton.add(panelDoors);
		panelDoors.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnGuardias = new JButton("Guardias");
		btnGuardias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					Random rand = new Random();

				    int randomNum = rand.nextInt((5 - 1) + 1) + 1;
System.out.println(randomNum);
				    for(int i=0;i<randomNum;i++){
					try {
						inJoker dialog = new inJoker();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				    }
				}else {
					if(dGuardias){
						dGuardias = false;
					}else{
						dGuardias = true;
					}
					if (dGuardias) btnGuardias.setBackground(Color.GREEN);
					else btnGuardias.setBackground(Color.RED);
				}
			}
		});
		if (dGuardias) btnGuardias.setBackground(Color.GREEN);
		else btnGuardias.setBackground(Color.RED);
		panelDoors.add(btnGuardias);
		
		JButton btnCeldas = new JButton("Celdas");
		btnCeldas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					Random rand = new Random();

					int randomNum = rand.nextInt((5 - 1) + 1) + 1;
				    for(int i=0;i<randomNum;i++){
					try {
						inJoker dialog = new inJoker();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				    }
				}else {
					if(dCeldas){
						dCeldas = false;
					}else{
						dCeldas = true;
					}
					if (dCeldas) btnCeldas.setBackground(Color.GREEN);
					else btnCeldas.setBackground(Color.RED);
				}
			}
		});
		if (dCeldas) btnCeldas.setBackground(Color.GREEN);
		else btnCeldas.setBackground(Color.RED);
		panelDoors.add(btnCeldas);
		
		JButton btnLaboratorio = new JButton("Laboratorio");
		btnLaboratorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					Random rand = new Random();

					int randomNum = rand.nextInt((5 - 1) + 1) + 1;
				    for(int i=0;i<randomNum;i++){
					try {
						inJoker dialog = new inJoker();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				    }
				}else {
					if(dLaboratorio){
						dLaboratorio = false;
					}else{
						dLaboratorio = true;
					}
					if (dLaboratorio) btnLaboratorio.setBackground(Color.GREEN);
					else btnLaboratorio.setBackground(Color.RED);
				}
			}
		});
		if (dLaboratorio) btnLaboratorio.setBackground(Color.GREEN);
		else btnLaboratorio.setBackground(Color.RED);
		panelDoors.add(btnLaboratorio);
		
		JButton btnTaller = new JButton("Taller");
		btnTaller.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					Random rand = new Random();

					int randomNum = rand.nextInt((5 - 1) + 1) + 1;
				    for(int i=0;i<randomNum;i++){
					try {
						inJoker dialog = new inJoker();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				    }
				}else {
					if(dTaller){
						dTaller = false;
					}else{
						dTaller = true;
					}
					if (dTaller) btnTaller.setBackground(Color.GREEN);
					else btnTaller.setBackground(Color.RED);
				}
			}
		});
		if (dTaller) btnTaller.setBackground(Color.GREEN);
		else btnTaller.setBackground(Color.RED);
		panelDoors.add(btnTaller);
		
		JButton btnJardin = new JButton("Jardin");
		btnJardin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					Random rand = new Random();

					int randomNum = rand.nextInt((5 - 1) + 1) + 1;
				    for(int i=0;i<randomNum;i++){
					try {
						inJoker dialog = new inJoker();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				    }
				}else {
					if(dJardin){
						dJardin = false;
					}else{
						dJardin = true;
					}
					if (dJardin) btnJardin.setBackground(Color.GREEN);
					else btnJardin.setBackground(Color.RED);
				}
			}
		});
		if (dJardin) btnJardin.setBackground(Color.GREEN);
		else btnJardin.setBackground(Color.RED);
		panelDoors.add(btnJardin);
		
		JButton btnEnfermera = new JButton("Enfermer\u00EDa");
		btnEnfermera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					Random rand = new Random();

					int randomNum = rand.nextInt((5 - 1) + 1) + 1;
				    for(int i=0;i<randomNum;i++){
					try {
						inJoker dialog = new inJoker();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				    }
				}else {
					if(dEnfermeria){
						dEnfermeria = false;
					}else{
						dEnfermeria = true;
					}
					if (dEnfermeria) btnEnfermera.setBackground(Color.GREEN);
					else btnEnfermera.setBackground(Color.RED);
				}
			}
		});
		if (dEnfermeria) btnEnfermera.setBackground(Color.GREEN);
		else btnEnfermera.setBackground(Color.RED);
		panelDoors.add(btnEnfermera);
		
		JButton btnPuente = new JButton("Puente");
		btnPuente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					//TODO Parte puente
					passJoker frame = new passJoker();
					frame.setVisible(true);
				
			}else {
				if(dPuente){
					dPuente = false;
				}else{
					dPuente = true;
				}
				if (dPuente) btnPuente.setBackground(Color.GREEN);
				else btnPuente.setBackground(Color.RED);
			}
			}
		});
		if (dPuente) btnPuente.setBackground(Color.GREEN);
		else btnPuente.setBackground(Color.RED);
		panelDoors.add(btnPuente);
	}

	private static URI getBaseURI(String ip) { // Pasar por argumento
	    return UriBuilder.fromUri("http://"+ ip + "/UYPCServer").build();
	}
}
