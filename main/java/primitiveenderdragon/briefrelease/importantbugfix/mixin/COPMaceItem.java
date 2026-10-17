package primitiveenderdragon.briefrelease.importantbugfix.mixin;

import net.minecraft.world.item.MaceItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(MaceItem.class)
public class COPMaceItem {

    @ModifyArg(
            method = "createAttributes",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/ai/attributes/AttributeModifier;<init>(Lnet/minecraft/resources/Identifier;DLnet/minecraft/world/entity/ai/attributes/AttributeModifier$Operation;)V",
                    ordinal = 1
            ),
            index = 1
    )
    private static double modifyAttackSpeed(double original) {
        return -3.25;
    }
}
