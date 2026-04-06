package tv.fussel.postgresqljdbc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpigotPostgreSqlJdbcPlugin extends JavaPlugin {
  @Override
  public void onLoad() {
    try {
      Class.forName("org.postgresql.Driver");
      getLogger().info("PostgreSQL JDBC driver loaded.");
    } catch (ClassNotFoundException exception) {
      throw new IllegalStateException("PostgreSQL JDBC driver is missing from plugin jar.", exception);
    }
  }

  @Override
  public void onEnable() {
    getLogger().info("Spigot-only PostgreSQL JDBC bridge enabled.");
  }

  @Override
  public void onDisable() {
    if (Bukkit.getServer() != null) {
      getLogger().info("Spigot-only PostgreSQL JDBC bridge disabled.");
    }
  }
}
