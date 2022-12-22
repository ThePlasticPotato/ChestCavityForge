package net.tigereye.chestcavity.util;


import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegisterEvent;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.registration.CCRecipes;

@Mod.EventBusSubscriber(modid = ChestCavity.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventBusSubscriber {

    @SubscribeEvent
    public static void registerRecipeTypes(final RegisterEvent event) {
        event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS, helper -> {
            CCRecipes.SALVAGE_RECIPE_TYPE = Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(ChestCavity.MODID,"crafting_salvage"), CCRecipes.SALVAGE_RECIPE_TYPE);
        });
    }
}
