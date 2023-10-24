# RPR-Vjezbe<br>
Za lv1 nisam uspio koristiti plugin kao u videozapisu od V. prof. dr Dino Kečo BA ing. nego sam koristio maven-assembly-plugin 
https://github.com/BeginSecure/IntelliJExecutableJar koji je bio koristen u ovom videozapisu (https://www.youtube.com/watch?v=870XIYMrlSo&list=LL&index=1),
poslije toga morao sam pokrenuti maven-plugin (assembly/single) kako bi se kreirala jar datoteka.<br>Program se normalno pokrenuo u terminalnom bloku koristeci ovaj kod:  
<b>java -jar ./lv1-z1-1.0-SNAPSHOT-jar-with-dependencies.jar <b>

# UPUTE ZA GIT<br>
Za prebacivanje podataka iz lokalne memorije u github koristenjem samo GIT-bash a puno mi je pomogao
ovaj videozapis (https://www.youtube.com/watch?v=mJ-qvsxPHpY&list=LL&index=7&t) sve dok nisam dosao do pushanja podataka
npr: <br>

    git push -u origin lvn-zn (grana na koju hocu da sacuvam)
    ispisalo bi mi: remote: Permission to amujalo1/RPR-Vjezbe.git denied to neko (neki drugi account).
Ali uz pomoc Stručnjaka iz prakse <br>
mr Hamza Išerić (hiseric1@etf.unsa.ba)<br>
koji mi je pomogao da rijesim problem tako da prije pushanja posaljem komandu:

    git config --local credential.helper ""
Sada da sumiramo sve komande za jednostavnu upotrebu GIT-a:

    git init 
    git add .
    git commit -m "info zasto komitamo"
    git status
    git checkout -b ime-grane
    git remote add origin https://github.com/amujalo1/RPR-Vjezbe.git
    git config --local credential.helper ""
    git push -u origin  lvn-zn
  init - inserta kao memorijsku karticu unutar datoteku u kojoj smo pokrenuli git<br>
  !! caution !! proveriti gdje si u GIT-BASH u da ne bi doslo do zabuna, koristiti cd .., ls, i ostale Ribiceve metode<br>
  add - azuriranje (update) podataka koje odaberemo mozemo ih pojedinacno azurirati npr git add ime-dat ili mozemo sve      azurirati sa " .. "<br>
  commit -m - izvrsi sve naredbe koje smo poslali bashu, potrebno je dati komentar sta smo sve izvrsili<br>
  status - provjeravamo u kojoj smo grani<br>
  checkout -b - ulazimo u postojecu ili pravimo novu granu<br> 
  remote add - dodajemo link u kojoj repositoriju cemo sve ovo smjestiti<br>
  git push -u origin  - izvrsava prebacivanje u github cloud, dodatno treba dodati naziv grane<br>
  config --local credential.helper "" - ovo nam samo treba ako nam gresku bude izbacivalo nakon pusha<br> 
    
    

