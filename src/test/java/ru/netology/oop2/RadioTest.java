package ru.netology.oop2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class RadioTest {
    @Test
    public void inputSize() {                                                 // ввод к-ва радиостаннций
        Radio radio = new Radio(20);
        Assertions.assertEquals(19, radio.getMaxStationNum());
        Assertions.assertEquals(0, radio.getMinStationNum());
        Assertions.assertEquals(0, radio.getCurrentRadioStationNum());
    }

    @Test
    public void inputNegativeSize() {                                           //отрицательное к-во радиостанций
        Radio radio = new Radio(-20);
        Assertions.assertEquals(0, radio.getMaxStationNum());
        Assertions.assertEquals(0, radio.getMinStationNum());
        Assertions.assertEquals(0, radio.getCurrentRadioStationNum());
    }


    @ParameterizedTest                                  //граничные значения и позитивное значение; 5 тестов
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
    public void nextStationIfMax() {
        Radio radio = new Radio(11);
        radio.setCurrentRadioStationNum(10);

        radio.setNextStation();

        int expected = 0;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStationIfMin() {
        Radio radio = new Radio(44);
        radio.setCurrentRadioStationNum(0);

        radio.setNextStation();

        int expected = 1;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStationIfMin() {
        Radio radio = new Radio(51);
        radio.setCurrentRadioStationNum(0);

        radio.setPrevStation();

        int expected = 50;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void prevStationIfMax() {
        Radio radio = new Radio(40);
        radio.setCurrentRadioStationNum(39);

        radio.setPrevStation();

        int expected = 38;
        int actual = radio.getCurrentRadioStationNum();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeIfMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolumeIfMin() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(0);

        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lowerVolumeIfMin() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(0);

        radio.lowerVolume();

        int expected = 0;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lowerVolumeIfMax() {
        Radio radio = new Radio();
        radio.setCurrentRadioVol(100);

        radio.lowerVolume();

        int expected = 99;
        int actual = radio.getCurrentVolLevel();

        Assertions.assertEquals(expected, actual);
    }
}

