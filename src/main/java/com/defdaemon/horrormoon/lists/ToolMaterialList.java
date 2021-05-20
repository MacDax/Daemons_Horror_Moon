package com.defdaemon.horrormoon.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import java.util.function.Supplier;

public enum ToolMaterialList implements IItemTier
{
    //TODO: Check silver_cross values
    silver_cross(1.0f, 0.0f, 1, 0, 100000, () -> Ingredient.of(ItemList.SILVER_INGOT.get()));

    private final float attackDamage;
    private final float efficiency;
    private final int durability;
    private final int harvestLevel;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Supplier<Ingredient> repairMaterial)
    {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.enchantability = enchantability;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return this.durability;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
