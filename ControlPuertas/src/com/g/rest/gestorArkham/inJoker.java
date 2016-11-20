package com.g.rest.gestorArkham;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class inJoker extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			inJoker dialog = new inJoker();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public inJoker() {
		setResizable(false);
		Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((700 - 250) + 1) + 250;
		//System.out.println(randomNum);
		setBounds(randomNum, randomNum, 453, 302);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblHahahaNoHas = new JLabel("HaHaHa, no has dicho la palabra m\u00E1gica");
			contentPanel.add(lblHahahaNoHas);
		}
		{
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("the_joker_arkham_asylum_by_baneparkour.jpg"));
			} catch (IOException e) {
			    e.printStackTrace();
			}
			Image dimg =  img.getScaledInstance(200, 300,
			        Image.SCALE_SMOOTH);
			JLabel imageLabel = new JLabel(new ImageIcon(dimg));
			contentPanel.add(imageLabel, BorderLayout.EAST);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
