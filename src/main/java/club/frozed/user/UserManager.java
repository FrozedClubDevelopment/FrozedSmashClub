package club.frozed.user;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/4/2021 @ 8:16 PM
 */
public class UserManager {

	@Getter private final Map<UUID, SmashPlayer> users = new HashMap<>();

	public SmashPlayer getOrCreate(UUID uuid) {
		return users.computeIfAbsent(uuid, SmashPlayer::new);
	}

	public SmashPlayer getByUuid(UUID uuid) {
		return users.getOrDefault(uuid, new SmashPlayer(uuid));
	}
}
