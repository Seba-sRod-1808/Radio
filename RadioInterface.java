public interface RadioInterface {
    void turnOn();
    void turnOff();
    boolean isOn();

    void switchBand(String band);
    String getBand();

    void saveStation(String station);
    void selectStation(String station);
    void nextStation();

    double getCurrentStation();

}