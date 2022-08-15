package gay.charon.reportsystem;

import gay.charon.reportsystem.commands.Report;
import org.bukkit.plugin.java.JavaPlugin;

public final class ReportSystem extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("------------------------------------");
        System.out.println("[*] Starting ReportSystem plugin");
        getCommand("report").setExecutor(new Report());
        System.out.println("[*] Started ReportSystem plugin");
        System.out.println("------------------------------------");
    }

}
