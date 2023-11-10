package club.frozed.utils.cuboid;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/**
 * Created by:
 * @Tristiisch74
 */
public class Cuboid {

	private final int xMin;
	private final int xMax;

	private final int yMin;
	private final int yMax;

	private final int zMin;
	private final int zMax;

	private final World world;

	public Cuboid(final Location point1, final Location point2) {
		this.xMin = Math.min(point1.getBlockX(), point2.getBlockX());
		this.xMax = Math.max(point1.getBlockX(), point2.getBlockX());
		this.yMin = Math.min(point1.getBlockY(), point2.getBlockY());
		this.yMax = Math.max(point1.getBlockY(), point2.getBlockY());
		this.zMin = Math.min(point1.getBlockZ(), point2.getBlockZ());
		this.zMax = Math.max(point1.getBlockZ(), point2.getBlockZ());

		this.world = point1.getWorld();
	}

	/*public Iterator<Block> blockList() {
		final ArrayList<Block> bL = new ArrayList<>(this.getTotalBlockSize());
		for (int x = this.xMin; x <= this.xMax; ++x) {
			for (int y = this.yMin; y <= this.yMax; ++y) {
				for (int z = this.zMin; z <= this.zMax; ++z) {
					final Block b = this.world.getBlockAt(x, y, z);
					bL.forEach(block -> bL.add(b));
				}
			}
		}

		return bL;
	}*/

	public double getDistance() {
		return this.getPoint1().distance(this.getPoint2());
	}

	public double getDistanceSquared() {
		return this.getPoint1().distanceSquared(this.getPoint2());
	}

	public int getHeight() {
		return this.yMax - this.yMin + 1;
	}

	public Location getPoint1() {
		return new Location(this.world, this.xMin, this.yMin, this.zMin);
	}

	public Location getPoint2() {
		return new Location(this.world, this.xMax, this.yMax, this.zMax);
	}

	public boolean isIn(final Location loc) {
		return loc.getWorld() == this.world
				&& loc.getBlockX() >= this.xMin
				&& loc.getBlockX() <= this.xMax
				&& loc.getBlockY() >= this.yMin
				&& loc.getBlockY() <= this.yMax
				&& loc.getBlockZ() >= this.zMin
				&& loc.getBlockZ() <= this.zMax
				;
	}

	public boolean isIn(final Player player) {
		return this.isIn(player.getLocation());
	}
}
