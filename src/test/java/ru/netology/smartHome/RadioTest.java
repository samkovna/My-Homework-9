package ru.netology.smartHome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test   // для станции средней
    public void shouldSetStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(7);

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции выше диапазона
    public void shouldNotSetStationAboveMax() {
        Radio radio = new Radio();

        radio.setCurrentStation(22);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @Test   // для станции ниже диапазона
    public void shouldNotSetStationBelowMin() {
        Radio radio = new Radio();

        radio.setCurrentStation(-5);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции средней +
    public void shouldNextStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(6);

        radio.next();

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции средней -
    public void shouldPrevStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(4);

        radio.prev();

        int expected = 3;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции 9 +
    public void shouldNextStationAboveMax() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции 0 -
    public void shouldNextStationBelowMin() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для установки средней громкости
    public void shouldSetVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(40);

        int expected = 40;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для установки громкости выше 100
    public void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();

        radio.setCurrentVolume(90);
        radio.setCurrentVolume(150);

        int expected = 90;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для установки громкости ниже 0
    public void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();

        radio.setCurrentVolume(5);
        radio.setCurrentVolume(-10);

        int expected = 5;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для прибавления громкости
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(35);

        radio.increaseVolume();

        int expected = 36;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для уменьшения громкости
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(76);

        radio.decreaseVolume();

        int expected = 75;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для громкости 0 -
    public void shouldDecreaseVolumeBelowMin() {
        Radio radio = new Radio();

        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для громкости 100 +
    public void shouldIncreaseVolumeAboveMax() {
        Radio radio = new Radio();

        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

}
