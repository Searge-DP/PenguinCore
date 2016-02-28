package joshie.lib.helpers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.FallbackResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.client.resources.data.IMetadataSerializer;

public class ResourceHelper {
	public static void refreshDomain(IResourcePack pack) {
		Minecraft.getMinecraft().refreshResources();
		/*Minecraft mc = Minecraft.getMinecraft();
		if (mc.getResourceManager() instanceof SimpleReloadableResourceManager) {
			SimpleReloadableResourceManager manager = ((SimpleReloadableResourceManager) mc.getResourceManager());
			for (String s : pack.getResourceDomains()) {
				IMetadataSerializer serializer = getSerializer(manager);
				if (serializer != null) {
					FallbackResourceManager fallbackresourcemanager = new FallbackResourceManager(serializer);
					getResourceManagers(manager).put(s, fallbackresourcemanager);
					fallbackresourcemanager.addResourcePack(pack);
					//Now to reload
					try {
						Method method = SimpleReloadableResourceManager.class.getDeclaredMethod("notifyReloadListeners");
						method.setAccessible(true);
						method.invoke(manager);
					} catch (Exception e) { e.printStackTrace(); }
				}
			}
		}*/
	}
	
	private static Map<String, FallbackResourceManager> getResourceManagers(SimpleReloadableResourceManager manager) {
		try {
			Field f = SimpleReloadableResourceManager.class.getDeclaredField("domainResourceManagers");
			f.setAccessible(true);
			return (Map<String, FallbackResourceManager>) f.get(manager);
		} catch (Exception e) { e.printStackTrace(); return null; }
	}
	
	private static IMetadataSerializer getSerializer(SimpleReloadableResourceManager manager) {
		try {
			Field f = SimpleReloadableResourceManager.class.getDeclaredField("rmMetadataSerializer");
			f.setAccessible(true);
			return (IMetadataSerializer) f.get(manager);
		} catch (Exception e) { e.printStackTrace(); return null; }
	}
}
