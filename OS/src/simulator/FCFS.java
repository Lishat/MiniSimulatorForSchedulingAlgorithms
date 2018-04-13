package simulator;

import java.awt.Color;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FCFS {
			public Timer fcfstimer;
			FCFS()
			{
				Simulator.textPane.setText("      ");
				Collections.sort(Input_Parameters.Data, new Comparator<Parameters>(){
					@Override
					public int compare(Parameters a, Parameters b)
					{
						if(a.arrivalTime == b.arrivalTime)
							return 0;
						return (a.arrivalTime >= b.arrivalTime)?1:-1;
					}
				});
		        int p =20;
		        for(Parameters a:Input_Parameters.Data)
		        {
		        		JPanel panel = new JPanel();
		        		panel.setBounds(10+p, 250-a.burstTime*5, 15, a.burstTime*5);
		        		panel.setBackground(Color.RED);
		        		Simulator.layeredPane.add(panel);
		        		if(a.arrivalTime < 10)
		        		Simulator.textPane.setText(Simulator.textPane.getText() + "    " + a.arrivalTime);
		        		else
		        		Simulator.textPane.setText(Simulator.textPane.getText() + "   " + a.arrivalTime);
		        		p += 20;
		        } 
		        int delay = 1000/Integer.parseInt(Simulator.textField.getText());//milliseconds
		        ActionListener taskPerformer = new ActionListener() {
		        public void actionPerformed(ActionEvent evt) 
		        {
		        	try
		        	{
		        		if(Integer.parseInt(Simulator.label.getText()) >= Input_Parameters.Data.firstElement().arrivalTime)
		        		{
		        			Component tempPane = Simulator.layeredPane.getComponents()[0];
		        			tempPane.setBackground(Color.BLUE);
		        			if(tempPane.getHeight()-5 < 0)
		        			{
		        				tempPane.setBounds(tempPane.getX(), tempPane.getY()+5, 15, 0);
		        				Simulator.layeredPane.remove(tempPane);
		        				tempPane = Simulator.layeredPane.getComponents()[0];
		        				tempPane.setBackground(Color.BLUE);
		        				Input_Parameters.Data.remove(0);
		        			}
		        			if(Integer.parseInt(Simulator.label.getText()) >= Input_Parameters.Data.firstElement().arrivalTime)
		        			tempPane.setBounds(tempPane.getX(), tempPane.getY()+5, 15, tempPane.getHeight()-5);
		        		}
		        		Simulator.label.setText(String.valueOf(Integer.parseInt(Simulator.label.getText()) + 1));
		        	}
		        	catch(Exception e)
		        	{
		        		Simulator.label.setText("0");
		        		Simulator.layeredPane.removeAll();
		        		fcfstimer.stop();
		        	}
		        }
		        };
		        fcfstimer = new javax.swing.Timer(delay, taskPerformer);
		        fcfstimer.start();
			}
	}
