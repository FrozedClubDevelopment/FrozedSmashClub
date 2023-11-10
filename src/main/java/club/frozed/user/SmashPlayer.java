package club.frozed.user;

import club.frozed.FrozedSmashClub;
import club.frozed.server.mongo.SmashDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;

import java.util.UUID;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/4/2021 @ 6:58 PM
 */
@Getter @Setter
public class SmashPlayer {

	private final UUID uniqueId;
	private String name;

	private boolean loaded;

	private int kills;
	private int deaths;
	private int wins;

	private int elo;

	private int damagePercentage = 0;

	private SmashPlayerState state = SmashPlayerState.SPAWN;

	public SmashPlayer(UUID uniqueId) {
		this.uniqueId = uniqueId;
		this.loaded = false;

		load();
	}

	public void load() {
		Document document = SmashDatabase.getInstance().getUsers().find(Filters.eq("uniqueId", uniqueId.toString())).first();
		if (document != null) {
			this.kills = document.getInteger("kills");
			this.deaths = document.getInteger("deaths");
			this.wins = document.getInteger("wins");
			this.elo = document.getInteger("elo");
		}

		this.loaded = true;
	}

	public void save() {
		Document document = new Document();
		document.put("uniqueId", this.uniqueId.toString());

		document.put("kills", this.kills);
		document.put("deaths", this.deaths);
		document.put("wins", this.wins);
		document.put("elo", this.elo);

		SmashDatabase.getInstance().getUsers().replaceOne(Filters.eq("uniqueId", uniqueId.toString()), document, new UpdateOptions().upsert(true));
	}

	public void delete() {
		this.save();

		FrozedSmashClub.getInstance().getUserManager().getUsers().remove(this.uniqueId);
	}

	public enum SmashPlayerState {
		SPAWN, IN_MATCH
	}
}
