package net.tigereye.chestcavity.items;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tigereye.chestcavity.ChestCavity;
import net.tigereye.chestcavity.util.OrganUtil;

import javax.annotation.Nullable;
import java.util.List;

public class CreeperAppendix extends Item {

    public CreeperAppendix() {
        super(new Item.Properties().stacksTo(1).tab(ChestCavity.ORGAN_ITEM_GROUP));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level world, List<Component> tooltip, TooltipFlag tooltipContext) {
        super.appendHoverText(itemStack,world,tooltip,tooltipContext);
        tooltip.add(Component.literal("This appears to be a fuse.").withStyle(ChatFormatting.ITALIC));
        tooltip.add(Component.literal("It won't do much by itself.").withStyle(ChatFormatting.ITALIC));
    }
}
