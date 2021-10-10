package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableStringConverter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SerieNumeros extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JList ListaDeSerie = new JList();
	DefaultListModel<String> modelo = new DefaultListModel<>(); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerieNumeros frame = new SerieNumeros();
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
	public SerieNumeros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("Ingrese un n\u00FAmero mayor a 0");
		lblMensaje.setBounds(10, 42, 207, 14);
		contentPane.add(lblMensaje);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(227, 39, 119, 23);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnMostrarSerie = new JButton("Imprimir Serie");
		btnMostrarSerie.addMouseListener(new MouseAdapter() {
		});
		 btnMostrarSerie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				 int i = 0; int N1 = 1; int N2 = 2; int suma = 0; int ciclo=0;
				 ciclo = Integer.parseInt(txtNumero.getText());
			     String [] resultado = new String [ciclo];
			       
			        while(i<ciclo)
			        {
			        suma = N1+N2;
			        String x = (N1 + " + " + N2 + " = " + suma).toString(); 
			        resultado[i] = x;
			        ListaDeSerie.setModel(modelo);
					modelo.addElement(resultado[i]);
					txtNumero.setText("");
			        N1 = N2; 
			        N2 = suma;
			        i++;
			        }
			}
		});
		btnMostrarSerie.setBounds(284, 109, 119, 23);
		contentPane.add(btnMostrarSerie);
		
		ListaDeSerie.setBounds(10, 74, 182, 176);
		contentPane.add(ListaDeSerie);
		
		JButton btnBorrar = new JButton("Borrar serie");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int eliminar = ListaDeSerie.getSelectedIndex();
				modelo.removeAllElements();
			}
		});
		btnBorrar.setBounds(284, 156, 119, 23);
		contentPane.add(btnBorrar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(284, 202, 119, 23);
		contentPane.add(btnSalir);
	
		
	}
}
