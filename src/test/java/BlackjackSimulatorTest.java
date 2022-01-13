import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackjackSimulatorTest {

    @Test
    void setUpOnePlayer() {
        Player p = new Player("player1");
        assertEquals("player1", p.getName());
        assertTrue(p.getIsPlaying());
        assertEquals(0, p.getScore());
    }

    @Test
    void testIsAboveLimit() {
        Player p = new Player("player1");
        p.updateScore(22);
        assertTrue(p.isAboveLimit());
    }

    @Test
    void testIsNotAboveLimit() {
        Player p = new Player("player1");
        p.updateScore(21);
        assertFalse(p.isAboveLimit());
    }

    @Test
    void testUpdateScore() {
        Player p = new Player("player1");
        p.updateScore(10);
        assertEquals(10, p.getScore());
    }
}