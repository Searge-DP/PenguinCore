package joshie.lib;

import java.util.Map;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

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
