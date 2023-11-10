package club.frozed.game.item;

import lombok.AllArgsConstructor;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/13/2021 @ 8:45 PM
 */
@AllArgsConstructor
public class SmashItem {

	private final String name;
	private final ItemStack item;
	private final int damage;
	private final int uses;
	private final int chance;

}
