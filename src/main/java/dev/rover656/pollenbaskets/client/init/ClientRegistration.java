package dev.rover656.pollenbaskets.client.init;

import dev.rover656.pollenbaskets.BeeMod;
import dev.rover656.pollenbaskets.client.entity.CustomBeeRenderer;
import dev.rover656.pollenbaskets.common.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BeeMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistration {

    @SuppressWarnings("unused")
    @SubscribeEvent
    public static void clientInit(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.TEST_BEE.get(), CustomBeeRenderer::new);
    }
}
