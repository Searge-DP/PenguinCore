package joshie.lib;

import java.io.IOException;

import net.minecraftforge.fml.common.asm.transformers.AccessTransformer;

public class AccessTransformers extends AccessTransformer {
    public AccessTransformers() throws IOException {
        super("penguin_at.cfg");
    }
}
