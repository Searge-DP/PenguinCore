package joshie.lib.helpers;

import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class MCServerHelper {
    public static World getWorld(int dimension) {
        return DimensionManager.getWorld(dimension);
    }
}