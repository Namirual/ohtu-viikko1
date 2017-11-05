/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author lmantyla
 */
public class StatisticsTest {

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        Reader reader = new ReaderStub();
        stats = new Statistics(new ReaderStub());
    }

    @Test
    public void konstruktoriLuoStatistiikanJollaOnPelaajia() {
        assertEquals("Semenko", stats.search("Semenko").getName());
    }

    @Test
    public void josPelaajaaEiLöydyPalauttaaTyhjän() {
        assertEquals(null, stats.search("Selänne"));
    }

    @Test
    public void tiiminEtsiminenPalauttaaPelaajaListan() {
        assertEquals(3, stats.team("EDM").size());
    }

    @Test
    public void enitenPisteitäSaaneenHakuToimii() {
        assertEquals("Gretzky", stats.topScorers(2).get(0).getName());
        assertEquals("Lemieux", stats.topScorers(2).get(1).getName());

    }
}

class ReaderStub implements Reader {

    public ReaderStub() {
    }

    public List<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();

        players.add(new Player("Semenko", "EDM", 4, 12));
        players.add(new Player("Lemieux", "PIT", 45, 54));
        players.add(new Player("Kurri", "EDM", 37, 53));
        players.add(new Player("Yzerman", "DET", 42, 56));
        players.add(new Player("Gretzky", "EDM", 35, 89));

        return players;
    }
}
