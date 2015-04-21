package oo10.models;

public class Weerstation {
    protected String stationnaam;
    protected Integer stationcode;
    protected String icon;
    protected Float temperatuur = 0f;
    protected String windrichting;

    public String getStationnaam() {
        return stationnaam;
    }

    public Integer getStationcode() {
        return stationcode;
    }

    public String getIcon() {
        return icon;
    }

    public Float getTemperatuur() {
        return temperatuur;
    }

    public String getWindrichting() {
        return windrichting;
    }

    @Override
    public String toString()
    {
        return stationcode + " - " + stationnaam;
    }
}