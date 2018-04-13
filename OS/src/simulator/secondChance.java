package simulator;
import java.util.*;
public class secondChance {
	public int main(int n, int fSize, int[] page)
    {
        Vector<Integer> second = new Vector<Integer>();
        ArrayList<Integer> queue = new ArrayList<Integer>();
        int pageFaultCount = 0;
        int p = 0;
        for(int i = 0; i < fSize; i++)
        {
            queue.add(-1);
        }
        for(int i = 0; i < n; i++)
        {
            if(queue.indexOf(page[i]) == -1)
            {
                while(second.indexOf(queue.get(p)) != -1)
                {
                    second.remove(new Integer(queue.get(p)));
                    p++;
                    p%=fSize;
                }
                queue.set(p, page[i]);
                p++;
                pageFaultCount++;
                p%=fSize;
            }
            else
            {
                if(second.indexOf(page[i]) == -1)
                second.add(page[i]);
            }
        }
        return pageFaultCount;
    }
}
