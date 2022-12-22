package net.tigereye.chestcavity;


import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.tigereye.chestcavity.config.CCConfig;
import net.tigereye.chestcavity.network.NetworkHandler;
import net.tigereye.chestcavity.registration.*;
import net.tigereye.chestcavity.ui.ChestCavityScreen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ChestCavity.MODID)
public class ChestCavity {
	//TODO: FIGURE OUT HOW TO PROPERLY SEND PACKETS FROM THE SERVER TO THE PLAYER WHEN THEY LOG IN
	public static final String MODID = "chestcavity";
    private static final boolean DEBUG_MODE = false; //Make SURE that this is false when building (at least when building to publish)
	private static final boolean LOG_OR_PRINT = true; //Doesnt really matter when building, as long as above is false
	public static final Logger LOGGER = LogManager.getLogger();
	public static CCConfig config;
	public static final ResourceLocation COMPATIBILITY_TAG = new ResourceLocation(MODID,"organ_compatibility");
	public static final CreativeModeTab ORGAN_ITEM_GROUP = new CreativeModeTab("chestcavity.organs") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(CCItems.HUMAN_STOMACH.get());
		}
	};


	public ChestCavity() {
		LOGGER.info("ChestCavity Instance Created!");
		printOnDebug("ChestCavity Constructor Called, DEBUG_MODE == true!");
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);
		bus.addListener(this::doClientStuff);
		bus.addListener(this::doServerStuff);

		//Register mod resources
		AutoConfig.register(CCConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(CCConfig.class).getConfig();
		CCContainers.MENU_TYPES.register(bus);
		CCItems.ITEMS.register(bus);
		CCRecipes.RECIPE_SERIALIZERS.register(bus);
		CCEnchantments.ENCHANTMENTS.register(bus);
		CCListeners.register();
		CCStatusEffects.MOB_EFFECTS.register(bus);
		CCTagOrgans.init();
	}

	public void setup(FMLCommonSetupEvent event) {
		NetworkHandler.init();
	}

	public void doClientStuff(FMLClientSetupEvent event) {
		MenuScreens.register(CCContainers.CHEST_CAVITY_SCREEN_HANDLER.get(), ChestCavityScreen::new);
		CCKeybindings.init();
	}

	public void doServerStuff(FMLDedicatedServerSetupEvent event) {
		//ServerPlayNetworking.registerGlobalReceiver(CCNetworkingPackets.RECEIVED_UPDATE_PACKET_ID, (server, player, handler, buf, sender) -> {
		//    Optional<ChestCavityEntity> optional = ChestCavityEntity.of(player);
		//    optional.ifPresent(chestCavityEntity -> NetworkUtil.ReadChestCavityReceivedUpdatePacket(chestCavityEntity.getChestCavityInstance()));
		//});
		//ServerPlayNetworking.registerGlobalReceiver(CCNetworkingPackets.HOTKEY_PACKET_ID, (server, player, handler, buf, sender) -> {
		//    Optional<ChestCavityEntity> optional = ChestCavityEntity.of(player);
		//    optional.ifPresent(chestCavityEntity -> NetworkUtil.ReadChestCavityHotkeyPacket(chestCavityEntity.getChestCavityInstance(),buf));
		//});
	}

	public static boolean isDebugMode() {
		return DEBUG_MODE;
	}

	public static void printOnDebug(String stringToPrint) {
		if(DEBUG_MODE) {
			if(LOG_OR_PRINT) {
				LOGGER.debug("ChestCavity: " + stringToPrint);
			} else {
				System.out.println("ChestCavity DEBUG: " + stringToPrint);
			}
		}
	}
}
