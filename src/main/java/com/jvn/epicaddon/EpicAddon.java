package com.jvn.epicaddon;

import com.jvn.epicaddon.command.CmdMgr;
import com.jvn.epicaddon.register.RegItems;
import com.jvn.epicaddon.register.RegWeaponItemCap;
import com.jvn.epicaddon.resources.*;
import com.jvn.epicaddon.register.RegEpicAddonSkills;
import com.jvn.epicaddon.resources.config.ClientConfig;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("epicaddon")
public class EpicAddon
{
    public static final String MODID = "epicaddon";
    public static EpicAddon instance;
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // public static final AnimationManager

    public EpicAddon()
    {
        instance = this;
        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ClientConfig.CLIENT_CONFIG);
        ClientConfig.Load();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        //bus.addListener(CmdMgr::registerClientCommand);
        bus.addListener(EpicAddonAnimations::registerAnimations);
        bus.addListener(RegEpicAddonSkills::registerSkills);
        bus.addListener(RegWeaponItemCap::register);

        EpicAddonSkillCategories.ENUM_MANAGER.loadPreemptive(EpicAddonSkillCategories.class);
        EpicAddonStyles.ENUM_MANAGER.loadPreemptive(EpicAddonStyles.class);
        //WeaponCategory.ENUM_MANAGER.load(CapabilityItem.WeaponCategories.class);
        RegItems.ITEMS.register(bus);

        //EpicFightMod.getInstance().animationManager.registerAnimations();

        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CfgMgr.CLIENT_CONFIG);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static EpicAddon getInstance(){
        return instance;
    }


/*
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //LOGGER.info("-----Setup-----");
        //ResourceManager resourceManager = Minecraft.getInstance().getResourceManager();
        //EpicFightMod.getInstance().animationManager.loadAnimationsInit(resourceManager);
        //LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        //LOGGER.info("HELLO from server starting");
    }
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(modid = MODID)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

     */
}
