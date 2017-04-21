public class HelpDesk{

	private String[] services;
	private ArrayPriorityQueue queue;
	private int nextTicket;
	
	public HelpDesk(){
		services = {"0: Send someone to deal with this", "1: My computer crashed", "2: How do you install Java?", "3: I forgot my password", "4: I clicked something", "5: IDK" , "101: I want pizza"};
	}
	
	
	public void submitTicket(String yourName, String problem, int serviceNum){
		Ticket q = newTicket(yourName, problem, nextTicket, serviceNum);
		nextTicket++;
	}


}