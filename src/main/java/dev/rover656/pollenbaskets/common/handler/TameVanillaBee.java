package dev.rover656.pollenbaskets.common.handler;

import dev.rover656.pollenbaskets.common.entity.CustomBee;
import dev.rover656.pollenbaskets.common.init.EntityInit;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TameVanillaBee {
    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void beeInteraction(PlayerInteractEvent.EntityInteract event) {
        Entity entity = event.getTarget();

        if (entity.getType() == EntityType.BEE) {
            Bee bee = (Bee) entity;
            ItemStack itemStack = event.getItemStack();
            if (itemStack.is(ItemTags.FLOWERS)) {

                if (event.getLevel() instanceof ServerLevel serverLevel) {
                    CustomBee newBee = EntityInit.TEST_BEE.get().create(serverLevel, bee.serializeNBT(), null, bee.blockPosition(), MobSpawnType.TRIGGERED, false, false);
                    if (newBee != null) {
                        newBee.setPos(bee.position());
                        newBee.setXRot(bee.getXRot());
                        newBee.setYRot(bee.getYRot());
                        newBee.setYBodyRot(bee.yBodyRot);
                        newBee.setYHeadRot(bee.getYHeadRot());

                        serverLevel.addFreshEntity(newBee);
                        event.getTarget().remove(Entity.RemovalReason.DISCARDED);

                        // Fake a failed taming
                        serverLevel.broadcastEntityEvent(newBee, (byte)6);
                    }
                }
            }
        }
    }
}
