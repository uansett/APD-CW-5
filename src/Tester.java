import java.util.ArrayList;



public class Tester {
	public static void main(String args[]){
		// Adding Integers - Two inputs of same type
		Integer addUpto = 5;
		System.out.println(testAddIntegers(addUpto)); // should print 0+1..+addUpto
		Integer numberToInsert = 2;
		// should print the list from 0-addUpto with two elements with value of numberToInsert
		System.out.println(testIntListAndIntInsertInto(addUpto, numberToInsert)); 

	}

	private static String testAddIntegers(int upto){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(Integer i = 0;i<upto;i++)
			intList.add(i);
		return(""+Fold.fold(intList, new IntSumOfTwo()));
	}
	private static String testIntListAndIntInsertInto(Integer upto, Integer numberToInsert){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		for(Integer i = 0;i<upto;i++)
			intList.add(i);
		return (""+Fold.fold(intList, new IntListAndIntInsertInto()).toString());
	}
	
	private static class IntSumOfTwo implements Join<Integer, Integer>{
		@Override
		public Integer join(Integer t, Integer s) {
			if(t == null) t = 0;
			if(s == null) s = 0;
			return t+s;
		}
		
	}
	private static class IntLargestOfTwo implements Join<Integer, Integer>{

		@Override
		public Integer join(Integer t, Integer s) {
			if (t == null) t = 0;
			if (s == null) s = 0;
			return t>s?t:s;
		}
		
	}
	private static class IntAndStringLargestOfTwo implements Join<String, Integer>{

		@Override
		public Integer join(String t, Integer s) {
			if (t == null) t = "";
			if (s == null) s = 0;
			return t.length()>s?t.length():s;
		}
		
	}
	private static class IntListAndIntInsertInto implements Join<Integer,ArrayList<Integer>>{

		@Override
		public ArrayList<Integer> join(Integer t, ArrayList<Integer> s) {
			//REQUIRES: s has to be ordered {min .. max}
			if (t == null) t = 0;
			if (s == null) s = new ArrayList<Integer>();
			for(int i=0;i==s.size();i++){
				if(i==s.size()){
					s.add(t);
					break;
				}
				if(s.get(i)>t){
					s.add(i,t);
					break;
				}
			}
			return s;
		}
		
	}
	
}
