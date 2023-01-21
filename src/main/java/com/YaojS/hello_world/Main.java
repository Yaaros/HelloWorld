package com.YaojS.hello_world;

import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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

    @SubscribeEvent
    public static void leftClickBlock(PlayerInteractEvent.LeftClickBlock event){
       Player player = event.getPlayer();
       player.sendMessage(new TextComponent("LeftClickBlock is fired"),Util.NIL_UUID);
    }

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event){
        Player player = event.getPlayer();
        player.sendMessage(new TextComponent("!"),Util.NIL_UUID);

    }
    @SubscribeEvent
    public static void rightClickSword(PlayerInteractEvent.RightClickItem event){
        Player player = event.getPlayer();
        Level level = player.level;
        //如果是服务端
        if (!level.isClientSide()){
            //获取其主手物品是否是钻石剑,获取到的是物品的所有信息，包含Count,Damage,ench...
            ItemStack itemstack = event.getItemStack();
            Item item = itemstack.getItem();
            if (item == Items.DIAMOND_SWORD){
                //获取玩家准心对准的信息
                HitResult hitResult = player.pick(20,0,false);//false表示穿透流体
                Vec3 vec3 = hitResult.getLocation();
                player.teleportTo(vec3.x,vec3.y,vec3.z);

            }
        }

    }
}
