package simulator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PriorityPreemptive {
	public Timer PPtimer;
	public static int index;
	public static int count;
	PriorityPreemptive()
	{
		Simulator.textPane.setText("      ");
		Collections.sort(Input_Parameters.Data, new Comparator<Parameters>(){
			@Override
			public int compare(Parameters a, Parameters b)
			{
				if(a.arrivalTime == b.arrivalTime)
					return (a.priority >= b.priority)?1:-1;
				return (a.arrivalTime >= b.arrivalTime)?1:-1;
			}
		});
		for(int i = 0; i <= Input_Parameters.Data.size()-1;i++)
		{
			Input_Parameters.Data.get(i).serialId = i;
		}
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
        		index = 0;
        		Collections.sort(Input_Parameters.Data, new Comparator<Parameters>(){
        			@Override
        			public int compare(Parameters a, Parameters b)
        			{
        				if(a.priority == b.priority)
        					return (a.arrivalTime >= b.arrivalTime)?1:-1;
        				return (a.priority >= b.priority)?1:-1;
        			}
        		});
        		count = 0;
        		while(Simulator.layeredPane.getComponent(index).getHeight() == 0)
        		{
        			index++;
        			index%=Input_Parameters.Data.size();
        			if(count == Input_Parameters.Data.size())
        			{
        				count = 0;
        				Simulator.layeredPane.removeAll();
        			}
        			count++;
        		}
        		count = 0;
        		while(Input_Parameters.Data.get(index).burstTime <= 0 || Integer.parseInt(Simulator.label.getText()) < Input_Parameters.Data.get(index).arrivalTime)
        		{
        			index++;
        			index%=Input_Parameters.Data.size();
        			if(count == Input_Parameters.Data.size())
        			{
        				count = 0;
        				break;
        			}
        			count++;
        		}
        		if(Input_Parameters.Data.get(index).burstTime > 0 && Integer.parseInt(Simulator.label.getText()) >= Input_Parameters.Data.get(index).arrivalTime)
        		{
        			Component tempPane = Simulator.layeredPane.getComponents()[Input_Parameters.Data.get(index).serialId];
        			tempPane.setBackground(Color.BLUE);
        			Input_Parameters.Data.get(index).burstTime -= 1;
        			if(tempPane.getHeight()-5 <= 0)
        			{
        				tempPane.setBounds(tempPane.getX(), tempPane.getY()+5, 15, 0);
        				Simulator.label.setText(String.valueOf(Integer.parseInt(Simulator.label.getText()) + 1));
        				return;
        			}
        			tempPane.setBounds(tempPane.getX(), tempPane.getY()+5, 15, tempPane.getHeight()-5);
        		}
        		Simulator.label.setText(String.valueOf(Integer.parseInt(Simulator.label.getText()) + 1));
        	}
        	catch(Exception e)
        	{
        		Simulator.label.setText("0");
        		Simulator.layeredPane.removeAll();
        		PPtimer.stop();
        	}
        }
        };
        PPtimer = new javax.swing.Timer(delay, taskPerformer);
        PPtimer.start();
	}
}
