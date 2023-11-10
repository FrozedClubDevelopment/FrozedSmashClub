package club.frozed.game.player;

import club.frozed.FrozedSmashClub;
import club.frozed.user.SmashPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/14/2021 @ 7:06 PM
 */
public class PlayerListener implements Listener {

	private final FrozedSmashClub plugin = FrozedSmashClub.getInstance();

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().setMaxHealth(6.0D);
		event.getPlayer().setHealth(6.0D);
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageEvent event) {
		event.setDamage(0.0D);
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		event.setDamage(0.0D);

		Player player = (Player) event.getEntity();
		SmashPlayer smashPlayer = this.plugin.getUserManager().getByUuid(player.getUniqueId());
		int smashPlayerDamage = smashPlayer.getDamagePercentage();

		smashPlayer.setDamagePercentage(smashPlayerDamage + 2);
		player.setLevel(smashPlayerDamage);
		player.setExp(1.0F);

		if (smashPlayerDamage >= 10) {
			player.setVelocity(player.getLocation().getDirection().normalize().multiply(-((smashPlayerDamage / 30))));
		} else if (smashPlayerDamage >= 20) {
			player.setVelocity(player.getLocation().getDirection().normalize().multiply(-((smashPlayerDamage / 20))));
		} else {
			player.setVelocity(player.getLocation().getDirection().normalize().multiply(-((smashPlayerDamage / 5))));
		}

		//player.setVelocity(player.getLocation().getDirection().normalize().multiply(-((smashPlayerDamage / 10))));
	}
}
