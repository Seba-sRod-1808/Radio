package src;

public class Main {
    public static void main(String[] args) {
        CarRadio radio = new CarRadio();
        ConsoleView view = new ConsoleView(radio);
        view.controller();
    }
}