package com.defdaemon.horrormoon.objects.entities;

import com.defdaemon.horrormoon.lists.EntityList;
import com.defdaemon.horrormoon.lists.ItemList;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class IronPistolBulletEntity extends ProjectileItemEntity
{
    public IronPistolBulletEntity(EntityType<IronPistolBulletEntity> type, World world)
    {
        super(type, world);

    }

    public IronPistolBulletEntity(LivingEntity entity, World world)
    {
        super(EntityList.IRON_PISTOL_BULLET_PROJECTILE.get(), entity, world);
    }

    public IronPistolBulletEntity(double x, double y, double z, World world)
    {
        super(EntityList.IRON_PISTOL_BULLET_PROJECTILE.get(), x, y, z, world );
    }

    @Override
    protected Item getDefaultItem() {
        return ItemList.IRON_PISTOL_BULLET.get();
    }


    @Nonnull
    @Override
    public IPacket<?> getAddEntityPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Nonnull
    @Override
    protected void onHit(RayTraceResult result) {

        this.remove();
    }
}
