package primitiveenderdragon.briefrelease.importantbugfix.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MultiPlayerGameMode.class)
public class NMCMiningCooldown {
    @ModifyConstant(
            method = "continueDestroyBlock",
            constant = @Constant(intValue = 5)
    )
    private int MiningCooldownFix(int value) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;

        if (player != null) {
            if (player.isCreative()) {
                return 0;
            }
            return 1;
        }
        return 1;
    }
}
