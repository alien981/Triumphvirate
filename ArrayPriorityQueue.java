//Team Chipettes
//Kristin Lin, Yedoh Kang, Vernita Lawren
//APCS2 pd1
//HW32 -- Getting Past the Velvet Rope
//2017-04-19

/*~~~~~~~~~~~~~~~~~~~~~~~~~
  Algo: 
  End -> Front
  Front: first element in, first element out
  End: last element in, last element out
  Enqueue: add at the specified index, using binary search and linear search
  -> if the same number, traverse backwards until you reach another number, then shift everything one place to the right
  Dequeue: remove the last element (constant runtime)
  ~~~~~~~~~~~~~~~~~~~~~~~~~*/

import java.util.ArrayList;

public class ArrayPriorityQueue {

    ArrayList<T> _data;

    public ArrayPriorityQueue() {
        _data = new ArrayList<T>();
    }
     
    //adds an item to this priority queue
    public void add (T x, int y) {
        int lo = 0;
        int mid = 0;
        int hi = _data.size()-1;
        while (lo <= hi) { //running until target is found or bounds cross
	    mid = (lo + hi) / 2; 
	    int c = _data.get(mid).getPriority(); 
	    if (c == y) {//mid value and x are EQUAL
		//time to traverse backwards until you reach either the front or the next level of priority
		while (mid > -1 && _data.get(mid).getPriority() == y) {	    
		    mid = mid - 1;
		}
		_data.add(mid+1, x);
		return;
	    }
	    else if (c > y) { //mid value is GREATER THAN x
		//look at upper half of data
		lo = mid + 1; 
	    }
	    else { //mid value is LESS THAN x
		//look at lower half of data
		hi = mid - 1;
	    }
        }
        // x IS NOT PRESENT; insert x at lo.
        _data.add(lo, x);
    }

     
    //returns true if this stack is empty, otherwise returns false
    public boolean isEmpty() {
        return _data.size() == 0;
    }
     
    //returns the smallest item stored in the array
    public Ticket peekMin() {
        return _data.get(_data.size() - 1);
    }
     
    public Ticket removeMin() {
        Ticket temp = peekMin(); 
        _data.remove(temp);
        return temp;
    }

    public String toString() {
	String retStr = "";
	for (Ticket x : _data) {
	    retStr = x + ", " + retStr;
	}
	return retStr;
    }

    public static void main(String[] args) {
	ArrayPriorityQueue test = new ArrayPriorityQueue();
	System.out.println(test.isEmpty());
	Ticket q = new Ticket(0, "a");
	test.add(q);
	Ticket w = new Ticket(5, "d");
	test.add(w);
	Ticket e = new Ticket(0, "b");
	test.add(e);
	Ticket r = new Ticket(500, "e");
	test.add(r);
	Ticket t = new Ticket(1, "c");
	test.add(t);
	
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
    }
}


