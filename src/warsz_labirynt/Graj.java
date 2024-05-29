package warsz_labirynt;

import java.util.Scanner;

public class Graj {
	public static void grajLab(char[][] lab){
		
		Scanner scan = new Scanner(System.in);
		
		String ruch;
		
		int[] dolar = {0,0};
		int[] at = {0,0};
		
		int x;
		int y;
		
		int yL = lab.length;    // wysokość labiryntu 
        int xL = lab[0].length; // Szerokość labiryntu 
		
		
		for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == '$') {
                    dolar[0] = i;
                    dolar[1] = j;
                }}}
    																	//Znajdowanie wsp gracza i wyjścia
		for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[i].length; j++) {
                if (lab[i][j] == '@') {
                    at[0] = i;
                    at[1] = j;
                }}}
		System.out.println("Odnalazłem symbole:\n$ "+dolar[0]+" "+ dolar[1]);
		System.out.println("Odnalazłem symbole:\n@ "+at[0]+" "+ at[1]);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		int kierunek = 2; // zmienna z drugiej próby 
		 x = dolar[1];
		 y = dolar[0];
		
		
		while(dolar[0] != at[0] || dolar[1] != at[1]) {
			
			for (int i = 0; i < lab.length; i++) {
	            for (int j = 0; j < lab[i].length; j++) {
	                System.out.print(lab[i][j] + " ");
	            }
	            System.out.println(); 
	        }
			
		     
			ruch = scan.next();
			
			x = dolar[1];
			y = dolar[0];
	
			switch(ruch.hashCode()) { 
			case 110:               //Dla n
				if(lab[y - 1][x] != '#' && y-1 <=yL  && y-1 >= 0) {
					lab[y][x] = '.';
					lab[y-1][x] = '$';
					dolar[0] = dolar[0] - 1;
					}else {System.out.println("Niedozwolony ruch");}
			break;
		
			case 101:				//Dla e
				if(lab[y][x + 1] != '#' && x+1 <=xL && x + 1 >= 0) {
					lab[y][x] = '.';
					lab[y][x+1] = '$';
					dolar[1] = dolar[1] + 1;
				}else {System.out.println("Niedozwolony ruch");}
				break;
				
			case 119:				//Dla w 
				if(lab[y][x - 1] != '#' && x-1 <=xL && x - 1 >= 0) {
					lab[y][x] = '.';
					lab[y][x-1] = '$';
					dolar[1] = dolar[1] - 1;
				}else {System.out.println("Niedozwolony ruch");}
				break;
				
			case 115:				//Dla s
			
				if(lab[y + 1][x] != '#' && y+1 <=yL  && y+1 >= 0) {
					lab[y][x] = '.';
					lab[y+1][x] = '$';
					dolar[0] = dolar[0] + 1;
					}else {System.out.println("Niedozwolony ruch");}
				break;
				} // koniec switcha  
			
			
			
			
			
			}  // koniec while od grania  
		
		
		
       
			 System.out.println("Ukończyłeś labirynt");
		
			
			 	System.exit(0);
			 	return;}
		
		
		
		
	} // ostatnie klamry
