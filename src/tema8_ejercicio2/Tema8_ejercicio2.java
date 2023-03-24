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
		JComboBox comboBox = new JComboBox();
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(386, 100, 153, 24);
		frame_1.getContentPane().add(comboBox_2);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String url = "jdbc:mysql://127.0.0.1:3307/provincias";
					String user = "alumno";
					String password = "alumno";
					String nombre;
					Connection con = DriverManager.getConnection(url, user, password);
					Statement stmt = con.createStatement();
					PreparedStatement sel_pstmt = con.prepareStatement("SELECT nomp FROM provincia WHERE comunidad_id=?");
					sel_pstmt.setInt(1, 1);
					ResultSet rs_sel = sel_pstmt.executeQuery();
					 while(rs_sel.next())
					 {
					 nombre=rs_sel.getString("nomp");
					 comboBox_2.addItem(nombre);
					 }
					 rs_sel.close();
					 stmt.close();
					 con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			}
		});
		
		comboBox.setBounds(84, 100, 165, 24);
		frame_1.getContentPane().add(comboBox);
		String url = "jdbc:mysql://127.0.0.1:3307/provincias";
		String user = "alumno";
		String password = "alumno";
		
		Scanner s= new Scanner(System.in);
		
		try {
			String nombre;
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery("SELECT * FROM comunidad");
			 while(rs.next())
			 {
			 nombre=rs.getString("nomc");
			 comboBox.addItem(nombre);
			 }
			 rs.close();
			 stmt.close();
			 con.close();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		
		

		
		comboBox.setBounds(84, 100, 165, 24);
		
		
		
		
		
		
		
	
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(408, 73, 132, 15);
		frame_1.getContentPane().add(lblProvincia);
		
		JLabel lblComunidadAutonoma = new JLabel("Comunidad autonoma");
		lblComunidadAutonoma.setBounds(74, 73, 174, 15);
		frame_1.getContentPane().add(lblComunidadAutonoma);
		
	
	}
	
	
}

