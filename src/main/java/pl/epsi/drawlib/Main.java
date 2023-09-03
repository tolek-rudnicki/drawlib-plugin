package pl.epsi.drawlib;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import pl.epsi.drawlib.commands.CircleCommand;
import pl.epsi.drawlib.commands.ExOneCommand;

public class Main extends JavaPlugin {

    private ConsoleCommandSender sender = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        sender.sendMessage("STARTING DRAWLIB");
        this.getCommand("ex1").setExecutor(new ExOneCommand());
        this.getCommand("circle").setExecutor(new CircleCommand());
    }

    @Override
    public void onDisable() {
        sender.sendMessage("STOPPING DRAWLIB");
    }

}
