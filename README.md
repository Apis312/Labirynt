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
  W przypadku wyboru ręcznego wpistwania w pliku main jest zaimplementowana funkcjonalność samodzielnego utworzenia labiryntu przez podanie wymiarów tablicy a następnie wypełnienie jej dozwolonymi znakami. Program sprawdzi czy stworzony w ten sposób labirynt zawiera "$" oraz "@", jeśli nie to poinformuje że lab. nie zawiera punktu początkowego lub końcowego 

  Wpisz_labirynt
  Plik zawiera bardzo prostą możliwość ręcznego wpisania labiryntu. Podaje się wysokość i szerokość (wymiar tablicy) a następnie wypełnia tablicę znakami. Sprawdzana jest poprawność wymiarów (czy są większe od 0). Program na bierząco sprawdza czy podany znak jest poprawny - nie pozwoli wypełnić tablicy np.literami.

  Wczytaj
  Plik ten zawiera funkcję która pozwala wczytać labirynt z pliku txt. W obecnej formie plik musi znajdować się w katalogu głównym projektu, jednak można wskazać inny plik zmieniając zawartość zmiennej "plik" np. na inną nazwę lub ścierzkę do innego pliku. 
  Do wczytywania labiryntu użyto java.io.BufferedReader, java.io.FileReader. Na wypadek gdyby plik nie istniał konieczna jest też obsługa wyjątków - zaimportowanie java.util.IOException. Zaimportowanie ArrayList oraz list pomaga nam obejść to że domyślne tablice w 
  javie nie mają metody podobnej do append(). W tym przypadku kolejne elementy są dodawane metodą .add().
  Plik jest "przerabiany" na pojedyncze linie które zostają dodane do tablicy linijki (jako array typu char). Pętla while od 30 linijki kodu tłumaczy linijki na tablicę dwuwymiarową typu char. Funkcja zwraca tę tablicę

  Graj
  Plik ten zawiera nie wymienioną w treści zadania funkcję umożliwiającą samodzielne przejście labiryntu (Napistałem ją żeby utworzyć zasady rządzące grą, mieć jak je przetestować oraz jestem zdania że Gra nie może przechodzić się sama).
  Przed rozpoczęciem właściwej gry program odnajduje pozycję znaków $ oraz @. Pozycje te przypisywane są do zmiennych dolar , at. Jest to istotne ponieważ w logice gry, zwycięstwo jest osiągnięte gdy współrzędne $ pokryją się z wsp. @.
  By znaleźć pozycję znaków dwie pętle for przeszukują ją znak po znaku i jeśli na danej pozycji znajduje się poszukiwany znak zapisyują jego pozycję. 
  W kodzie pozostawiłem linie kodu informujące o tym że symbole zostały odnalezione oraz na jakiej pozycj, mimo że nie są one konieczne.
  Gracz może przemieszczać "$" podając w konsoli kierunek przemieszczenia jako kierunek geograficzny N-góra E-lewo itd.
  Przed wykonaniem polecenia program sprawdza czy ruch jest możliwy - czy nie jest to próba wejścia w ścianę lub wyjścia poza rozmiar tablicy.
  Gra kończy się gdy gracz doprowadzi "$" do pozycji na której znajduje się "@"
  
  
  
