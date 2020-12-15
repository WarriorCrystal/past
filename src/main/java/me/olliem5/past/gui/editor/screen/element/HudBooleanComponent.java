package me.olliem5.past.gui.editor.screen.element;

import me.olliem5.past.Past;
import me.olliem5.past.gui.editor.screen.Element;
import me.olliem5.past.settings.Setting;
import me.olliem5.past.util.colour.ColourUtil;
import me.olliem5.past.util.module.GUIColourUtil;
import net.minecraft.client.gui.Gui;

public class HudBooleanComponent extends Element {
    private Setting op;
    private HudButton parent;
    private int offset;
    private int x;
    private int y;

    public HudBooleanComponent(Setting op, HudButton parent, int offset) {
        this.op = op;
        this.parent = parent;
        this.x = parent.parent.getX() + parent.parent.getWidth();
        this.y = parent.parent.getY() + parent.offset;
        this.offset = offset;
    }

    @Override
    public void setOff(final int newOff) {
        this.offset = newOff;
    }

    @Override
    public void renderElement() {
        Gui.drawRect(parent.parent.getX() - 1, this.parent.parent.getY() + this.offset, parent.parent.getX(), this.parent.parent.getY() + 15 + this.offset, Past.settingsManager.getSettingID("HudEditorRainbow").getValBoolean() ? ColourUtil.getMultiColour().getRGB() : GUIColourUtil.getGUIColour());
        Gui.drawRect(parent.parent.getX() + parent.parent.getWidth(), this.parent.parent.getY() + this.offset, parent.parent.getX() + parent.parent.getWidth() + 1, this.parent.parent.getY() + 15 + this.offset, Past.settingsManager.getSettingID("HudEditorRainbow").getValBoolean() ? ColourUtil.getMultiColour().getRGB() : GUIColourUtil.getGUIColour());
        Gui.drawRect(parent.parent.getX() - 1, parent.parent.getY() + offset, parent.parent.getX() + parent.parent.getWidth() + 1, parent.parent.getY() + offset + 16, Past.settingsManager.getSettingID("HudEditorRainbow").getValBoolean() ? ColourUtil.getMultiColour().getRGB() : GUIColourUtil.getGUIColour());

        if (op.getValBoolean()) {
            Gui.drawRect(parent.parent.getX(), parent.parent.getY() + offset, parent.parent.getX() + parent.parent.getWidth(), parent.parent.getY() + offset + 15, Past.settingsManager.getSettingID("HudEditorRainbow").getValBoolean() ? ColourUtil.getMultiColour().getRGB() : GUIColourUtil.getGUIColour());
            Gui.drawRect(parent.parent.getX(), parent.parent.getY() + offset, parent.parent.getX() + parent.parent.getWidth(), parent.parent.getY() + offset + 15, 0x75101010);
        } else {
            Gui.drawRect(parent.parent.getX(), parent.parent.getY() + offset, parent.parent.getX() + parent.parent.getWidth(), parent.parent.getY() + offset + 15, 0xFF111111);
        }

        Gui.drawRect(parent.parent.getX(), parent.parent.getY() + offset, parent.parent.getX() + 1, parent.parent.getY() + offset + 15, Past.settingsManager.getSettingID("HudEditorRainbow").getValBoolean() ? ColourUtil.getMultiColour().getRGB() : GUIColourUtil.getGUIColour());
        Gui.drawRect(parent.parent.getX() + parent.parent.getWidth(), parent.parent.getY() + offset, parent.parent.getX() + parent.parent.getWidth() - 1, parent.parent.getY() + offset + 15, Past.settingsManager.getSettingID("HudEditorRainbow").getValBoolean() ? ColourUtil.getMultiColour().getRGB() : GUIColourUtil.getGUIColour());

        if (Past.settingsManager.getSettingID("HudEditorCustomFont").getValBoolean()) {
            Past.customFontRenderer.drawStringWithShadow(op.getName(), parent.parent.getX() + 4, parent.parent.getY() + this.offset + 4, -1);
        } else {
            mc.fontRenderer.drawStringWithShadow(op.getName(), parent.parent.getX() + 4, parent.parent.getY() + this.offset + 4, -1);
        }
    }

    @Override
    public void updateElement(int mouseX, int mouseY) {
        this.y = parent.parent.getY() + this.offset;
        this.x = parent.parent.getX();
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.isOpen()) {
            this.op.setValBoolean(!op.getValBoolean());
        }
    }

    public boolean isMouseOnButton(int x, int y) {
        if (x > this.x && x < this.x + 100 && y > this.y && y < this.y + 15) {
            return true;
        } else {
            return false;
        }
    }
}