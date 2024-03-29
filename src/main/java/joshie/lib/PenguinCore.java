package joshie.lib;

import java.util.Map;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.Side;

@IFMLLoadingPlugin.SortingIndex(-99)
@IFMLLoadingPlugin.MCVersion("1.8")
@Mod(modid = PenguinCore.MODID, name = PenguinCore.MODNAME, version = PenguinCore.VERSION)
public class PenguinCore implements IFMLLoadingPlugin {
	public static final String JAVAPATH = "joshie.lib.";
	public static final String MODID = "PenguinCore";
	public static final String MODNAME = "PenguinCore";
	public static final String MODPATH = "joshie";
    public static final String VERSION = "@VERSION@";
	public static boolean isDev;
	
	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			PenguinFontRenderer.load();
		}
	}

	@Override
	public String[] getASMTransformerClass() {
		return new String[] { ClassTransformer.class.getName() };
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		isDev = ((Boolean) data.get("runtimeDeobfuscationEnabled"));
	}

	@Override
	public String getAccessTransformerClass() {
		return JAVAPATH + "AccessTransformers";
	}
}
