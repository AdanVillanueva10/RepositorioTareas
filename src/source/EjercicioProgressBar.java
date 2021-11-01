package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjercicioProgressBar extends JFrame {

	private JPanel contentPane;
	public static JProgressBar progressBar;
	private JLabel lblMensajeDeCarga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioProgressBar frame = new EjercicioProgressBar();
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
	public EjercicioProgressBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(Color.YELLOW);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			lblMensajeDeCarga.setText("");
			Random numAleatorio = new Random();
			int progreso=0;
			progressBar.setValue(0);
			Trabajo miTrabajo = new Trabajo();
			Thread miHilo = new Thread(miTrabajo);
			
			miHilo.start();
			while(progreso<=100)
			{
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					miHilo.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				progreso += numAleatorio.nextInt(5)+1;
				progressBar.setValue(progreso);	
		     }
				lblMensajeDeCarga.setText("La carga a sido completada");
			}
		});
		btnIniciar.setFont(new Font("SimSun", Font.PLAIN, 16));
		btnIniciar.setBounds(30, 270, 100, 32);
		contentPane.add(btnIniciar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(Color.YELLOW);
		btnSalir.setForeground(Color.BLACK);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnSalir.setFont(new Font("SimSun", Font.PLAIN, 16));
		btnSalir.setBounds(151, 270, 100, 32);
		contentPane.add(btnSalir);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("");
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setForeground(new Color(0, 255, 255));
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		progressBar.setBounds(44, 128, 421, 32);
		contentPane.add(progressBar);
		
		lblMensajeDeCarga = new JLabel("");
		lblMensajeDeCarga.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblMensajeDeCarga.setForeground(Color.GRAY);
		lblMensajeDeCarga.setBounds(84, 46, 291, 32);
		contentPane.add(lblMensajeDeCarga);
	}
}
