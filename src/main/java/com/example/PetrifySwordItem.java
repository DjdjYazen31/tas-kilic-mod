package com.example;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class PetrifySwordItem extends SwordItem {

    public PetrifySwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.getWorld().isClient()) {
            // 1. Hedefin hareket etmesini dondur (Slowness 255)
            target.addStatusEffect(new StatusEffectInstance(
                StatusEffects.SLOWNESS, 200, 255, false, false, true
            ));
            
            // 2. Blok kırmasını ve vurmasını engelle (Mining Fatigue 255)
            target.addStatusEffect(new StatusEffectInstance(
                StatusEffects.MINING_FATIGUE, 200, 255, false, false, true
            ));

            // 3. Zıplamasını ve net görmesini engelle
            target.addStatusEffect(new StatusEffectInstance(
                StatusEffects.BLINDNESS, 200, 0, false, false, true
            ));

            // 4. Taşlaşma Sesi
            attacker.getWorld().playSound(
                null, target.getBlockPos(), SoundEvents.BLOCK_STONE_BREAK, SoundCategory.PLAYERS, 1.0F, 0.8F
            );
        }
        return super.postHit(stack, target, attacker);
    }
}
