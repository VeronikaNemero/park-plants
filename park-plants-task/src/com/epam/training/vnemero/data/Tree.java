package com.epam.training.vnemero.data;

import java.util.Objects;

public class Tree extends Plant {

    public Tree(String name, double height) {
        super(name, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tree tree = (Tree) o;
        return Double.compare(tree.getHeight(), this.getHeight()) == 0
                              && Objects.equals(this.getName(), tree.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHeight());
    }
}
