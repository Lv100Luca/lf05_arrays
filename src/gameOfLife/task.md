# Game of Life****
In einer Petrischale wird eine Kolonie von Zellen gezüchtet. Auf der Petrischale sind die Zellen wie auf einem Schachbrett
angeordnet. Zwei Zellen, die senkrecht, waagerecht oder diagonal aneinander grenzen, nennt man benachbart. Eine Zelle hat 
also bis zu acht Nachbarn. Die Zellen einer Petrischale können tot oder lebendig sein. Lebende Zellen werden durch einen 
Kreis symbolisiert. Die Anzahl der Nachbarn einer Zelle, die lebendig sind, werden als Zahl der lebenden Nachbarn bezeichnet.
In jeder neuen Generation entscheidet sich für jede einzelne Zelle neu, ob sie lebendig oder tot ist. Entscheidungskriterium 
hierfür ist die Zahl der lebenden benachbarten Zellen:
- Eine Zelle wird (unabhängig von ihrem derzeitigen Zustand) in der nächsten Generation tot sein, wenn sie in der jetzigen
 Generation weniger als zwei oder mehr als drei lebende Nachbarn besitzt.
- Eine Zelle mit genau zwei lebenden Nachbarn ändert ihren Zustand nicht.
- Eine Zelle mit genau drei lebenden Nachbarn wird sich in der nächsten Generation im Zustand lebendig befinden.

Hierbei finden diese Zustandsänderungen alle auf einen Schlag statt, das heißt, der Zustand einer Zelle der neuen Generation
wird nur von Zellen aus der alten Generation beeinflusst. Die Aufgabe ist, die Entwicklung der Zellen zu simulieren. 
Hierbei soll der Spieler interaktiv in das Geschehen eingreifen können, indem er tote Zellen einer Generation vom Status 
tot auf lebend setzen kann. Für die Simulation existiert bereits eine grafische Oberfläche. Beim Start der Simulation wird 
die Anzahl der lebenden Zellen über ein Input-Dialog festgelegt. Die Größe der Petrischale beträgt 10 x 10; die Simulation
kann also maximal mit 100 lebendigen Zellen durchgeführt werden. Deine Aufgabe ist es, die Logikschicht der Anwendung zu 
implementieren.

### Aufgaben
Um dich mit dem Aussehen der GUI vertraut zu machen, führe die main-Methode der Klasse `GameOfLifeUI` aus. Da noch keine 
Logik vorhanden ist, bewirkt ein Klick auf den Button oder die Label noch nichts. Schließe das Fenster, wenn du fertig bist.
Orientiere dich bei der Implementierung an den Tests, indem du den Code schreibst, um einen Test zu erfüllen, ihn ausführst 
und dir dann den nächsten vornimmst. Zwischendurch kannst du immer wieder die GUI starten, um den erreichten Stand zu 
überprüfen.
#### 1.
Um das Spielfeld zu initialisieren und lebende Zellen in die Petrischale setzen zu können, müssen zunächst folgende Methoden
implementiert werden:
- `public void initializeBoard(int number)` initialisiert die Petrischale mit der ihr übergebenen Anzahl an lebenden Zellen,
die zufallsbestimmt in die Petrischale gesetzt werden. Sie wirft eine RuntimeException mit der Message "Die Anzahl der Zellen muss im Intervall 1 bis 100 liegen!", wenn die übergebene Anzahl nicht im
Intervall von 0 bis 100 liegt. Die Petrischale ist zwar nur 10 x 10 Felder groß, für die späteren Überprüfungen ist es 
allerdings sehr nützlich, die Außenränder um jeweils eine Reihe oben und unten und um jeweils eine weitere Spalte rechts 
und links zu erweitern, so dass die Petrischale eine Größe von 12x12 Feldern hat. Die eigentliche Petrischale befindet sich
dann auf den Koordianten 1, 1 bis 10, 10.  
- `public char[][] getBoard()` gibt die Petrischale im Format 10 x 10 Felder zurück.
- `public boolean setAliveCell(int row, int col)` setzt an die Stelle row, col eine lebende Zelle in die Petrischale. Die
Methode gibt true zurück, wenn das Setzen erfolgreich war, d.h. die Zelle an den Koordinaten row, col tot war und durch den
Aufruf auf lebend gesetzt werden konnte. Lebt die Zelle an den Koordinaten, wird false zurückgegeben. Row und Col sind dabei im Wertebereich 0 bis 9.
- `public int getAliveCell()` gibt die Anzahl der lebenden Zellen im Board zurück
- `public char getCellStatus(int row, int col)` gibt den Status der Zelle an der Stelle row, col in der Petrischale zurück,
also 'O' für eine lebende Zelle oder ' ' für eine tote Zelle.

Achte beim Implementieren der Methoden darauf, dass sie das Single Responibility-Prinzip einhalten, also immer nur für eine 
Aufgabe zuständig sind. Ist das nicht der Fall, lagere Codesnippets in private Hilfsmethoden aus und rufe sie geeignet auf.

Die Methoden werden von den ersten sechs Tests validiert. Starte wiederum die GUI. Nun müsstest du eine Petrischale mit 
der gewünschten Anzahl an Zellen initialisieren können und per Mausklick auf einzelne Zellen lebende Zellen setzen können.

#### 2.
Als nächstes ist die Logik der Simulation zu implementiren, so dass ein Klick auf den Button "Nächste Generation" eine 
neue Generation von Zellen simuliert und dabei die oben beschriebenen Regeln anwendet. Dazu sind folgende Methoden zu 
implementieren:
- `public void simulate()` führt die eigentliche Simulation unter Beachtung der oben beschriebenen Regeln durch, ersetzt 
also die alte Generation von Zellen durch eine neue.
- `public boolean simulationOver()` gibt true zurück, wenn es nach einer Simulation keine lebenden Zellen mehr gibt oder 
ein stationärer Zustand erreicht ist, d.h. sich die Anordnung der Zellen in der Petrischale durch eine Simulation nicht
mehr ändert. Die Simulation bricht ab, wenn diese Methode true zurückgibt.

Diese Methoden werden von den restlichen Tests validiert. Überprüfe deinen Code auch über das Starten der GUI.