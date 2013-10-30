package test;

public class Prj1_Main {

	public static void main(String[] args) {
		String str = "Hello World !";
		int nombre = 1;
		
		System.out.println(str + nombre);
		
		String s[] = {"un","deux"};
		String t[] = s;
		s[0] = "trois";
		
		System.out.println(t[0] + " - "+ t[1]);
		
		// TODO Auto-generated method stub
	}
}
