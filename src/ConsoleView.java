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
        displayMenu();

        int option = getOption();

        switch (option) {
            case 1:
                radio.turnOn();
                showMessage("Radio Encendida");
                break;
        
            case 2:
                if (radio.isOn()) {
                    if (radio.getBand() == "AM") {
                        radio.switchBand("FM");
                        showMessage("Cambiado a FM");
                    } else {
                        radio.switchBand("AM");
                        showMessage("Cambiado a AM");
                    }
                } else {
                    showMessage("La radio está apagada.");
                }
                break;
            case 3:
                if (radio.isOn()) {
                    radio.nextStation();
                    showMessage("Frecuencia cambiada a " + radio.getCurrentStation());
                } else {
                    showMessage("La radio está apagada.");
                }
                break;
            case 4:
                if (radio.isOn()) {
                    int buttonSaved = getButtonNumber();
                    radio.saveStation(radio.getCurrentStation() + "");
                    showMessage("Estación guardada en el botón " + (buttonSaved + 1));
                } else {
                    showMessage("La radio esta apagada");
                }
                break;
            case 5:
                int buttonSelected = getButtonNumber();
                if (radio.isOn()) {
                    radio.selectStation(radio.getCurrentStation() + "");
                    showMessage("Estación seleccionada: " + radio.getCurrentStation());
                    
                } else {
                    showMessage("La radio está apagada.");
                }
                break;
            case 6:
                radio.turnOff();
                showMessage("Radio Apagada");
                break;
            default:
                showMessage("Opcion invalida");
                break;
        }
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
        int estacionGuardada = scanner.nextInt() - 1;
        return estacionGuardada;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
    
}
