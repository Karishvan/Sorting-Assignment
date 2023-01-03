import java.io.*;
public class DataCollector {
	
	//int i [] = new int[10];
	
	
	public static void main(String[] args) {
		String t1 = "bubble";
		String t2 = "select";
		String t3 = "insert";
		String t4 = "merge";
		String t5 = "quick";
		
		String[] sortTypes = {t1,t2,t3,t4,t5};
		String[] arrayTypes = {"rand", "near", "reversed", "unique"};
		
		
		
		int power = 1;
		
		//I is for sortType, J is for arrayType, and k is for power
		for (int i = 0; i < 5; i++) {
			String fileName = sortTypes[i];
			
			try {
				FileWriter fw = new FileWriter(new File(fileName + ".txt"));
				PrintWriter pw = new PrintWriter(fw);
				for (int j = 0; j < 4; j++) {
					pw.println("Array Type: " + arrayTypes[j]);
					for (int k = 0; k < 5; k++) {
						printToFile ((int) (Math.pow(10, power + k)), arrayTypes[j], sortTypes[i], power + k, pw);
					}
					
				} 
				
				pw.close();
			} catch (IOException e) {
			
			}
			
		
			
		}
		//printToFile((int) (Math.pow(10, power)), "near", t2, power);
			
	
		
		
		

	}
	
	public static long bubbleTime(int size, String arrType) {
		StopWatch sw = new StopWatch();
		int [] arr = getArray(size, arrType);
		
		sw.start();
		Sorts.bubbleSort(arr);
		sw.stop();
		
		return sw.getElapsedTime();
	}
	
	public static long selectionTime(int size, String arrType) {
		StopWatch sw = new StopWatch();
		int [] arr = getArray(size, arrType);
		
		sw.start();
		Sorts.selectSort(arr);
		sw.stop();
		
		return sw.getElapsedTime();
	}
	
	public static long insertTime(int size, String arrType) {
		StopWatch sw = new StopWatch();
		int [] arr = getArray(size, arrType);
		
		sw.start();
		Sorts.insertSort(arr);
		sw.stop();
		
		return sw.getElapsedTime();
	}
	
	public static long mergeTime(int size, String arrType) {
		StopWatch sw = new StopWatch();
		int [] arr = getArray(size, arrType);
		
		sw.start();
		Sorts.mergeSort(arr);
		sw.stop();
		
		return sw.getElapsedTime();
	}
	
	public static long quickTime(int size, String arrType) {
		StopWatch sw = new StopWatch();
	
		int [] arr = getArray(size, arrType);
		
		sw.start();
		Sorts.quickSort(arr);
		sw.stop();
		
		return sw.getElapsedTime();
	}
	
	
	public static int[] getArray(int size, String arrType) {
		int[] arr;
		if (arrType.equals("rand")) {
			arr = ArrayGen.randomizedArray(size);
			
		} else if (arrType.equals("near")) {
			arr = ArrayGen.nearlySortedArray(size);
		} else if (arrType.equals("reversed")) {
			arr = ArrayGen.reversedArray(size);
		} else {
			arr= ArrayGen.fewUniqueArray(size);
		}
		return arr;
	}
	
	
	public static void printToFile(int size, String arrayType, String sortType, int power, PrintWriter pw) {
		
		long sum = 0;
		
			
			for (int i = 0; i < 11; i ++) {
				long n;
				if (sortType.equals("bubble")) {
					n = bubbleTime(size, arrayType);
				} else if (sortType.equals("select")) {
					n = selectionTime(size, arrayType);
				} else if (sortType.equals("insert")) {
					n = insertTime(size, arrayType);
				} else if (sortType.equals("merge")) {
					n = mergeTime(size, arrayType);
				} else {
					n = quickTime(size, arrayType);
				}
				
				if (i != 0) {
					sum += n;
					System.out.println(n);
				}
				
			
				
			}
			pw.println(sum/10);
			
		
		
		
		
	}
		

}
