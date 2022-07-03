package me.justbeast_.playerplacedsculkshriekers;

import org.bukkit.Material;
import org.bukkit.block.data.type.SculkShrieker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerPlacedSculkShriekers extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        var block = event.getBlock();
        if (block.getType() != Material.SCULK_SHRIEKER) return;
        SculkShrieker shrieker = (SculkShrieker) block.getBlockData();
        shrieker.setCanSummon(true);
        block.setBlockData(shrieker);
    }
}
