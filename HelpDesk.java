import cs1.Keyboard;

public class HelpDesk{

    //are services still necessary? Or how can we change them to make them more relevant
    private String[] services = {"0: Send someone to deal with this", "1: My computer crashed", "2: How do you install Java?", "3: I forgot my password", "4: I clicked something", "5: IDK" , "101: I want pizza"};
    private String[] types = {"Not booting up", "Screen is blank", "Internet issues", "Slow or frozen", "Other"};
    private String[] solutions = {"Check if your computer is plugged in, and if not, reset to factory settings.", "Try rebooting your computer; if problem persists, call for help again and answer no for all questions.", "Disconnect to the wifi and reconnect again, or check the cable for the ethernet. If problem persists, call for help again and answer no for all questions.", "Clear your RAM and reboot your computer; if problem persists, call for help again and answer no for all questions.", "Please await human assistance."};
    private ArrayPriorityQueue queue;
    private int nextTicket;

    //constructor
    public HelpDesk(){
	nextTicket = 0;
	queue = new ArrayPriorityQueue();
    }

    //enqueue new tickets
    public void submitTicket(String yourName) {
	// USER INPUT FOR NAME 
	int serviceNum = classify();
	Ticket q = new Ticket(yourName, types[serviceNum], nextTicket, serviceNum);
	nextTicket++;
	queue.add(q);
    }

    //to determine the priority of issuee
    public int classify() {
	System.out.println("Is your computer not booting up? \n1: no \n2: yes");
	int s = Keyboard.readInt();
	if (s == 2) {
	    return 0;
	} else {
	    System.out.println("Is your screen blank? \n1: no \n2: yes");
	    s = Keyboard.readInt();
	    if (s == 2) {
		return 1;
	    } else {
		System.out.println("Is your computer having internet issues? \n1: no \n2: yes");
		s = Keyboard.readInt();
		if (s == 2) {
		    return 2;
		} else {
		    System.out.println("Is your computer slow or frozen? \n1: no \n2: yes" );
			s = Keyboard.readInt();
			if (s == 2) {
			    return 3;
			} else {
			    System.out.println("Thank you for your response.");
			    return 4;
			}
		}
	    }
	}
    }

    //overwrite toString
    public String toString(){
	return queue.toString();
    }

    //dequeue tickets by priority	
    public String resolveIssue(){
	Ticket current = (Ticket) queue.removeMin();
	current.setSolution(solutions[current.getPriority()]);
	String q = "\nName: " + current.name + "\nIssue: " + current + "\nSolution: " + current.getSolution();
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
	q.submitTicket("Wilson"); //internet issues
	q.submitTicket("Jonathan"); //other
	q.submitTicket("Billy"); //not booting up

	System.out.println(q.resolveIssue()); //billy
	System.out.println(q.resolveIssue()); //wilson
	System.out.println(q.resolveIssue()); //jonathan
	
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
