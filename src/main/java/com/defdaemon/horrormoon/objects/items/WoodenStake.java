package com.defdaemon.horrormoon.objects.items;

import com.defdaemon.horrormoon.util.KeyboardUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

import static com.defdaemon.horrormoon.util.KeyboardUtil.isHoldingShift;

//TODO: Write WoodenStake class so it can kill only Vampires

public class WoodenStake extends Item
{

    public WoodenStake(Properties properties)
    {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        //super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add((new TranslationTextComponent("tooltip.daemonhorrormoon.wooden_stake")).append(" ").append(stack.getDisplayName()));
        tooltip.add((new StringTextComponent("Kills vampires only !")).withStyle(TextFormatting.AQUA));
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
