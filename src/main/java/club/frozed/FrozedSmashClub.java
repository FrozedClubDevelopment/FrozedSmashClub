package club.frozed;

import club.frozed.game.item.ItemListener;
import club.frozed.game.match.MatchListener;
import club.frozed.game.match.MatchManager;
import club.frozed.game.player.DoubleJumpListener;
import club.frozed.game.player.PlayerListener;
import club.frozed.game.provider.SmashScoreboard;
import club.frozed.server.mongo.SmashDatabase;
import club.frozed.user.UserListener;
import club.frozed.user.UserManager;
import club.frozed.utils.command.CommandFramework;
import club.frozed.utils.menu.ButtonListener;
import club.frozed.utils.scoreboard.BoardManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class FrozedSmashClub extends JavaPlugin {

	@Getter private static FrozedSmashClub instance;

	private final CommandFramework commandFramework = new CommandFramework(this);

	private UserManager userManager;
	private MatchManager matchManager;

	@Override
	public void onEnable() {
		instance = this;
		this.saveConfig();

		new SmashDatabase();

		this.registerManagers();
		this.registerListeners();

		new BoardManager(new SmashScoreboard(), 20);
	}

	@Override
	public void onDisable() {

	}

	private void registerManagers() {
		this.userManager = new UserManager();
		this.matchManager = new MatchManager();
	}

	private void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new UserListener(), this);
		Bukkit.getPluginManager().registerEvents(new ItemListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
		Bukkit.getPluginManager().registerEvents(new MatchListener(), this);
		Bukkit.getPluginManager().registerEvents(new ButtonListener(), this);
		Bukkit.getPluginManager().registerEvents(new DoubleJumpListener(), this);
	}
}
