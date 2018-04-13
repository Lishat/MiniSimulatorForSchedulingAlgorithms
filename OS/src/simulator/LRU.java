package simulator;
import java.util.*;
public class LRU {
	static int pagefaults(int pages[],int n,int cap){
        HashSet<Integer> s = new HashSet<>(cap);
        HashMap<Integer,Integer>  index=new HashMap<>();
        int pgfault=0,i=0;
        for(i=0;i<n;i++){
            if(s.size()<cap){
                if(!s.contains(pages[i])){//ALREADY REPRESENTS PAGE FAULTS
                    s.add(pages[i]);
                    pgfault+=1;
                }
                index.put(pages[i],i);//STORING LRU index of each page
            }
            //if set is full remove lru and insert current page
            else{
                if(!s.contains(pages[i])){
                    int lru=Integer.MAX_VALUE;
                    int val=Integer.MIN_VALUE;                  
                    Iterator<Integer> itr = s.iterator();
                    while (itr.hasNext()) {
                        int temp = itr.next();
                        if (index.get(temp) < lru)
                        {
                            lru = index.get(temp);
                            val = temp;
                        }
                    }
                    s.remove(val);
                    s.add(pages[i]);
                    pgfault+=1;

                    
                }
                    
                index.put(pages[i],i);
            }
        }
        return pgfault;
    }
    public int main(int n,int cap,int[] pages) {
        return pagefaults(pages,n,cap); 
    }
}
