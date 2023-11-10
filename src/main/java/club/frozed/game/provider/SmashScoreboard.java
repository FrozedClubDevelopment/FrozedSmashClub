package club.frozed.game.provider;

import club.frozed.FrozedSmashClub;
import club.frozed.user.SmashPlayer;
import club.frozed.utils.CC;
import club.frozed.utils.scoreboard.BoardAdapter;
import club.frozed.utils.scoreboard.BoardStyle;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/14/2021 @ 7:42 PM
 */
public class SmashScoreboard implements BoardAdapter {

	private final FrozedSmashClub plugin = FrozedSmashClub.getInstance();

	@Override
	public String getTitle(Player player) {
		return CC.translate("&b&lSMASH");
	}

	@Override
	public BoardStyle getBoardStyle(Player player) {
		return BoardStyle.MODERN;
	}

	@Override
	public List<String> getLines(Player player) {
		List<String> lines = new ArrayList<>();
		SmashPlayer smashPlayer = this.plugin.getUserManager().getByUuid(player.getUniqueId());

		lines.add(CC.translate(" "));
		lines.add(CC.translate("&b&lYou"));
		lines.add(CC.translate("&f • Damage: &b" + smashPlayer.getDamagePercentage() + "%"));
		lines.add(CC.translate(" "));
		lines.add(CC.translate("&b&lPlayers"));
		Bukkit.getServer().getOnlinePlayers().forEach(o -> lines.add(CC.translate("&f • &b" + o.getName())));
		lines.add(CC.translate(" "));
		lines.add(CC.translate("&bfrozed.club"));

		return lines;
	}
}
