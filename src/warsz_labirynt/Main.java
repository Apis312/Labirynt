package warsz_labirynt;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int wybor = 0;
		char[][] labirynt = {{1,2,3}, {4,5,6}};
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Działam");
		
	
		
		while(wybor != 5) {
			
			System.out.println("Wybierz funkcję\n1.Wczytaj z pliku\n2.Wprowadz recznie\n3.Graj\n4.Samograj\n5.Wyjdz");
			wybor = scan.nextInt();
		
		switch(wybor) {
		
		case 1:
			//Wczytywanie labiryntu z pliku tekstowego
			labirynt = Wczytaj.wczytajPlik();
			wybor = 0;
			break;
			
		case 2:
			//Wpisywanie labiryntu "z palca"
			Wpisz_labirynt l1 = new Wpisz_labirynt();
			labirynt =  l1.Wpisz();
			int x = l1.getSzer();
			int y = l1.getWys();
			
			boolean jestAt = false;
			boolean jestDol = false;
			
			
			for(int i = 0 ; i < y; i++) {
				for(int j = 0; j < y; j++) {
					
					if(labirynt[j][i]== '@') {jestAt = true; }
					if(labirynt[j][i] == '$') {jestDol = true;}
					}}
			
			if(jestAt == false || jestDol == false) {System.out.println("W podanym labiryncie nie ma puntku początkowego lub końcowego");}
			
			wybor = 0;
			break;
			
			
		case 3:
			//graj w labirynt
			
			System.out.println("Poruszaj $ tak by dotrzeć do @\nBy sterować wprowadz litere N E W S (poruszanie zgodnie z kompasem)\nWpisz dowolny symbol by kontynuować");
			scan.next();
			//System.out.println("test");
			Graj.grajLab(labirynt);
			break;
			

		case 4:
			//samograj
			Samograj.sgrajLab(labirynt);
			break;
			
		case 5:
		System.out.println("\n\nDowidzenia!");
		System.exit(0);
		
		}}
		}}
