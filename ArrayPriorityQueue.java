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

public class ArrayPriorityQueue implements PriorityQueue {

    ArrayList<Comparable> _data;

    public ArrayPriorityQueue() {
        _data = new ArrayList<Comparable>();
    }
     
    //adds an item to this priority queue
    public void add (Comparable x) {
        int lo = 0;
        int mid = 0;
        int hi = _data.size()-1;
        while (lo <= hi) { //running until target is found or bounds cross
	    mid = (lo + hi) / 2; 
	    int c = _data.get(mid).compareTo(x); 
	    if (c == 0) {//mid value and x are EQUAL
		//time to traverse backwards until you reach either the front or the next level of priority
		while (mid > -1 && _data.get(mid).compareTo(x) == 0) {	    
		    mid = mid - 1;
		}
		_data.add(mid+1, x);
		return;
	    }
	    else if (c > 0) { //mid value is GREATER THAN x
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
    public Comparable peekMin() {
        return _data.get(_data.size() - 1);
    }
     
    public Object removeMin() {
        Comparable temp = peekMin(); 
        _data.remove(temp);
        return temp;
    }

    public String toString() {
	String retStr = "";
	for (Comparable x : _data) {
	    retStr += x + ",";
	}
	return retStr;
    }
	
	public void sort(){
			int maxPos;
	for( int pass = _data.size()-1; pass > 0; pass-- ) {
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		if ( _data.get(i).compareTo( _data.get(maxPos) ) > 0 )
		    maxPos = i;
	    }
	    _data.set( maxPos, ( _data.set( pass, _data.get(maxPos) ) ) );
	}
	}

    public static void main(String[] args) {
	ArrayPriorityQueue test = new ArrayPriorityQueue();
	
	Ticket q = new Ticket(1, "q");
	test.add(q);
	Ticket w = new Ticket(0, "w");
	test.add(w);
	Ticket e = new Ticket(5, "e");
	test.add(e);
	Ticket r = new Ticket(0, "r");
	test.add(r);
	test.sort();
	System.out.println(test);
	
/*	System.out.println(test.isEmpty());
	test.add(1); 
	test.add(2);
	test.add(2);
	test.add(2);
	test.add(3);
	test.add(3);
	test.add(4);
	test.add(4);
	test.add(4);
	test.add(5);
	test.add(4);
	test.add(3);
	test.add(2);
	test.add(1);
	System.out.println(test);
	System.out.println(test.isEmpty());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.removeMin());
	System.out.println(test.isEmpty());*/
    }
}


