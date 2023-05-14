package pojo;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class origins {  @JsonProperty("id_airport")
public String getId_airport() {
    return this.id_airport; }
    public void setId_airport(String id_airport) {
        this.id_airport = id_airport; }
    String id_airport;
    @JsonProperty("iata")
    public String getIata() {
        return this.iata; }
    public void setIata(String iata) {
        this.iata = iata; }
    String iata;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("main_city_name")
    public String getMain_city_name() {
        return this.main_city_name; }
    public void setMain_city_name(String main_city_name) {
        this.main_city_name = main_city_name; }
    String main_city_name;
    @JsonProperty("country_code")
    public String getCountry_code() {
        return this.country_code; }
    public void setCountry_code(String country_code) {
        this.country_code = country_code; }
    String country_code;
    @JsonProperty("country_name")
    public String getCountry_name() {
        return this.country_name; }
    public void setCountry_name(String country_name) {
        this.country_name = country_name; }
    String country_name;
    @JsonProperty("type")
    public String getType() {
        return this.type; }
    public void setType(String type) {
        this.type = type; }
    String type;
    @JsonProperty("destinations")
    public ArrayList<Destination> getDestinations() {
        return this.destinations; }
    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations; }
    ArrayList<Destination> destinations;
}
