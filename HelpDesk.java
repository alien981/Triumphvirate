public class HelpDesk{

	private String[] services = {"0: Send someone to deal with this", "1: My computer crashed", "2: How do you install Java?", "3: I forgot my password", "4: I clicked something", "5: IDK" , "101: I want pizza"};
	private ArrayPriorityQueue queue;
	private int nextTicket;
	
	public HelpDesk(){
		nextTicket = 0;
		queue = new ArrayPriorityQueue();
	}
	
	public void submitTicket(String yourName, String problem, int serviceNum){
		Ticket q = new Ticket(yourName, problem, nextTicket, serviceNum);
		nextTicket++;
		queue.add(q, q.getPriority());
	}
	
	public String toString(){
		return queue.toString();
	}
	
	
	

	
	public String resolveIssue(){
		String q = "Issue solved: ";
		q += queue.removeMin();
		return q;
	}


	public String getServices(){
		String q = "";
		for(String w: services){
			q+= w + "\n";
		}
		return q;
	}
	
	
	
	public static void main(String[] args){
		HelpDesk q = new HelpDesk();
		q.submitTicket("q", "f", 5);
		q.submitTicket("q", "a", 0);
		q.submitTicket("q", "b", 2);
		q.submitTicket("q", "c", 2);
		q.submitTicket("q", "e", 4);
		q.submitTicket("q", "d", 3);
		System.out.println(q);
		
		System.out.println(q.resolveIssue());
		System.out.println(q.resolveIssue());
		System.out.println(q.resolveIssue());
		System.out.println(q.resolveIssue());
		System.out.println(q.resolveIssue());
		System.out.println(q.resolveIssue());
		
		System.out.println(q.getServices());
	}
	
}