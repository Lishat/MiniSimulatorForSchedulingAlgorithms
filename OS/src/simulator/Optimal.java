package simulator;

public class Optimal {
	public int main(int n,int Frames,int[] Pagest){
		int i,j,PageFaults=0,flag,flag1=1,l,m;
		int kk=1;
		int table[][]  =new int[100][100];
		int Memory[]    = new int[100];
		int PageFault[] = new int[21];
		int Check[]     = new int[100];
		int Pages[] = new int[n+1];
		PageFaults = 1;
		for(i=1;i<=n;i++){
			Pages[i] = Pagest[i-1];
		}
		
		
		for(i=1;i<=Frames;i++){
			Memory[i] = -1;
		}
	
		Memory[1] = Pages[1];                              //drop the first element of the string
		for(j=1;j<=Frames;j++){
			table[kk][j]=Memory[j];
		}
		kk++;
	
		
		for(i=2;i<=n;i++){
			flag1 = 1;
			flag = 0;
			for(j=1;j<=Frames;j++){
				if(Pages[i]==Memory[j]){
					flag = 1;                             //if the element already exists in the memory
					break;
				}
			}
			if(flag == 1){
				PageFault[i] = 1;
				//Do nothing.
			}
			else{
				flag1 = 0;
				for(j=1;j<=Frames;j++){
					if(Memory[j] == -1){
						flag1 = 1;                       //if there is space in the memory for new element
						break;
					}
				}
				if(flag1==1){
					Memory[j] = Pages[i];
					PageFaults = PageFaults + 1;
					PageFault[i] = 0;
				}
			}
			if(flag1==0){                             //if the memory is occupied and the current element is not present
				for(l=1;l<=Frames;l++){
					Check[l] = 0;                  //check is for finding the element in the memory which will not appear in the latter string and replacing that with the current element 
				}
				int k,count=0,exit=1,count1=0;
				for(k=i+1;k<=n;k++){
					for(l=1;l<=Frames;l++){
						if(Pages[k] == Memory[l]){
							Check[l] = 1;
							count++;
						}
						if(count>=Frames-1){
							count1=0;
							for(m=1;m<=Frames;m++){
								count1 = count1 + Check[m];       //count of no. of elements in the memory which will appear in the latter string
							}
						}
						if(count1 == Frames-1){           //if exactly one element is there which will not come again
							for(m=1;m<=Frames;m++){
								if(Check[m]==0){
									Memory[m] = Pages[i];           //replacing that with current element
									exit=0;
									break;
								}
							}
						}
						if(exit==0){
							break;
						}
						
					}
					if(exit==0){
						break;
					}
					
				}
				if(exit==1){                    //if more than one element is present in the memory which will not appear in the next part of the string
					for(j=1;j<=Frames;j++){
						if(Check[j] == 0){          //applying first in first out for such elements
							Memory[j] = Pages[i];
							break;
						}
					}
				}
				PageFaults = PageFaults + 1;
			}
			for(j=1;j<=Frames;j++){
				table[kk][j]=Memory[j];          //displaying the entire process table
			}
			kk++;
			
		}
		return PageFaults;
	}
}
