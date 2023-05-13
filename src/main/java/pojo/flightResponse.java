package pojo;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class flightResponse {
    @JsonProperty("origins")
    public ArrayList<Origin> getOrigins() {
    return this.origins; }
    public void setOrigins(ArrayList<Origin> origins) {
        this.origins = origins; }
    ArrayList<Origin> origins;
    @JsonProperty("default_destinations")
    public ArrayList<DefaultDestination> getDefault_destinations() {
        return this.default_destinations; }
    public void setDefault_destinations(ArrayList<DefaultDestination> default_destinations) {
        this.default_destinations = default_destinations; }
    ArrayList<DefaultDestination> default_destinations;
}

