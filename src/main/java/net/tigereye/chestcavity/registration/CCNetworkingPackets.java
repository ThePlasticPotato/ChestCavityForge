package net.tigereye.chestcavity.registration;


import net.minecraft.resources.ResourceLocation;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.interfaces.ChestCavityEntity;
import net.tigereye.chestcavity.util.NetworkUtil;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CCNetworkingPackets {
    public static final ResourceLocation ORGAN_DATA_PACKET_ID = new ResourceLocation(ChestCavity.MODID,"organ_data");
    public static final ResourceLocation UPDATE_PACKET_ID = new ResourceLocation(ChestCavity.MODID,"update");
    public static final ResourceLocation RECEIVED_UPDATE_PACKET_ID = new ResourceLocation(ChestCavity.MODID,"received_update");

    public static final ResourceLocation HOTKEY_PACKET_ID = new ResourceLocation(ChestCavity.MODID, "hotkey");

    public static void register() {
        //COMMENTED BY BOONELDAN
        //ServerLoginConnectionEvents.QUERY_START.register(NetworkUtil::sendOrganDataPacket);
        //ServerPlayNetworking.registerGlobalReceiver(CCNetworkingPackets.RECEIVED_UPDATE_PACKET_ID, (server, player, handler, buf, sender) -> {
        //    Optional<ChestCavityEntity> optional = ChestCavityEntity.of(player);
        //    optional.ifPresent(chestCavityEntity -> NetworkUtil.ReadChestCavityReceivedUpdatePacket(chestCavityEntity.getChestCavityInstance()));
        //});






        //DONE
        //ServerPlayNetworking.registerGlobalReceiver(CCNetworkingPackets.HOTKEY_PACKET_ID, (server, player, handler, buf, sender) -> {
        //    Optional<ChestCavityEntity> optional = ChestCavityEntity.of(player);
        //    optional.ifPresent(chestCavityEntity -> NetworkUtil.ReadChestCavityHotkeyPacket(chestCavityEntity.getChestCavityInstance(),buf));
        //});
        //ServerLoginNetworking.registerGlobalReceiver(CCNetworkingPackets.ORGAN_DATA_PACKET_ID,(server, handler, understood, buf, synchronizer, sender) -> {
        //});
    }

    public static void registerClient(){
        //DONE
        //ClientPlayNetworking.registerGlobalReceiver(CCNetworkingPackets.UPDATE_PACKET_ID, (client, handler, buf, responseSender) -> {
        //    Optional<ChestCavityEntity> optional = ChestCavityEntity.of(client.cameraEntity);
        //    optional.ifPresent(chestCavityEntity -> NetworkUtil.ReadChestCavityUpdatePacket(chestCavityEntity.getChestCavityInstance(), buf));
        //});




        //COMMENTED BY BOONELDAN
        //ClientLoginNetworking.registerGlobalReceiver(CCNetworkingPackets.ORGAN_DATA_PACKET_ID, (client, handler, buf, responseSender) -> {
        //    NetworkUtil.readOrganDataPacket(buf);
        //    return CompletableFuture.completedFuture(PacketByteBufs.empty());
        //});
    }
}
