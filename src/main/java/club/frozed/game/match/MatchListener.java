package club.frozed.game.match;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/13/2021 @ 9:48 PM
 */
public class MatchListener implements Listener {

	@EventHandler
	public void onFoodConsumption(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
}
