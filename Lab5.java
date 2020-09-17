// Java program for stable marriage problem  
import java.util.*; 
  
public class Lab5{  
    public static void main(String args[]){
       int prefer[][] = new int[][]{{2, 5, 1, 3, 4},  
                                    {1, 2, 3, 4, 5},  
                                    {5, 3, 2, 1, 4},  
                                    {2, 3, 5, 4, 1},  
                                    {2, 3, 5, 4, 1},  
                                    {2, 3, 5, 4, 1}};

        makeMatch(prefer);  
    }
  
// Number of Men or Women  
static int N = 5;  
  
// This function returns true if current match is better than proposed match
static boolean checkMatch(int prefer[][], int company ,  
                               int potentialProg, int currProg )  
{  
    // Check if company prefers current programmer over new one
    for (int i = 0; i < N; i++)  
    {  
        // If potential comes before curr in list of prefrences,  
        if (prefer[company][i] == currProg) {
            return true;
        } 
        //if potential comes before curr 
        if (prefer[company][i] == potentialProg ){
            return false;            
        }  
         
    } 
    return false; 
}  
  
static void makeMatch(int prefer[][]){  
    int pairs[] = new int[N];  
    boolean freeAgent[] = new boolean[N];  
    // Initialize all programmers as free agents
    Arrays.fill(pairs, -1);  
    int freeCount = N;  
  
    // While there are free men  
    while (freeCount > 0){  
        // check if programmer is looking for a job  
        int programmer;  
        for (programmer = 0; programmer < N; programmer++){
             if (freeAgent[programmer] == false)  
                break;

        }    
        // pick a free agent
        for (int i = 0; i < N &&  freeAgent[programmer] == false; i++){  
            int company = i;  

            // if the pair is open, pair is made
            if (pairs[company] == -1){  
                pairs[company] = programmer;  
                freeAgent[programmer] = true;  
                freeCount--;  
            }  
            else {  
                // Find current engagement of company  
                int currProg = pairs[company];  
                // check to see if match can be improved with new match
                if (checkMatch(prefer, company, currProg, programmer) == false){  
                    pairs[company] = programmer;  
                    freeAgent[programmer] = true;  
                    freeAgent[currProg] = false;  
                }  
            } 
        }  
          
    } 
  
// Print the solution  
System.out.println("Company Programmer");  
for (int i = 0; i < N; i++){
     
    System.out.print(" " );  
    System.out.println(i + "     " +  (pairs[i]+1)); 
} 
}  

} //end Lab