package ru.netology.oop2;

public class Radio {

    private int maxStationNum;
    private int minStationNum;
    private int currentRadioStationNum = minStationNum;

    private int maxVolLevel = 100;
    private int minVolLevel = 0;
    private int currentVolLevel = minVolLevel;

//    public Radio(int minStationNum, int maxStationNum) {  //конструктор с двумя переменными
//        this.minStationNum = minStationNum;
//        this.maxStationNum = maxStationNum;
//        this.currentRadioStationNum = minStationNum;
//    }

    public Radio(int size) {
        maxStationNum = minStationNum + size - 1;
        if (size < 0) {
            maxStationNum = currentRadioStationNum;
        }
    }

    public Radio() {
        maxStationNum = 9;
        minStationNum = 0;
    }

    public int getMaxStationNum() {
        return maxStationNum;
    }

    public int getMinStationNum() {
        return minStationNum;
    }

    public int getCurrentRadioStationNum() {
        return currentRadioStationNum;
    }

    public int getCurrentVolLevel() {
        return currentVolLevel;
    }

    public void setCurrentRadioStationNum(int newCurrentStationNum) {  //смена радиостанции вводом номера станции !!!!!!!!
        if (newCurrentStationNum < minStationNum) {
            currentRadioStationNum = minStationNum;
            return;
        }
        if (newCurrentStationNum > maxStationNum) {
            currentRadioStationNum = maxStationNum;
            return;
        }
        currentRadioStationNum = newCurrentStationNum;
    }

    public void setNextStation() {  //кнопка Next
        if (currentRadioStationNum == maxStationNum) {
            currentRadioStationNum = minStationNum;
        } else {
            currentRadioStationNum++;
        }
    }

    public void setPrevStation() {                    //кнопка prev
        if (currentRadioStationNum == minStationNum) {
            currentRadioStationNum = maxStationNum;
        } else {
            currentRadioStationNum--;
        }
    }

    //звук
    public void increaseVolume() {                  // прибавить громкости
        if (currentVolLevel < maxVolLevel) {
            currentVolLevel = currentVolLevel + 1;
        }

    }

    public void lowerVolume() {                   //убавить громкость
        if (currentVolLevel > minVolLevel) {
            currentVolLevel = currentVolLevel - 1;
        }
    }

    public void setCurrentRadioVol(int newCurrentRadioVol) {   //смена громкости вводом значения громкости
        if (newCurrentRadioVol > maxVolLevel) {
            return;
        }
        if (newCurrentRadioVol < minVolLevel) {
            return;
        }
        currentVolLevel = newCurrentRadioVol;
    }
}




