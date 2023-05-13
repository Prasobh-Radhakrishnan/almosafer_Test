package pojo;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;

public class flightPayload {

        @JsonProperty("template")
        public String getTemplate() {
            return this.template; }
        public void setTemplate(String template) {
            this.template = template; }
        String template;
        @JsonProperty("country")
        public String getCountry() {
            return this.country; }
        public void setCountry(String country) {
            this.country = country; }
        String country;
        @JsonProperty("media")
        public String getMedia() {
            return this.media; }
        public void setMedia(String media) {
            this.media = media; }
        String media;
        @JsonProperty("locale")
        public String getLocale() {
            return this.locale; }
        public void setLocale(String locale) {
            this.locale = locale; }
        String locale;
    }

