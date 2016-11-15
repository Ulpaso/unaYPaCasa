package com.g.rest.gestorArkham;

import java.awt.BorderLayout;
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

public class GestorArkhamGUI extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

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
		
		JPanel panelDoors = new JPanel();
		panelButton.add(panelDoors);
		panelDoors.setLayout(new GridLayout(0, 1, 0, 0));
		
		JToggleButton tglbtnGuardias = new JToggleButton("Guardias");
		panelDoors.add(tglbtnGuardias);
		
		JToggleButton tglbtnCeldas = new JToggleButton("Celdas");
		panelDoors.add(tglbtnCeldas);
		
		JToggleButton tglbtnEnfermeria = new JToggleButton("Enfermeria");
		panelDoors.add(tglbtnEnfermeria);
		
		JToggleButton tglbtnLaboratorio = new JToggleButton("Laboratorio");
		panelDoors.add(tglbtnLaboratorio);
		
		JToggleButton tglbtnPuente = new JToggleButton("Puente");
		panelDoors.add(tglbtnPuente);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
