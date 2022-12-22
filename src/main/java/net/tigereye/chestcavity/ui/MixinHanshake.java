package net.tigereye.chestcavity.ui;

import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.HandshakeHandler;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.chestcavities.organs.OrganManager;
import net.tigereye.chestcavity.network.NetworkHandler;
import net.tigereye.chestcavity.network.packets.OrganDataPacket;
import net.tigereye.chestcavity.util.OrganDataPacketHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;

//@Mixin(HandshakeHandler.class)
@Mod.EventBusSubscriber(modid = ChestCavity.MODID, value = Dist.DEDICATED_SERVER, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MixinHanshake {

    //@Inject(at = @At("TAIL"), method = "<init>")
    @SubscribeEvent
    public static void sendServerPackets(PlayerEvent.PlayerLoggedInEvent event) {//Connection networkManager, NetworkDirection side, CallbackInfo ci) {
        if(event.getEntity() instanceof ServerPlayer serverPlayer) {//side == NetworkDirection.LOGIN_TO_CLIENT) {
            int count = OrganManager.GeneratedOrganData.size();
            ArrayList<OrganDataPacketHelper> helpers = new ArrayList<>();
            OrganManager.GeneratedOrganData.forEach((id, data) -> helpers.add(new OrganDataPacketHelper(id, data.pseudoOrgan, data.organScores.size(), data.organScores)));

            System.out.println("BOONELDAN TEST PACKET SENT");

            NetworkHandler.CHANNEL.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new OrganDataPacket(count, helpers));
        }
    }
}
