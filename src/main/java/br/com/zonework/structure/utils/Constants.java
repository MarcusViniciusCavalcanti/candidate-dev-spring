package br.com.zonework.structure.utils;

public enum Constants {
    CREDENTIALS("credentials");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
