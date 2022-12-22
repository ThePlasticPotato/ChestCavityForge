package net.tigereye.chestcavity.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.network.packets.ChestCavityHotkeyPacket;
import net.tigereye.chestcavity.network.packets.ChestCavityUpdatePacket;
import net.tigereye.chestcavity.network.packets.OrganDataPacket;
import net.tigereye.chestcavity.network.packets.RecievedChestCavityUpdatePacket;

public final class NetworkHandler {

    private static final String VERSION = "2.16.2";

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(ChestCavity.MODID, "main"), () -> VERSION, VERSION::equals, VERSION::equals);

    public static void init() {
        int index = 0;
        CHANNEL.messageBuilder(ChestCavityUpdatePacket.class, index++, NetworkDirection.PLAY_TO_CLIENT).encoder(ChestCavityUpdatePacket::encode).decoder(ChestCavityUpdatePacket::decode).consumerMainThread(ChestCavityUpdatePacket::handle).add();
        CHANNEL.messageBuilder(OrganDataPacket.class, index++, NetworkDirection.LOGIN_TO_CLIENT).encoder(OrganDataPacket::encode).decoder(OrganDataPacket::decode).consumerMainThread(OrganDataPacket::handle).add();
        CHANNEL.messageBuilder(ChestCavityHotkeyPacket.class, index++, NetworkDirection.PLAY_TO_SERVER).encoder(ChestCavityHotkeyPacket::encode).decoder(ChestCavityHotkeyPacket::new).consumerMainThread(ChestCavityHotkeyPacket::handle).add();
        CHANNEL.messageBuilder(RecievedChestCavityUpdatePacket.class, index++, NetworkDirection.PLAY_TO_SERVER).add();
    }
}
