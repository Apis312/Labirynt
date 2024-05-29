package warsz_labirynt;
import java.util.Scanner;

public class Wpisz_labirynt {
	
	Scanner scan = new Scanner(System.in);
	
	int wysokosc;
	int szerokosc;
	boolean poprawne = false;
	char tymczas;
		
	public char[][] Wpisz() {
		while (poprawne == false) {
			System.out.println("Podaj wysokosc labiryntu");
			wysokosc = scan.nextInt();
				if(wysokosc > 0) { poprawne = true;}}
			
			poprawne = false;
			
			while (poprawne == false) {
				System.out.println("Podaj szerokosc labiryntu");
				szerokosc = scan.nextInt();
					if(szerokosc > 0) {poprawne = true;}}
			
			poprawne = false;
			
			char[][] array = new char[szerokosc][wysokosc];
			
			
			
			for (int i = 0; i < szerokosc ; i++) {
	            for (int j = 0; j < wysokosc ; j++) {
	            	while(poprawne == false) {
	            		System.out.println("Podaj znak");
	            		tymczas = scan.next().charAt(0);
	            		if (tymczas == '.' || tymczas == '#' || tymczas == '$' || tymczas == '@'){ array[j][i] = tymczas; poprawne = true; System.out.println("Wpisano pomyślnie"); }
	            			}
	            poprawne = false;}}
		return array;
	}
	

	public int getWys() {return wysokosc;}
	public int getSzer() {return szerokosc;}
	
	
}
