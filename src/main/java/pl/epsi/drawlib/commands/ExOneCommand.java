package pl.epsi.drawlib.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.epsi.drawlib.Draw;
import pl.epsi.drawlib.Selection;
import pl.epsi.drawlib.shapes.Square;

public class ExOneCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("cant do that");
            return false;
        }
        Player p = (Player) commandSender;
        Draw.circle(p.getLocation(), 15, Material.STONE);
        Draw.square(p.getLocation(), 10, Material.STONE);
        Square square = new Square(p.getLocation().clone().add(0, 1, 0), 13);
        Selection sel = square.select(true);
        sel.stroke(Material.STONE);

        return false;
    }
}
