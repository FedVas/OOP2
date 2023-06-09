package ru.netology.oop2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {

    @ParameterizedTest  //граничные значения и позитивное значение; 5 тестов
    @CsvFileSource(files = "src/test/resources/RadioTestCase")
    public void limitValuesRadio(int input, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNum(input);

        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/VolTestCase")
    public void limitValuesVolume(int input, int expected) {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(input);

        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationIf9() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNum(9);

        radio.setNextStation();

        int expected = 0;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationIf0() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNum(0);

        radio.setNextStation();

        int expected = 1;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStationIf0() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNum(0);

        radio.setPrevStation();

        int expected = 9;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStationIf9() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNum(9);

        radio.setPrevStation();

        int expected = 8;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeIf100() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeIf0() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(0);

        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lowerVolumeIf0() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(0);

        radio.lowerVolume();

        int expected = 0;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lowerVolumeIf100() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(100);

        radio.lowerVolume();

        int expected = 99;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }
}

