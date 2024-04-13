package me.hans.mailsender;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Arrays;

public class MailCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can execute this command!");
            return false;
        }

        Player player = (Player) sender;

        // Check if the command has enough arguments
        if (args.length < 3) {
            player.sendMessage("Usage: /mail <target> <subject> <text>");
            return false;
        }

        String target = args[0]; // Email address of the target
        String subject = args[1]; // Subject of the email
        String text = String.join(" ", Arrays.copyOfRange(args, 2, args.length)); // Combine the remaining arguments into the email body

        // Send the email using MailService
        String result = MailService.sendMail(target, subject, text);

        // Optionally, you can send a confirmation message to the player
        player.sendMessage("Email sent to " + target + ": " + result);

        return true;
    }
}
