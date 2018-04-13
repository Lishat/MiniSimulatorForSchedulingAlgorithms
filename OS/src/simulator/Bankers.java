package simulator;
import java.util.*;
public class Bankers {
	public ArrayList<Integer> main(int p,int r,int[] PROCESS,int[] AVAIL,int MAXM[][],int ALLOT[][]) {
        
        int P=p;
        int R=r;
        int hu=1;
                        //System.out.println(R); CHECK
        ArrayList<Integer> SAFE = new ArrayList<Integer>();
	ArrayList<Integer> EMPTY = new ArrayList<Integer>();
        int i=0;
        while(i<p){SAFE.add(0);i+=1;}
        
        
        //CALCULATING NEED MATRIX
        int NEED[][] = new int [P][R];
        for(i=0; i < p; i++)
        {
            for(int j=0; j<r; j++)
                NEED[i][j] = MAXM[i][j]-ALLOT[i][j];
        }
        
        int[] FINISH=new int[P+1];
        for(i=0;i<p;i++)FINISH[p]=0;
        
        
        int[] WORK = new int[R];
        for(i=0; i < r; i++)
                WORK[i]=AVAIL[i];
        
        
        int count=0,found;
        while(count<p){
            found=0;
            int j;
            for(i=0;i<P;i++){
                if(FINISH[i]==0){
                    for(j=0;j<R;j++){
                        if(NEED[i][j]>WORK[j])break;
                    }
                    if(j==R){
                        for(int k=0;k<R;k++){
                            WORK[k]+=ALLOT[i][k];
                        }
                        SAFE.set(count,i);
			count++;
                        //System.out.println(i);for checking
                        FINISH[i]=1;
                        found=1;
                        hu=1;
                    }
                }
            }
            if(found==0)
            {
                
                hu=0;
            	break;
            }
        }

        if(hu==1)
        {
            return SAFE;
        }
	return EMPTY;
        }
}
