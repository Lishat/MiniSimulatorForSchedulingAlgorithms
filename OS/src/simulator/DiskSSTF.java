package simulator;
import java.util.*;
public class DiskSSTF {
	public Float main(Integer processCount,Integer headPosition,ArrayList<Integer>queue)
    {
        int i,j;
        int[] visit=new int[processCount];
        ArrayList<Integer> seekList=new ArrayList<Integer>();
        for(i=0;i<processCount;i++)
        {
            visit[i]=0;
            seekList.add(0);
        }
        for(i=0;i<processCount;i++)
        {
            int mini=-1;
            for(j=0;j<processCount;j++)
            {
                if(visit[j]==0)
                {
                    mini= (mini==-1 || Math.abs(queue.get(mini)-headPosition)>=Math.abs(headPosition-queue.get(j))) ? j : mini;
                }
            }
            if(mini==-1)
            {
                break;
            }
            seekList.set(mini,Math.abs(queue.get(mini)-headPosition));
            visit[mini]=1;
            headPosition=queue.get(mini);
        }
        Float seeker=new Float(0.0);
        for(i=0;i<processCount;i++)
        {
            seeker+=seekList.get(i);
        }
        return seeker/processCount;
    }
}
