package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisaaTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldollisellaKonstruktorillaOikeaTilavuus() {
        Varasto saldoVarasto = new Varasto(4, 2);
        assertEquals(4, saldoVarasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldollisellaKonstruktorillaOikeaSaldo() {
        Varasto saldoVarasto = new Varasto(4, 2);
        assertEquals(2, saldoVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void alkuSaldollisellaSaldoEiVoiOllaTilavuuttaSuurempi() {
        Varasto saldoVarasto = new Varasto(4, 8);
        assertEquals(4, saldoVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriMuuttaaNegatiivisetParametritNolliksi() {
        Varasto huonoVarasto = new Varasto(-10);
        assertEquals(0, huonoVarasto.getTilavuus(), vertailuTarkkuus);

        huonoVarasto = new Varasto(-10, -5);
        assertEquals(0, huonoVarasto.getTilavuus(), vertailuTarkkuus);
        assertEquals(0, huonoVarasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void eiVoiLisataNegatiivistaMaaraa() {
        double nykymaara = varasto.getTilavuus();
        varasto.lisaaVarastoon(-4);

        assertEquals(nykymaara, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void varastonSaldoKohoaaLisatessaVainMaksimiinAsti() {
        varasto.lisaaVarastoon(20);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastostaEiVoiOttaaNegatiivistaMaaraa() {
        double nykymaara = varasto.getSaldo();
        varasto.otaVarastosta(-4);

        assertEquals(nykymaara, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastostaVoiOttaaVainNiinPaljonKuinSaldoaOn() {
        varasto.lisaaVarastoon(10);
        assertEquals(10, varasto.otaVarastosta(20), vertailuTarkkuus);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void varastoOlioEsitetaanOikeanmuotoisenaMerkkijonona() {
        varasto.lisaaVarastoon(5);
        assertEquals("saldo = 5, vielä tilaa 5", varasto.toString());
    }
}
