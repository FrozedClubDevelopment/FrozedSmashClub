package club.frozed.user;

import club.frozed.FrozedSmashClub;
import club.frozed.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/13/2021 @ 9:07 PM
 */
public class UserListener implements Listener {

	private final FrozedSmashClub plugin = FrozedSmashClub.getInstance();

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
		Player player = Bukkit.getPlayer(event.getUniqueId());
		if (player != null && player.isOnline()) {
			event.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
			event.setKickMessage(CC.translate("&cYou tried to login too quickly after disconnecting.\n&cTry again in a few seconds."));

			this.plugin.getServer().getScheduler().runTask(this.plugin, () -> player.kickPlayer(CC.translate("&cDuplicate login kick")));
			return;
		}

		SmashPlayer smashPlayer = this.plugin.getUserManager().getOrCreate(event.getUniqueId());
		smashPlayer.save();
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onPlayerLoginEvent(PlayerLoginEvent event) {
		SmashPlayer smashPlayer = this.plugin.getUserManager().getOrCreate(event.getPlayer().getUniqueId());
		if (smashPlayer == null) {
			event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			event.setKickMessage("§cAn error has ocurred while loading your profile. Please reconnect.");
			return;
		}

		if (!smashPlayer.isLoaded()) {
			smashPlayer.save();
			event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
			event.setKickMessage("§cAn error has ocurred while loading your profile. Please reconnect.");
		}
	}

	private void handledSaveDate(Player player) {
		SmashPlayer smashPlayer = this.plugin.getUserManager().getOrCreate(player.getUniqueId());
		if (smashPlayer != null) {
			smashPlayer.delete();
		}
	}

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		handledSaveDate(event.getPlayer());
	}

	@EventHandler
	public void onPlayerKickEvent(PlayerKickEvent event) {
		handledSaveDate(event.getPlayer());
	}
}
