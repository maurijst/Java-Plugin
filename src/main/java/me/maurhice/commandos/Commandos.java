package me.maurhice.commandos;

import me.maurhice.commandos.utils.Utils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public final class Commandos extends JavaPlugin {
    private File CommandosConfigFile;
    private FileConfiguration CommandosConfig;



    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        Knight itemRecipe = new Knight();
        itemRecipe.customRecipe();
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);
        getServer().getPluginManager().registerEvents(new DeathEvent(),this);
        getServer().getPluginManager().registerEvents(new RightClick(),this);
        getServer().getPluginManager().registerEvents(new JoinEvent(),this);
        getServer().getPluginManager().registerEvents(new CraftEvent(), this);
        CreateCommandosConfig();














    }
    public FileConfiguration getCommandosConfig() {
        return this.CommandosConfig;
    }
    private void CreateCommandosConfig() {

        {
            CommandosConfigFile = new File(getDataFolder(), "Commandos.yml");
            if (!CommandosConfigFile.exists()) {
                CommandosConfigFile.getParentFile().mkdirs();
                this.getConfig().addDefault("prefix", "&8[&5Test&8]&r");
                this.getConfig().options().copyDefaults(true);
                this.saveConfig();
            }
            saveResource("Commandos.yml", false);

            try {
                CommandosConfig.load(CommandosConfigFile);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            }
        }
    }






    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.saveConfig();
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("Friet")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.YELLOW + "Het is Patat bamibal!");
            } else {
                System.out.println("Je moet een mooiboy zijn om dat commando uit te voeren");


            }
        }
        if (command.getName().equals("Patat")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.YELLOW + "Je bent een goede kerel!");
            } else {
                System.out.println("Je moet een mooiboy zijn om dat commando uit te voeren");
            }

        }

        if (command.getName().equals("Menu")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                Inventory gui = Bukkit.createInventory(player, 54, ChatColor.DARK_AQUA + "Commands GUI");

                ItemStack Spawn = new ItemStack(Material.TNT);
                ItemStack Feed = new ItemStack(Material.PUMPKIN_PIE);
                ItemStack Fly = new ItemStack(Material.FEATHER);
                ItemStack Ya = new ItemStack(Material.BEACON);
                ItemStack Ya1 = new ItemStack(Material.AIR);
                ItemStack Ya2 = new ItemStack(Material.GHAST_TEAR);
                ItemStack Ya3 = new ItemStack(Material.DOUBLE_PLANT );
                ItemStack Ya4 = new ItemStack(Material.GOLDEN_APPLE);
                ItemStack Ya5 = new ItemStack(Material.SKULL_ITEM,1,(short) 3);
                ItemStack Ya6 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemStack Ya7 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemStack Ya9 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemStack Ya10 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                ItemStack Ya11 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                ItemStack Ya12 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
                ItemStack Ya13 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemStack Ya14 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemStack Ya15 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);

                ItemMeta Spawn_meta = Spawn.getItemMeta();
                Spawn_meta.setDisplayName(ChatColor.DARK_GRAY + "Suicide");
                ArrayList<String> Spawn_lore = new ArrayList<>();
                Spawn_lore.add(ChatColor.LIGHT_PURPLE + "Go to the spawn");
                Spawn.setItemMeta(Spawn_meta);

                ItemMeta Feed_meta = Feed.getItemMeta();
                Feed_meta.setDisplayName(ChatColor.DARK_GREEN + "Feed");
                ArrayList<String> Feed_lore = new ArrayList<>();
                Feed_lore.add(ChatColor.LIGHT_PURPLE + "Feed yourself");
                Feed.setItemMeta(Feed_meta);

                ItemMeta Fly_meta = Fly.getItemMeta();
                Fly_meta.setDisplayName(ChatColor.AQUA + "Vliegtuigmodus");
                ArrayList<String> Fly_lore = new ArrayList<>();
                Fly_lore.add(ChatColor.LIGHT_PURPLE + "Turn on Flight");
                Fly_meta.setLore(Fly_lore);
                Fly.setItemMeta(Fly_meta);

                ItemMeta Ya_meta = Ya.getItemMeta();
                Ya_meta.setDisplayName(ChatColor.GOLD + "Glow");
                ArrayList<String> Ya_lore = new ArrayList<>();
                Ya_lore.add(ChatColor.WHITE + "Enables Glow effect");
                Ya.setItemMeta(Ya_meta);

                ItemMeta Ya2_Meta = Ya2.getItemMeta();
                Ya2_Meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Vanish");
                Ya2.setItemMeta(Ya2_Meta);

                ItemMeta Ya3_Meta = Ya3.getItemMeta();
                Ya3_Meta.setDisplayName(ChatColor.BLUE + "Verandert de tijd naar dag");
                Ya3.setItemMeta(Ya3_Meta);

                ItemMeta Ya4_Meta = Ya4.getItemMeta();
                Ya4_Meta.setDisplayName(ChatColor.BLUE + "Peaceful");
                Ya4.setItemMeta(Ya4_Meta);

                SkullMeta Ya5Meta = (SkullMeta) Ya5.getItemMeta();
                Ya5Meta.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString(String.valueOf(player.getUniqueId()))));
                Ya5Meta.setDisplayName(ChatColor.GOLD + "" + player.getName());
                ArrayList<String> Ya5_lore = new ArrayList<String>();
                Ya5_lore.add(ChatColor.DARK_PURPLE + "Health:" + ChatColor.YELLOW + " " + player.getHealth());
                Ya5_lore.add(ChatColor.DARK_PURPLE + "Level:" + " " + ChatColor.YELLOW + player.getLevel());
                Ya5_lore.add(ChatColor.DARK_PURPLE + "Exp to level-up:" + " " + ChatColor.YELLOW + player.getExpToLevel());
                Ya5_lore.add(ChatColor.DARK_PURPLE + "Food:" + " " + ChatColor.YELLOW + " " + player.getSaturation());
                Ya5Meta.setLore(Ya5_lore);
                Ya5.setItemMeta(Ya5Meta);



                ItemStack[] menu_items = {Ya6, Ya7, Ya9, Ya10, Ya11, Ya12, Ya13, Ya14, Ya15,Ya1, Ya1,Ya1, Ya1,Ya1, Ya1,Ya1, Ya1, Ya1, Ya1, Ya2, Ya1, Spawn, Ya1, Feed, Ya1, Ya5, Ya1, Ya1, Ya3, Ya1, Ya, Ya1, Fly, Ya1, Ya4, Ya1, Ya1, Ya1, Ya1, Ya1, Ya1, Ya1, Ya1, Ya1, Ya1, Ya6, Ya7, Ya9, Ya10, Ya11, Ya12, Ya13, Ya14, Ya15};
                gui.setContents(menu_items);
                player.openInventory(gui);
            }


        }
        if (command.getName().equals("Tab")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                Inventory kleur = Bukkit.createInventory(player, 45, ChatColor.GOLD + "Tab Kleur");
                ItemStack Roze = new ItemStack(Material.PINK_SHULKER_BOX);
                ItemStack Blue = new ItemStack(Material.BLUE_SHULKER_BOX);
                ItemStack Aqua = new ItemStack(Material.LIGHT_BLUE_SHULKER_BOX);
                ItemStack Rood = new ItemStack(Material.RED_SHULKER_BOX);
                ItemStack Geel = new ItemStack(Material.YELLOW_SHULKER_BOX);
                ItemStack Groen = new ItemStack(Material.LIME_SHULKER_BOX);
                ItemStack Wit = new ItemStack(Material.WHITE_SHULKER_BOX);
                ItemStack Geen = new ItemStack(Material.AIR);
                ItemStack Eind = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
                ItemStack Eind1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
                ItemStack Eind2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);

                ItemMeta Roze_meta = Roze.getItemMeta();
                Roze_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Roze");
                Roze.setItemMeta(Roze_meta);

                ItemMeta Blue_meta = Blue.getItemMeta();
                Blue_meta.setDisplayName(ChatColor.BLUE + "Blauw");
                Blue.setItemMeta(Blue_meta);

                ItemMeta Aqua_meta = Aqua.getItemMeta();
                Aqua_meta.setDisplayName(ChatColor.AQUA + "Aqua");
                Aqua.setItemMeta(Aqua_meta);

                ItemMeta Rood_meta = Rood.getItemMeta();
                Rood_meta.setDisplayName(ChatColor.RED + "Rood");
                Rood.setItemMeta(Rood_meta);

                ItemMeta Geel_meta = Geel.getItemMeta();
                Geel_meta.setDisplayName(ChatColor.YELLOW + "Geel");
                Geel.setItemMeta(Geel_meta);

                ItemMeta Groen_meta = Groen.getItemMeta();
                Groen_meta.setDisplayName(ChatColor.GREEN + "Groen");
                Groen.setItemMeta(Groen_meta);

                ItemMeta Wit_meta = Wit.getItemMeta();
                Wit_meta.setDisplayName(ChatColor.WHITE + "Reset");
                Wit.setItemMeta(Wit_meta);






                ItemStack[] kleur_items = {Eind, Eind, Eind, Eind2, Eind1, Eind2, Eind, Eind, Eind,Geen,Geen,Geen,Geen,Geen,Geen,Geen,Geen, Geen, Roze, Blue, Aqua, Rood, Geel, Groen, Geen, Geen, Wit, Geen, Geen, Geen, Geen, Geen, Geen, Geen, Geen, Geen,  Eind, Eind, Eind, Eind2, Eind1, Eind2, Eind, Eind, Eind};
                kleur.setContents(kleur_items);
                player.openInventory(kleur);


            }
        }

            if (command.getName().equalsIgnoreCase("Kick")) {
               Player player = (Player) sender;
                if (sender.isOp()) {
                    List<String> arguments = new ArrayList<String>(Arrays.asList(args));
                    String playername = arguments.get(0);
                    arguments.remove(0);
                    String message = String.join("  ", arguments);
                    int length = args.length;

                    if (length >= 2) {
                        Player target = Bukkit.getPlayerExact(playername);
                        if (target instanceof Player) {
                            target.kickPlayer(Utils.chat("&6&l[Helaas]" + "" + "\n" + "&fReden:" + "  " + message + "\n" + "&fDoor:" + "" + player.getName()));
                        } else {
                            player.sendMessage(Utils.chat("Speler is niet online"));

                        }
                    } else {
                        player.sendMessage(Utils.chat( "&5/kick [speler] [reden]&5!"));
                    }
                } else {
                    player.sendMessage(ChatColor.GOLD + "Geen permissies");
                }

            }
            if (command.getName().equalsIgnoreCase("Prefix")) {
                Player player = (Player) sender;
                if (sender.isOp()) {
                    List<String> arguments = new ArrayList<String>(Arrays.asList(args));
                    String Naam = arguments.get(0);
                    arguments.remove(0);
                    String prefix = String.join("  ", arguments);
                    int length = args.length;

                    if (length > 1) {
                        Player target = Bukkit.getPlayerExact(Naam);
                        if (target instanceof Player) {
                            target.setPlayerListName(Utils.chat(prefix + " " + Naam));
                            player.sendMessage(Utils.chat("&6Prefix is aangepast"));
                            String playerprefix = player.getName() + ":" + "\n" + "prefix:" + "\n" + "'" + prefix + "'" + "\n";
                            this.getConfig().set(playerprefix,true);
                        } else {
                            player.sendMessage(Utils.chat( "&eDeze speler is niet online"));
                        }
                    } else {
                        player.sendMessage(ChatColor.AQUA + "/Prefix [speler] [prefix]");
                    }
                } else {
                    player.sendMessage(ChatColor.BLUE + "Geen permissies voor dit command");
                }

            }
            if (command.getName().equalsIgnoreCase("Ban")) {
                Player player = (Player) sender;
                List<String> arguments = new ArrayList<String>(Arrays.asList(args));
                String Banned = arguments.get(0);
                arguments.remove(0);
                String reden = String.join(" ", arguments);

                int length = args.length;
                if (sender.isOp()) {
                    if (length > 1) {
                        Player target = Bukkit.getPlayerExact(Banned);
                        if (target instanceof Player) {
                            target.kickPlayer(Utils.chat("&8[&4&lBouncer&8]" + "\n" + "&cReden:&f" + " " + reden + "\n" + "&cDoor:&f" + "" + player.getName()));
                            player.sendMessage(ChatColor.DARK_RED + "Speler verbannen");
                            this.getConfig().set("target" + reden + "Is Banned", Boolean.valueOf(true));
                            this.getConfig().set("players." + Banned + ".reason", arguments);
                            this.getConfig().set("players." + Banned + ".by", sender.getName());
                            saveConfig();

                        }
                    }

                } else {
                    player.sendMessage(ChatColor.GOLD + "Helaas jij kan geen mensen verbannen");
                }
            }
            if(command.getName().equalsIgnoreCase("craft")){
                Player player = (Player) sender;
                Inventory Craften = Bukkit.createInventory(player, InventoryType.WORKBENCH, ChatColor.GOLD + "Crafting Table");

                player.sendMessage(ChatColor.AQUA + "Crafting table geopend!");
                player.openInventory(Craften);
            }
        if(command.getName().equalsIgnoreCase("Health")){
            Player player = (Player) sender;

            List<String> arguments = new ArrayList<String>(Arrays.asList(args));
            String speler = arguments.get(0);
            arguments.remove(0);
            String Levens = String.join(" ", arguments);

            int length = args.length;
            if(length > 1){
                Player target = Bukkit.getPlayerExact(speler);
                if(target instanceof Player){
                    target.setHealthScale(Double.parseDouble(Levens));
                }
            }
        }
        if(command.getName().equalsIgnoreCase("Tikkertje")){
     List<String> arguments = new ArrayList<String>((Arrays.asList(args)));
        String Tikker = arguments.get(0);
        arguments.remove(0);
        String  Renners = String.join(" ", Tikker);

    int length = args.length;
    if(length > 1){
        Player target = Bukkit.getPlayerExact(Tikker);
        Player targets = Bukkit.getPlayerExact(Renners);

        if(target instanceof Player){
            if(target.getName().equalsIgnoreCase(Tikker)) {
                target.setDisplayName(Utils.chat("&4[Tikker]&r" + " " + target.getName()));
                target.setGlowing(true);
                target.sendMessage(Utils.chat("&4[Tikkertje]" + " " + "&fJij bent de tikker!"));
                target.getInventory().setHelmet(new ItemStack(Material.SLIME_BLOCK,1));
                target.getInventory().setItemInMainHand(new ItemStack(Material.SLIME_BALL,1));




                }else{
                    target.setExp(0);

                }
            }else {
                targets.setDisplayName(Utils.chat("&6[Renner]" + " " + targets.getName()));
                targets.setGlowing(false);
                targets.sendMessage(Utils.chat("&4[Tikkertje]" + " " + "&fRen nu het nog kan!"));
                targets.getInventory().setHelmet(new ItemStack(Material.AIR,1));

        }

            }


            }

        if(command.getName().equalsIgnoreCase("Quit")) {
            Player player = (Player) sender;
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target.isGlowing() == true) {
                target.setGlowing(false);
                target.sendMessage(Utils.chat("&4[Tikkertje]" + " " + "&fTikspel gestopt!"));
                target.setPlayerListName(Utils.chat(target.getName()));
                target.getInventory().setHelmet(new ItemStack(Material.AIR));
                target.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
            } else {
                target.setGlowing(false);
                target.sendMessage(Utils.chat("&4[Tikkertje]" + " " + "&fTikspel gestopt!"));
                target.setPlayerListName(Utils.chat(target.getName()));
            }
        }
        if (command.getName().equals("Kit")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                Inventory kit = Bukkit.createInventory(player, 27, ChatColor.DARK_BLUE + "Kits");
                ItemStack Tank = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemStack Warrior = new ItemStack(Material.IRON_SWORD);
                ItemStack Bard = new ItemStack(Material.GOLD_CHESTPLATE);
                ItemStack King = new ItemStack(Material.GOLD_HELMET);
                ItemStack Vul = new ItemStack(Material.STAINED_GLASS_PANE,1,(short) 3 );
                ItemStack Vul1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short) 9);
                ItemStack Vul2 = new ItemStack(Material.STAINED_GLASS_PANE,1);
                ItemStack Vul3 = new ItemStack(Material.AIR);

                ItemMeta Tank_meta = Tank.getItemMeta();
                Tank_meta.setDisplayName(ChatColor.BLUE + "Tank Kit");
                Tank.setItemMeta(Tank_meta);

                ItemMeta Warrior_meta = Warrior.getItemMeta();
                Warrior_meta.setDisplayName(Utils.chat("&9Warrior &bKit"));
                Warrior.setItemMeta(Warrior_meta);

                ItemMeta Bard_meta = Bard.getItemMeta();
                Bard_meta.setDisplayName(Utils.chat("&3Bard &fKit!"));
                Bard.setItemMeta(Bard_meta);

                ItemMeta King_meta = King.getItemMeta();
                King_meta.setDisplayName(Utils.chat("&6King &fKit"));
                King.setItemMeta(King_meta);



                ItemStack[] Kit_items = {Vul1,Vul1,Vul1,Vul,Vul2,Vul,Vul1,Vul1,Vul1,Tank, Warrior, Bard, King,Vul3,Vul3,Vul3,Vul3,Vul3,Vul1,Vul1,Vul1,Vul,Vul2,Vul,Vul1,Vul1,Vul1};
                kit.setContents(Kit_items);
                player.openInventory(kit);

            }
        }
        if(command.getName().equalsIgnoreCase("Selector")){
            if(sender instanceof Player){
                Player p = (Player) sender;
                p.getInventory().setItemInMainHand(new ItemStack(Material.NETHER_STAR,1));
                ItemMeta Selector_meta = p.getInventory().getItemInMainHand().getItemMeta();
                Selector_meta.setDisplayName(ChatColor.GOLD + "Selector");
                p.getInventory().getItemInMainHand().setItemMeta(Selector_meta);

            }

        }
        if(command.getName().equalsIgnoreCase("CraftMenu")) {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                p.getInventory().setItemInMainHand(new ItemStack(Material.PAPER, 1));
                ItemMeta Crafter_meta = p.getInventory().getItemInMainHand().getItemMeta();
                Crafter_meta.setDisplayName(ChatColor.GOLD + "Craft Menu");
                p.getInventory().getItemInMainHand().setItemMeta(Crafter_meta);
            }
        }







            return false;

        }


    }






