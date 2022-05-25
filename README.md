# OOP-projekt-2
OOP aine raames tehtud teine rühmatöö
Autorid: Karl Kristjan Tamm, Karl Väärtnõu

Kirjutada/paste-da tekst ning see lihtsa Caesari krüpteeringuga faili salvestada, võimalus dekrüpteerida failist ekraanile tekst.

Kirjeldus: Programmi eesmärk on krüpteerida tekst kasutades Caesar-i krüpteeringut, mis on sisuliselt
tähestikunihe. Kasutajal on võimalus sisestada tekst ning tahetud nihe (mis on siis krüpteeringu võti) 
ning vajutades Krüpteeri, krüpteerib teksti uue tekstifaili "krüpteeritud.txt". Kui tekstiväli on tühi, lööb
ette veateate, paludes sisestada teksti. Dekrüpteerida saab ainult tekstifailist, kasutaja peab sisestama nihke,
millega siis eeldatavasti teksti originaalselt krüpteeriti, valib faili ning ekraanile textarea-sse kuvatakse
dekrüpteeritud tekst. Et nõuded oleks täidetud, loetakse tekstist eraldi klassiobjekt (isend).

Klasside eesmärgid:
Erind - loodud erind, mis visatakse, kui Krüpteeringu isendit üritatakse luua tühja tekstiga

Krüpteering - klass, mis loob tekstist lihtsalt isendi, mille parameetriks ongi tekst sõnekujul.
Sisaldab kahte meetodit - krüpteeri ja dekrüpteeri. Krüpteeri väntab kogu sõne sümbolhaaval läbi, 
castib char-i int-iks, liidab kasutaja poolt antud nihke otsa, ning castib selle uuesti chariks. StringBuilderiga
ehitatakse järk-järgult üles krüpteeritud tekst. Dekrüpteeri töötab täpselt samamoodi, ainuke vahe on, et nihe
lahutatakse char-i int väärtusest, mitte ei liideta.

Peaklass - kogu kasutajaliides, kus kasutaja saab sisestada teksti mida krüpteerida soovitud nihkega, ning 
dekrüpteerimine, kus kasutaja saab failida faili, sisestada nihke ning kuvatakse ette dekrüpteeritud tekst.

Rühmaliikmete panus:
Karl Väärtnõu - kogu Peaklass.
Karl Kristjan Tamm - erind, Krüpteeringu klass ning väiksed viimistlused viimasel minutil Peaklassile.

Tegemiste mured:
JavaFX jändamine, katsetamine-eksimine, muud midagi. Töö sujus ja sai kiiresti tehtud.

Töö lõpptulemus:
8/10: Tegelt saaks palju etemalt teha, et tekst ei pea olema mingi veider eraldi isend, sai loodud 
lihtsalt selleks, et täita nõudmised. Samuti saaks teha sedasi, et kasutaja saab ka valida, kas tahab krüpteeritud
teksti faili või lihtsalt et saab aknast copyda, samamoodi dekrüpteeringuga - et saaks ka sisestada krüpteeritud
teksti ja aknast kuvatakse siis peale dekrüpteerimist dekrüpteeritud tekst. Aga üleüldiselt arvame, et vaadates, 
kui kiiresti pidime selle tegema, siis oleme tulemusega rahul.

Testimine:
Katsetasime krüpteeringu meetodeid erinevate sõnedega ning saime alati õiged tulemused.






