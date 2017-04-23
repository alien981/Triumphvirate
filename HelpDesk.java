import cs1.Keyboard;

public class HelpDesk{

    private String[] services = {"0: Send someone to deal with this", "1: My computer crashed", "2: How do you install Java?", "3: I forgot my password", "4: I clicked something", "5: IDK" , "101: I want pizza"};
    private String[] types = {"Not booting up", "Screen is blank", "Internet issues", "Slow or frozen", "Other"};
    private String[] solutions;
    private ArrayPriorityQueue queue;
    private int nextTicket;
	
    public HelpDesk(){
	nextTicket = 0;
	queue = new ArrayPriorityQueue();
    }
	
    public void submitTicket(String yourName) {
	serviceNum = classify();
	Ticket q = new Ticket(yourName, types[serviceNum], nextTicket, serviceNum);
	nextTicket++;
	queue.add(q);
    }

    //to determine the priority of issuee
    public int classify() {
	System.out.println("Is your computer booting up? \n1: no \n2: yes");
	int s = Keyboard.readInt();
	if (s == 1) {
	    return 0;
	} else {
	    System.out.println("Is your screen blank? \n1: no \n2: yes");
	    int s = Keyboard.readInt();
	    if (s == 2) {
			System.out.println(1);
			return 1;
	    } 
		else {
		System.out.println("Is your computer having internet issues? \n1: no \n2: yes");
		int s = Keyboard.readInt();
		if (s == 2) {
		    System.out.println(2);
		    return 2;
		} else {
		    System.out.println("Is your computer slow or frozen? \n1: no \n2: yes" );
			int s = Keyboard.readInt();
			if (s == 2) {
			    System.out.println(3);
			    return 3;
			} else {
			    System.out.println("Thank you for your response.");
			    System.out.println(4);
			    return 4;
			}
		}
	    }
	}
    }
	
    public String toString(){
	return queue.toString();
    }
	
    public String resolveIssue(){
	Ticket current = queue.removeMin();
	current.setSolution(solutions[current.getPriority()]);
	if (current.resolved == true) {
	    String q = "Issue: " + current + "\nSolution: " + current.getSolution();
	}
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
	q.submitTicket("w");
	/*q.submitTicket("q", "f", 5);
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
		
	System.out.println(q.getServices());*/
    }
	
}
