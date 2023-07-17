package dev.rover656.pollenbaskets.common.init;

import dev.rover656.pollenbaskets.BeeMod;
import dev.rover656.pollenbaskets.common.entity.CustomBee;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = BeeMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityInit {
    private static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BeeMod.MODID);

    public static final RegistryObject<EntityType<CustomBee>> TEST_BEE = ENTITY_TYPES.register("test",
            () -> EntityType.Builder.of(CustomBee::new, MobCategory.CREATURE)
                    .sized(0.7F, 0.6F)
                    .clientTrackingRange(8)
                    .build("test"));

    public static void init(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(TEST_BEE.get(), CustomBee.createAttributes().build());
    }
}
