package club.frozed.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elb1to
 * Project: FrozedSmashClub
 * Date: 6/4/2021 @ 7:03 PM
 */
public final class CC {

	public final static String SB_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------";
    public final static String MENU_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------------";

	public static String translate(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

	public static List<String> translate(List<String> lines) {
		List<String> strings = new ArrayList<>();
		for (String line : lines) {
			strings.add(ChatColor.translateAlternateColorCodes('&', line));
		}

		return strings;
	}

	public static List<String> translate(String[] lines) {
		List<String> strings = new ArrayList<>();
		for (String line : lines) {
			if (line != null) {
				strings.add(ChatColor.translateAlternateColorCodes('&', line));
			}
		}

		return strings;
	}
}
