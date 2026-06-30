package com.cauesobral.vitalis.model;

// Grau de prioridade - protocolo Manchester adaptado
public enum Priority {

    BLUE(0),
    GREEN(1),
    YELLOW(2),
    ORANGE(3),
    RED(4);

    private final int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}