package com.github.kazuhito_m.gdcrconwaysgameoflife.infrastructure.datasource;

import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.World;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class WorldDataSource implements WorldRepository {

    @Override
    public World register(String identifier, World world) {
        // TODO 仮実装。 後にRedisか何かに
        return store.put(identifier, world);
    }

    @Override
    public World lookup(String identifier) {
        // TODO 仮実装。 後にRedisか何かに
        return store.get(identifier);
    }

    // TODO 仮実装。 後にRedisか何かに
    final Map<String, World> store = new HashMap<>();

}
