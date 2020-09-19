/** This program implements the "Gale Shapley" algorithm,
    we specifically modeled after this implementation:  
https://www.sanfoundry.com/java-program-gale-shapley-algorithm/**/
public class MatchMaker{
    private int N, pairs;
    private String[][] pPref;
    private String[][] compPref;
    private String[] programmer;
    private String[] company;
    private String[] jobMatch;
    private boolean[] progMatch;
 
    // Constructor
    public MatchMaker(String[] prog, String[] comp, String[][] pp, String[][] cp){
        N = pp.length;
        pairs = 0;
        programmer = prog;
        company = comp;
        pPref = pp;
        compPref = cp;
        progMatch = new boolean[N];
        jobMatch = new String[N];
        match();
    }
    /** function to calculate all matches **/
    private void match(){
        while (pairs < N){
            int free;
            for (free = 0; free < N; free++)
                if (!progMatch[free])
                    break;
 
            for (int i = 0; i < N && !progMatch[free]; i++){
                int index = compIndexOf(pPref[free][i]);
                if (jobMatch[index] == null){
                    jobMatch[index] = programmer[free];
                    progMatch[free] = true;
                    pairs++;
                }
                else{
                    String currentPartner = jobMatch[index];
                    if (morePreference(currentPartner, programmer[free], index)){
                        jobMatch[index] = programmer[free];
                        progMatch[free] = true;
                        progMatch[progIndexOf(currentPartner)] = false;
                    }
                }
            }            
        }
        printResult();
    }// end calc matches method

    // function to check if company prefers new applicant over old applicant
    private boolean morePreference(String curPartner, String newPartner, int index){
        for (int i = 0; i < N; i++){
            if (compPref[index][i].equals(newPartner))
                return true;
            if (compPref[index][i].equals(curPartner))
                return false;
        }
        return false;
    }

    // Accessors 

    // gets index of programmer
    private int progIndexOf(String str){
        for (int i = 0; i < N; i++){
            if (programmer[i].equals(str))
                return i;
        }
        return -1;
    }
    // gets index of a company
    private int compIndexOf(String str){
        for (int i = 0; i < N; i++){
            if (company[i].equals(str))
                return i;
        }
        return -1;
    }
    // for output
    public void printResult(){
        System.out.println("Result : ");
        for (int i = 0; i < N; i++){
            System.out.println(company[i] +""+ jobMatch[i]);
        }
    }
    
    // Main 
    public static void main(String[] args){
        // this is the test example 
        String[] programmers = {"1", "2", "3", "4" ,"5"};
        String[] companies = {"A", "B", "C", "D", "E"};
        // prefrence lists from programmers
        String[][] progPref = {{"E", "A", "D", "B", "C"}, 
                         {"D", "E", "B", "A", "C"}, 
                         {"D", "B", "C", "E", "A"}, 
                         {"C", "B", "D", "A", "E"},
                         {"A", "D", "B", "C", "E"}};
        // prefrence list for companies                      
        String[][] compPref = {{"2", "5", "1", "3", "4"}, 
                         {"1", "2", "3", "4", "5"}, 
                         {"5", "3", "2", "1", "4"},
                         {"1", "3", "2", "4", "5"}, 
                         {"2", "3", "5", "4", "1"}};
        MatchMaker test1 = new MatchMaker(programmers, companies, progPref, compPref);                        
    }
} // end lab