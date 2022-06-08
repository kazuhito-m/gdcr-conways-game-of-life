package com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model;

public interface WorldRepository {
    World register(String identifier, World world);

    World lookup(String identifier);
}
