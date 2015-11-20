package TextGame;

public class LocHandlers {

	private static int ftDonations = 0;
	private static int ftRewards = 0;
	private static int brotherQuest = 0;
	public static Character search(Character player, Items items){
		if (brotherQuest == 0 && player.getCurrentLocation().equals(Locations.forestTempleBasement)){
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
				player.setBoss(0);
				player = player.combat(items);
				if (player.getWin()){
					brotherQuest = 2;
					brotherQuest2RoundUp(player);
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
		} else if (brotherQuest == 1 && player.getCurrentLocation().equals(Locations.forestTempleBasement)){
			System.out.println("The hellhound charges you with a roar. A flame rushing at you from the darkness.");
			player.setBoss(0);
			player = player.combat(items);
			if (player.getWin()){
				brotherQuest = 2;
				System.out.println("As he crawls to his feet, all menace is gone from his appearance. \nYes, he is still the hellhound, but he's cute and cuddly, not menacing. \nHellhound: You saved me. Let's get out of here.\nThe hellhound leads you out of the temple. Hellhound: you really saved me back there. I wish I could repay you, but I don't have anything.");
				player.setCurrentLocation(Locations.forestTempleEntrance);
				Locations.forest.setLocDescription ("It looks bright and green and full of life.\nYou hear leaves rustle on the breeze.\nThere are passageways deeper into the forest, maybe wild trails. A trail of burned leaves and ash leads due South.");
				Locations.forest.addExit(Exit.south, Locations.abandonedShelter);
				System.out.println( player.getCurrentLocation().getDescription());
				player.getCurrentLocation().printOptions();
			}
		} else{
			System.out.println("You find nothing of value.");
		}
		return player;
	}
	private static void brotherQuest2RoundUp(Character player) {
		System.out.println("As he crawls to his feet, all menace is gone from his appearance. \nYes, he is still the hellhound, but he's cute and cuddly, not menacing. \nHellhound: You saved me. Let's get out of here.\nThe hellhound leads you out of the temple. Hellhound: you really saved me back there. I wish I could repay you, but I don't have anything.");
		player.setCurrentLocation(Locations.forestTempleEntrance);
		Locations.forest.setLocDescription ("It looks bright and green and full of life.\nYou hear leaves rustle on the breeze.\nThere are passageways deeper into the forest, maybe wild trails. A trail of burned leaves and ash leads due South.");
		Locations.forest.addExit(Exit.south, Locations.abandonedShelter);
		System.out.println( player.getCurrentLocation().getDescription());
		player.getCurrentLocation().printOptions();
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
		if (player.getCurrentLocation().isNPC(Locations.Ice)){
			player = NPCHandlers.talkToIce(player);
		} else if (player.getCurrentLocation().isNPC(Locations.guardDog)){
			player = NPCHandlers.talkToGuardDog(player, items);
		} else if (player.getCurrentLocation().isNPC(Locations.Coon)){
			player = NPCHandlers.talkToCoon(player, items);
		} else if (player.getCurrentLocation().isNPC(Locations.IceUnknown)){
			NPCHandlers.talkToIceUnknown();
		} else if (player.getCurrentLocation().isNPC(Locations.realestateShark)){
			player = NPCHandlers.talkToShark(player);
		} else if (player.getCurrentLocation().isNPC(Locations.blacksmith)){
			player = NPCHandlers.talkToBlacksmith(player, items);
		} else if (player.getCurrentLocation().isNPC(Locations.Luka)){
			player = NPCHandlers.talkToLuka(player, items);
		} else if (player.getCurrentLocation().isNPC(Locations.kindHellhound)){
			player = NPCHandlers.talkToHellhound(player);
		} else if (player.getCurrentLocation().isNPC(Locations.Jake)){
			player = NPCHandlers.talkToJake(player, items);
		} else if (player.getCurrentLocation().isNPC(Locations.guardCat)){
			player = NPCHandlers.talkToGuardCat(player, items);
		} else if (player.getCurrentLocation().isNPC(Locations.salesCow)){
			player = NPCHandlers.talkToSalesCow(player, items);
		} else if (player.getCurrentLocation().isNPC(Locations.farmer)){
			player = NPCHandlers.talkToFarmer(player, items);
		}
		return player;
	}
	public static Character look(Character player){
		if (player.getCurrentLocation().hasNPC()){
		System.out.println(player.getCurrentLocation().getNPC().getDescription());
		} else if (player.getCurrentLocation() == Locations.forestTempleMain){
			player = LocHandlers.setFTDonations(player);
		}
		return player;
	}
	public static Character make(Character player){
	
		if(player.getCurrentLocation().equals(Locations.vacantHome)){
		System.out.println("Changed Base to Village Home. Inhabiting NPCs Migrated to your new base.");
	player.setBase(Locations.livingRoom);
	Locations.vacantHome.setLocName("Your front yard.");
	Locations.vacantHome.setLocDescription("Welcome home. You have a small pool in your front yard, a tree, and a lot of grass.");
	Locations.vacantHome.addExit(Exit.in, Locations.livingRoom);
	
	if (Locations.beach.hasNPC()){
		Locations.beach.removeNPC();
		Locations.IceRoom.addNPC(Locations.Ice);
		Locations.livingRoom.addExit(Exit.north, Locations.IceRoom);
	}
	}else{ 
		System.out.println("You cannot make a base of this location.");
	}
	return player;
	}
	public static Character open(Character player){
		for (Key key : player.getInventory().getKeychain()){
			if (player.getCurrentLocation().equals(key.getLocation())){
					System.out.println("You used the key. the door opened.");
					player.getInventory().items.remove(key);
					player.getInventory().getKeychain().remove(key);
					key.getLocation().addExit(Exit.in, key.getDestination());
					return player;
			}
		} 
		System.out.println("The lock won't budge.");
		return player;
	}
}