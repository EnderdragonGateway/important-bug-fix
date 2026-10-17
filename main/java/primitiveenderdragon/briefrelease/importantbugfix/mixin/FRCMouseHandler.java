package primitiveenderdragon.briefrelease.importantbugfix.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Mixin(MouseHandler.class)
public class FRCMouseHandler {

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void modifyDoubleClickThreshold(CallbackInfo ci) {
        try {
            Field field = MouseHandler.class.getDeclaredField("DOUBLE_CLICK_THRESHOLD_MS");
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            Minecraft mc = Minecraft.getInstance();
            Player player = mc.player;

            if (player != null) {
                if (player.isCreative()) {
                    field.setLong(null, 50L);
                }
                field.setLong(null, 100L);
            }
            field.setLong(null, 100L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}