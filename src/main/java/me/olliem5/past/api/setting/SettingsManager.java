package me.olliem5.past.api.setting;

import me.olliem5.past.Past;
import me.olliem5.past.impl.gui.editor.component.HudComponent;
import me.olliem5.past.api.module.Module;

import java.util.ArrayList;

public class SettingsManager {
    private ArrayList<Setting> settings;

    public SettingsManager() {
        this.settings = new ArrayList<>();
    }

    public void registerSetting(Setting args) {
        this.settings.add(args);
    }

    public ArrayList<Setting> getSettings() {
        return this.settings;
    }

    public Setting getSettingName(String name) {
        for (Setting setting : getSettings()) {
            if (setting.getName() == name) {
                return setting;
            }
        }
        Past.log("Setting error, setting `" + name + "` NOT found!");
        return null;
    }

    public Setting getSettingID(String id) {
        for (Setting setting : getSettings()) {
            if (setting.getId() == id) {
                return setting;
            }
        }
        Past.log("Setting error, setting id `" + id + "` NOT found!");
        return null;
    }

    public ArrayList<Setting> getSettingsModule(Module module) {
        ArrayList<Setting> list = new ArrayList<>();
        for (Setting setting : getSettings()) {
            if (setting.getParent() == module) {
                list.add(setting);
            }
        }
        return list;
    }

    public ArrayList<Setting> getSettingsHudComponent(HudComponent hudComponent) {
        ArrayList<Setting> list = new ArrayList<>();
        for (Setting setting : getSettings()) {
            if (setting.getHudParent() == hudComponent) {
                list.add(setting);
            }
        }
        return list;
    }
}
