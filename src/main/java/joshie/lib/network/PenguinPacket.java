package joshie.lib.network;

import joshie.lib.helpers.ClientHelper;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public abstract class PenguinPacket implements IMessage {
    public abstract void handlePacket(EntityPlayer player);

    public void handleQueuedClient(NetHandlerPlayClient handler) {
        handlePacket(ClientHelper.getPlayer());
    }

    public void handleQueuedServer(NetHandlerPlayServer serverHandler) {
        handlePacket(serverHandler.playerEntity);
    }
}
