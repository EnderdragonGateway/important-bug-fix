package primitiveenderdragon.briefrelease.importantbugfix.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.enderdragon.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.phases.EnderDragonPhaseManager;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(EnderDragon.class)
public class EDFEnderDragon {

    @Shadow
    @Final
    private EnderDragonPhaseManager phaseManager;

    @Shadow
    @Final
    private EnderDragonPart body;

    @Redirect(
            method = "aiStep",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/phys/Vec3;add(DDD)Lnet/minecraft/world/phys/Vec3;",
                    ordinal = 0
            ))
    private Vec3 modifyYddAddition(Vec3 instance, double x, double y, double z) {
        return instance.add(x, y * 10.0, z);
    }

    /**
     * @author 强化末影龙，完全免疫击退、爆炸击退、提高生命值
     * @reason 添加 KNOCKBACK_RESISTANCE 和 EXPLOSION_KNOCKBACK_RESISTANCE 属性
     */
    @Overwrite
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 360.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
                .add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE, 1.0)
                .add(Attributes.CAMERA_DISTANCE, 10.0);
    }
/*
    @ModifyArg(
            method = "knockBack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Entity;hurtServer(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)Z",
                    ordinal = 0
            ),
            index = 2
    )
    private float modifyKnockBackDamage(float original) {
        return 15.0F;
    }
*/
    @ModifyArg(
            method = "hurt",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/Entity;hurtServer(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)Z",
                    ordinal = 0
            ),
            index = 2
    )
    private float modifyHurtDamage(float original) {
        return 25.0F;
    }

    /**
     * @author 因为MC-196953，龙栖息时无伤害击退玩家不生效，但累积击退速度，修改hurtmarked容易崩溃，所以改成栖息依然造成伤害，同步基岩版
     * @reason 翅膀伤害 简单普通困难，龙不栖息：8.5 15 22.5，龙栖息：5 8 12
     */
    @Overwrite
    private void knockBack(final ServerLevel serverLevel, final List<Entity> entities) {
        EnderDragon self = (EnderDragon)(Object)this;

        double xm = (this.body.getBoundingBox().minX + this.body.getBoundingBox().maxX) / 2.0;
        double zm = (this.body.getBoundingBox().minZ + this.body.getBoundingBox().maxZ) / 2.0;

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity livingTarget) {
                double xd = entity.getX() - xm;
                double zd = entity.getZ() - zm;
                double dd = Math.max(xd * xd + zd * zd, 0.1);
                entity.push(xd / dd * 4.0, 0.2, zd / dd * 4.0);

                boolean isSitting = this.phaseManager.getCurrentPhase().isSitting();
                boolean isRecentlyHurt = livingTarget.getLastHurtByMobTimestamp() < entity.tickCount - 2;
                float damage = (!isSitting && isRecentlyHurt) ? 15.0F : 8.0F;

                DamageSource damageSource = self.damageSources().mobAttack(self);
                entity.hurtServer(serverLevel, damageSource, damage);
                EnchantmentHelper.doPostAttackEffects(serverLevel, entity, damageSource);
            }
        }
    }
}