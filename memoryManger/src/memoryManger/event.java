package memoryManger;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;


class  holeComparator implements Comparator<Hole>{ 
    
   
    public int compare(Hole p1,Hole p2) { 
        if (p1.start >p2.start) 
            return 1;
        else if (p1.start <= p2.start) 
            return -1;
        	return 0; 
        	
        	
}  
};
public class event {
	private static  double memsize;
	private static  int size;
//	private static  int size2;
	private   PriorityQueue<Hole> holeq = new PriorityQueue<Hole>(10, new holeComparator());
	public static   Vector<Hole> finalVHole =new Vector<>(size);

//	public  void setSize2()
//	{
	//	if(finalVHole.elementAt(0).start==0 &&finalVHole.elementAt(size-1).end==memsize)
		
		//	size2=size-1;
	//	else if (finalVHole.elementAt(0).start==0 || finalVHole.elementAt(size-1).end==memsize)
		//	size2=size;
		//else 
		//	size2=size+1;
	//}
	
	public  void setmemSize(double i)
	{
		memsize=i;
	}
	public  void setSize(int i)
	{
		size=i;
	}
	
	private void addholes(Vector v)

	{
	
	for(int i=0;i<size;i++)
	{	
	    
		Hole p=new Hole();
		p.start=(Double) ((Vector)v.elementAt(i)).elementAt(0);
		p.size=(Double) ((Vector)v.elementAt(i)).elementAt(1);
		holeq.add(p);
	    
	}
    }
	
	public  void HoleV(Vector v)
	{   
		addholes(v);
		while(!holeq.isEmpty())
		{    
			finalVHole.add(holeq.peek());
		    System.out.println(holeq.peek().start);
		    System.out.println(holeq.peek().size);
			holeq.remove();
		}
	}
	
	
}