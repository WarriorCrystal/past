package me.olliem5.past.module.modules.player;

import me.olliem5.past.Past;
import me.olliem5.past.module.Category;
import me.olliem5.past.module.Module;
import me.olliem5.past.settings.Setting;
import me.olliem5.past.util.player.PlayerUtil;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class Burrow extends Module {
    public Burrow() {
        super("Burrow", "Places an obsidian block inside of you", Category.PLAYER);
    }

    Setting height;
    Setting autoswitch;

    @Override
    public void setup() {
        Past.settingsManager.registerSetting(height = new Setting("Height", "BurrowHeight", 1.0, 1.14, 1.3, this));
        Past.settingsManager.registerSetting(autoswitch = new Setting("Auto Switch", "BurrowAutoSwitch", true, this));
    }

    private BlockPos playerPos;

    @Override
    public void onEnable() {
        playerPos = new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ);

        if (mc.world.getBlockState(playerPos).getBlock() == Blocks.OBSIDIAN) {
            toggle();
            return;
        }

        mc.player.jump();
    }

    public void onUpdate() {
        if (nullCheck()) return;

        int oldSlot = -1;

        if (mc.player.posY > playerPos.getY() + height.getValueDouble()) {

            if (autoswitch.getValBoolean()) {
                oldSlot = mc.player.inventory.currentItem;
                mc.player.inventory.currentItem = PlayerUtil.getBlockInHotbar(Blocks.OBSIDIAN);
            }

            PlayerUtil.placeBlock(playerPos);

            if (autoswitch.getValBoolean()) {
                mc.player.inventory.currentItem = oldSlot;
            }

            mc.player.jump();
            toggle();
        }
    }
}
