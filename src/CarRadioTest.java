package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarRadioTest {

    @Test
    public void testTurnOnAndOff() {
        RadioInterface radio = new CarRadio();

        assertFalse(radio.isOn());

        radio.turnOn();
        assertTrue(radio.isOn());

        radio.turnOff();
        assertFalse(radio.isOn());
    }

    @Test
    public void testSwitchBandAndInitialStation() {
        RadioInterface radio = new CarRadio();
        radio.turnOn();

        radio.switchBand("AM");
        assertEquals("AM", radio.getBand());
        assertEquals(530, radio.getCurrentStation());

        radio.switchBand("FM");
        assertEquals("FM", radio.getBand());
        assertEquals(87.9, radio.getCurrentStation());
    }

    @Test
    public void testSaveAndSelectStation() {
        RadioInterface radio = new CarRadio();
        radio.turnOn();

        radio.nextStation(); // deberia dar 88.1
        radio.saveStation("1");
      // avanzar otra
        radio.nextStation(); // deberia dar 88.3
        assertEquals(88.3, radio.getCurrentStation(), 0.001);

        radio.selectStation("1");
        assertEquals(88.1, radio.getCurrentStation(), 0.001);
    }
}
