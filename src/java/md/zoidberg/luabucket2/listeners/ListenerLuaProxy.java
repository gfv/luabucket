package md.zoidberg.luabucket2.listeners;

import md.zoidberg.luabucket2.EventDispatcher;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ListenerLuaProxy implements Listener {
    private EventDispatcher dispatcher;

    public ListenerLuaProxy(EventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @EventHandler
    public void onVehicleExitEvent(org.bukkit.event.vehicle.VehicleExitEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleBlockCollisionEvent(org.bukkit.event.vehicle.VehicleBlockCollisionEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleEnterEvent(org.bukkit.event.vehicle.VehicleEnterEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleUpdateEvent(org.bukkit.event.vehicle.VehicleUpdateEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleCreateEvent(org.bukkit.event.vehicle.VehicleCreateEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleDestroyEvent(org.bukkit.event.vehicle.VehicleDestroyEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleMoveEvent(org.bukkit.event.vehicle.VehicleMoveEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleDamageEvent(org.bukkit.event.vehicle.VehicleDamageEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onVehicleEntityCollisionEvent(org.bukkit.event.vehicle.VehicleEntityCollisionEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onAsyncPlayerPreLoginEvent(org.bukkit.event.player.AsyncPlayerPreLoginEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerInteractEntityEvent(org.bukkit.event.player.PlayerInteractEntityEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerToggleSprintEvent(org.bukkit.event.player.PlayerToggleSprintEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerFishEvent(org.bukkit.event.player.PlayerFishEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerKickEvent(org.bukkit.event.player.PlayerKickEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerToggleFlightEvent(org.bukkit.event.player.PlayerToggleFlightEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerChangedWorldEvent(org.bukkit.event.player.PlayerChangedWorldEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerBedLeaveEvent(org.bukkit.event.player.PlayerBedLeaveEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerGameModeChangeEvent(org.bukkit.event.player.PlayerGameModeChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerItemBreakEvent(org.bukkit.event.player.PlayerItemBreakEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerDropItemEvent(org.bukkit.event.player.PlayerDropItemEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerPickupItemEvent(org.bukkit.event.player.PlayerPickupItemEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerItemHeldEvent(org.bukkit.event.player.PlayerItemHeldEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerCommandPreprocessEvent(org.bukkit.event.player.PlayerCommandPreprocessEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerBedEnterEvent(org.bukkit.event.player.PlayerBedEnterEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerInteractEvent(org.bukkit.event.player.PlayerInteractEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerTeleportEvent(org.bukkit.event.player.PlayerTeleportEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerBucketFillEvent(org.bukkit.event.player.PlayerBucketFillEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerToggleSneakEvent(org.bukkit.event.player.PlayerToggleSneakEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerRegisterChannelEvent(org.bukkit.event.player.PlayerRegisterChannelEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerMoveEvent(org.bukkit.event.player.PlayerMoveEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerAnimationEvent(org.bukkit.event.player.PlayerAnimationEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerBucketEmptyEvent(org.bukkit.event.player.PlayerBucketEmptyEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerRespawnEvent(org.bukkit.event.player.PlayerRespawnEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerLevelChangeEvent(org.bukkit.event.player.PlayerLevelChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerQuitEvent(org.bukkit.event.player.PlayerQuitEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerChatTabCompleteEvent(org.bukkit.event.player.PlayerChatTabCompleteEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerPortalEvent(org.bukkit.event.player.PlayerPortalEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerVelocityEvent(org.bukkit.event.player.PlayerVelocityEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerLoginEvent(org.bukkit.event.player.PlayerLoginEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerEggThrowEvent(org.bukkit.event.player.PlayerEggThrowEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerExpChangeEvent(org.bukkit.event.player.PlayerExpChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerUnregisterChannelEvent(org.bukkit.event.player.PlayerUnregisterChannelEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerShearEntityEvent(org.bukkit.event.player.PlayerShearEntityEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(org.bukkit.event.player.AsyncPlayerChatEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockSpreadEvent(org.bukkit.event.block.BlockSpreadEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockGrowEvent(org.bukkit.event.block.BlockGrowEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityBlockFormEvent(org.bukkit.event.block.EntityBlockFormEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockIgniteEvent(org.bukkit.event.block.BlockIgniteEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onSignChangeEvent(org.bukkit.event.block.SignChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockFormEvent(org.bukkit.event.block.BlockFormEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockPistonExtendEvent(org.bukkit.event.block.BlockPistonExtendEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockBreakEvent(org.bukkit.event.block.BlockBreakEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockDispenseEvent(org.bukkit.event.block.BlockDispenseEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onNotePlayEvent(org.bukkit.event.block.NotePlayEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockBurnEvent(org.bukkit.event.block.BlockBurnEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockPhysicsEvent(org.bukkit.event.block.BlockPhysicsEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onLeavesDecayEvent(org.bukkit.event.block.LeavesDecayEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockRedstoneEvent(org.bukkit.event.block.BlockRedstoneEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockPlaceEvent(org.bukkit.event.block.BlockPlaceEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockCanBuildEvent(org.bukkit.event.block.BlockCanBuildEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockPistonRetractEvent(org.bukkit.event.block.BlockPistonRetractEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockDamageEvent(org.bukkit.event.block.BlockDamageEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockFromToEvent(org.bukkit.event.block.BlockFromToEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBlockFadeEvent(org.bukkit.event.block.BlockFadeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onCreatureSpawnEvent(org.bukkit.event.entity.CreatureSpawnEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onSheepRegrowWoolEvent(org.bukkit.event.entity.SheepRegrowWoolEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPigZapEvent(org.bukkit.event.entity.PigZapEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityPortalEnterEvent(org.bukkit.event.entity.EntityPortalEnterEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityTeleportEvent(org.bukkit.event.entity.EntityTeleportEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityDamageByBlockEvent(org.bukkit.event.entity.EntityDamageByBlockEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityShootBowEvent(org.bukkit.event.entity.EntityShootBowEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onProjectileLaunchEvent(org.bukkit.event.entity.ProjectileLaunchEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onFoodLevelChangeEvent(org.bukkit.event.entity.FoodLevelChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityCombustByEntityEvent(org.bukkit.event.entity.EntityCombustByEntityEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityExplodeEvent(org.bukkit.event.entity.EntityExplodeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityBreakDoorEvent(org.bukkit.event.entity.EntityBreakDoorEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityDamageEvent(org.bukkit.event.entity.EntityDamageEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onExpBottleEvent(org.bukkit.event.entity.ExpBottleEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onExplosionPrimeEvent(org.bukkit.event.entity.ExplosionPrimeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onCreeperPowerEvent(org.bukkit.event.entity.CreeperPowerEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityTameEvent(org.bukkit.event.entity.EntityTameEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityRegainHealthEvent(org.bukkit.event.entity.EntityRegainHealthEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityTargetLivingEntityEvent(org.bukkit.event.entity.EntityTargetLivingEntityEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onSlimeSplitEvent(org.bukkit.event.entity.SlimeSplitEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityInteractEvent(org.bukkit.event.entity.EntityInteractEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityCreatePortalEvent(org.bukkit.event.entity.EntityCreatePortalEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onProjectileHitEvent(org.bukkit.event.entity.ProjectileHitEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityCombustByBlockEvent(org.bukkit.event.entity.EntityCombustByBlockEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPotionSplashEvent(org.bukkit.event.entity.PotionSplashEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onItemSpawnEvent(org.bukkit.event.entity.ItemSpawnEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityDamageByEntityEvent(org.bukkit.event.entity.EntityDamageByEntityEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onSheepDyeWoolEvent(org.bukkit.event.entity.SheepDyeWoolEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityChangeBlockEvent(org.bukkit.event.entity.EntityChangeBlockEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityTargetEvent(org.bukkit.event.entity.EntityTargetEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityCombustEvent(org.bukkit.event.entity.EntityCombustEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onItemDespawnEvent(org.bukkit.event.entity.ItemDespawnEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEntityDeathEvent(org.bukkit.event.entity.EntityDeathEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPlayerDeathEvent(org.bukkit.event.entity.PlayerDeathEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onRemoteServerCommandEvent(org.bukkit.event.server.RemoteServerCommandEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onMapInitializeEvent(org.bukkit.event.server.MapInitializeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onServerCommandEvent(org.bukkit.event.server.ServerCommandEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onServiceRegisterEvent(org.bukkit.event.server.ServiceRegisterEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onServiceUnregisterEvent(org.bukkit.event.server.ServiceUnregisterEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPluginDisableEvent(org.bukkit.event.server.PluginDisableEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onServerListPingEvent(org.bukkit.event.server.ServerListPingEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPluginEnableEvent(org.bukkit.event.server.PluginEnableEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onWorldUnloadEvent(org.bukkit.event.world.WorldUnloadEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onStructureGrowEvent(org.bukkit.event.world.StructureGrowEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onChunkUnloadEvent(org.bukkit.event.world.ChunkUnloadEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onChunkPopulateEvent(org.bukkit.event.world.ChunkPopulateEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPortalCreateEvent(org.bukkit.event.world.PortalCreateEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onSpawnChangeEvent(org.bukkit.event.world.SpawnChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onWorldSaveEvent(org.bukkit.event.world.WorldSaveEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onChunkLoadEvent(org.bukkit.event.world.ChunkLoadEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onWorldInitEvent(org.bukkit.event.world.WorldInitEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onWorldLoadEvent(org.bukkit.event.world.WorldLoadEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onEnchantItemEvent(org.bukkit.event.enchantment.EnchantItemEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPrepareItemEnchantEvent(org.bukkit.event.enchantment.PrepareItemEnchantEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPaintingBreakByEntityEvent(org.bukkit.event.painting.PaintingBreakByEntityEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPaintingPlaceEvent(org.bukkit.event.painting.PaintingPlaceEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPaintingBreakEvent(org.bukkit.event.painting.PaintingBreakEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onInventoryOpenEvent(org.bukkit.event.inventory.InventoryOpenEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onFurnaceSmeltEvent(org.bukkit.event.inventory.FurnaceSmeltEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onInventoryClickEvent(org.bukkit.event.inventory.InventoryClickEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onBrewEvent(org.bukkit.event.inventory.BrewEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onFurnaceBurnEvent(org.bukkit.event.inventory.FurnaceBurnEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onPrepareItemCraftEvent(org.bukkit.event.inventory.PrepareItemCraftEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onCraftItemEvent(org.bukkit.event.inventory.CraftItemEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onInventoryEvent(org.bukkit.event.inventory.InventoryEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onInventoryCloseEvent(org.bukkit.event.inventory.InventoryCloseEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onWeatherChangeEvent(org.bukkit.event.weather.WeatherChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onLightningStrikeEvent(org.bukkit.event.weather.LightningStrikeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

    @EventHandler
    public void onThunderChangeEvent(org.bukkit.event.weather.ThunderChangeEvent ev) {
        dispatcher.raiseEvent(ev);
    }

}