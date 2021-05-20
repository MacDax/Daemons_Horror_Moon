package com.defdaemon.horrormoon.lists;

import com.defdaemon.horrormoon.Main;
import com.defdaemon.horrormoon.objects.items.IronPistolBulletItem;
import com.defdaemon.horrormoon.objects.items.SilverCross;
import com.defdaemon.horrormoon.objects.items.SilverPistolBulletItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemList {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);

    //TODO: Check SILVER_CROSS properties
    public static final RegistryObject<Item> SILVER_CROSS = ITEMS.register("silver_cross", () -> new SilverCross(ToolMaterialList.silver_cross, 0, 6.0f, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> SILVER_NUGGET = ITEMS.register("silver_nugget", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_MISC)));
    public static final RegistryObject<Item> WOODEN_STAKE = ITEMS.register("wooden_stake", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_HELMET = ITEMS.register("silver_helmet", () -> new ArmorItem(AmorMaterialList.silver_armor, EquipmentSlotType.HEAD, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_CHESTPLATE = ITEMS.register("silver_chestplate", () -> new ArmorItem(AmorMaterialList.silver_armor, EquipmentSlotType.CHEST, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_LEGGINGS = ITEMS.register("silver_leggings", () -> new ArmorItem(AmorMaterialList.silver_armor, EquipmentSlotType.LEGS, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_BOOTS = ITEMS.register("silver_boots", () -> new ArmorItem(AmorMaterialList.silver_armor, EquipmentSlotType.FEET, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_HORSE_ARMOR = ITEMS.register("silver_horse_armor", () -> new HorseArmorItem(6, "silver", (new Item.Properties()).stacksTo(1).tab(ItemGroup.TAB_MISC)));


    //Future stuff
    public static final RegistryObject<Item> IRON_RIFLE_BULLET = ITEMS.register("iron_rifle_bullet", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> SILVER_RIFLE_BULLET = ITEMS.register("silver_rifle_bullet", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> MAGAZINE_DESERT_EAGLE = ITEMS.register("magazine_desert_eagle", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> MAGAZINE_SP_R_208 = ITEMS.register("magazine_sp_r_208", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> MAGAZINE_AK47  = ITEMS.register("magazine_ak47", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GUN_DESERT_EAGLE = ITEMS.register("gun_desert_eagle", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GUN_SP_R_208 = ITEMS.register("gun_sp_r_208", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> GUN_AK47  = ITEMS.register("gun_ak47", () -> new Item(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    public static final RegistryObject<Item> SILVER_PISTOL_BULLET = ITEMS.register("silver_pistol_bullet", () -> new SilverPistolBulletItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_PISTOL_BULLET = ITEMS.register("iron_pistol_bullet", () -> new IronPistolBulletItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
}
