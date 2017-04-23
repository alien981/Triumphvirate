public class Ticket implements Comparable{

    public String name;
    private int number;
    private int priority;
    private String description;
    private String solution;
    public boolean resolved;
	
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
	solution = null;
	resolved = false;
    }
	
    public int getPriority(){
	return priority;
    }

    public String setSolution(String sol) {
	solution = sol;
	resolved = true;
	return solution;
    }

    public String getSolution() {
	return solution;
    }

    public int compareTo(Object x) {
	return priority - ( (Ticket) x).getPriority();
    }
	
    public String toString(){
	return description;
    }



}
