package com.defdaemon.horrormoon.lists;

import com.defdaemon.horrormoon.Main;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum AmorMaterialList implements IArmorMaterial {
    silver_armor("silver_armor", 9, new int[] { 1, 4, 5, 2 }, 17, () -> Ingredient.of(ItemList.SILVER_INGOT.get()), "item.armor.equip_gold", 0.0f);

    private String name, equipSound;
    private int durability, enchantability;
    private int[] damageReductionAmounts;
    private Supplier<Ingredient> repairMaterial;
    private float toughness;
    private static int[] max_damage_array = new int[]{13, 15, 16, 11};

    private AmorMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Supplier<Ingredient> repairMaterial, String equipSound, float toughness) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmounts = damageReductionAmounts;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
        this.toughness = toughness;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        return this.damageReductionAmounts[slot.getIndex()];
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return max_damage_array[slot.getIndex()] * this.durability;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public String getName()
    {
        return Main.MOD_ID + ":" + this.name;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public SoundEvent getEquipSound() {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public float getToughness()
    {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
