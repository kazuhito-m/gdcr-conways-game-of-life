package com.github.kazuhito_m.gdcrconwaysgameoflife.application;

import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.World;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldCondition;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldRepository;
import org.springframework.stereotype.Service;

@Service
public class LifeGameService {
    private final WorldRepository repository;

    public void initialize(String identifier, WorldCondition condition) {
        World world = new World(condition);
        repository.register(identifier, world);
    }

    public World nextWorldOf(String identifier) {
        World world = repository.lookup(identifier);
        World worldOfNextGeneration = world.nextGeneration();
        repository.register(identifier, worldOfNextGeneration);
        return worldOfNextGeneration;
    }

    public LifeGameService(WorldRepository repository) {
        this.repository = repository;
    }
}
