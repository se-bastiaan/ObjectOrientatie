package oo10.models;

/**
 * POJO representing Weerstation from Buienradar
 */
public class Weerstation {
    protected String stationnaam;
    protected Integer stationcode;
    protected String icon;
    protected Float temperatuur = 0f;
    protected String windrichting;

    /**
     * Get stationnaam
     * @return Stationnaam
     */
    public String getStationnaam() {
        return stationnaam;
    }

    /**
     * Get stationcode
     * @return Stationcode
     */
    public Integer getStationcode() {
        return stationcode;
    }

    /**
     * Get icon url
     * @return Icon url
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Get temperatuur
     * @return Temperatuur
     */
    public Float getTemperatuur() {
        return temperatuur;
    }

    /**
     * Get windrichting
     * @return Windrichting
     */
    public String getWindrichting() {
        return windrichting;
    }

    /**
     * Override toString to print proper string
     * @return {@link java.lang.String}
     */
    @Override
    public String toString()
    {
        return stationcode + " - " + stationnaam;
    }
}