package club.frozed.game.arena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/13/2021 @ 1:23 PM
 */
@Getter @Setter @AllArgsConstructor
public class SmashArena {

	private String arenaName;
	private String icon;
	private int iconData;

	private List<Location> playerSpawns;
	private List<Location> itemSpawns;

	private double arenaMax;
	private double arenaMin;

	private boolean enabled;

}
