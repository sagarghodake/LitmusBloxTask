package multithreading;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Convert {
	public static void main(String[] args) {
		String fileContenet=readFileAndWrittenContentInString(new File("C:\\Users\\sagar\\Downloads\\JavaProject.csv"));
		double fixedCostTotal=0,totalActualHours=0;
		System.out.println("TASK 1");
		System.out.println(fileContenet);
		String []allRows=fileContenet.split("\n");
		//printArray(allRows);
		System.out.println("TASK2");
		System.out.println("STATUS,PRIORITY,DEADLINE,FIXED COST,ACTUAL HRS");
		
		// started reading from second row as first row is nothing but labels
		for(int i=1;i<allRows.length;i++){
			String columnData[]=allRows[i].split(",");
		//STATUS,PRIORITY,DEADLINE,TASK NAME,ASSIGNEE,DESCRIPTION,DELIVERABLE,% DONE,FIXED COST,EST. HRS,ACTUAL HRS
		//0       1          2      3            4         5            6         7        8        9         10
			System.out.println(columnData[0]+"  |  "+columnData[1]+"  |  "+columnData[2]+"  |  "+columnData[8]+"  |  "+columnData[10]);
		    String fixedCostAfterRemovingCurrencyUnit=columnData[8].replaceAll("[^0-9.]", "");  
			fixedCostTotal=fixedCostTotal+Double.parseDouble(fixedCostAfterRemovingCurrencyUnit);
			totalActualHours=totalActualHours+Integer.parseInt(columnData[10].replaceAll("[^0-9.]", ""));
		}
		System.out.println("-----------------------------------$"+fixedCostTotal+"  |  "+totalActualHours);
	}
	public static void printArray(String [] input){
		for(String data:input)
			System.out.println(data);
	}
	public static String readFileAndWrittenContentInString(File inputFile) {
		String content = "";
		try {
			FileInputStream inputStream = new FileInputStream(inputFile);
			int data=0;
			while((data=inputStream.read())!=-1){
				content=content+(char)data;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Input file not found at specifiad path.Check if file present in path specified." + e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem in reading input file. "+e.getMessage());
		}

		return content;
	}
}
