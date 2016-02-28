package joshie.lib.helpers;

import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.client.FMLClientHandler;

public class ClientHelper {
	public static boolean isShiftPressed() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }
	
	public static String getLang() {
        return FMLClientHandler.instance().getCurrentLanguage();
    }
}
