package com.github.kazuhito_m.gdcrconwaysgameoflife.infrastructure.datasource;

import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.World;
import com.github.kazuhito_m.gdcrconwaysgameoflife.domain.model.WorldRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

// TODO 仮実装。 後にRedisか何かにしたい。(現在はただのメモリ内Map)

@Repository
public class WorldDataSource implements WorldRepository {

    @Override
    public World register(String identifier, World world) {
        return store.put(identifier, world);
    }

    @Override
    public World lookup(String identifier) {
        return store.get(identifier);
    }

    final Map<String, World> store = new HashMap<>();

}
