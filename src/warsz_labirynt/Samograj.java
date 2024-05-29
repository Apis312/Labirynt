package warsz_labirynt;


import java.util.Scanner;

public class Samograj {
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////
	public static void sgrajLab(char[][] lab){
		
		
		Scanner scan = new Scanner(System.in);
		String[] kierunki = {"n","e","s","w"};
		int[] proba = {1,0,3,2};
		
		String rozwiazanie = "";
		
	
		
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
	
			// tutaj samograj 
		
		boolean poprawny = false;
		int k = 0;   //początkowe "prosto" to północ 
		
		
		while(dolar[0] != at[0] || dolar[1] != at[1]) {		
			
			poprawny = false;
			
			k = k + 1;  // w prawo
			if(k >= 4) {k = k - 4;}  // żeby nie wyjść poza wymiar tablicy
			
			while(poprawny != true) {
			// Sprawdz wszystkie kierunki dla "prawo"
			if(kierunki[k] == "n") {
				if(lab[dolar[0] - 1][dolar[1]]  != '#') {				//sprawdz czy "prawo" to północ i jeśli tak to czy można wykonać taki ruch
					rozwiazanie = rozwiazanie + "n";
					dolar[0] = dolar [0] - 1;
					poprawny = true;
					k = 0;		//od teraz prosto to północ
				}}else if(kierunki[k] == "e") {
							if(lab[dolar[0]]   [dolar[1] + 1] != '#') {		//sprawdz czy prawo to wschód 
								rozwiazanie = rozwiazanie + "e";
								dolar[1] = dolar[1] + 1;
								k = 1;	//od teraz prosto to wschód 
								poprawny = true;
							}
				}else if(kierunki[k] == "s") {
							if(lab[dolar[0] + 1]	[dolar[1]] != '#') {
								rozwiazanie = rozwiazanie + "s";
								dolar[0] = dolar[0] + 1;
								k = 2;
								poprawny = true;
							}}
				else if (kierunki[k] == "w") {
							if(lab[dolar[0]]	[dolar[1] - 1] != '#') {
								rozwiazanie = rozwiazanie + "w";
								dolar[1] = dolar[1] - 1;
								k = 3;
								poprawny = true;
							}}
			if(poprawny == true) {continue;}
			
			k = k - 1;
			if( k <= 0) {k = k + 4;}
			//Sprawdz wszystkie kierunki dla prosto
			
			
			
			if(kierunki[k] == "n") {
				if(lab[dolar[0] - 1][dolar[1]]  != '#') {				//sprawdz czy "prawo" to północ i jeśli tak to czy można wykonać taki ruch
					rozwiazanie = rozwiazanie + "n";
					dolar[0] = dolar [0] - 1;
					poprawny = true;
					k = 0;		//od teraz prosto to północ
				}}else if(kierunki[k] == "e") {
							if(lab[dolar[0]]   [dolar[1] + 1] != '#') {		//sprawdz czy prawo to wschód 
								rozwiazanie = rozwiazanie + "e";
								dolar[1] = dolar[1] + 1;
								poprawny = true;
								k = 1;	//od teraz prosto to wschód 
							}
				}else if(kierunki[k] == "s") {
							if(lab[dolar[0] + 1]	[dolar[1]] != '#') {
								rozwiazanie = rozwiazanie + "s";
								dolar[0] = dolar[0] + 1;
								k = 2;
								poprawny = true;
							}}
				else if (kierunki[k] == "w") {
							if(lab[dolar[0]]	[dolar[1] - 1] != '#') {
								rozwiazanie = rozwiazanie + "w";
								dolar[1] = dolar[1] - 1;
								k = 3;
								poprawny = true;
							}}
			
			if(poprawny == true) {continue;}
			
			k = k + 3;
			if(k >= 4) {k = k - 4;}
			//sprawdz wszystkie kierunki dla "lewo"
			if(kierunki[k] == "n") {
				if(lab[dolar[0] - 1][dolar[1]]  != '#') {				//sprawdz czy "prawo" to północ i jeśli tak to czy można wykonać taki ruch
					rozwiazanie = rozwiazanie + "n";
					dolar[0] = dolar [0] - 1;
					poprawny = true;
					k = 0;		//od teraz prosto to północ
				}}else if(kierunki[k] == "e") {
							if(lab[dolar[0]]   [dolar[1] + 1] != '#') {		//sprawdz czy prawo to wschód 
								rozwiazanie = rozwiazanie + "e";
								dolar[1] = dolar[1] + 1;
								poprawny = true;
								k = 1;	//od teraz prosto to wschód 
							}
				}else if(kierunki[k] == "s") {
							if(lab[dolar[0] + 1]	[dolar[1]] != '#') {
								rozwiazanie = rozwiazanie + "s";
								dolar[0] = dolar[0] + 1;
								poprawny = true;
								k = 2;
							}}
				else if (kierunki[k] == "w") {
							if(lab[dolar[0]]	[dolar[1] - 1] != '#') {
								rozwiazanie = rozwiazanie + "w";
								dolar[1] = dolar[1] - 1;
								poprawny = true;
								k = 3;
							}}
			if(poprawny == true) {continue;}
			}
			// dodaj wartość boolean porpawne. Jeśli jest fałsz to wykonuj kolejne sprawdzenia
			// jeśli jest true wrócić na początek pętli i gites powinno być
			
			
			
			
			
		}//koniec while od samograja
		
		
			
	
			
			 System.out.println("Trasa jaką przebył samograj:\n"+ rozwiazanie);
		
		
			
		
		
		
		
	}} 

