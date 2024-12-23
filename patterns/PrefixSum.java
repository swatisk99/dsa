//$Id$
package learn.java.dsa.patterns;

public class PrefixSum {
	public static void getPrefixSumArray(int[] array) {
		int size = array.length;
		for(int i=1;i<size;i++) {
			array[i] += array[i-1];  
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,8,10};
		getPrefixSumArray(array);
	}

}
