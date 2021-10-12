package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SimulacionDeExamen extends JFrame {

	String Respuesta = "\nRespuestas correctas:\n1-¿Quién ganó el mundial de futbol del año 2010? España\n"
			+        "2-¿Comó se llama el jugador que ganó el balón de oro en el año 2006? Fabio Cannavaro\n"
			+        "3-¿Cuantós años duró el Cruz Azul sin ganar un título de liga? 23 años\n"
			+        "4-¿En qué país se realizó el mundial de 1930? Uruguay\n"
			+        "5-¿Que mundial quedó fuera México por el caso de los cachirules? Italia 1990";

	private JPanel contentPane;
	int Evaluacion = 0; int pregunta = 0;
	int [] resultado = new int [5];
	String [] Preguntas = {"1-¿Quién ganó el mundial de futbol del año 2010",   
	                      "2-¿Comó se llama el jugador que ganó el balón de oro en el año 2006?",
	                      "3-¿Cuantós años duró el Cruz Azul sin ganar un título de liga?",
	                      "4-¿En qué país se realizó el mundial de 1930?",
	                      "5-¿Que mundial quedó fuera México por el caso de los cachirules"};
	private JLabel lblPregunta;
	private JRadioButton rdbtnOpcion1;
	private JRadioButton rdbtnOpcion2;
	private JRadioButton rdbtnOpcion3;
	private JButton btnGuardar;
	
	public void CambioDeRespuestas()
	{
		switch(lblPregunta.getText())
		{
			case "1-¿Quién ganó el mundial de futbol del año 2010": 
				rdbtnOpcion1.setText("Brasil");
				rdbtnOpcion2.setText("España");
				rdbtnOpcion3.setText("Alemania");
                break;
			case  "2-¿Comó se llama el jugador que ganó el balón de oro en el año 2006?":
				rdbtnOpcion1.setText("Ronaldo Nazario");
				rdbtnOpcion2.setText("Zinedine Zidane");
				rdbtnOpcion3.setText("Fabio Cannavaro");
				break;
			case "3-¿Cuantós años duró el Cruz Azul sin ganar un título de liga?":
				rdbtnOpcion1.setText("23 años");
				rdbtnOpcion2.setText("30 años");
				rdbtnOpcion3.setText("25 años");
			    break;
			case  "4-¿En qué país se realizó el mundial de 1930?":
				rdbtnOpcion1.setText("Estados unidos");
				rdbtnOpcion2.setText("Uruguay");
				rdbtnOpcion3.setText("Brasil");
				break;
			case  "5-¿Que mundial quedó fuera México por el caso de los cachirules":
				rdbtnOpcion1.setText("Italia 1990");
				rdbtnOpcion2.setText("Korea Japón 2002");
				rdbtnOpcion3.setText("Estados Unidos 1994");
				break;
		}
	}
	public void GuardarRespuestas()
	{
		switch(lblPregunta.getText())
		{
			case "1-¿Quién ganó el mundial de futbol del año 2010": 
				if(rdbtnOpcion2.isSelected())
					{resultado[0] = 1;}
				else {resultado[0] = 0;}
                break;
			case  "2-¿Comó se llama el jugador que ganó el balón de oro en el año 2006?":
				if(rdbtnOpcion3.isSelected())
				{resultado[1] = 1;}
			else {resultado[1] = 0;}
				break;
			case "3-¿Cuantós años duró el Cruz Azul sin ganar un título de liga?":
				if(rdbtnOpcion1.isSelected())
				{resultado[2] = 1;}
			else {resultado[2] = 0;}
			    break;
			case  "4-¿En qué país se realizó el mundial de 1930?":
				if(rdbtnOpcion2.isSelected())
				{resultado[3] = 1;}
			else {resultado[3] = 0;}
				break;
			case  "5-¿Que mundial quedó fuera México por el caso de los cachirules":
				if(rdbtnOpcion1.isSelected())
				{resultado[4] = 1;}
			else {resultado[4] = 0;}
				break;
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulacionDeExamen frame = new SimulacionDeExamen();
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
	public SimulacionDeExamen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnSalir.setBounds(449, 227, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnEvaluar = new JButton("Evaluar");
		btnEvaluar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i = 0; i<5; i++)
				{if(resultado[i] == 1)
				{Evaluacion = Evaluacion + resultado[i];}}
				Evaluacion = Evaluacion * 2;
				JOptionPane.showMessageDialog(contentPane, "El resultado de su evaluación fue: " + Evaluacion + Respuesta);
			}
		});
		btnEvaluar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnEvaluar.setBounds(225, 227, 89, 23);
		contentPane.add(btnEvaluar);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pregunta == 4)
				{pregunta = 0;}
				else
				{ pregunta++; }
				lblPregunta.setText(Preguntas[pregunta]);
				CambioDeRespuestas();
			}
		});
		btnSiguiente.setBounds(117, 227, 89, 23);
		contentPane.add(btnSiguiente);
		
		JButton btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pregunta == 0)
				{pregunta = 4;}
				else 
				{pregunta--;}
				lblPregunta.setText(Preguntas[pregunta]);
				CambioDeRespuestas();
				}
		});
		btnAnterior.setBounds(10, 227, 89, 23);
		contentPane.add(btnAnterior);
		
		JLabel lblMensaje = new JLabel("Esta es la pregunta: ");
		lblMensaje.setBounds(10, 28, 145, 23);
		contentPane.add(lblMensaje);
		
		lblPregunta = new JLabel("");
		lblPregunta.setText(Preguntas[pregunta]);
		lblPregunta.setBounds(165, 30, 423, 19);
		contentPane.add(lblPregunta);
		
		rdbtnOpcion1 = new JRadioButton("");
		rdbtnOpcion1.setText("Brasil");
		rdbtnOpcion1.setBounds(19, 93, 109, 23);
		contentPane.add(rdbtnOpcion1);
		
		rdbtnOpcion2 = new JRadioButton("");
		rdbtnOpcion2.setText("España");
		rdbtnOpcion2.setBounds(19, 115, 206, 23);
		contentPane.add(rdbtnOpcion2);
		
		rdbtnOpcion3 = new JRadioButton("");
		rdbtnOpcion3.setText("Alemania");
		rdbtnOpcion3.setBounds(19, 141, 206, 23);
		contentPane.add(rdbtnOpcion3);
		
		ButtonGroup radOpciones = new ButtonGroup();
		radOpciones.add(rdbtnOpcion1);
		radOpciones.add(rdbtnOpcion2);
		radOpciones.add(rdbtnOpcion3);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GuardarRespuestas();
			}
		});
		btnGuardar.setBounds(334, 227, 89, 23);
		contentPane.add(btnGuardar);
	}
}
