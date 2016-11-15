package com.g.rest.gestorArkham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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


//TODO: Hacer bucle control de actualizacion controlar por un id que se actualiza


public class GestorArkhamGUI extends JFrame {

	private JPanel contentPane;
	
	
	
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
		dGuardias = true;
		dCeldas = false;
		dLaboratorio = false;
		dTaller = false;
		dJardin = false;
		dEnfermeria = true;
		dPuente = false;
		
		
		JPanel panelDoors = new JPanel();
		panelButton.add(panelDoors);
		panelDoors.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnGuardias = new JButton("Guardias");
		btnGuardias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(nivHack > 0){
					//
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
		if (dCeldas) btnCeldas.setBackground(Color.GREEN);
		else btnCeldas.setBackground(Color.RED);
		panelDoors.add(btnCeldas);
		
		JButton btnLaboratorio = new JButton("Laboratorio");
		if (dLaboratorio) btnLaboratorio.setBackground(Color.GREEN);
		else btnLaboratorio.setBackground(Color.RED);
		panelDoors.add(btnLaboratorio);
		
		JButton btnTaller = new JButton("Taller");
		if (dTaller) btnTaller.setBackground(Color.GREEN);
		else btnTaller.setBackground(Color.RED);
		panelDoors.add(btnTaller);
		
		JButton btnJardin = new JButton("Jardin");
		if (dJardin) btnJardin.setBackground(Color.GREEN);
		else btnJardin.setBackground(Color.RED);
		panelDoors.add(btnJardin);
		
		JButton btnEnfermera = new JButton("Enfermer\u00EDa");
		if (dEnfermeria) btnEnfermera.setBackground(Color.GREEN);
		else btnEnfermera.setBackground(Color.RED);
		panelDoors.add(btnEnfermera);
		
		JButton btnPuente = new JButton("Puente");
		if (dPuente) btnPuente.setBackground(Color.GREEN);
		else btnPuente.setBackground(Color.RED);
		panelDoors.add(btnPuente);
	}


}
