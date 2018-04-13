package simulator;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.util.*;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
public class Simulator {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JPanel panel_1;
	private JLabel lblSchedulingAlgorithms;
	private JPanel panel_2;
	public static JRadioButton rdbtnShortestJobFirst;
	public static JRadioButton rdbtnPriority;
	public static JRadioButton rdbtnFirstComeFirst;
	private JPanel panel_3;
	private JLabel lblPreemptivenonpreemptive;
	private JPanel panel_4;
	public static JRadioButton rdbtnPreemptive;
	public static JRadioButton rdbtnNonpreemptive;
	private JPanel panel_5;
	public static JRadioButton rdbtnRoundRobin;
	public static JTextField textField;
	private JLabel lblTimeInSecs;
	public static JLabel label;
	public static JTextField textField_1;
	public static JTextPane textPane;
	private JPanel panel;
	private JLayeredPane layeredPane_1;
	private JLayeredPane layeredPane_2;
	public static JLayeredPane layeredPane;
	private JLayeredPane layeredPane_3;
	private JLayeredPane layeredPane_4;
	private JLayeredPane layeredPane_5;
	private JPanel panel_6;
	private JLabel lblEnterThe;
	private JLabel lblEnterTheNumber;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JButton btnCompare;
	private Deque<JTextField> TextBoxes;
	private JLabel label_11;
	private JLabel lblFifoSstfScan;
	private JLayeredPane layeredPane_6;
	private JLayeredPane layeredPane_7;
	private JLayeredPane layeredPane_8;
	private JLabel lblEnterTheNumber_1;
	private JTextField textField_4;
	private JLabel lblEnterTheNumber_2;
	private JTextField textField_5;
	private JPanel panel_10;
	private JLabel lblEnterTheProcessesspace;
	private JTextField textField_6;
	private JLabel label_12;
	private JTextField textField_7;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JLabel lblEnterTheMaximum;
	private JLabel lblEnterTheAllocation;
	private JButton btnCalculate;
	private JLabel label_13;
	private JLabel label_14;
	private JPanel panel_11;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JPanel panel_12;
	private JButton btnCalculate_1;
	private JLabel lblPageReplacementAlgorithms;
	private JLabel lblFirstInFirst;
	private JLabel lblOptimal;
	private JLabel lblLeastFrequentlyUsed;
	private JLabel lblLeastRecentlyUsed;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel lblFcfsOptimalLfu;
	private JLabel label_21;
	private JButton btnReset;
	private JButton btnRandomInput;
	private JButton btnRandom;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulator window = new Simulator();
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
	public Simulator() {
		initialize();
	}
	public void CloseSimulator()
	{
		frame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 880, 560);
		frame.getContentPane().add(tabbedPane);
		
		layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Scheduling Algorithms", null, layeredPane_2, null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		layeredPane.setOpaque(true);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setBounds(0, 0, 884, 288);
		layeredPane_2.add(layeredPane);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(0, 285, 884, 249);
		layeredPane_1.setOpaque(true);
		layeredPane_1.setBackground(new Color(240, 240, 240));
		layeredPane_2.add(layeredPane_1);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 36, 884, 30);
		layeredPane_1.add(panel_1);
		panel_1.setLayout(null);
		
		lblSchedulingAlgorithms = new JLabel("Scheduling Algorithms:");
		lblSchedulingAlgorithms.setBounds(21, 0, 138, 30);
		panel_1.add(lblSchedulingAlgorithms);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 66, 884, 30);
		layeredPane_1.add(panel_2);
		panel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_2.setLayout(null);
		
		rdbtnFirstComeFirst = new JRadioButton("First Come First Serve");
		rdbtnFirstComeFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnShortestJobFirst.setSelected(false);
				rdbtnPriority.setSelected(false);
				rdbtnRoundRobin.setSelected(false);
				rdbtnPreemptive.setEnabled(false);
				rdbtnNonpreemptive.setEnabled(false);
				textField_1.setEnabled(false);
			}
		});
		rdbtnFirstComeFirst.setBounds(42, 5, 173, 23);
		panel_2.add(rdbtnFirstComeFirst);
		
		rdbtnShortestJobFirst = new JRadioButton("Shortest Job First");
		rdbtnShortestJobFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPriority.setSelected(false);
				rdbtnRoundRobin.setSelected(false);
				rdbtnFirstComeFirst.setSelected(false);
				rdbtnPreemptive.setEnabled(true);
				rdbtnNonpreemptive.setEnabled(true);
				textField_1.setEnabled(false);
			}
		});
		rdbtnShortestJobFirst.setBounds(406, 5, 152, 23);
		panel_2.add(rdbtnShortestJobFirst);
		
		rdbtnPriority = new JRadioButton("Priority");
		rdbtnPriority.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnRoundRobin.setSelected(false);
				rdbtnFirstComeFirst.setSelected(false);
				rdbtnShortestJobFirst.setSelected(false);
				rdbtnPreemptive.setEnabled(true);
				rdbtnNonpreemptive.setEnabled(true);
				textField_1.setEnabled(false);
			}
		});
		rdbtnPriority.setBounds(610, 5, 105, 23);
		panel_2.add(rdbtnPriority);
		
		rdbtnRoundRobin = new JRadioButton("Round Robin");
		rdbtnRoundRobin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnShortestJobFirst.setSelected(false);
				rdbtnPriority.setSelected(false);
				rdbtnFirstComeFirst.setSelected(false);
				rdbtnPreemptive.setEnabled(false);
				rdbtnNonpreemptive.setEnabled(false);
				textField_1.setEnabled(true);
			}
		});
		rdbtnRoundRobin.setBounds(245, 5, 109, 23);
		panel_2.add(rdbtnRoundRobin);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 95, 884, 30);
		layeredPane_1.add(panel_3);
		panel_3.setLayout(null);
		
		lblPreemptivenonpreemptive = new JLabel("Preemptive/Non-preemptive:");
		lblPreemptivenonpreemptive.setBounds(22, 11, 185, 14);
		panel_3.add(lblPreemptivenonpreemptive);
		
		textPane = new JTextPane();
		textPane.setBounds(0, 11, 723, 20);
		layeredPane_1.add(textPane);
		textPane.setText("");
		
		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(747, 11, 100, 20);
		layeredPane_1.add(lblArrivalTime);
		
		panel_4 = new JPanel();
		panel_4.setBounds(0, 136, 884, 30);
		layeredPane_1.add(panel_4);
		panel_4.setLayout(null);
		
		rdbtnPreemptive = new JRadioButton("Preemptive");
		rdbtnPreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rdbtnNonpreemptive.setSelected(false);
			}
		});
		rdbtnPreemptive.setBounds(241, 5, 115, 23);
		panel_4.add(rdbtnPreemptive);
		
		rdbtnNonpreemptive = new JRadioButton("Non-preemptive");
		rdbtnNonpreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPreemptive.setSelected(false);
			}
		});
		rdbtnNonpreemptive.setBounds(406, 5, 127, 23);
		panel_4.add(rdbtnNonpreemptive);
		
		panel_5 = new JPanel();
		panel_5.setBounds(0, 177, 884, 30);
		layeredPane_1.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input inp = new Input();
				inp.setVisible(true);
			}
		});
		btnRun.setBounds(717, 5, 65, 23);
		panel_5.add(btnRun);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseSimulator();
			}
		});
		btnCancel.setBounds(797, 5, 77, 23);
		panel_5.add(btnCancel);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(124, 6, 72, 20);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JLabel lblTimeQuantum = new JLabel("Time Speed x:");
		lblTimeQuantum.setBounds(10, 5, 104, 18);
		panel_5.add(lblTimeQuantum);
		
		JLabel lblTimeQuantum_1 = new JLabel("Time Quantum:");
		lblTimeQuantum_1.setBounds(311, 5, 111, 23);
		panel_5.add(lblTimeQuantum_1);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setBounds(412, 6, 86, 20);
		panel_5.add(textField_1);
		textField_1.setColumns(10);
		
		btnRandom = new JButton("Random");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Input_Parameters rand = new Input_Parameters(10);
				rand.setVisible(true);
				String[] values = {"0", "13", "3", "0", "20", "2", "1", "15", "7", "5", "6", "8", "10", "4", "4", "14", "3", "1", "20", "4", "6", "24", "8", "5", "26", "6", "10", "26", "9", "9" };
				int i = 0;
				for(JTextField x:Input_Parameters.tempText)
				{
					x.setText(values[i]);
					i++;
				}
			}
		});
		btnRandom.setBounds(604, 5, 89, 23);
		panel_5.add(btnRandom);
		
		panel = new JPanel();
		panel.setBounds(0, 218, 884, 20);
		layeredPane_1.add(panel);
		panel.setLayout(null);
		
		lblTimeInSecs = new JLabel("Time in secs:");
		lblTimeInSecs.setBounds(10, 0, 85, 19);
		panel.add(lblTimeInSecs);
		
		label = new JLabel("0");
		label.setBounds(103, 2, 46, 14);
		panel.add(label);
		
		layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("Disk Scheduling Algorithms", null, layeredPane_3, null);
		
		layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBounds(0, 0, 875, 242);
		layeredPane_4.setOpaque(true);
		layeredPane_4.setBackground(Color.WHITE);
		layeredPane_3.add(layeredPane_4);
		
		
		layeredPane_5 = new JLayeredPane();
		layeredPane_5.setBounds(0, 243, 875, 300);
		layeredPane_5.setOpaque(true);
		layeredPane_5.setBackground(new Color(240, 240, 240));
		layeredPane_3.add(layeredPane_5);
		
		panel_6 = new JPanel();
		panel_6.setBounds(0, 30, 875, 39);
		layeredPane_5.add(panel_6);
		panel_6.setLayout(null);
		
		lblEnterThe = new JLabel("Enter the Initial Head Position: ");
		lblEnterThe.setBounds(10, 11, 200, 17);
		panel_6.add(lblEnterThe);
		
		lblEnterTheNumber = new JLabel("Enter the Number of Processes: ");
		lblEnterTheNumber.setBounds(536, 11, 234, 17);
		panel_6.add(lblEnterTheNumber);
		
		textField_2 = new JTextField();
		textField_2.setText("1");
		textField_2.setBounds(220, 9, 86, 20);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setText("1");
		textField_3.setBounds(728, 9, 86, 20);
		panel_6.add(textField_3);
		textField_3.setColumns(10);
		
		panel_7 = new JPanel();
		panel_7.setBounds(0, 76, 875, 85);
		layeredPane_5.add(panel_7);
		
		JButton btnGenerateInputFor = new JButton("Generate Input for Processes");
		btnGenerateInputFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TextBoxes = new ArrayDeque<JTextField>();
				for(int i = 1; i <= Integer.parseInt(textField_3.getText()); i++)
				{
					JTextField temptextField = new JTextField();
					temptextField.setText("0");
					panel_7.add(temptextField);
					temptextField.setColumns(10);
					TextBoxes.add(temptextField);
					SwingUtilities.updateComponentTreeUI(frame);
				}
			}
		});
		btnGenerateInputFor.setBounds(316, 8, 210, 23);
		panel_6.add(btnGenerateInputFor);
		
		panel_8 = new JPanel();
		panel_8.setBounds(0, 160, 875, 129);
		layeredPane_5.add(panel_8);
		panel_8.setLayout(null);
		
		label_1 = new JLabel("First In First Out:");
		label_1.setBounds(22, 11, 116, 22);
		panel_8.add(label_1);
		
		label_2 = new JLabel("Shortest Seek Time First:");
		label_2.setBounds(22, 31, 167, 22);
		panel_8.add(label_2);
		
		label_3 = new JLabel("Scan:");
		label_3.setBounds(22, 54, 61, 14);
		panel_8.add(label_3);
		
		label_4 = new JLabel("CScan:");
		label_4.setBounds(22, 64, 46, 37);
		panel_8.add(label_4);
		
		label_5 = new JLabel("CLook:");
		label_5.setBounds(22, 87, 46, 31);
		panel_8.add(label_5);
		
		label_6 = new JLabel("0");
		label_6.setBounds(199, 15, 52, 14);
		panel_8.add(label_6);
		
		label_7 = new JLabel("0");
		label_7.setBounds(199, 35, 46, 14);
		panel_8.add(label_7);
		
		label_8 = new JLabel("0");
		label_8.setBounds(199, 54, 52, 14);
		panel_8.add(label_8);
		
		label_9 = new JLabel("0");
		label_9.setBounds(199, 75, 52, 14);
		panel_8.add(label_9);
		
		label_10 = new JLabel("0");
		label_10.setBounds(199, 95, 52, 14);
		panel_8.add(label_10);
		
		btnCompare = new JButton("Compare");
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> queue = new ArrayList<Integer>();
				for(JTextField a: TextBoxes)
				{
					queue.add(Integer.parseInt(a.getText()));
				}
				DiskFIFO object1 = new DiskFIFO();
				Vector<Float> p = new Vector<Float>();
				p.add(new Float(object1.main(Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_2.getText()), queue)));
				label_6.setText(Float.toString(p.get(0)));
				DiskSSTF object2 = new DiskSSTF();
				p.add(new Float(object2.main(Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_2.getText()), queue)));
				label_7.setText(Float.toString(p.get(1)));
				Scan object3 = new Scan();
				p.add(new Float(object3.main(Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_2.getText()), queue)));
				label_8.setText(Float.toString(p.get(2)));
				Cscan object4 = new Cscan();
				p.add(new Float(object4.main(Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_2.getText()), queue)));
				label_9.setText(Float.toString(p.get(3)));
				Clook object5 = new Clook();
				p.add(object5.main(Integer.parseInt(textField_3.getText()), Integer.parseInt(textField_2.getText()), queue));
				label_10.setText(Float.toString(p.get(4)));
				Float temp = Collections.min(p);
				for(int i = 0; i <= 4; i++)
				{
					if(p.get(i) == temp)
					{
						if(i == 0)
						{
							label_11.setText("The best algorithm is First In First Out");
						}
						else if(i == 1)
						{
							label_11.setText("The best algorithm is Shortest Seek Time First");
						}
						else if(i == 2)
						{
							label_11.setText("The best algorithm is Scan");
						}
						else if(i == 3)
						{
							label_11.setText("The best algorithm is CScan");
						}
						else if(i == 4)
						{
							label_11.setText("The best algorithm is CLook");
						}
						break;
					}
				}
				for(int i = 0; i <= 4 ;i++)
				{	
					JPanel panel_9 = new JPanel();
					panel_9.setBounds(10+i*60, 200 - Math.round(p.get(i)), 30, 126 + Math.round(p.get(i)));
					panel_9.setBackground(Color.RED);
					layeredPane_4.add(panel_9);
				}
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
		btnCompare.setBounds(725, 91, 89, 23);
		panel_8.add(btnCompare);
		
		label_11 = new JLabel("");
		label_11.setBounds(257, 11, 595, 37);
		panel_8.add(label_11);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_7.removeAll();
				panel_7.repaint();
				panel_7.revalidate();
			}
		});
		btnReset.setBounds(607, 91, 89, 23);
		panel_8.add(btnReset);
		
		btnRandomInput = new JButton("Random Input");
		btnRandomInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("53");
				textField_3.setText("8");
				TextBoxes = new ArrayDeque<JTextField>();
				String[] temp = {"98", "183", "37", "122", "14", "124", "65", "67"};
				for(int i = 0; i < 8; i++)
				{
					JTextField x = new JTextField();
					x.setText(temp[i]);
					x.setColumns(10);
					TextBoxes.add(x);
					panel_7.add(x);
				}
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
		btnRandomInput.setBounds(462, 91, 116, 23);
		panel_8.add(btnRandomInput);
		
		lblFifoSstfScan = new JLabel(" FIFO           SSTF          Scan          CScan        CLook");
		lblFifoSstfScan.setBounds(10, 11, 354, 14);
		layeredPane_5.add(lblFifoSstfScan);
		
		layeredPane_6 = new JLayeredPane();
		layeredPane_6.setOpaque(true);
		layeredPane_6.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Banker's Algorithm", null, layeredPane_6, null);
		
		panel_10 = new JPanel();
		panel_10.setBounds(10, 11, 855, 510);
		layeredPane_6.add(panel_10);
		panel_10.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBounds(22, 42, 86, 20);
		panel_10.add(textField_4);
		textField_4.setText("5");
		textField_4.setColumns(10);
		
		lblEnterTheNumber_1 = new JLabel("Enter the number of Processes:");
		lblEnterTheNumber_1.setBounds(22, 5, 227, 26);
		panel_10.add(lblEnterTheNumber_1);
		
		textField_5 = new JTextField();
		textField_5.setBounds(354, 42, 86, 20);
		panel_10.add(textField_5);
		textField_5.setText("3");
		textField_5.setColumns(10);
		
		lblEnterTheNumber_2 = new JLabel("Enter the number of Resources: ");
		lblEnterTheNumber_2.setBounds(354, 5, 201, 26);
		panel_10.add(lblEnterTheNumber_2);
		
		lblEnterTheProcessesspace = new JLabel("Enter the processes(space separated):");
		lblEnterTheProcessesspace.setBounds(22, 119, 259, 14);
		panel_10.add(lblEnterTheProcessesspace);
		
		textField_6 = new JTextField();
		textField_6.setText("0 1 2 3 4");
		textField_6.setBounds(22, 165, 239, 20);
		panel_10.add(textField_6);
		textField_6.setColumns(10);
		
		label_12 = new JLabel("Enter the resources(space separated):");
		label_12.setBounds(354, 119, 268, 14);
		panel_10.add(label_12);
		
		textField_7 = new JTextField();
		textField_7.setBounds(354, 165, 268, 20);
		textField_7.setText("3 3 2");
		panel_10.add(textField_7);
		textField_7.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(22, 258, 190, 118);
		textArea.setText("7 5 3\n3 2 2\n9 0 2\n2 2 2\n4 3 3");
		panel_10.add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(421, 258, 201, 118);
		textArea_1.setText("0 1 0\n2 0 0\n3 0 2\n2 1 1\n0 0 2");
		panel_10.add(textArea_1);
		
		lblEnterTheMaximum = new JLabel("Enter the maximum resources that can be allocated to Process");
		lblEnterTheMaximum.setBounds(22, 221, 368, 26);
		panel_10.add(lblEnterTheMaximum);
		
		lblEnterTheAllocation = new JLabel("Enter the Allocation Matrix");
		lblEnterTheAllocation.setBounds(421, 224, 217, 20);
		panel_10.add(lblEnterTheAllocation);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int processNo = Integer.parseInt(textField_4.getText());
				int resourceNo = Integer.parseInt(textField_5.getText());
				int[] process = new int[processNo];
				int[] resource = new int[resourceNo];
				int i = 0;
				for(String x: textField_6.getText().split(" "))
				{
					process[i] = Integer.parseInt(x);
					i++;
				}
				i = 0;
				for(String x: textField_7.getText().split(" "))
				{
					resource[i] = Integer.parseInt(x);
					i++;
				}
				int[][] maxm = new int[processNo][resourceNo];
				int[][] allocationMatrix = new int[processNo][resourceNo];
				i = 0;
				int j = 0;
				for(String x: textArea.getText().split("\n"))
				{
					j = 0;
					for(String y: x.split(" "))
					{
						maxm[i][j] = Integer.parseInt(y);
						j++;
					}
					i++;
				}
				i = 0;
				j = 0;
				for(String x: textArea_1.getText().split("\n"))
				{
					j = 0;
					for(String y: x.split(" "))
					{
						allocationMatrix[i][j] = Integer.parseInt(y);
						j++;
					}
					i++;
				}
				Bankers object = new Bankers();
				ArrayList<Integer> result =  new ArrayList<Integer>(object.main(processNo, resourceNo, process, resource, maxm, allocationMatrix));
				if(result.isEmpty())
				{
					label_13.setText("The given system is not in a safe state");
					label_14.setText("");
				}
				else
				{
					label_13.setText("The given system is in safe state and the safe sequence is:");
					label_14.setText(result.toString());
				}
			}
		});
		btnCalculate.setBounds(678, 284, 108, 32);
		panel_10.add(btnCalculate);
		
		label_13 = new JLabel("");
		label_13.setBounds(22, 411, 764, 32);
		panel_10.add(label_13);
		
		label_14 = new JLabel("");
		label_14.setBounds(22, 454, 764, 32);
		panel_10.add(label_14);
		
		layeredPane_7 = new JLayeredPane();
		layeredPane_7.setOpaque(true);
		layeredPane_7.setBackground(Color.WHITE);
		tabbedPane.addTab("Dining Philosopher's Problem", null, layeredPane_7, null);
		
		JButton btnDiningPhilosophersProblem = new JButton("Dining Philosopher's Problem");
		btnDiningPhilosophersProblem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Dining();
			}
		});
		btnDiningPhilosophersProblem.setBounds(306, 229, 261, 23);
		layeredPane_7.add(btnDiningPhilosophersProblem);
		
		layeredPane_8 = new JLayeredPane();
		layeredPane_8.setOpaque(true);
		layeredPane_8.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Page Replacement Algorithms", null, layeredPane_8, null);
		
		JLayeredPane layeredPane_9 = new JLayeredPane();
		layeredPane_9.setOpaque(true);
		layeredPane_9.setBackground(Color.WHITE);
		layeredPane_9.setBounds(10, 11, 412, 291);
		layeredPane_8.add(layeredPane_9);
		
		JLayeredPane layeredPane_10 = new JLayeredPane();
		layeredPane_10.setOpaque(true);
		layeredPane_10.setBackground(Color.WHITE);
		layeredPane_10.setBounds(432, 11, 412, 291);
		layeredPane_8.add(layeredPane_10);
		
		JLayeredPane layeredPane_11 = new JLayeredPane();
		layeredPane_11.setBounds(10, 302, 834, 219);
		layeredPane_8.add(layeredPane_11);
		
		panel_11 = new JPanel();
		panel_11.setBounds(0, 22, 834, 57);
		layeredPane_11.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblEnterTheNo = new JLabel("Enter the no. of Pages: ");
		lblEnterTheNo.setBounds(10, 0, 188, 24);
		panel_11.add(lblEnterTheNo);
		
		textField_8 = new JTextField();
		textField_8.setText("20");
		textField_8.setBounds(153, 2, 86, 20);
		panel_11.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblEnterTheFrame = new JLabel("Enter the frame size: ");
		lblEnterTheFrame.setBounds(259, 3, 137, 19);
		panel_11.add(lblEnterTheFrame);
		
		textField_9 = new JTextField();
		textField_9.setText("3");
		textField_9.setBounds(381, 2, 86, 20);
		panel_11.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblEnterThePagesspace = new JLabel("Enter the pages(space separated): ");
		lblEnterThePagesspace.setBounds(10, 35, 229, 14);
		panel_11.add(lblEnterThePagesspace);
		
		textField_10 = new JTextField();
		textField_10.setText("7 0 1 2 0 3 0 4 2 3 0 3 2 1 2 0 1 7 0 1");
		textField_10.setBounds(259, 32, 278, 20);
		panel_11.add(textField_10);
		textField_10.setColumns(10);
		
		btnCalculate_1 = new JButton("Calculate");
		btnCalculate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int n = Integer.parseInt(textField_8.getText());
				int fSize = Integer.parseInt(textField_9.getText());
				int[] pages = new int[n];
				int i = 0;
				for(String x: textField_10.getText().split(" "))
				{
					pages[i] = Integer.parseInt(x);
					i++;
				}
				Vector<Integer> p = new Vector<Integer>();
				FIFOPage object2 = new FIFOPage();
				p.add(n - object2.main(n, fSize, pages));
				label_15.setText(Integer.toString(p.get(0)));
				Optimal object = new Optimal();
				p.add(n - object.main(n, fSize, pages));
				label_16.setText(Integer.toString(p.get(1)));
				LFU object3 = new LFU();
				p.add(n - object3.main(n, fSize, pages));
				label_17.setText(Integer.toString(p.get(2)));
				LRU object4 = new LRU();
				p.add(n - object4.main(n, fSize, pages));
				label_18.setText(Integer.toString(p.get(3)));
				secondChance object1 = new secondChance();
				p.add(n - object1.main(n, fSize, pages));
				label_19.setText(Integer.toString(p.get(4)));
				for(int j = 0;j <= 4 ;j++)
				{	
					JPanel panel = new JPanel();
					panel.setBounds(10+j*60, 200 - p.get(j)*10, 30, 126 + p.get(j)*10);
					panel.setBackground(Color.BLUE);
					layeredPane_9.add(panel);
				}
				for(int j = 0;j <= 4 ;j++)
				{	
					JPanel panel = new JPanel();
					panel.setBounds(10+j*60, 200 - (n - p.get(j))*10, 30, 126 + (n-p.get(j))*10);
					panel.setBackground(Color.RED);
					layeredPane_10.add(panel);
				}
				int temp = Collections.max(p);
				for(int j = 0; j <= 5; j++)
				{
					if(p.get(j) == temp)
					{
						if(j == 0)
						{
							label_20.setText("The best algorithm is First In First Out Algorithm");
						}
						else if(j == 1)
						{
							label_20.setText("The best algorithm is Optimal Algorithm");
						}
						else if(j == 2)
						{
							label_20.setText("The best algorithm is Least Frequently Used Algorithm");
						}
						else if(j == 3)
						{
							label_20.setText("The best algorithm is Least Recently Used Algorithm");
						}
						else if(j == 4)
						{
							label_20.setText("The best algorithm is the Second Chance Algorithm");
						}
						break;
					}
				}
				SwingUtilities.updateComponentTreeUI(frame);
			}
		});
		btnCalculate_1.setBounds(652, 11, 89, 23);
		panel_11.add(btnCalculate_1);
		
		panel_12 = new JPanel();
		panel_12.setBounds(0, 78, 834, 141);
		layeredPane_11.add(panel_12);
		panel_12.setLayout(null);
		
		lblPageReplacementAlgorithms = new JLabel("Page Replacement Algorithms: ");
		lblPageReplacementAlgorithms.setBounds(10, 0, 270, 23);
		panel_12.add(lblPageReplacementAlgorithms);
		
		lblFirstInFirst = new JLabel("First In First Out:");
		lblFirstInFirst.setBounds(10, 24, 150, 23);
		panel_12.add(lblFirstInFirst);
		
		lblOptimal = new JLabel("Optimal:");
		lblOptimal.setBounds(10, 55, 80, 14);
		panel_12.add(lblOptimal);
		
		lblLeastFrequentlyUsed = new JLabel("Least Frequently Used:");
		lblLeastFrequentlyUsed.setBounds(10, 80, 139, 14);
		panel_12.add(lblLeastFrequentlyUsed);
		
		lblLeastRecentlyUsed = new JLabel("Least Recently Used:");
		lblLeastRecentlyUsed.setBounds(10, 105, 127, 14);
		panel_12.add(lblLeastRecentlyUsed);
		
		JLabel lblSecondChance = new JLabel("Second Chance:");
		lblSecondChance.setBounds(10, 127, 127, 14);
		panel_12.add(lblSecondChance);
		
		label_15 = new JLabel("0");
		label_15.setBounds(166, 28, 46, 14);
		panel_12.add(label_15);
		
		label_16 = new JLabel("0");
		label_16.setBounds(166, 55, 46, 14);
		panel_12.add(label_16);
		
		label_17 = new JLabel("0");
		label_17.setBounds(166, 80, 46, 14);
		panel_12.add(label_17);
		
		label_18 = new JLabel("0");
		label_18.setBounds(166, 105, 46, 14);
		panel_12.add(label_18);
		
		label_19 = new JLabel("0");
		label_19.setBounds(166, 127, 46, 14);
		panel_12.add(label_19);
		
		label_20 = new JLabel("");
		label_20.setBounds(251, 34, 562, 32);
		panel_12.add(label_20);
		
		lblFcfsOptimalLfu = new JLabel(" FCFS       Optimal         LFU            LRU          Second                         No. of hits");
		lblFcfsOptimalLfu.setBounds(10, 0, 417, 22);
		layeredPane_11.add(lblFcfsOptimalLfu);
		
		label_21 = new JLabel(" FCFS       Optimal         LFU            LRU          Second                No. of misses");
		label_21.setBounds(433, 0, 417, 22);
		layeredPane_11.add(label_21);
		
		
		
	}
}
