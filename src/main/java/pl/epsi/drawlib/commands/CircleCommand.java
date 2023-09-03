package pl.epsi.drawlib.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import pl.epsi.drawlib.Main;
import pl.epsi.drawlib.Selection;
import pl.epsi.drawlib.shapes.Circle;
import pl.epsi.drawlib.transformations.Composite;
import pl.epsi.drawlib.transformations.Move;
import pl.epsi.drawlib.transformations.Rotate;
import pl.epsi.drawlib.transformations.Transformation;

public class CircleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("cant do that");
            return false;
        }
        Player p = (Player) commandSender;
        Circle circle = new Circle(p.getLocation(), Integer.valueOf(args[0]));
        Selection selection = circle.select(Boolean.valueOf(args[1]));
        selection.stroke(Material.STONE);

        //Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> {
        //    selection.restore();
        //}, 40L);

        Transformation transformation = new Composite()
                .add(new Move(new Vector(0, 5, 0)));
                //.add(new Rotate(p.getLocation(), 45));
        selection = selection.transform(transformation);
        selection.stroke(Material.STONE);

        return false;
    }
}
