package com.epam.training.vnemero.data;

import java.util.Objects;

public class Bush extends Plant {

    public Bush(String name, double height) {
        super(name, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bush bush = (Bush) o;
        return Double.compare(bush.getHeight(), this.getHeight()) == 0
                && Objects.equals(this.getName(), bush.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHeight());
    }
}
