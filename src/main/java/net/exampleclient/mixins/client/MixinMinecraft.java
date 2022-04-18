package net.exampleclient.mixins.client;

import net.exampleclient.ExampleClient;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
  
    @Inject(method = "startGame", at = @At("RETURN"))
    public void onStart(CallbackInfo ci) {
        ExampleClient.INSTANCE.start();
    }
  
    @Inject(method = "shutdown", at = @At("HEAD"))
    public void onShutdown(CallbackInfo ci) {
        ExampleClient.INSTANCE.shutdown();
    }
  
}
