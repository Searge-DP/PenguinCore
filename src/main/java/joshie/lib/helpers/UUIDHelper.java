package joshie.lib.helpers;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class UUIDHelper {
    public static UUID getPlayerUUID(EntityPlayer player) {
        return EntityPlayer.getUUID(player.getGameProfile());
        //return player.getUniqueID();
        //return player.getPersistentID();
    }
    
    public static UUID getEntityUUID(Entity entity) {
        return entity.getPersistentID();
    }
}