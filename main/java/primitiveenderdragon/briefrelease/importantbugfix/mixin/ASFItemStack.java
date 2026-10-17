package primitiveenderdragon.briefrelease.importantbugfix.mixin;

import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import java.util.Objects;

@Mixin(ItemStack.class)
public class ASFItemStack {

    /**
     * @author 判断物品类型只看物品名字，导致附魔不同的同名物品被认为是相同
     * @reason 某些代码误用此段，而非isSameItemSameComponents
     */
    @Overwrite
    public static boolean isSameItem(final ItemStack a, final ItemStack b) {
        if (!a.is(b.getItem())) {
            return false;
        } else {
            return a.isEmpty() && b.isEmpty() || Objects.equals(a.getEnchantments(), b.getEnchantments());
        }
    }
}
