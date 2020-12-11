package subway.domain;

public class Link {

    private String lineName;
    private String stationName;
    private int order;

    public Link(String lineName, String stationName, int order) {
        this.lineName = lineName;
        this.stationName = stationName;
        this.order = order;
    }

    public Link(String targetLineName, String targetStationName) {
        this.lineName = targetLineName;
        this.stationName = targetStationName;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }

    public int getOrder() {
        return order;
    }
}
