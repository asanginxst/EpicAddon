package com.jvn.epicaddon.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.WeaponItem;

public class DarkRepulsorItem extends WeaponItem {
    public DarkRepulsorItem(Item.Properties build, Tier tier) {
        super(tier, 0, 0.0f, build);

    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }
}
