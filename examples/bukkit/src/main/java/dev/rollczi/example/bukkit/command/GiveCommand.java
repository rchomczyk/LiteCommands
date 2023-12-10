package dev.rollczi.example.bukkit.command;

import dev.rollczi.litecommands.annotations.argument.Arg;
import dev.rollczi.litecommands.annotations.command.Command;
import dev.rollczi.litecommands.annotations.execute.Execute;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Command(name = "give")
public class GiveCommand {

    @Execute
    void give(@Arg Player target, @Arg Material type, @Arg int amount) {
        target.getInventory().addItem(new ItemStack(type, amount));
    }

}
