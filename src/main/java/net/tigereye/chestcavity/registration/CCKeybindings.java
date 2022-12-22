package net.tigereye.chestcavity.registration;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tigereye.chestcavity.ChestCavity;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;


@Mod.EventBusSubscriber(modid = ChestCavity.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CCKeybindings {

    private static final String ORGAN_ABILITY_KEY_CATEGORY = "organ_abilities";

    public static final ResourceLocation UTILITY_ABILITIES_ID = new ResourceLocation(ChestCavity.MODID,"utility_abilities");
    public static final List<ResourceLocation> UTILITY_ABILITY_LIST = new ArrayList<>();
    public static final KeyMapping UTILITY_ABILITIES = register(UTILITY_ABILITIES_ID, ORGAN_ABILITY_KEY_CATEGORY, GLFW.GLFW_KEY_V);

    public static final ResourceLocation ATTACK_ABILITIES_ID = new ResourceLocation(ChestCavity.MODID,"attack_abilities");
    public static final List<ResourceLocation> ATTACK_ABILITY_LIST = new ArrayList<>();
    public static final KeyMapping ATTACK_ABILITIES =  register(ATTACK_ABILITIES_ID, ORGAN_ABILITY_KEY_CATEGORY, GLFW.GLFW_KEY_R);

    private static final int DEFAULT_KEY = GLFW.GLFW_KEY_UNKNOWN; //GLFW.GLFW_KEY_KP_DECIMAL;


    public static final KeyMapping CREEPY = register(CCOrganScores.CREEPY, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, true); //GLFW.GL
    public static final KeyMapping DRAGON_BREATH = register(CCOrganScores.DRAGON_BREATH, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, true);
    public static final KeyMapping DRAGON_BOMBS = register(CCOrganScores.DRAGON_BOMBS, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, true);
    public static final KeyMapping FORCEFUL_SPIT = register(CCOrganScores.FORCEFUL_SPIT, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, true);
    public static final KeyMapping FURNACE_POWERED = register(CCOrganScores.FURNACE_POWERED, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, false);
    public static final KeyMapping IRON_REPAIR = register(CCOrganScores.IRON_REPAIR, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, false);
    public static final KeyMapping PYROMANCY = register(CCOrganScores.PYROMANCY, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, true);
    public static final KeyMapping GHASTLY = register(CCOrganScores.GHASTLY, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, true);
    public static final KeyMapping GRAZING = register(CCOrganScores.GRAZING, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, false);
    public static final KeyMapping SHULKER_BULLETS = register(CCOrganScores.SHULKER_BULLETS, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, true);
    public static final KeyMapping SILK = register(CCOrganScores.SILK, ORGAN_ABILITY_KEY_CATEGORY, DEFAULT_KEY, false);

    public static void init() {}

    public static KeyMapping register(ResourceLocation id, String category, int defaultKey) {
        //ClientRegistry.registerKeyBinding(keyMapping);
        return new KeyMapping(
                "key." + id.getNamespace() + "." + id.getPath(), // The translation key of the keybinding's name
                KeyConflictContext.IN_GAME,
                InputConstants.Type.KEYSYM, // The type of the keybinding, KEYSYM for keyboard, MOUSE for mouse.
                defaultKey, // The keycode of the key
                "category." + id.getNamespace() + "." + category // The translation key of the keybinding's category.
        );
    }

    public static KeyMapping register(ResourceLocation id, String category, int defaultKey, boolean isAttack){
        if(isAttack) {ATTACK_ABILITY_LIST.add(id);}
        else {UTILITY_ABILITY_LIST.add(id);}
        return register(id, category, defaultKey);
    }

    @SubscribeEvent
    public static void registerKey(RegisterKeyMappingsEvent event) {
        ChestCavity.printOnDebug("RegisterKeyMappingsEvent Fired!");
        event.register(UTILITY_ABILITIES);
        event.register(ATTACK_ABILITIES);
        event.register(CREEPY);
        event.register(DRAGON_BREATH);
        event.register(DRAGON_BOMBS);
        event.register(FORCEFUL_SPIT);
        event.register(FURNACE_POWERED);
        event.register(IRON_REPAIR);
        event.register(PYROMANCY);
        event.register(GHASTLY);
        event.register(GRAZING);
        event.register(SHULKER_BULLETS);
        event.register(SILK);
    }
}
