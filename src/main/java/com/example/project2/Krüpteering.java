package com.example.project2;

public class Krüpteering {

    private final String tekst;
    //loob klassiisendi, mis on lihtsalt tekst
    public Krüpteering(String tekst) {
        this.tekst = tekst;
        //kui tekst on tühi, viskab erindi
        if(tekst.equals(""))
            throw new Erind("Tekst puudub!");
    }

    public  String krypteeri(int nihe) {
        //lihtlabane krüpteering - iga sümboli kohta stringis võtab selle chari int value, liidab sellele nihke ning
        //castib uue sümboli int väärtuse siis vastavaks chariks ning ehitab StringBuilderiga uut krüpteeritud sõne
        //ei hakanud kaasama olukorda, kus char-i int väärtus peaks unicode sümbolite
        //väärtustest üle minema, sest neid väärtuseid on tuhandeid, tavalised tähed on
        //kogu selle tabeli keskel niikuinii, ehk ei tohiks üle minna
        StringBuilder krypteeritudTekst = new StringBuilder();
        for (int i=0; i<tekst.length(); i++) {
            if (Character.isUpperCase(tekst.charAt(i))) {
                char ch = (char)((int)tekst.charAt(i) + nihe);
                krypteeritudTekst.append(ch);
            }else{
                char ch = (char)((int)tekst.charAt(i) + nihe);
                krypteeritudTekst.append(ch);
            }
        }
        return krypteeritudTekst.toString();
    }

    public  String deKrypteeri(int nihe) {
        //dekrüpteerimine täpselt sama loogika alusel mis krüpteerimine, aint et nihke liitmisel sisend-chari
        //int väärtuse otsa, lahutab selle ja siis castib intiks
        StringBuilder krypteerimataTekst = new StringBuilder();
        for (int i=0; i<tekst.length(); i++) {
            if (Character.isUpperCase(tekst.charAt(i))) {
                char ch = (char)((int)tekst.charAt(i) - nihe);
                krypteerimataTekst.append(ch);
            }else{
                char ch = (char)((int)tekst.charAt(i) - nihe);
                krypteerimataTekst.append(ch);
            }
        }
        return krypteerimataTekst.toString();
    }
    //siin lihtsalt testitud meetodite töötavust
    public static void main(String[] args) {
        Krüpteering krüpteering = new Krüpteering("Sisesta nihe, täisarvuna");
        System.out.println(krüpteering.krypteeri(1));
        Krüpteering dekkrypt = new Krüpteering("Tjtftub!ufltu-!njeb!tppwje!lsýquffsjeb");
        System.out.println(dekkrypt.deKrypteeri(1));
    }


}

