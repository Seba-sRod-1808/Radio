package src;
import java.util.Scanner;


public class ConsoleView {
    private Scanner scanner;
    private CarRadio radio;

    public ConsoleView(CarRadio radio) {
        this.scanner = new Scanner(System.in);
        this.radio = radio;
    }

    public void controller() {
    boolean exit = false;

    while (!exit) {

        showRadioStatus();

        if (!radio.isOn()) {
            displayOffMenu();
            int option = getOption();

            switch (option) {
                case 1:
                    radio.turnOn();
                    showMessage("Radio Encendida");
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    showMessage("Opción inválida");
            }

        } else {
            displayOnMenu();
            int option = getOption();

            switch (option) {
                case 1:
                    radio.turnOff();
                    showMessage("Radio Apagada");
                    break;

                case 2:
                    if (radio.getBand().equals("AM")) {
                        radio.switchBand("FM");
                    } else {
                        radio.switchBand("AM");
                    }
                    showMessage("Banda actual: " + radio.getBand());
                    break;

                case 3:
                    radio.nextStation();
                    showMessage("Frecuencia actual: " + radio.getCurrentStation());
                    break;

                case 4:
                    int saveBtn = getButtonNumber();
                    radio.saveStation(String.valueOf(saveBtn + 1));
                    showMessage("Estación guardada en botón " + (saveBtn + 1));
                    break;

                case 5:
                    int selectBtn = getButtonNumber();
                    radio.selectStation(String.valueOf(selectBtn + 1));
                    showMessage("Estación seleccionada: " + radio.getCurrentStation());
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    showMessage("Opción inválida");
            }
        }
    }

    System.out.println("Programa finalizado.");
}

    private void displayOffMenu() {
        System.out.println("\n1. Prender Radio");
        System.out.println("2. Salir");
    }

    private void displayOnMenu() {
        System.out.println("\n1. Apagar Radio");
        System.out.println("2. Cambiar AM / FM");
        System.out.println("3. Cambiar Frecuencia");
        System.out.println("4. Guardar Estación");
        System.out.println("5. Seleccionar Estación");
        System.out.println("6. Salir");
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

    private void showRadioStatus() {
        if (!radio.isOn()) {
            System.out.println("\n[Radio APAGADA]");
        } else {
            System.out.println(
                "\n[Radio ENCENDIDA | Banda: " 
                + radio.getBand() 
                + " | Frecuencia: " 
                + radio.getCurrentStation() 
                + "]"
            );
        }
    }

    public int getButtonNumber() {
        System.out.print("Seleccione una de las estaciones guardadas (1-12): ");
        int estacionGuardada = scanner.nextInt() - 1;
        return estacionGuardada;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
    
}
