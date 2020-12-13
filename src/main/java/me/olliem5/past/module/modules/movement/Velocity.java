package me.olliem5.past.module.modules.movement;

import me.olliem5.past.Past;
import me.olliem5.past.event.events.PacketEvent;
import me.olliem5.past.module.Category;
import me.olliem5.past.module.Module;
import me.olliem5.past.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;

public class Velocity extends Module {
    public Velocity() {
        super("Velocity", "Makes you take 0 knockback", Category.MOVEMENT);
    }

    Setting velocity;
    Setting explosions;

    @Override
    public void setup() {
        Past.settingsManager.registerSetting(velocity = new Setting("Velocity", "VelocityVelocity", true, this));
        Past.settingsManager.registerSetting(explosions = new Setting("Explosions", "VelocityExplosions", true, this));
    }

    @EventHandler
    public Listener<PacketEvent.Receive> listener = new Listener<>(event -> {
        if (event.getPacket() instanceof SPacketEntityVelocity) {
            if (velocity.getValBoolean() && ((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId()) {
                event.cancel();
            }
        } else if (explosions.getValBoolean() && event.getPacket() instanceof SPacketExplosion) {
            event.cancel();
        }
    });
}
