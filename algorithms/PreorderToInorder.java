//$Id$
package learn.java;

import java.util.*;

class PreorderToInorder {
	
	public static void main(String[] args) {
		List<Integer> list= Arrays.asList(1,2,3,4,6,5,7);
		PreorderToInorder pTO = new PreorderToInorder();
		try {
			BinaryTree bT = pTO.getBTFromInOrder(list,0,list.size()-1);
			System.out.println(bT.toString());
			List<Integer> pre = pTO.getPreOrderFromBT(bT);
			pre.forEach(e-> System.out.println(e));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public BinaryTree getBTFromInOrder(List<Integer> inOrder,int start, int end) throws Exception {
		BinaryTree bT = new BinaryTree();
		if(inOrder!=null && !inOrder.isEmpty() && (start<=end && start>=0 && end<=inOrder.size())) {
			int	mid=(start+end)/2;
			int size = end-start+1;
			bT.setParent(inOrder.get(mid));
			if(size>1) {
				if(size==2) {
					bT.setlC(inOrder.get(0));
				}
				else if(size==3) {
					bT.setlC(inOrder.get(0));
					bT.setrC(inOrder.get(2));
				}
				else {
					bT.setlC(getBTFromInOrder(inOrder,0,mid-1));
					if(size==4) {
						bT.setrC(inOrder.get(3));
					}
					else {
						bT.setrC(getBTFromInOrder(inOrder,mid+1, end-1));	
					}
				}
			}
		}
		return bT;
	}
	
	
	public List<Integer> getPreOrderFromBT(BinaryTree bT){
		List<Integer> list = new LinkedList<>();
		if(bT!= null && !bT.isEmpty()) {
			list.add(bT.getParent());
			if (bT.getlC() instanceof Integer) {
				list.add((Integer)bT.getlC());
			}else {
				list.addAll(getPreOrderFromBT((BinaryTree)bT.getlC()));
			}
			if (bT.getrC() instanceof Integer) {
				list.add((Integer)bT.getrC());
			}else {
				list.addAll(getPreOrderFromBT((BinaryTree)bT.getrC()));
			}
		}
		return list;
	}
	
	//Initially, created sublists to for each BT subsets. This will cause trouble in large datasets
	//Switched to passing indices
	private static void convertToPreOrder(List<Integer> inOrder, int start,int end, List<Integer> preOrder) {
        if (inOrder == null || inOrder.isEmpty() && (start<=end && start>=0 && end<=inOrder.size())) {
            return;
        }        
        int mid = (end+start) / 2;
        preOrder.add(inOrder.get(mid));
        convertToPreOrder(inOrder,0, mid-1, preOrder);
        convertToPreOrder(inOrder,mid + 1, end, preOrder);
    }
	
	private static void getBTFromPreAndInorder(List<Integer> inOrder, List<Integer> preOrder, BinaryTree bT) {
		
	}
}
