package tema8_ejercicio2;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Tema8_ejercicio2 {

	private JFrame frame;
	private JFrame frame_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tema8_ejercicio2 window = new Tema8_ejercicio2();
					window.frame_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		
		});
	}

	/**
	 * Create the application.
	 */
	public Tema8_ejercicio2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 483);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(380, 100, 174, 24);
		frame.getContentPane().add(comboBox_1);
		frame_1 = new JFrame();
		frame_1.setBounds(100, 100, 704, 483);
		frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame_1.getContentPane().setLayout(null);
		JComboBox comboBoxCA = new JComboBox();
		
		JComboBox comboBoxPO = new JComboBox();
		comboBoxPO.setBounds(386, 100, 153, 24);
		frame_1.getContentPane().add(comboBoxPO);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(408, 73, 132, 15);
		frame_1.getContentPane().add(lblProvincia);
		
		JLabel lblComunidadAutonoma = new JLabel("Comunidad autonoma");
		lblComunidadAutonoma.setBounds(74, 73, 174, 15);
		frame_1.getContentPane().add(lblComunidadAutonoma);
		
		comboBoxCA.setBounds(84, 100, 165, 24);
		frame_1.getContentPane().add(comboBoxCA);
		String url = "jdbc:mysql://127.0.0.1:3307/provincias";
		String user = "alumno";
		String password = "alumno";
		
		Scanner s= new Scanner(System.in);
		
		

		comboBoxCA.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					String url = "jdbc:mysql://127.0.0.1:3307/provincias";
					String user = "alumno";
					String password = "alumno";
					String nombre;
					Connection con=ConnectionSingleton.getConnection();
					
					PreparedStatement stmt = con.prepareStatement("SELECT * FROM provincia WHERE comunidad_idc=?");
					stmt.setInt(1,  comboBoxCA.getSelectedIndex() + 1);
					ResultSet rs = stmt.executeQuery();
					comboBoxPO.removeAllItems();
					
					 while(rs.next())
					 {
					 nombre=rs.getString("nomp");
					 comboBoxPO.addItem(nombre);
					 }
					 rs.close();
					 stmt.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			}
		
			
		});
		
		
			
				
		
	
		try {
			String nombre;
			Connection con=ConnectionSingleton.getConnection();
			Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM comunidad");
			 
				comboBoxCA.removeAllItems();
				
			 while(rs.next())
			 {
			 nombre=rs.getString("nomc");
			 comboBoxCA.addItem(nombre);
			 }
			 rs.close();
			 stmt.close();
			 con.close();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		
		

		
		comboBoxCA.setBounds(84, 100, 165, 24);
		
		
		
		
		
		
		
	
	
	}
	
	
}

