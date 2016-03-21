import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String vocab = sc.next();
			System.out.println("The string '" + vocab + "' contains " + count(vocab.toUpperCase()) + " palindromes.");
		}
	}

	public static int count(String vocab){
		List<String> list = new ArrayList<String>();
		for(int i = 1; i < vocab.length() + 1; i++){
			for(int s = 0; s < vocab.length() - i + 1; s++){
				if(!list.contains(vocab.substring(s, s + i)) && verify(vocab.substring(s, s + i))){
					list.add(vocab.substring(s, s + i));
				}
			}
		}

		return list.size();
	}

	public static boolean verify(String vocab){
		for(int i = 0; i < vocab.length() / 2; i++){
			if(vocab.charAt(i) != vocab.charAt(vocab.length() - 1 - i)){
				return false;
			}
		}

		return true;
	}
}