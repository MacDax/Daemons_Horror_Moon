package com.defdaemon.horrormoon.objects.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class WoodenStake extends SwordItem
{
    public WoodenStake(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }
}
