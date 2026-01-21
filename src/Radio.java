package src;

public class Radio implements RadioInterface {  

    private boolean on;
    private String band;
    private double amFrequence;
    private double fmFrequence;
    private double[] amButtons;
    private double[] fmButtons;

    public Radio() {
        this.on = false;
        this.band = "AM";
        this.amFrequence = 530;
        this.fmFrequence = 87.9;
        this.amButtons = new double[12];
        this.fmButtons = new double[12];
    }

    @Override
    public void turnOn() { 
        this.on = true; 
    }

    @Override
    public void turnOff() { 
        this.on = false; 
    }

    @Override
    public boolean isOn() { 
        return this.on; 
    }
    
    @Override
    public void switchBand(String band) { 
        this.band = band; 
    }

    @Override
    public String getBand() { 
        return this.band; 
    }

    @Override
    public void nextStation() {
        if (this.band.equals("AM")) {
            this.amFrequence += 10;
            if (this.amFrequence > 1610) this.amFrequence = 530;
        } else {
            this.fmFrequence += 0.2;
            if (this.fmFrequence > 107.9) this.fmFrequence = 87.9;
            this.fmFrequence = Math.round(this.fmFrequence * 10.0) / 10.0;
        }
    }

    @Override
    public double getCurrentStation() {
        return this.band.equals("AM") ? this.amFrequence : this.fmFrequence;
    }

    @Override
    public void saveStation(String station) {
        int button = Integer.parseInt(station);
        if (this.band.equals("AM")) {
            this.amButtons[button - 1] = this.amFrequence;
        } else {
            this.fmButtons[button - 1] = this.fmFrequence;
        }
    }

    @Override
    public void selectStation(String station) {
        int button = Integer.parseInt(station);
        if (this.band.equals("AM")) {
            this.amFrequence = this.amButtons[button - 1];
        } else {
            this.fmFrequence = this.fmButtons[button - 1];
        }
    }
}