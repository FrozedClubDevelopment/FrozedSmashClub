package club.frozed.utils.command;

import club.frozed.FrozedSmashClub;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/4/2021 @ 7:03 PM
 */
public abstract class BaseCommand {

	public BaseCommand() {
		FrozedSmashClub.getInstance().getCommandFramework().registerCommands(this, null);
	}

	public abstract void onCommand(CommandArgs command);
}
