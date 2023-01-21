package com.YaojS.hello_world;

import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("hello_world")
@Mod.EventBusSubscriber

public class Main {

    @SubscribeEvent
    public static void playerJoinWorld(PlayerEvent.PlayerLoggedInEvent event){
        Player player = event.getPlayer();

        player.sendMessage(new TextComponent("Hello,"+player.getDisplayName().getString()+",Welcome to the World!"), Util.NIL_UUID);

    }
}
