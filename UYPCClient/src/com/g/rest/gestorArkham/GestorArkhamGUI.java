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

public class GestorArkhamGUI extends JFrame {

	private JPanel contentPane;

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
				
				try {
					BufferedImage myPicture = ImageIO.read(new File("planta0.jpeg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				picLabel.setIcon(new ImageIcon(myPicture));
				panel.repaint();
			}
		});
		panelButton.add(plantaB);
		
		JButton plantaP = new JButton("Planta Primera");
		plantaP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.remove(picLabel);
					try {
						BufferedImage myPicture = ImageIO.read(new File("planta1.jpeg"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				JLabel picLabel = new JLabel(new ImageIcon(myPicture));
				panel.add(picLabel, BorderLayout.CENTER);
				panel.repaint();
			}
		});
		panelButton.add(plantaP);
	}

}
