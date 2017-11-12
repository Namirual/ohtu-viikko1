package main;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    static final double tilavuus = 100.0;
    static final double alkuSaldo = 20.2;
    static final double otto1 = 50.7;
    static final double otto2 = 3.14;
    static final double lisäys1 = 3.14;
    static final double liiansuuri = 1000.0;
    static final double virheotto = -32.9;

    public static void main(String[] args) {
        Varasto mehua = new Varasto(tilavuus);
        Varasto olutta = new Varasto(tilavuus, alkuSaldo);
        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);
        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("getTilavuus    = " + olutta.getTilavuus());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());
        mehut();
        virheet1();
        virheet2();
        virheet3();
    }

    public static void mehut() {
        Varasto mehua = new Varasto(tilavuus);

        System.out.println("Mehusetterit:");
        System.out.println("Lisätään 50.7");
        mehua.lisaaVarastoon(otto1);
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Otetaan 3.14");
        mehua.otaVarastosta(otto2);
        System.out.println("Mehuvarasto: " + mehua);
    }

    public static void virheet1() {
        Varasto olutta = new Varasto(tilavuus, alkuSaldo);
        System.out.println("Virhetilanteita:\nnew Varasto(-100.0);");
        Varasto huono = new Varasto(-tilavuus);
        System.out.println(huono);

        System.out.println("new Varasto(100.0, -50.7)");
        huono = new Varasto(tilavuus, -otto1);
        System.out.println(huono);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.lisaaVarastoon(1000.0)");
        olutta.lisaaVarastoon(liiansuuri);
        System.out.println("Olutvarasto: " + olutta);
    }

    public static void virheet2() {
        Varasto mehua = new Varasto(tilavuus);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.lisaaVarastoon(-50.7)");
        mehua.lisaaVarastoon(-otto1);
        System.out.println("Mehuvarasto: " + mehua);

        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("mehua.otaVarastosta(-32.9)");
        double saatiin = mehua.otaVarastosta(virheotto);
        System.out.println("saatiin " + saatiin);
        System.out.println("Mehuvarasto: " + mehua);
    }

    public static void virheet3() {
        Varasto olutta = new Varasto(tilavuus, alkuSaldo);

        System.out.println("Olutvarasto: " + olutta);
        System.out.println("olutta.otaVarastosta(1000.0)");
        double saatiin = olutta.otaVarastosta(liiansuuri);
        System.out.println("saatiin " + saatiin);
        System.out.println("Olutvarasto: " + olutta);

    }
}
