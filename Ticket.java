public class Ticket implements Comparable{

    private int priority;
    private String description;
    private String typeOfProblem;
    private int number;
    private String name;
    private String solution;
    private boolean resolved;
	
    public Ticket(int num, String cargo){
	priority = num;
	description = cargo;
	resolved = false;
    }
	
    public Ticket(String yourName, String desc, int num, int serviceNum){
	description = desc;
	name = yourName;
	number = num;
	priority = serviceNum;
    }
	
    public int getPriority(){
	return priority;
    }

    public int compareTo(Object x) {
	return priority - ( (Ticket) x).getPriority();
    }
	
    public String toString(){
	return description;
    }



}
