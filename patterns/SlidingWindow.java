//$Id$
package learn.java.dsa.patterns;

public class SlidingWindow {
	/** 
	 * returns starting index of subarray where adjacent elements have an expected sum 
	 * @param array
	 * @param expSum
	 * @param windowSize
	 * @return
	 */
	public static int getSumArray(int[] array, int expSum,int windowSize) {
		int n = array.length;
		int sum = 0;
		for(int j=0;j<windowSize;j++) {
			sum += array[j];
		}
		int i=0;
		for ( i = 1; i < n-2 && sum != expSum; i++) {
			sum = sum+array[i+windowSize-1]-array[i-1];
		}
		return i-1;
	}
	
	/**
	 * printssubarray of size {@code windowSize}
	 * @param array
	 * @param start
	 * @param windowSize
	 */
	public static void printSubArray(int[] array,int start, int windowSize) {
		for(int i=start;i<start+windowSize;i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void main(String[] args) {
		int array[] = {3,2,7,5,9,6,2};
		int expSum = 20;
		int windowSize = 3;
		int index = getSumArray(array,expSum,windowSize);
		printSubArray(array,index,3);
	}
}
