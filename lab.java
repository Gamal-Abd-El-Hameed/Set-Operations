import java.util.Scanner;
import java.util.ArrayList;

public class lab {
	public static String stringToSet(String s) {
		String arr = s.replaceAll("\\{|\\}", "");
		arr = arr.replace(",", "");
		return arr;
	}
	
	public static ArrayList<String> Union(String[] sublists) {
		Scanner scan_int = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		System.out.println("Enter number of first subset:");
		int firstSublist = scan_int.nextInt()-1;
		System.out.println("Enter number of second subset:");
		int secondSublist = scan_int.nextInt()-1;
		String sub1 = sublists[firstSublist];
		String sub2 = sublists[secondSublist];
		arr.add(sub1);
		
		for(int i=0; i<sub2.length(); i=i+2)
		{
			boolean f = true;
			for(int j=0; f && j<sub1.length(); j += 2) 
				if(sub2.charAt(i) == sub1.charAt(j)) 
					f = false;
			if(f) arr.add(sub2.charAt(i) + "");
		}
		scan_int.close();
		return arr;
	}
	
	public static ArrayList<String> Intersection(String[] sublists) {
		ArrayList<String> arr = new ArrayList<String>();
		Scanner scan_int = new Scanner(System.in);
		System.out.println("Enter number of first subset:");
		int firstSublist = scan_int.nextInt()-1;
		System.out.println("Enter number of second subset:");
		int secondSublist = scan_int.nextInt()-1;
		String sub1 = sublists[firstSublist];
		String sub2 = sublists[secondSublist];
		
		for(int i = 0; i < sub1.length(); i += 2)
			for(int j=0; j<sub2.length(); j += 2)
				if(sub1.charAt(i) == sub2.charAt(j))
					arr.add(sub1.charAt(i)+"");
		scan_int.close();
		return arr;
	}
	
	public static ArrayList<String> Complement(String[] sublists, String s) {
		ArrayList<String> arr = new ArrayList<String>();
		Scanner scan_int = new Scanner(System.in);
		System.out.println("Enter number subset:");
		int Sublist = scan_int.nextInt() - 1;
		String sub = sublists[Sublist];
		for(int i = 0; i < s.length(); i += 2) 
		{
			boolean flag = true;
			for(int j = 0; flag && j < sub.length(); j += 2) 
				if(s.charAt(i) == sub.charAt(j))
					flag = false;
			if(flag) arr.add(s.charAt(i)+"");
		}
		scan_int.close();
		return arr;
	}
	
	public static void main(String args[]) {
		Scanner scan_str = new Scanner(System.in);
		Scanner scan_int = new Scanner(System.in);
		System.out.println("Enter Universal Set:");
		String universe = scan_str.nextLine();
		universe = stringToSet(universe);
		System.out.println("Enter number of subsets:");
		int num_sublists =  scan_int.nextInt();
		String[] sublists = new String[num_sublists];
		System.out.printf("Enter subsets:\n");
		for(int i = 0; i < num_sublists; i++) 
			sublists[i] = stringToSet(scan_str.nextLine());
		while(true)
		{
			System.out.println("Enter Type of operation:\n"
								+ "1-Union\n"
								+ "2-Intersection\n"
								+ "3-Complement\n");
			String operation = scan_str.nextLine().toLowerCase();
			ArrayList<String> arr = new ArrayList<String>(); // ArrayList contains final results
			if(operation.equals("union")) 
				arr = Union(sublists);
			else if(operation.equals("intersection")) 
				arr = Intersection(sublists);	
			else if(operation.equals("complement"))
				arr = Complement(sublists, universe);
			
			System.out.println("Result");
			for(int i = 0; i < arr.size(); i++)
				System.out.print(arr.get(i) + " ");
			System.out.println("\nEnter 1 for another Operation or -1 to Exit:");
			if(scan_int.nextInt() == -1) break;
		}
		scan_str.close();
		scan_int.close();
	}
}
