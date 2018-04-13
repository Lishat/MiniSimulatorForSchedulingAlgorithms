package simulator;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.util.*;

public class Input_Parameters extends JDialog {
	private JLayeredPane layeredPane;
	public static Vector<Parameters> Data;
	public static Deque<JTextField> tempText;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Input_Parameters dialog = new Input_Parameters(10);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CloseParameterFrame()
	{
		super.setVisible(false);
	}
	/**
	 * Create the dialog.
	 */
	public Input_Parameters(int k) {
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 528, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String s = "";
						Data = new Vector<Parameters>();
						int i =0,serial =1;
						for(JTextField x: tempText)
						{
							if(i%3 == 0)
							{
								s = serial+ " " + x.getText() + " ";
							}
							else if(i%3 == 1)
							{
								s = s + x.getText() + " ";
							}
							else if(i%3 == 2)
							{
								s = s + x.getText();
								Parameters t = new Parameters();
								t.serialId = Integer.parseInt(s.split(" ")[0]);
								t.arrivalTime = Integer.parseInt(s.split(" ")[1]);
								t.burstTime = Integer.parseInt(s.split(" ")[2]);
								t.priority = Integer.parseInt(s.split(" ")[3]);
								Data.add(t);
								serial++;
							}
							i++;
						}
						if(Simulator.rdbtnFirstComeFirst.isSelected())
						{
							new FCFS();
						}
						else if(Simulator.rdbtnRoundRobin.isSelected())
						{
							new RoundRobin();
						}
						else if(Simulator.rdbtnShortestJobFirst.isSelected() && Simulator.rdbtnNonpreemptive.isSelected())
						{
							new SJF();
						}
						else if(Simulator.rdbtnShortestJobFirst.isSelected() && Simulator.rdbtnPreemptive.isSelected())
						{
							new SRTF();
						}
						else if(Simulator.rdbtnPriority.isSelected() && Simulator.rdbtnNonpreemptive.isSelected())
						{
							new PriorityNonPreemptive();
						}
						else if(Simulator.rdbtnPriority.isSelected() && Simulator.rdbtnPreemptive.isSelected())
						{
							new PriorityPreemptive();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CloseParameterFrame();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 193, 26);
		getContentPane().add(panel);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the Following Parameters");
		panel.add(lblEnterTheFollowing);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1, 26, 431, 31);
		getContentPane().add(panel_1);
		{
			JLabel lblArrivalTimeBurst = new JLabel("Arrival Time               Burst Time               Priority");
			panel_1.add(lblArrivalTimeBurst);
		}
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 56, 434, 472);
		tempText = new ArrayDeque<JTextField>();
		getContentPane().add(layeredPane);
		{
			for(int i = 0; i < k; i++)
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBounds(0, 57+i*33, 434, 33);
				layeredPane.add(panel_2);
			
				JTextField textField = new JTextField();
				textField.setText("0");
				tempText.add(textField);
				panel_2.add(textField);
				textField.setColumns(10);
			
				JTextField textField_1 = new JTextField();
				textField_1.setText("0");
				tempText.add(textField_1);
				panel_2.add(textField_1);
				textField_1.setColumns(10);
				
				JTextField textField_2 = new JTextField();
				textField_2.setText("0");
				tempText.add(textField_2);
				panel_2.add(textField_2);
				textField_2.setColumns(10);
			}
		}
	}
}
