package net.examplemod.fabric;

import io.github.fabricators_of_create.porting_lib.util.EnvExecutor;
import net.examplemod.ExampleMod;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleMod.init();
        ExampleMod.LOGGER.info(EnvExecutor.unsafeRunForDist(
                () -> () -> "{} is accessing Porting Lib on a fabric client!",
                () -> () -> "{} is accessing Porting Lib on a fabric server!"
                ), ExampleMod.NAME);
    }
}
