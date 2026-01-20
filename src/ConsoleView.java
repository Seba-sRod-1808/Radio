package src;

import java.util.Scanner;


public class ConsoleView {
    private Scanner scanner;

    public ConsoleView(CarRadio radio) {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Car Radio Menu:");
        System.out.println("1. Prender Radio");
        System.out.println("2. AM a FM");
        System.out.println("3. Cambiar Frecuencia");
        System.out.println("4. Guardar Estación");
        System.out.println("5. Seleccionar Estación");
        System.out.println("6. Apagar Radio");
    }

    public int getOption() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public void showStatus(boolean isOn, String band, double getCurrentStation) {
        if (isOn == true) {
            System.out.printf("Radio Encendida");
        } else {
            System.out.println("Radio Apagada");
        }

        if (band == "FM") {
            System.out.printf(" | Banda: FM | Estación Actual: ", getCurrentStation);
        } else {
            System.out.printf(" | Banda: AM | Estación Actual: ", getCurrentStation);
        }
        
    }

    public int getButtonNumber() {
        System.out.print("Seleccione una de las estaciones guardadas (1-12): ");
        int estacionGuardada = scanner.nextInt() - 1; // Ajuste para índice de array
        return estacionGuardada;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
