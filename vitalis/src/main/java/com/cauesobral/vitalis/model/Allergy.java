package com.cauesobral.vitalis.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.Objects;

@Embeddable
public class Allergy {

    private String name;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    private String reaction;


    public Allergy() {}

    public Allergy(String name, Severity severity, String reaction) {
        this.name = name;
        this.severity = severity;
        this.reaction = reaction;
    }

    public String getName() { return name; }
    public Severity getSeverity() { return severity; }
    public String getReaction() { return reaction; }

    public void setName(String name) { this.name = name; }
    public void setSeverity(Severity severity) { this.severity = severity; }
    public void setReaction(String reaction) { this.reaction = reaction; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Allergy)) return false;
        Allergy allergy = (Allergy) o;
        return Objects.equals(name, allergy.name)
                && severity == allergy.severity
                && Objects.equals(reaction, allergy.reaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, severity, reaction);
    }

    @Override
    public String toString() {
        return "Allergy{name='" + name + "', severity=" + severity + ", reaction='" + reaction + "'}";
    }
}
