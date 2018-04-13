package simulator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RoundRobin {
	public Timer rrtimer;
	public static int index;
	public static int quantum;
	public static int count;
	RoundRobin()
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
        index = 0;
        count = 0;
        quantum = Integer.parseInt(Simulator.textField_1.getText());
        ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) 
        {
        	try
        	{
        		if(Integer.parseInt(Simulator.label.getText()) < Input_Parameters.Data.get(index).arrivalTime)
        		{
        			index = 0;
        		}
        		count = 0;
        		while(Simulator.layeredPane.getComponent(index).getHeight() == 0)
        		{
        			index++;
        			index%=Input_Parameters.Data.size();
        			if(count == Input_Parameters.Data.size())
        			{
        				System.out.println(count);
        				count = 0;
        				Simulator.layeredPane.removeAll();
        			}
        			count++;
        		}
        		if(Integer.parseInt(Simulator.label.getText()) >= Input_Parameters.Data.get(index).arrivalTime)
        		{
        			Component tempPane = Simulator.layeredPane.getComponents()[index];
        			tempPane.setBackground(Color.BLUE);
        			if(tempPane.getHeight()-5*quantum < 0)
        			{
        				Simulator.label.setText(String.valueOf(Integer.parseInt(Simulator.label.getText()) + tempPane.getHeight()/5));
        				tempPane.setBounds(tempPane.getX(), tempPane.getY(), 15, 0);
        				index++;
	        			index%=Input_Parameters.Data.size();
	        			tempPane = Simulator.layeredPane.getComponents()[index];
	        			return;
        			}
        			index++;
        			index%=Input_Parameters.Data.size();
        			tempPane.setBounds(tempPane.getX(), tempPane.getY()+5*quantum, 15, tempPane.getHeight()-5*quantum);
        			Simulator.label.setText(String.valueOf(Integer.parseInt(Simulator.label.getText()) + quantum));
        		}
        		else
        		{
        			Simulator.label.setText(String.valueOf(Integer.parseInt(Simulator.label.getText()) + 1));
        		}
        	}
        	catch(Exception e)
        	{
        		Simulator.label.setText("0");
        		rrtimer.stop();
        	}
        }
        };
        rrtimer = new javax.swing.Timer(delay, taskPerformer);
        rrtimer.start();
	}
}
