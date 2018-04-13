package simulator;
import java.util.*;
public class FIFOPage {
	public int main(int n, int fSize, int[] page)
    {
        ArrayList<Integer> queue = new ArrayList<Integer>(fSize);
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
                queue.set(p, page[i]);
                p++;
                pageFaultCount++;
                p%=fSize;
            }
        }
        return pageFaultCount;
    }
}
