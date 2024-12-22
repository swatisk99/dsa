//$Id$
package learn.java;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
	public Integer parent;
	public Object lC,rC;
	public BinaryTree() {
	}
	public BinaryTree(Integer parent, Object lC, Object rC) {
		this.parent = parent;
		this.lC = lC;
		this.rC = rC;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public Object getlC() {
		return lC;
	}
	public void setlC(Object lC) throws Exception {
		if(lC!=null && !(lC instanceof Integer) && !(lC instanceof BinaryTree)) {
			throw new Exception("Child nodes must be of Integer type or BinaryTree");
		}
		this.lC = lC;
	}
	public Object getrC() {
		return rC;
	}
	public void setrC(Object rC) throws Exception {
		if(rC!=null && !(rC instanceof Integer) && !(rC instanceof BinaryTree)) {
			throw new Exception("Child nodes must be of Integer type or BinaryTree");
		}
		this.rC = rC;
	}
	public int size() {
		int size = 0;
		if(this.parent!=null) {
			size++;
			if(this.lC instanceof Integer) {
				size++;
			}
			else {
				size += ((BinaryTree)(this.lC)).size();
			}
			if(this.rC instanceof Integer) {
				size++;
			}
			else {
				size += ((BinaryTree)(this.rC)).size();
			}
		}
		return size;
	}
	
	public boolean isEmpty() {
		return this.parent==null;
	}
	public String toString() {
		if(!isEmpty()) {
			return toString(0);
		}
		return null;
	}
	
	public String toString(int level) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < level; i++) {
            out.append("\t");
        }
		out.append(this.getParent()).append("\n");
		if (this.getlC() instanceof Integer) {
			for (int i = 0; i <= level; i++) {
	            out.append("\t");
	        }
			out.append((Integer)this.getlC()).append("\n");
		}else {
			out.append(((BinaryTree)this.getlC()).toString(level+1)).append("\n");
		}
		if (this.getrC() instanceof Integer) {
			for (int i = 0; i <= level; i++) {
	            out.append("\t");
	        }
			out.append((Integer)this.getrC()).append("\n");
		}else {
			
			out.append(((BinaryTree)this.getrC()).toString(level+1)).append("\n");
		}
		
	
//		if(this.lC instanceof Integer) {
//			out.append("\n").append(this.lC);
//		}
//		if(this.rC instanceof Integer) {
//			out.append("\t").append(this.rC);
//		}
//		if(this.lC instanceof BinaryTree) {
//			out.append("\n").append(this.lC);
//		}
//		if(this.rC instanceof BinaryTree) {
//			out.append("\t").append(this.rC);
//		}
		return out.toString();
	
	}

}
