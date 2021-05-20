package com.defdaemon.horrormoon.objects.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

//TODO: Build SilverCross class to scare vampires away

public class SilverCross extends SwordItem
{
    public SilverCross(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity one, LivingEntity two)
    {
        // Test for specific Entity
        // if(one == Vampire) {
        //   remove entity
        // }
        // remove WoodenStake from stack
        System.out.printf("One: %s", one.getName());
        System.out.printf("Two: %s", two.getName());
        return true;
    }
}
