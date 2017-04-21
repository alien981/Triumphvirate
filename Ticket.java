public class Ticket{

	private int priority;
	private String description;
	private String typeOfProblem;
	private int number;
	private String name;
	
	public Ticket(String yourName, String desc, int num, int serviceNum){
		description = desc;
		name = yourName;
		number = num;
		priority = serviceNum;
	}
	
	public int getPriority(){
		return priority;
	}



}