package com.example.project2;

public class Krüpteering {

    private final String tekst;

    public Krüpteering(String tekst) {
        this.tekst = tekst;
        if(tekst.equals(""))
            throw new Erind("Tekst puudub!");
    }

    public  String krypteeri(int nihe) {
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

    public static void main(String[] args) {
        Krüpteering krüpteering = new Krüpteering("Sisesta nihe, täisarvuna");
        System.out.println(krüpteering.krypteeri(1));
        Krüpteering dekkrypt = new Krüpteering("Tjtftub!ufltu-!njeb!tppwje!lsýquffsjeb");
        System.out.println(dekkrypt.deKrypteeri(1));
    }


}

