package primitiveenderdragon.briefrelease.importantbugfix.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Minecraft.class)
public class FRCClientMinecraft {

    @ModifyConstant(
            method = "startUseItem",
            constant = @Constant(intValue = 4)
    )
    private int modifyRightClickDelay(int original) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null) {
            if (player.isCreative()) {
                return 1;
            }
            return 2;
        }
        return 2;
    }
}
