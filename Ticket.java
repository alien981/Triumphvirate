public class Ticket implements Comparable{

    private String name;
    private int number;
    private int priority;
    private String description;
    private String typeOfProblem;
    private String solution;
    private boolean resolved;
	
    public Ticket(int num, String cargo){
	priority = num;
	description = cargo;
	resolved = false;
    }
	
    public Ticket(String yourName, String desc, int num, int serviceNum){
	name = yourName;
	number = num;
	priority = serviceNum;
	description = desc;
	typeOfProblem = null;
	solution = null;
	resolved = false;
    }
	
    public int getPriority(){
	return priority;
    }

    public int setPriority(int p) {
	priority = p;
	return priority;
    }

    public String setType(String type) {
	typeOfProblem = type;
	return typeOfProblem;
    }

    public String setSolution(String sol) {
	solution = sol;
	resolved = true;
	return solution;
    }

    public int compareTo(Object x) {
	return priority - ( (Ticket) x).getPriority();
    }
	
    public String toString(){
	return description;
    }



}
