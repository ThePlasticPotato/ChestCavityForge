package net.tigereye.chestcavity.listeners;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tigereye.chestcavity.chestcavities.instance.ChestCavityInstance;
import net.tigereye.chestcavity.registration.CCOrganScores;
import net.tigereye.chestcavity.registration.CCTags;

import java.util.List;

public class OrganFoodEffectListeners {

    //COMMENTED BY BOONELDAN

    /*
    public static void callMethods(List<Pair<MobEffectInstance, Float>> list, ItemStack itemStack, Level world, LivingEntity entity, ChestCavityInstance cc){
        applyRotgut(list, itemStack, world, entity, cc);
    }

    private static List<Pair<MobEffectInstance, Float>> applyRotgut(List<Pair<MobEffectInstance, Float>> list, ItemStack itemStack, Level world, LivingEntity entity, ChestCavityInstance cc) {
        float rotten = cc.getOrganScore(CCOrganScores.ROTGUT)+cc.getOrganScore(CCOrganScores.ROT_DIGESTION);
        if(rotten > 0){
            if(itemStack.is(CCTags.ROTTEN_FOOD)) {
                list.removeIf(pair -> pair.getFirst().getEffect() == MobEffects.HUNGER);
            }
        }
        return list;
    }

     */
}
