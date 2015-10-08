package TextGame;

import java.util.Enumeration;

public class LocHandlers {

	private static int ftDonations = 0;
	private static int ftRewards = 0;
	private static int brotherQuest = 0;
	public static Character search(Character player, Items items){
		if (brotherQuest == 0 && player.getCurrentLocation().equals(Locations.l14)){
			System.out.println("Five people in black robes, stand equally spaced in a circle. \nIn the middle sits a teenage German shepherd chained to the ground.\nThe boy looks at you in panic, as the hooded men start chanting.");
			System.out.println("Do you move to HELP him, or LEAVE?");
			String choice = "";
			while (choice == ""){
			choice = Input.getInput();
			switch (choice){
			case "h":
			case "help":
				System.out.println("As you approach the circle, smoke starts rising from it.\nWhen it clears, the five hooded men lay crumpled on the floor. \nIn the middle of the circle, stands a canine, sure, but this one is no longer chained. \nHe is nude now, twice as tall as the teen was, his hair flaming, in a trail down his back all the way to the tail. \nIt's a hellhound, and he seems angry. \nHellhound: Time for you to die!");
				brotherQuest = 1;
				player.setEnemy(Locations.l1.getCreatures().get(0));
				player = Combat.combat(player, items);
				if (player.getWin()){
					brotherQuest = 2;
					System.out.println("As he crawls to his feet, all menace is gone from his appearance. \nYes, he is still the hellhound, but he's cute and cuddly, not menacing. \nHellhound: You saved me. Let's get out of here.\nThe hellhound leads you out of the temple. Hellhound: you really saved me back there. I wish I could repay you, but I don't have anything.");
					player.setCurrentLocation(Locations.l7);
					Locations.l3.setLocDescription ("It looks bright and green and full of life.\nYou hear leaves rustle on the breeze.\nThere are passageways deeper into the forest, maybe wild trails. A trail of burned leaves and ash leads due South.");
					Locations.l3.addExit(new Exit(Exit.south, Locations.l15));
					System.out.println( player.getCurrentLocation().getDescription());

					// Show available exits
					System.out.println( "\nAvailable exits :" );
					for (Enumeration<Exit> e = player.getCurrentLocation().getExits().elements(); e.hasMoreElements();)
					{
						Exit an_exit = (Exit) e.nextElement();
						System.out.println(an_exit);
					}
						if (player.getCurrentLocation().getNPCs().size() != 0){
						System.out.println("You see " + player.getCurrentLocation().getNPCs().get(0).getName());
						System.out.println("You can LOOK or TALK");
						}
				}
				break;
			case "l":
			case "leave":
				System.out.println("You choose to turn around and forget.");
			default: 
				System.out.println("choice not understood.");
				choice = "";
			}
			}
		} else if (brotherQuest == 1 && player.getCurrentLocation().equals(Locations.l14)){
			System.out.println("The hellhound charges you with a roar. A flame rushing at you from the darkness.");
			player.setEnemy(Locations.l1.getCreatures().get(0));
			player = Combat.combat(player, items);
			if (player.getWin()){
				brotherQuest = 2;
				System.out.println("As he crawls to his feet, all menace is gone from his appearance. \nYes, he is still the hellhound, but he's cute and cuddly, not menacing. \nHellhound: You saved me. Let's get out of here.\nThe hellhound leads you out of the temple. Hellhound: you really saved me back there. I wish I could repay you, but I don't have anything.");
				player.setCurrentLocation(Locations.l7);
				Locations.l3.setLocDescription ("It looks bright and green and full of life.\nYou hear leaves rustle on the breeze.\nThere are passageways deeper into the forest, maybe wild trails. A trail of burned leaves and ash leads due South.");
				Locations.l3.addExit(new Exit(Exit.south, Locations.l15));
				System.out.println( player.getCurrentLocation().getDescription());

				// Show available exits
				System.out.println( "\nAvailable exits :" );
				for (Enumeration<Exit> e = player.getCurrentLocation().getExits().elements(); e.hasMoreElements();)
				{
					Exit an_exit = (Exit) e.nextElement();
					System.out.println(an_exit);
				}
					if (player.getCurrentLocation().getNPCs().size() != 0){
					System.out.println("You see " + player.getCurrentLocation().getNPCs().get(0).getName());
					System.out.println("You can LOOK or TALK");
					}
			}
		} else{
			System.out.println("You find nothing of value.");
		}
		return player;
	}
	public static Character setFTDonations(Character player){
		System.out.println("You stand in front of the offer block. There is a slot in the middle to prevent people from retrieving offers given. Will you donate?");
		System.out.println("Yes or No?");
		boolean choice = Input.yesNo(player);
		if (choice){
			System.out.println("How much?");
			int value = Input.getInteger();
			ftDonations = ftDonations + value;
			player.setGold(-value);
			if (ftRewards == 0){
				if (ftDonations > 1000){
					ftRewards = 1;
					
				}
			}
		}else{
			System.out.println("You choose not to donate.");
		}
		return player;
	}
	public int getFTDonations(){
		return ftDonations;
	}
	public static int getBrotherQuest(){
		return brotherQuest;
	}
	public static void setBrotherQuest(int value){
		brotherQuest = value;
	}
	public static Character talk(Character player, Items items){
		if (player.getCurrentLocation().getNPCs().contains(Locations.Ice)){
			player = NPCHandlers.talkToIce(player);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.guardDog)){
			player = NPCHandlers.talkToGuardDog(player, items);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.Coon)){
			player = NPCHandlers.talkToCoon(player, items);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.IceUnknown)){
			NPCHandlers.talkToIceUnknown();
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.realestateShark)){
			player = NPCHandlers.talkToShark(player);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.blacksmith)){
			player = NPCHandlers.talkToBlacksmith(player, items);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.Luka)){
			player = NPCHandlers.talkToLuka(player, items);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.kindHellhound)){
			player = NPCHandlers.talkToHellhound(player);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.Jake)){
			player = NPCHandlers.talkToJake(player, items);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.guardCat)){
			player = NPCHandlers.talkToGuardCat(player, items);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.salesCow)){
			player = NPCHandlers.talkToSalesCow(player, items);
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.farmer)){
			player = NPCHandlers.talkToFarmer(player, items);
		}
		return player;
	}
	public static Character look(Character player){
		if (player.getCurrentLocation().getNPCs().contains(Locations.Ice)){
		System.out.println(Locations.Ice.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.guardDog)){
			System.out.println(Locations.guardDog.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.Coon)){
			System.out.println(Locations.Coon.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.IceUnknown)){
			System.out.println(Locations.IceUnknown.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.blacksmith)){
			System.out.println(Locations.blacksmith.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.realestateShark)){
			System.out.println(Locations.realestateShark.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.Luka)){
			System.out.println(Locations.Luka.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.kindHellhound)){
			System.out.println(Locations.kindHellhound.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.Jake)){
			System.out.println(Locations.Jake.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.guardCat)){
			System.out.println(Locations.guardCat.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.salesCow)){
			System.out.println(Locations.salesCow.getDescription());
		} else if (player.getCurrentLocation().getNPCs().contains(Locations.farmer)){
			System.out.println(Locations.farmer.getDescription());
		} else if (player.getCurrentLocation() == Locations.l13){
			player = LocHandlers.setFTDonations(player);
		}
		return player;
	}
	public static Character make(Character player){
	
		if(player.getCurrentLocation().equals(Locations.l10)){
		System.out.println("Changed Base to Village Home. Inhabiting NPCs Migrated to your new base.");
	player.setBase(Locations.l11);
	Locations.l10.setLocName("Your front yard.");
	Locations.l10.setLocDescription("Welcome home. You have a small pool in your front yard, a tree, and a lot of grass.");
	Locations.l10.addExit(new Exit(Exit.in, Locations.l11));
	
	if (Locations.l1.getNPCs().contains(Locations.Ice)){
		Locations.l1.getNPCs().remove(Locations.Ice);
		Locations.l12.getNPCs().add(Locations.Ice);
		Locations.l11.addExit(new Exit(Exit.north, Locations.l12));
	}
	}else{ 
		System.out.println("You cannot make a base of this location.");
	}
	return player;
	}
	public static Character open(Character player, Items items){
		if (player.getCurrentLocation().equals(Locations.l24)){
			if (player.getInventory().contains(items.items.get(14))){
				System.out.println("You used the key. the door opened.");
				player.getInventory().remove(items.items.get(14));
				Locations.l24.addExit(new Exit (Exit.in, Locations.l26));
			}else{
				System.out.println("the door remains locked, and you don\'t wanna kick it in \nright next to the farmer. Better luck with the key.");
			}
		} else {
			System.out.println("Nothing to open here.");
		}
		return player;
	}
	public static Character buyShop (Character player, Item[] forSale){
		for (int i = 0; i< forSale.length; i++){
			System.out.println(forSale[i].getName() + "\t" + forSale[i].getValue());
		}
		String choice = Input.getInput();
		for (int i = 0; i< forSale.length; i++){
			if (choice == forSale[i].getName()){
				if (player.getGold() >= forSale[i].getValue()){
					player.setGold(player.getGold()-forSale[i].getValue());
					player.addItem(forSale[i]);
					System.out.println("You bought the " + forSale[i].getName());
				} else {
					System.out.println("You don\'t have that kind of money.");
				}
			} else { 
				System.out.println("Sorry, I don\'t have that.");
			}
		}
		return player;
	}
}