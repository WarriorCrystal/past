package me.olliem5.past.impl.modules.movement;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.olliem5.past.Past;
import me.olliem5.past.api.module.Category;
import me.olliem5.past.api.module.Module;
import me.olliem5.past.api.module.ModuleInfo;
import me.olliem5.past.api.setting.Setting;

import java.util.ArrayList;

@ModuleInfo(name = "Sprint", description = "Automatically makes you sprint", category = Category.MOVEMENT)
public class Sprint extends Module {

    Setting sprintmode;

    private ArrayList<String> sprintmodes;

    @Override
    public void setup() {
        sprintmodes = new ArrayList<>();
        sprintmodes.add("Legit");
        sprintmodes.add("Rage");

        Past.settingsManager.registerSetting(sprintmode = new Setting("Mode", "SprintMode", this, sprintmodes, "Legit"));
    }

    public void onUpdate() {
        if (nullCheck()) return;

        if (sprintmode.getValueString() == "Legit") {
            try {
                if (mc.gameSettings.keyBindForward.isKeyDown() && !(mc.player.collidedHorizontally) && !(mc.player.isSneaking()) && !(mc.player.isHandActive()) && mc.player.getFoodStats().getFoodLevel() > 6f) {
                    mc.player.setSprinting(true);
                }
            } catch (Exception ignored) {}
        } else {
            try {
                if (!(mc.player.isSneaking()) && !(mc.player.collidedHorizontally) && mc.player.getFoodStats().getFoodLevel() > 6f && mc.gameSettings.keyBindForward.isKeyDown() || mc.gameSettings.keyBindLeft.isKeyDown() || mc.gameSettings.keyBindRight.isKeyDown() || mc.gameSettings.keyBindBack.isKeyDown()) {
                    mc.player.setSprinting(true);
                }
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void onDisable() {
        mc.player.setSprinting(false);
    }

    public String getArraylistInfo() {
        return ChatFormatting.GRAY + " " + sprintmode.getValueString().toUpperCase();
    }
}
