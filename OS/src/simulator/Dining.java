package simulator;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

public class Dining {

	private JFrame frame;
	private JPanel contentPane;
	private Timer seconds;
	private int index = 0;
	private Random rand = new Random();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dining window = new Dining();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dining() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(101, 101, 619, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		contentPane.setBackground(Color.cyan);
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(101, 168, 101, 89);
		label.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\images.png"));
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(183, 323, 90, 89);
		label_1.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\images.png"));
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(257, 67, 97, 101);
		label_2.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\images.png"));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(445, 168, 97, 89);
		label_3.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\images.png"));
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(382, 323, 85, 89);
		label_4.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\images.png"));
		contentPane.add(label_4);
		
		
		JButton btnExit = new JButton("STOP DINING");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setBounds(398, 51, 190, 24);
		contentPane.add(btnExit);
		
		JLabel phil3 = new JLabel("THINKING ");
		phil3.setBounds(382, 423, 130, 30);
		contentPane.add(phil3);
		
		JLabel phil2 = new JLabel("THINKING ");
		phil2.setBounds(445, 266, 120, 24);
		contentPane.add(phil2);
		
		JLabel phil1 = new JLabel("THINKING ");
		phil1.setBounds(275, 168, 120, 30);
		contentPane.add(phil1);
		
		JLabel phil5 = new JLabel("THINKING ");
		phil5.setBounds(119, 266, 135, 24);
		contentPane.add(phil5);
		
		JLabel phil4 = new JLabel("THINKING ");
		phil4.setBounds(183, 423, 120, 24);
		contentPane.add(phil4);
		
		JLabel f1 = new JLabel("");
		f1.setBounds(382, 135, 25, 55);
		f1.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\fork.png"));
		contentPane.add(f1);
		
		JLabel f3 = new JLabel("");
		f3.setBounds(312, 383, 25, 55);
		f3.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\fork.png"));
		contentPane.add(f3);
		
		JLabel f4 = new JLabel("");
		f4.setBounds(129, 286, 25, 55);
		f4.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\fork.png"));
		contentPane.add(f4);
		
		JLabel f5 = new JLabel("");
		f5.setBounds(212, 135, 25, 55);
		f5.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\fork.png"));
		contentPane.add(f5);
		
		JLabel f2 = new JLabel("");
		f2.setBounds(487, 286, 25, 55);
		f2.setIcon(new ImageIcon("C:\\Users\\Subhadeep\\Desktop\\fork.png"));
		contentPane.add(f2);
		
		JLabel f[]={f1,f2,f3,f4,f5};
		JLabel stat[]={phil1,phil2,phil3,phil4,phil5};
		JButton button = new JButton("START DINING");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					index = rand.nextInt(5);
					ActionListener taskPerformer = new ActionListener() {
			        public void actionPerformed(ActionEvent evt) 
			        {
			        	try
			        	{
			        		for(JLabel x: stat)
							{
								x.setText("THINKING");
							}
			        		for(JLabel x: f)
			        		{
			        			x.setVisible(true);
			        		}
			        		f[(index+2)%5].setVisible(false);
			        		f[(index+3)%5].setVisible(false);
			        		index = (index+3)%5;
			        		stat[index].setText("EATING");
			        		f[(index+2)%5].setVisible(false);
			        		f[(index+3)%5].setVisible(false);
			        		index = (index+3)%5;
			        		stat[index].setText("EATING");
			        	}
			        	catch(Exception e)
			        	{
			        		seconds.stop();
			        	}
			        }
			        };
			        seconds = new javax.swing.Timer(3000, taskPerformer);
			        seconds.start();
			}
		});
		button.setBounds(37, 52, 190, 24);
		contentPane.add(button);
		
	}

}
