package com.defdaemon.horrormoon;

import com.defdaemon.horrormoon.lists.BlockList;
import com.defdaemon.horrormoon.lists.EntityList;
import com.defdaemon.horrormoon.lists.ItemList;
import com.defdaemon.horrormoon.lists.ToolMaterialList;
import com.defdaemon.horrormoon.world.gen.OreGeneration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

//TODO: Fit silver armor onto armor stand
//TODO: Fix texture horse armor


@Mod(Main.MOD_ID)
@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Main
{
    public static Main instance;
    public static final String MOD_ID = "daemonhorrormoon";
    //public static final ItemGroup MAGIC_ITEMS_TAB = new Main.MagicItemsGroup("magic_items_group");
    public static final Logger LOGGER = LogManager.getLogger();

    public Main()
    {
        instance = this;

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        BlockList.BLOCKS.register(modEventBus);
        ItemList.ITEMS.register(modEventBus);
        EntityList.ENTITIES.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generatesOres);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void createBlockItem(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockList.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
        {
                final Item.Properties properties = new Item.Properties().tab(ItemGroup.TAB_MISC);
                final BlockItem blockitem  = new BlockItem(block, properties);
                blockitem.setRegistryName(block.getRegistryName());
                registry.register(blockitem);
        });
    }

    private void setup(final FMLClientSetupEvent event)
    {
    }


    private void clientSetup(final FMLClientSetupEvent event)
    {
        RegisterEntityModels(event.getMinecraftSupplier());
    }

    private void RegisterEntityModels(Supplier<Minecraft> minecraft)
    {
        ItemRenderer renderer = minecraft.get().getItemRenderer();
        RenderingRegistry.registerEntityRenderingHandler(EntityList.SILVER_PISTOL_BULLET_PROJECTILE.get(), (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer));
        RenderingRegistry.registerEntityRenderingHandler(EntityList.IRON_PISTOL_BULLET_PROJECTILE.get(), (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer));
    }

    public void onServerStarting(FMLServerStartingEvent event)
    {

    }

    public static class MagicItemsGroup extends ItemGroup
    {

        public MagicItemsGroup(String name) {
            super(name);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemList.WOODEN_STAKE.get());
        }
    }

}
