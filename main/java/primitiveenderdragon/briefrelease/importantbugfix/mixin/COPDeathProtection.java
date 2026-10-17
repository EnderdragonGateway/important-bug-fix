package primitiveenderdragon.briefrelease.importantbugfix.mixin;

import net.minecraft.world.item.component.DeathProtection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(DeathProtection.class)
public class COPDeathProtection {

    @ModifyArg(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/effect/MobEffectInstance;<init>(Lnet/minecraft/core/Holder;II)V",
                    ordinal = 0
            ),
            index = 1
    )
    private static int modifyRegenerationDuration(int original) {
        return 360;
    }

    @ModifyArg(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/effect/MobEffectInstance;<init>(Lnet/minecraft/core/Holder;II)V",
                    ordinal = 0
            ),
            index = 2
    )
    private static int modifyRegenerationAmplifier(int original) {
        return 2;
    }

    @ModifyArg(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/effect/MobEffectInstance;<init>(Lnet/minecraft/core/Holder;II)V",
                    ordinal = 1
            ),
            index = 1
    )
    private static int modifyAbsorptionDuration(int original) {
        return 200;
    }

    @ModifyArg(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/effect/MobEffectInstance;<init>(Lnet/minecraft/core/Holder;II)V",
                    ordinal = 1
            ),
            index = 2
    )
    private static int modifyAbsorptionAmplifier(int original) {
        return 2;
    }
}
