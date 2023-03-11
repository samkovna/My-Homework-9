package ru.netology.smartHome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio();

    @Test   // для станции средней
    public void shouldSetStation() {

        radio.setCurrentStation(7);

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции выше диапазона
    public void shouldNotSetStationAboveMax() {

        radio.setCurrentStation(22);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }


    @Test   // для станции ниже диапазона
    public void shouldNotSetStationBelowMin() {

        radio.setCurrentStation(-5);

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции средней +
    public void shouldNextStation() {

        radio.setCurrentStation(6);

        radio.next();

        int expected = 7;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции средней -
    public void shouldPrevStation() {

        radio.setCurrentStation(4);

        radio.prev();

        int expected = 3;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции 9 +
    public void shouldNextStationAboveMax() {

        radio.setCurrentStation(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для станции 0 -
    public void shouldNextStationBelowMin() {

        radio.setCurrentStation(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для установки средней громкости
    public void shouldSetVolume() {

        radio.setCurrentVolume(40);

        int expected = 40;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для установки громкости выше 100
    public void shouldNotSetVolumeAboveMax() {

        radio.setCurrentVolume(90);
        radio.setCurrentVolume(150);

        int expected = 90;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для установки громкости ниже 0
    public void shouldNotSetVolumeBelowMin() {

        radio.setCurrentVolume(5);
        radio.setCurrentVolume(-10);

        int expected = 5;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для прибавления громкости
    public void shouldIncreaseVolume() {

        radio.setCurrentVolume(35);

        radio.increaseVolume();

        int expected = 36;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для уменьшения громкости
    public void shouldDecreaseVolume() {

        radio.setCurrentVolume(76);

        radio.decreaseVolume();

        int expected = 75;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для громкости 0 -
    public void shouldDecreaseVolumeBelowMin() {

        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test   // для громкости 100 +
    public void shouldIncreaseVolumeAboveMax() {

        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test  // заданное количество станций в диапазоне
    public void setQuantityStations() {
        Radio radio = new Radio(7);

        radio.setCurrentStation(4);

        Assertions.assertEquals(0, radio.getMinStation());
        Assertions.assertEquals(6, radio.getMaxStation());
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test  // заданное количество станций более 10
    public void setQuantityStationsAboveMax() {
        Radio radio = new Radio(15);

        radio.setCurrentStation(8);

        Assertions.assertEquals(0, radio.getMinStation());
        Assertions.assertEquals(9, radio.getMaxStation());
        Assertions.assertEquals(8, radio.getCurrentStation());
    }
    @Test  // установить максимальную громкость
    public void setMaxVolume() {

        Assertions.assertEquals(100, radio.getMaxVolume());
    }

    @Test  // установить минимальную громкость
    public void setMinVolume() {

        Assertions.assertEquals(0, radio.getMinVolume());
    }

}
