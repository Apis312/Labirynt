Gra w labirynt. 

treść zadania : 
  Stworzyć aplikację, która wczyta z pliku lub standardowego wejścia, dwuwymiarowy obraz labiryntu o określonych rozmiarach. Pola w labiryncie mogą przyjąć następujące wartości:
  - #, ściana na którą nie można wejść,
  - ., korytarz po którym można chodzić,
  - $, punkt startowy
  - @, punkt docelowy.
  Aplikacja na wyjściu wypisuje ciąg kroków, nieoddzielonych żadnymi znakami (tj. spacje, nowe linie), który wystarczy do przejścia labiryntu od początku do końca. Droga nie musi być optymalna i uwzględnia nawroty.

----------------------------------------------------------------------------------------------------------------------
Opis programu 

Program podzielony jest na kilka plików. Zawierają one implementacje określonych funkcji np. plik Samograj.java implementuje automatyczne rozwiązanie labiryntu oraz wypisanie tego rozwiązania na wyjście. 

  Main
  Główny plik zawierający funkcję main zawiera "menu" aplikacji. Za pomocą scannera oraz instrukcji switch pozwala wybrać którą funkcję programu chcemy wykorzystać. Konieczne było zaimportowanie jedynie java.util.Scanner. W pliku tym zostaje też zainicjalizowana tablica dwuwymiarowa typu char[][] która będzie służyła do przechowywania labiryntu.

  Wczytaj
  Plik ten zawiera funkcję która pozwala wczytać labirynt z pliku txt. W obecnej formie plik musi znajdować się w katalogu głównym projektu, jednak można wskazać inny plik zmieniając zawartość zmiennej "plik" np. na inną nazwę lub ścierzkę do innego pliku. 
  Do wczytywania labiryntu użyto java.io.BufferedReader, java.io.FileReader. Na wypadek gdyby plik nie istniał konieczna jest też obsługa wyjątków - zaimportowanie java.util.IOException. Zaimportowanie ArrayList oraz list pomaga nam obejść to że domyślne tablice w javie nie mają metody podobnej do append(). W tym przypadku kolejne elementy są dodawane metodą .add().
  Plik jest "przerabiany" na pojedyncze linie które zostają dodane do tablicy linijki (jako array typu char). Pętla while od 30 linijki kodu tłumaczy linijki na tablicę dwuwymiarową typu char. Funkcja zwraca tę tablicę
  
