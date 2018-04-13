package simulator;

public class LFU {
	public int main(int n,int f,int[] pages) {
        int count[]=new int[n+1];
        int frames[]= new int [f+1];
        int freq[]= new int [f+1];
        boolean flag=false;
        int i,j,pagehit=0,num,min;
        for(i=0; i < f; i++)
        {
                frames[i]=0;
                freq[i]=0;
        }
        for(i=0;i<n;i++)
        {
            flag = true;
            int page = pages[i];
            
            for(j=0; j<f; j++)
            {
                if(frames[j] == page)
                {
                    flag = false;
                    pagehit++;
                    count[page]++;
                    break;
                }
            }
            if(flag)
            {
                if(i>=f)
                {
                    for(j=0; j<f; j++)
                    {
                        num = frames[j];
                        freq[j] = count[num];
                    }
                    min = freq[0];
                    for(j=0; j<f; j++)
                    {
                        if(freq[j] < min)
                        {
                            min = freq[j];
                        }
                    }
                    for(j=0; j<f; j++)
                    {
                        if(freq[j] == min)
                        {
                            count[page]++;
                            frames[j] = page;
                            break;
                        }
                    }
                }
                else
                {
                    frames[i]=page;
                    count[page]++;
                }
            }
        }
        return n-pagehit;
    }
}
