Gra w labirynt. 

treść zadania : 
  Stworzyć aplikację, która wczyta z pliku lub standardowego wejścia, dwuwymiarowy obraz labiryntu o określonych rozmiarach. Pola w labiryncie mogą przyjąć następujące wartości:
  - #, ściana na którą nie można wejść,
  - ., korytarz po którym można chodzić,
  - $, punkt startowy
  - @, punkt docelowy.
  Aplikacja na wyjściu wypisuje ciąg kroków, nieoddzielonych żadnymi znakami (tj. spacje, nowe linie), który wystarczy do przejścia labiryntu od początku do końca. Droga nie musi być optymalna i uwzględnia nawroty.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Instrukcja
Program nie wymaga żadnych dodatkowych instalacji. 
Plik w którym znajduje się labirynt do czytania powinien nazywać się "plik" i mieć rozszerzenie .txt 
Jego lokalizacja to główny katalog projektu. Jeśli chcemy by nasz plik nazywał się inaczej / znajdował się w innym miejscu należy zmienić zawartość zmiennej w pliku Wczytaj.

Dodatkowe informacje o tym jak samodzielnie zagrać, zostają podane na wyjście konsoli po wybraniu opcji odpowiedzialnej za funkcję "graj"

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

  Samograj
  Początek pliku jest taki sam jak w "Graj". Program znajduje istotne dla niego symbole "$" , "@".
  By przejść labirynt samodzielnie labirynt stosuje metodę poruszania się wzdłuż ściany po prawej stronie. Najpierw zawsze stara się iść w prawo. 
  Kierunki dostępne w grze przechowywane są w tablicy {n,e,s,w} a zmienna k przechowuje nasze obecne "prosto". Jeśli k = 0 za prosto uznamy kierunek n, jeśli k = 2 to za "prosto" usnamy kierunek s.
  Program będzie się starał skręcić w prawo. Gdzie prawo rozumiane jest jako k + 1. Jeśli jest to możliwe to k = k + 1. Sprawia to że to co wcześniej było prawą stroną jest teraz postrzegane jako prosto. 
  Jeśli zwrot w prawo nie jest możliwy program sprawdzi możliwość przemieszczenia się na wprost. Jeśli to też nie jest możliwe spróbuje zwrotu w lewo. W ostateczności zawróci. 
  Trasa jaką przebędzie nasz samograj jest przechowywana w zmiennej rozwiązanie (typ string). Jeśli dany ruch został uznany za poprawny to dodajemy go do rozwiązania(konkatenacja) rozwiązanie = rozwiązanie + "s".
  Aby nie doszło do sytuacji w której k > 3 lub k < 0 wprowadziłem instrukcje if które dodają lub odejmują wartość 4. Jest tak dlatego że k = 4 było by jednoznaczne z k = 0, tzn. zostałby wykonany pełen obrót.
Jako że program zwraca trasę - nie pokazuje przebiegu na żywo, nie jest konieczne podmienianie znaków w tablicy. 
Gdy wsp. uznawane za $ pokryją się z wsp znaku "@" program opuszcza pętlę i wypisuje swoją trasę do konsoli.
Zamieszczam też plik z rysunkiem którym pomagałem sobie w projektowaniu tej funkcji programu.
  
  
  
