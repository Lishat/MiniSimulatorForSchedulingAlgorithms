package simulator;
import java.util.*;
public class DiskFIFO {
	public Float main(Integer processCount,Integer headPosition,ArrayList<Integer> queue )
    {
        int i;
        Float seekTime=new Float(0);
        for(i=0;i<processCount;i++)
        {
            seekTime+=Math.abs(headPosition-queue.get(i));
            headPosition=queue.get(i);
        }
        return seekTime/processCount;
    }
}
