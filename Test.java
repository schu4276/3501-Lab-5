public class Test{
	public static void main(String[] args){
      
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

        // Examples that are showcasing results with a different n
        String[] twoprogrammers = {"1", "2", "3"};
        String[] twocompanies = {"A", "B", "C"};
        // prefrence lists from programmers
        String[][] twoprogPref = {{"B", "A", "C"}, 
                         {"B", "C", "A"}, 
                         {"A", "C", "B"}};
        // prefrence list for companies                      
        String[][] twocompPref = {{"2", "3", "1"}, 
                         {"1", "2", "3"},  
                         {"2", "3", "1"}};
        MatchMaker twotest2 = new MatchMaker(twoprogrammers, twocompanies, twoprogPref, twocompPref);    

        // A third test showing that input can be any string 
        String[] twoprogrammers3 = {"Bob", "Jim", "Porky"};
        String[] twocompanies3 = {"Target", "BestBuy", "PizzaHut"};
        // prefrence lists from programmers
        String[][] twoprogPref3 = {{"TargetS", "PizzaHut", "BestBuy"}, 
                         {"PizzaHut", "BestBuy", "Target"}, 
                         {"Target", "PizzaHut", "BestBuy"}};
        // prefrence list for companies                      
        String[][] twocompPref3 = {{"Porky", "Jim", "Bob"}, 
                         {"Jim", "Porky", "Bob"},  
                         {"Bob", "Jim", "Porky"}};
        MatchMaker twotest3 = new MatchMaker(twoprogrammers3, twocompanies3, twoprogPref3, twocompPref3);                  
    }




}// end test