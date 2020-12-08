package me.olliem5.past.util.colour;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.awt.*;

public class ColourUtil {
    //ChatFormatting colours.
    public static ChatFormatting aqua = ChatFormatting.AQUA;
    public static ChatFormatting black = ChatFormatting.BLACK;
    public static ChatFormatting blue = ChatFormatting.BLUE;
    public static ChatFormatting gold = ChatFormatting.GOLD;
    public static ChatFormatting gray = ChatFormatting.GRAY;
    public static ChatFormatting green = ChatFormatting.GREEN;
    public static ChatFormatting red = ChatFormatting.RED;
    public static ChatFormatting white = ChatFormatting.WHITE;
    public static ChatFormatting yellow = ChatFormatting.YELLOW;
    public static ChatFormatting lightPurple = ChatFormatting.LIGHT_PURPLE;
    public static ChatFormatting darkAqua = ChatFormatting.DARK_AQUA;
    public static ChatFormatting darkBlue = ChatFormatting.DARK_BLUE;
    public static ChatFormatting darkGray = ChatFormatting.DARK_GRAY;
    public static ChatFormatting darkGreen = ChatFormatting.DARK_GREEN;
    public static ChatFormatting darkPurple = ChatFormatting.DARK_PURPLE;
    public static ChatFormatting darkRed = ChatFormatting.DARK_RED;

    //ChatFormatting addons.
    public static ChatFormatting bold = ChatFormatting.BOLD;
    public static ChatFormatting italic = ChatFormatting.ITALIC;
    public static ChatFormatting obfuscated = ChatFormatting.OBFUSCATED;
    public static ChatFormatting strikethrough = ChatFormatting.STRIKETHROUGH;
    public static ChatFormatting underline = ChatFormatting.UNDERLINE;

    //Random ChatFormatting stuff.
    public static ChatFormatting reset = ChatFormatting.RESET;
    public static char prefixCode = ChatFormatting.PREFIX_CODE;

    //RGB.
    public static Color getMultiColour() {
        return Color.getHSBColor((float) (System.currentTimeMillis() % 7500L) / 7500f, 0.8f, 0.8f);
    }
}
