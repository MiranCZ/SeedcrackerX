package kaptainwutax.seedcrackerX.mixin;

import kaptainwutax.seedcrackerX.SeedCracker;
import kaptainwutax.seedcrackerX.profile.config.ConfigScreen;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {

//    @Shadow public abstract DynamicRegistryManager getRegistryManager();

    @Inject(method = "disconnect", at = @At("HEAD"))
    private void disconnect(CallbackInfo ci) {
        SeedCracker.get().setActive(ConfigScreen.getConfig().isActive());
        SeedCracker.get().reset();
    }

    @Inject(method = "getGeneratorStoredBiome", at = @At("HEAD"), cancellable = true)
    private void getGeneratorStoredBiome(int x, int y, int z, CallbackInfoReturnable<Biome> ci) {
//        Optional<Biome> biome = getRegistryManager().get(Registry.BIOME_KEY).getOrEmpty(BiomeKeys.THE_VOID);
        Optional<Biome> biome = Registry.BIOME.getOrEmpty(new Identifier("minecraft", "the_void"));;
        ci.setReturnValue(biome.orElse(Biomes.THE_VOID));
    }

}
