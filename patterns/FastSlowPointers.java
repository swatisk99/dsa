//$Id$
package learn.java.dsa.patterns;

import java.util.LinkedList;

public class FastSlowPointers {
	public static boolean checkIfCyclicLinkedList(LinkedList<Object> list) {
		for(int slowPointer = 0,fastPointer=0;fastPointer < list.size(); slowPointer++,fastPointer+=2) {
			if(slowPointer==fastPointer) {
				return true;
			}
		}
		return false;
	}
	
}
