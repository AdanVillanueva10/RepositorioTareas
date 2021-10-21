package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RevisarExpresion extends JFrame {

	private JPanel contentPane;
	private JTextField txtExpresion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RevisarExpresion frame = new RevisarExpresion();
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
	public RevisarExpresion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("Ingrese una expresi\u00F3n matematica");
		lblMensaje.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 13));
		lblMensaje.setBounds(43, 24, 271, 33);
		contentPane.add(lblMensaje);
		
		txtExpresion = new JTextField();
		txtExpresion.setBounds(42, 68, 272, 33);
		contentPane.add(txtExpresion);
		txtExpresion.setColumns(10);
		
		JButton btnRevisarExpresion = new JButton("Revisar Expresion");
		btnRevisarExpresion.setBackground(Color.GREEN);
		btnRevisarExpresion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Stack<Character> pilaExpresion = new Stack<Character>();
				Character IngresarExp;
				String expresion = txtExpresion.getText();
				boolean bandera = true;

				for(int i = 0; i<expresion.length(); i++)
				{
				IngresarExp = expresion.charAt(i);
				if(IngresarExp == '(') { pilaExpresion.push(IngresarExp); }
				if(IngresarExp == ')') 
				{ 
					if(pilaExpresion.empty()) 
					{  bandera = false; break;  }  
					else { pilaExpresion.pop(); }
				}
				}
				
				if(pilaExpresion.empty() && bandera)
				{JOptionPane.showMessageDialog(contentPane, "La expresión que ingresó es correcta." );}
				else {JOptionPane.showMessageDialog(contentPane, "La expresión que ingresó es incorrecta." );}
				
			}
		});
		btnRevisarExpresion.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 11));
		btnRevisarExpresion.setBounds(43, 132, 160, 38);
		contentPane.add(btnRevisarExpresion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.GREEN);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 11));
		btnSalir.setBounds(43, 194, 160, 38);
		contentPane.add(btnSalir);
	}
}
