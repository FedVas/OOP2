package ru.netology.oop2;

public class Radio {
    private int currentRadioStationNum;
    private int currentVolLevel;

    public int getCurrentRadioStationNum() {
        return currentRadioStationNum;
    }

    public int getCurrentVolLevel() {
        return currentVolLevel;
    }

    public void setCurrentRadioStationNum(int newCurrentStationNum) {  //смена радиостанции вводом номера станции
        if (newCurrentStationNum < 0) {
            return;
        }
        if (newCurrentStationNum > 9) {
            return;
        }
        currentRadioStationNum = newCurrentStationNum;
    }

    public void setNextStation() {  //кнопка Next
        if (currentRadioStationNum == 9) {
            currentRadioStationNum = 0;
        } else {
            currentRadioStationNum++;
        }
    }

    public void setPrevStation() {                    //кнопка prev
        if (currentRadioStationNum == 0) {
            currentRadioStationNum = 9;
        } else {
            currentRadioStationNum--;
        }
    }

    //звук
    public void increaseVolume() {                  // прибавить громкости
        if (currentVolLevel < 100) {
            currentVolLevel = currentVolLevel + 1;
        }

    }

    public void lowerVolume() {                   //убавить громкость
        if (currentVolLevel > 0) {
            currentVolLevel = currentVolLevel - 1;
        }
    }

    public void setCurrentRadioVol(int newCurrentRadioVol) {   //смена громкости вводом значения громкости
        if (newCurrentRadioVol > 100) {
            return;
        }
        if (newCurrentRadioVol < 0) {
            return;
        }
        currentVolLevel = newCurrentRadioVol;
    }
}




