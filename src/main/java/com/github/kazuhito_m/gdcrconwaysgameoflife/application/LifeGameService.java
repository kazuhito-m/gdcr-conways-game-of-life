package com.github.kazuhito_m.gdcrconwaysgameoflife.application;

import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.World;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldCondition;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldRepository;
import org.springframework.stereotype.Service;

@Service
public class LifeGameService {

    public void initialize(String identifier, WorldCondition condition) {
        World world = new World(condition);
        repository.register(identifier, world);
    }

    public World nextWorldOf(String identifier) {
        World world = repository.lookup(identifier);
        World nextWorld = world.next();
        repository.register(identifier, nextWorld);
        return nextWorld;
    }

    final WorldRepository repository;

    public LifeGameService(WorldRepository repository) {
        this.repository = repository;
    }

}
