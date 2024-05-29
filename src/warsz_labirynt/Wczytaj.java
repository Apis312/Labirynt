package warsz_labirynt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Wczytaj {
  
    
    public static char[][] wczytajPlik() {
    	
    	String plik = "plik.txt";
    	
        List<char[]> linijki = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(plik))) {
            String linia;
            
            while ((linia = reader.readLine()) != null) {
                char[] values = linia.toCharArray();                // linia z pliku na tablicę 
                linijki.add(values);}									// wpisanie do listy
        } catch (IOException e) {
            e.printStackTrace();			//jeśli pliku nie ma to funkcja zwraca null
            return null; }
        
        
        char[][] array = new char[linijki.size()][];
        for (int i = 0; i < linijki.size(); i++) {
            array[i] = linijki.get(i);
        }
        
        System.out.println("Pomyślnie wczytano plik");
        return array; 
    }
}
