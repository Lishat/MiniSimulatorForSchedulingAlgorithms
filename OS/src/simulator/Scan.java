package simulator;
import java.util.*;
public class Scan {
	 public Float main(Integer processCount,Integer headPosition,ArrayList<Integer> queue)
	    {
	        Float seekTime=new Float(0.0);
	        ArrayList<Integer> less=new ArrayList<Integer>();
	        ArrayList<Integer> more=new ArrayList<Integer>();
	        for(Integer i: queue)
	        {
	            if(i<=headPosition)
	            {
	                less.add(i);
	            }
	            else
	            {
	                more.add(i);
	            }
	        }
	        Collections.sort(less);
	        Collections.reverse(less);
	        Collections.sort(more);
	        for(Integer i:less)
	        {
	            seekTime+=headPosition-i;
	            headPosition=i;
	        }
	        seekTime+=headPosition;
	        headPosition=0;
	        for(Integer i:more)
	        {
	            seekTime+=i-headPosition;
	            headPosition=i;
	        }
	        return seekTime/processCount;
	    }
}
