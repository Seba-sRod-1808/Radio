package src;

public class CarRadio implements RadioInterface {

    private boolean isOn;
    private String band; // cambia am por fm
    private double currentStation;

    private double[] amButtons;
    private double[] fmButtons;

    public CarRadio() {
        isOn = false;
        band = "FM";
        currentStation = 87.9;

        amButtons = new double[12];
        fmButtons = new double[12];
    }

    @Override
    public void turnOn() {
        isOn = true;
    }

    @Override
    public void turnOff() {
        isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void switchBand(String band) {
        if (!isOn) return;

        if (band.equals("AM")) {
            this.band = "AM";
            currentStation = 530;
        } else if (band.equals("FM")) {
            this.band = "FM";
            currentStation = 87.9;
        }
    }

    @Override
    public String getBand() {
        return band;
    }

    @Override
    public void nextStation() {
        if (!isOn) return;

        if (band.equals("FM")) {
            currentStation += 0.2;
            if (currentStation > 107.9) {
                currentStation = 87.9;
            }
        } else {
            currentStation += 10;
            if (currentStation > 1610) {
                currentStation = 530;
            }
        }
        
        currentStation = round(currentStation);
    }

    @Override
    public void saveStation(String station) {
        if (!isOn) return;

        int button = Integer.parseInt(station) - 1;
        if (button < 0 || button >= 12) return;

        if (band.equals("FM")) {
            fmButtons[button] = currentStation;
        } else {
            amButtons[button] = currentStation;
        }
    }

    @Override
    public void selectStation(String station) {
        if (!isOn) return;

        int button = Integer.parseInt(station) - 1;
        if (button < 0 || button >= 12) return;

        if (band.equals("FM")) {
            currentStation = fmButtons[button];
        } else {
            currentStation = amButtons[button];
        }
    }

    @Override
    public double getCurrentStation() {
        return currentStation;
    }

    private double round(double value) {
    return Math.round(value * 100.0) / 100.0;
}

}
