package pl.kosma.enderdragonnogriefing.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnderDragonEntity.class)
public class EnderDragonEntityMixin {
    @Redirect(
            method = "destroyBlocks(Lnet/minecraft/util/math/Box;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/GameRules;getBoolean(Lnet/minecraft/world/GameRules$Key;)Z")
    )
    private boolean GameRules_getBoolean(GameRules instance, GameRules.Key<GameRules.BooleanRule> rule) {
        return false;
    }
}
