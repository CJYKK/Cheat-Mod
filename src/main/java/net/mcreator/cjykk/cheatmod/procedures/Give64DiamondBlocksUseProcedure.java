package net.mcreator.cjykk.cheatmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.cjykk.cheatmod.CheatModModElements;
import net.mcreator.cjykk.cheatmod.CheatModMod;

import java.util.Map;

@CheatModModElements.ModElement.Tag
public class Give64DiamondBlocksUseProcedure extends CheatModModElements.ModElement {
	public Give64DiamondBlocksUseProcedure(CheatModModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CheatModMod.LOGGER.warn("Failed to load dependency entity for procedure Give64DiamondBlocksUse!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(Blocks.DIAMOND_BLOCK, (int) (1));
			_setstack.setCount((int) 64);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u5DF2\u7ECF\u7ED9\u4F60\u4E8664\u4E2A\u94BB\u77F3\u5757"), (true));
		}
	}
}
