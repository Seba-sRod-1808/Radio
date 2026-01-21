package src;

public class Main {
    public static void main(String[] args) {
        //CarRadio radio = new CarRadio(); NUESTRO
        Radio radio = new Radio();
        ConsoleView view = new ConsoleView(radio);
        view.controller();
    }
}