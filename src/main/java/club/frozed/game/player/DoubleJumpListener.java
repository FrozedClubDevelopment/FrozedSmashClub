package club.frozed.game.player;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/14/2021 @ 7:36 PM
 */
public class DoubleJumpListener implements Listener {

	/*@EventHandler
	public void onDoubleJump(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() == GameMode.CREATIVE) {
			return;
		}

		event.setCancelled(true);
		player.setAllowFlight(true);
		player.setFlying(false);
		player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
		player.playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0f, 0.4f);
	}*/

	@EventHandler
	public void onFly(PlayerToggleFlightEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() != GameMode.CREATIVE && event.getPlayer().getExp() == 1.0F) {
			event.setCancelled(true);
			player.setAllowFlight(false);
			player.setFlying(false);
			player.setVelocity(player.getLocation().getDirection().multiply(1.5D).setY(0.7D));
			player.getLocation().getWorld().playSound(player.getLocation(), Sound.BAT_TAKEOFF, 1.0F, -5.0F);

			player.setExp(0.0F);
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode() != GameMode.CREATIVE && player.getLocation().subtract(0.0, 2.0, 0.0).getBlock().getType() != Material.AIR && !player.isFlying()) {
			player.setAllowFlight(true);
		}
	}

	@EventHandler
	public void onPlayerSneak(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		if (!player.getAllowFlight()) {
			player.setVelocity(player.getLocation().getDirection().setY(-0.7D));
		}

		player.getWorld().createExplosion(player.getLocation(), 1.0F);
	}
}
