package main.java.com.djrapitops.plan.command.commands;

import com.djrapitops.javaplugin.command.CommandType;
import com.djrapitops.javaplugin.command.SubCommand;
import com.djrapitops.javaplugin.command.sender.ISender;
import main.java.com.djrapitops.plan.Permissions;
import main.java.com.djrapitops.plan.Phrase;
import main.java.com.djrapitops.plan.Plan;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * This subcommand is used to reload the plugin.
 *
 * @author Rsl1122
 * @since 2.0.0
 */
public class ReloadCommand extends SubCommand {

    private final Plan plugin;

    /**
     * Subcommand constructor.
     *
     * @param plugin Current instance of Plan
     */
    public ReloadCommand(Plan plugin) {
        super("reload", CommandType.CONSOLE, Permissions.MANAGE.getPermission(), Phrase.CMD_USG_RELOAD + "");

        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(ISender sender, String commandLabel, String[] args) {
        plugin.onDisable();
        plugin.reloadConfig();
        plugin.onEnable();
        sender.sendMessage(Phrase.RELOAD_COMPLETE + "");
        return true;
    }

}
