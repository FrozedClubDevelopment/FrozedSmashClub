package club.frozed.game.item.impl;

import club.frozed.game.item.SmashItem;
import club.frozed.utils.ItemBuilder;
import org.bukkit.Material;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/13/2021 @ 8:45 PM
 */
public class CrappySnowball extends SmashItem {

	public CrappySnowball() {
		super("Just a Crappy Snowball",
				new ItemBuilder(Material.SNOW_BALL).name("Just a Crappy Snowball").build(),
				4, 1, 7
		);
	}
}
