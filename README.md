<h1>Gerichtsplaner</h1>
<p>Gerichtsplaner ist ein Programm, das einen Gerichtsplan auf bestimmten Wünschen erfüllt, wie den Gerichtswünschen an bestimmten Tagen 
(z.B. am Montag soll etwas anderes gekocht werden als am Mittwoch) oder die Menge der Tage, die nach Kochen des Gerichtes das Gericht gegessen werden kann.</p>
<p>Es bringt dabei alle Gerichte mindestens einmal ein, sonst funktioniert das Programm auch nicht. Versucht aber auch wenn Gerichte mehr als einmal dran kommen müssen
möglichst ausgewogen zu sein.</p>
<h2>How to use</h2>
<h3>1. Jar-Datei & Start.bat</h3>
<p>Zum nutzen die jar-Datei weiter unten herunterladen oder builden. Im Ordner der jar-Datei eine bat-Datei zum Start anlegen, diese könnte so aussehen:</p>
<h4>Start.bat</h4>
<p>java -jar Gerichtsplaner.jar</p>
<h3>2. Gerichte.txt</h3>
<p>Des weiteren wird eine Datei für alle Gerichte benötigt. Bei dieser müssen in die erste Zeile alle Tage, an denen gekocht werden soll mit den 
Abkürzungen wie "Mo,Di,Mi,Do" reingeschrieben werden. Im Beispiel würde der Planer einen Plan für die Tage Montag, Dienstag, Mittwoch und Donnerstag generieren.</p>
<p>Darunter kommen alle Gerichte in eine eigene Zeile. Dies folgt folgendem Schema : ":Gerichtsname:, :Anzahl der Tagean denen das Gericht 
nach Kochen gegessen werden kann:, :Tage, an denen das Gericht erwünscht ist:"</p>
<p>Bei Gerichten, die mehr als ein Tag verzehrt werden können muss der Folgetag auch ein Kochtag sein, damit dieses Gericht eingeteilt wird. Es ist beispielsweise
nicht möglich, dass Dienstag und Donnerstag die einzigen "Kochtage" sind, wenn alle Gerichte 2 Tage oder länger verzehrt werden können.</p>
<p>Die Gerichte.txt-Datei könnte so aussehen<br>
<h4>Gerichte.txt</h4>
<p>Mo,Di,Mi,Do,Fr<br>
Plow,2,Di,Mi<br>
Tefteli1,2,Di,Mi,<br>
Tefteli2,1,Do<br>
Wraps,1,Di,Mi<br>
Pizza mit Thunfisch,1,Di,Mi<br>
Nudeln mit Tuschonko,1,Di,Mi<br>
Fischstaebchen,1,Di,Mi<br>
Gulasch,2,Di,Mi<br>
Omas Sosse,1,Di,Mi<br>
Schenkel mit Kartoffeln,1,Di,Mi<br>
Suppe mit Frikadellen,1,Mo<br>
Kartoffeln mit Wings,1,Mo<br>
Nudelsuppe,1,Mo<br>
Buchweizen und Tuschonko,1,Mo<br>
Suppe mit Klosen,1,Do<br>
Reissuppe,1,Do<br>
Bunte Nudeln mit Bockwurst,1,Fr<br>
Bratwurst,1,Fr<br>
Pelmeni,1,Fr<br>
Gebratene Kartoffeln,1,Mo<br>
Tuschonaja Kartoffeln,1,Do<br>
Po Franzuski,1,Mo<br></p>
<h3>3. Starten</h3>
<p>Anschließend auf die Start.bat-Datei doppelt klicken. Es wird wenn alles richtig gemacht worden ist eine Gerichtsplan.pdf-Datei generiert.</p>
<h2>Download</h2>
<p><a href="https://drive.google.com/file/d/1DjE0dyBIR_PrQir-uhnOKsv-jDrzs-fV/view?usp=sharing">Beispielordner herunterladen</a></p>
<p><a href="https://drive.google.com/file/d/1Tp8ppUVqhA7sSNLlwDE1YnMzthTgsnJO/view?usp=sharing">JAR-Datei herunterladen</a></p>
