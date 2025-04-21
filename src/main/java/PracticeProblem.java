import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class PracticeProblem {

	public static void main(String args[]) {
		q1();
		q2();
	}
		public static void q1(){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert a word: ");
		String word = scanner.nextLine();

		  ArrayList<String> result = perms(word);

        System.out.println("Permutations:");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> perms(String str) {
        Set<String> uniquePerms = new HashSet<>(); 
        generatePerms("", str, uniquePerms);

        return new ArrayList<>(uniquePerms); 
    }

    private static void generatePerms(String prefix, String remaining, Set<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                char c = remaining.charAt(i);
                String newPrefix = prefix + c;
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                generatePerms(newPrefix, newRemaining, result);
            }
        }
    }
		
		public static void q2(){

		Scanner scanner = new Scanner(System.in);
		System.out.print("Insert a word: ");
		String word = scanner.nextLine();

		ArrayList<String> result = permsUnique(word);

        System.out.println("Unique Permutations:");
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> permsUnique(String str) {
        Set<String> set = new HashSet<>();
        generateUnique("", str, set);
        return new ArrayList<>(set);
    }

    private static void generateUnique(String prefix, String remaining, Set<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                char c = remaining.charAt(i);
                String newPrefix = prefix + c;
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                generateUnique(newPrefix, newRemaining, result);
            }
        }
		

	}


}