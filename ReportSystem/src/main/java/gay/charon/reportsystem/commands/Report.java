package gay.charon.reportsystem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("rs.report")){
                String username = args[0];
                String reason = "";
                for (int i = 1; i < args.length; i++) {
                    reason = reason + args[i] + " ";
                }
                for(Player online : Bukkit.getOnlinePlayers()){
                    if(online.hasPermission("rs.recieve"))
                        online.sendMessage("§7§m----------------------\n§7§l• §fPlayer: §5" + username + "\n§7§l• §fReporter: §4" + player.getName() + "\n§7§l• §fReason: §5" + reason + "\n§7§m----------------------");
                }
                player.sendMessage("§8[§a!§8] §fReport has been sent successfully!");
            } else {
                player.sendMessage("§8[§c!§8] §fYou don't have permission to run this command!");
            }
        } else{
            System.out.println("[!] You have to run this command as player...");
        }
        return false;
    }
}
