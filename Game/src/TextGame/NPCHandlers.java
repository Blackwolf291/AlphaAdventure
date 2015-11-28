package TextGame;

public class NPCHandlers {
	static int IceCounter = 0;
	static int IceSpellCounter = 0;
	static boolean helpQuest = false;
	public static Character talkToShark(Character player){
		System.out.println("Shark: " + Locations.realestateShark.getTalkTo());
		System.out.println("Shark: This beautiful little home can be yours for only 10.000 gold. Interrested?");
		System.out.println("Yes or No");
		if (Input.convertYesNoToBoolean()){
			if (player.getGold() >= 10000)
			System.out.println("Shark: She's all yours pall.");
			Locations.vacantHome.removeNPC();
			System.out.println("Set the village home as your base?");
			if (Input.convertYesNoToBoolean()){
				setVacantHomeBase(player);
			}else{
				System.out.println("The vacant home remains vacant.");
				Locations.vacantHome.setLocDescription("It looks cozy and not very big, but I'll be a lot warmer than the beach, and a lot more comfortable too. \n There is a small pond in the front yard. You can MOVE in.");
			}
		}else{
			System.out.println("Maybe some other time then.");
		}
		return player;
	}
	public static void setVacantHomeBase(Character player){
		System.out.println("Changed Base to Village Home. Inhabiting NPCs Migrated to your new base.");
		Location oldBase = player.getBase();
		player.setBase(Locations.livingRoom);
		Locations.vacantHome.setLocName("Your front yard.");
		Locations.vacantHome.setLocDescription("Welcome home. You have a small pool in your front yard, a tree, and a lot of grass.");
		Locations.vacantHome.addExit(Exit.in, Locations.livingRoom);
		if (oldBase.isNPC(Locations.Ice)){
			oldBase.removeNPC();
			player.getBase().addExit(Exit.north, Locations.IceRoom);
		}
	}
	public static Character talkToBlacksmith(Character player, Items items){
		Item[] shopList = new Item[]{items.getItems().get(6),items.getItems().get(7),items.getItems().get(8),items.getItems().get(9),items.getItems().get(0)};
		Shop blacksmiths = new Shop(Locations.blacksmith, shopList, true, null);
		blacksmiths.runShop(player);
		return player;
	}
	public static Character talkToCoon(Character player, Items items){
		Item[] shopList = new Item[]{items.getItems().get(3),items.getItems().get(4),items.getItems().get(5),items.getItems().get(0)};
		Shop CoonsGeneralStore = new Shop(Locations.Coon, shopList, true, null);
		player = CoonsGeneralStore.runShop(player);
		return player;
	}
	
	
	
	
	public static Character talkToGuardDog(Character player, Items items) {
		if (LocHandlers.getBrotherQuest() == 2) {
			Locations.forestWestGate.addExit(Exit.east, Locations.forestVillage);
			Locations.forestWestGate.removeNPC();
			System.out.println("So you found my brother, how is he? \nThat's good to hear. \nMy name is Luka, welcome to the village.");
			Locations.forestWestGate.addNPC(Locations.Luka);
		} else if (helpQuest){
			System.out.println("The guard seems lonely. \n Guard: Did you find him? \n Oh... maybe next time?");
		} else {
		System.out.println("Guard: " + player.getCurrentLocation().getNPC().getTalkTo());
		System.out.println("You could try FIGHTing past him, TRICKing him, or CONvincing him to let you by.");
		String plan = Input.getInput();
		switch (plan) {
		case "fight":
			player.setBoss(1);
			player.combat(items);
			if (player.getWin()){
				Locations.forestWestGate.addExit(Exit.east, Locations.forestVillage);
				Locations.forestWestGate.removeNPC();
				System.out.println("Guard: You fight well for an outsider. Please be welcome in our village.");
				System.out.println("Guard; My name is Luka, nice to meet you.");
				Locations.forestWestGate.addNPC(Locations.Luka);
			}
			break;
		case "trick":
			int trickcounter = 0;
			if (player.think() + player.getLvl() + Input.dice(1,10) > 25 + 5 * trickcounter){
			System.out.println("The guard looks at you unbelievingly, but you manage to distract him long enough to sneak past him.");
			trickcounter++;
			player.setCurrentLocation(Locations.forestVillage);
			} else {
				System.out.println("He looks at you incredulously as you try convincing him to leave his post. \nGuard: Are you done yet?");
			}
			break;
		case "con":
			if (player.persuade() + player.getLvl() + Input.dice(1,10) >= 25){
				System.out.println("After a lot of talking, he relents, a little. \n guard: If you could do me a favor, I'll let you in. \n My little brother has gone to the Temple, but hasn't returned. Could you go investigate?"); 
				System.out.println("YES or NO.");
				if(Input.convertYesNoToBoolean()){
					System.out.println("You'll do it? Thanks.");
					helpQuest = true;
				}else{
					System.out.println("Maybe some other time then.");
				}
			}
			break;
		default:
			break;
		}
		}
		return player;
	}
	public static Character talkToIce(Character player) {
		System.out.println("Ice: " + Locations.Ice.getTalkTo());
		if(player.getCurrentLocation().equals(Locations.wreck)||player.getCurrentLocation().equals(Locations.beach)){
		if(!player.manaIsFull()){
			System.out.println("No, Heal, Ship");
		} else {
			System.out.println("No, Ship");
		}
		String reply = Input.getInput();
		switch (reply) {
		case "no":
			System.out.println("Ice: Maybe some other time then.");
			break;
		case "heal":
			if(!player.hpIsFull()){
				player.revive();
				System.out.println("A white glow envelops you.");
				System.out.println("Ice: There, all healed up.");
				if (IceCounter < 3) {
				++IceCounter;
				} else if (IceCounter == 3 && player.getBase() != player.getCurrentLocation()){
					System.out.println("Ice: Maybe it's time I moved out of this wreck.");
					System.out.println("Move Ice into your base?");
					if (Input.convertYesNoToBoolean()){
						Locations.wreck.removeNPC();
						if (player.getBase() == Locations.beach) {
							Locations.beach.addNPC(Locations.Ice);
						} else if (player.getBase() == Locations.livingRoom){
							Locations.IceRoom.addNPC(Locations.Ice);
							Locations.livingRoom.addExit(Exit.north, Locations.IceRoom);
						}
					} else {
						System.out.println("Ice: Maybe some other time");
					}
				}
			} else {
				System.out.println("Ice: Sorry, I can't waste my time on the healthy.");
			}
			break;
		case "ship":
			System.out.println("Ice: I was on a tropical cruise, hired as a medic but that's the price of a free trip. \nI had just retired to my quarters when a storm started to pick up. \nNext thing I know, I find myself here, still on my bed, but with the cabin gone.");
			break;
		default: 
			System.out.println("Ice: Sorry, I can't help you with that.");
		}
		} else if (player.getCurrentLocation().equals(Locations.IceRoom)){
			if(!player.hpIsFull()){
				System.out.println("No, Heal, Magic");
			} else {
				System.out.println("No, Magic");
			}
			String reply = Input.getInput();
			switch (reply) {
			case "no":
				System.out.println("Ice: Maybe some other time then.");
				break;
			case "heal":
				if(!player.hpIsFull()){
					player.revive();
					System.out.println("A white glow envelops you.");
					System.out.println("Ice: There, all healed up.");
				} else {
					System.out.println("Ice: Sorry, I can't waste my time on the healthy.");
				}
				break;
			case "Magic":
				System.out.println("Ice: So you're interrested in the white art of healing? I can teach you a spell or two, but it'll take time.");
				if (IceSpellCounter < 5){
					IceSpellCounter++;
					System.out.println("After hours of conversation and meditation, Ice taps you on the shoulder.\nIce: That's enough for today. Don't expect magic to just come to you, on the first try. \nIt'll come. Give it time.");
				} else if (IceSpellCounter == 5){
					IceSpellCounter++;
					System.out.println("After an hour of conversation and meditation, Ice interrupts you suddenly. \nIce: That's it... You found it. Look at your hands. \nYou try prying your eyes open without letting your focus slip, to find your hands are glowing. \nThe shock instantly disrupts your concentration, and the light fades.");
				} else if (IceSpellCounter == 6){
					IceSpellCounter++;
					System.out.println("Ice: Let\'s try getting you to a state where you can summon the magic and use it.\nIce: Today you learn the heal spell.");
					System.out.println("A few hours later you feel you can reliably cast Heal.");
					player.addSpell(Locations.minorHeal);
					System.out.println("You have learned Minor heal. \nYou can use Fireball in combat by typing \'fireball\' \nor cast the strongest fire spell you know by typing \'fire\'. \nFire spells cannot be used outside of battle.");
					
				}
				break;
			default: 
				System.out.println("Ice: Sorry, I can't help you with that.");
			}
		}
		return player;
	}
	public static void talkToIceUnknown() {
		System.out.println("Stranger: " + Locations.IceUnknown.getTalkTo());
		System.out.println("Stranger: I was a medic aboard the ship before the disaster. If you need it, I can heal you.");
		Locations.wreck.removeNPC();
		Locations.wreck.addNPC(Locations.Ice);
	}
	public static Character talkToLuka(Character player, Items items){
		System.out.println(Locations.Luka.getTalkTo());
		if (LocHandlers.getBrotherQuest() == 3){
			System.out.println("He\'s nearby? Why isn\'t he here? He\'s a WHAT? \nHellhound: I\'m gonna go see him, can you stand guard here for a bit? \nHellhound: Else, I\'m stuck here.");
			System.out.println("Sure! (yes) or Sorry... (no)");
			String help = "";
			while (help == ""){
				help = Input.getInput();
				switch (help){
				case "sure!":
				case "sure":
				case "yes":
				case "y":
					System.out.println("Luka: You will? Thank you so much. \n The big Shepherd \nLuka: I know the cabin. I\'ll be right back.");
					player.setBoss(2);
					player = player.combat(items);
					if (player.getWin()){
						System.out.println("Only a few minutes later, Luka walks back down the path, holding the paw of a hellhound. \nHe\'s not really looking anywhere but at the panicked looking hellhound.\nLuka: Easy Jake, it\'s not so bad. You're still my brother.\nLuka: I\'ll convince the village you\'re still you. And look " + player.getName() + " is here too. \nLuca: " + player.getName() + ", please, take him to my home." );
					Locations.forestVillage.addExit(Exit.north, Locations.lukasPlace);
					if (player.getBase() == Locations.livingRoom){
						System.out.println("Luka: It\'s right next to yours.");
					}else{
						System.out.println("Luka: It\'s right next to the vacant house.");
					}
					player.setCurrentLocation(Locations.lukasPlace);
					}
					Locations.forest.addCreature(Locations.extraLocation.chooseEnemy(2));
					break;
				case "sorry...":
				case "sorry":
				case "no":
				case "n":
					System.out.println ("Luka: Well, maybe next time... please tell him he can come by at any time.");
					LocHandlers.setBrotherQuest(4);
					break;
					default:
						System.out.println ("Sorry, what did you say?");
						help = "";
							
				}
			}	
		}else{
			System.out.println("Luka: hey, welcome back. Wanna go for a fight? \n YES, NO.");
			if (Input.convertYesNoToBoolean()){
				player.setBoss(1);
				player.combat(items);
				if (player.getWin()){
					System.out.println("It seems you are still the better warrior.");
				}
			}
		}
		return player;
	}
	public static Character talkToHellhound(Character player){
		if (player.getCurrentLocation() == Locations.abandonedShelter){
		if (LocHandlers.getBrotherQuest() == 4){
			System.out.println("Hellhound: You spoke to my brother? What did he say?");
			System.out.println("Tell him his brother wants him HOME, or that he should STAY away");
			String tell = "";
			while (tell == ""){
			tell = Input.getInput();
			switch (tell){
			case "home":
			case "h":
				System.out.println("Hellhound: Really? Luka said that? Well then, Luka, Jake is coming home!");
				Locations.abandonedShelter.removeNPC();
				Locations.forestVillage.addExit(Exit.north, Locations.lukasPlace);
				break;
			case "stay":
			case "s":
				System.out.println("Hellhound: I told you I was a monster. Well, I think I can live here.");
				break;
			default:
				System.out.println("Hellhound: Sorry, what did you say?");
				tell = "";
			}
			}
		}else{
			System.out.println("Hellhound: " + Locations.kindHellhound.getTalkTo());
		System.out.println("You wanna ask about his TRANSFORMATION, his BROTHER or WHY he is out here.");
		String ask = "";
		while (ask == ""){
		ask = Input.getInput();
		switch (ask){
		case "transformation":
		case "transform":
		case "trans":
		case "t":
			System.out.println("Hellhound: It\'s an abomination... You saw me before that cult changed me, \nHellhound: what do you think of my new look?");
			System.out.println("OKAY, SEXY, MONSTER");
			String tell = Input.getInput();
			switch (tell){
			case "okay":
			case "ok":
			case "o":
				System.out.println("Hellhound: Now you\'re just being nice to me. I know you don't mean it.");
				break;
			case "sexy":
			case "s":
				System.out.println("Hellhound: You... you mean it? That's the nicest thing you could have said. \nHellhound: I hope you mean it, cause then maybe there is still a chance for me.");
				break;
			case "monster":
			case "mon":
			case "m":
				System.out.println("Hellhound: Then you know why I should stay here. They would hunt me down if anyone ever saw me. \nHellhound: As you said, I'm a monster now.");
				break;
				default:
					System.out.println("Hellhound: I don't know what you just said, but it doesn't matter anyway. \nHellhound: I know what I am. That's why I should stay here \nHellhound: so that everyone will be safer.");
			}
			break;
		case "brother":
		case "bro":
		case "b":
			System.out.println("Hellhound: You know about my brother? He's a town guard in a village nearby. \nHellhound: If he saw a hellhound approach, he'd kill me without question.\nHellhound: Maybe you can have a talk with him for me some day.");
			LocHandlers.setBrotherQuest(3);
			break;
		case "why":
		case "w":
			System.out.println("Hellhound: Why I\'m here? Cause I can\'t go home, that\'s why! This is a place I used to come as a pup. \nHellhound: It\'s a bit of a safe haven.");
			break;
			default:
				System.out.println("Hellhound: Sorry, I don't know what you\'re talking about. Can you rephrase that?");
				ask = "";
		}
		}
		}
		}
		return player;
	}
	public static Character talkToJake(Character player, Items items) {
		System.out.println("Jake: " + Locations.Jake.getTalkTo());
		System.out.println("Jake: I can never repay you enough for all you have done. \nJake: Maybe I can do something for you in return. \nJake: I\'ve been practicing with fire, and I think I can teach you FIREBALL. \nJake: Would you like that?");
		System.out.println("Learn Fireball? yes/no");
		if (Input.convertYesNoToBoolean()){
			player.addSpell(Locations.fireball);
			System.out.println("You have learned Fireball. \nYou can use Fireball in combat by typing \'fireball\' \nor cast the strongest fire spell you know by typing \'fire\'. \nFire spells cannot be used outside of battle.");
		}
		return player;
	}
	public static Character talkToGuardCat(Character player, Items items) {
		System.out.println("Guard cat: " + Locations.guardCat.getTalkTo());
		System.out.println("talk about HIM, his JOB, or just stand in his SUN.");
		String choice = Input.getInput();
		switch (choice){
		case "him":
		case "h":
			System.out.println("Guard cat: You wanna know about me? There is much I can tell you. \nGuard cat: but I don\'t feel like it right now.");
			break;
		case "job":
		case "j":
			System.out.println("Guard cat: I\'m not gonna stop you from leaving. \nGuard cat: I\'m watching incoming, not outgoing people. \nGuard cat: I must warn you though, creatures out there are a lot stronger than in the forest.");
			break;
		case "sun":
		case "s":
			System.out.println("Guard cat: You really wanna pick a fight with me? okay then.");
			player.combat(items);
			break;
			default:
				System.out.println("Guard cat: not surrrre who of us is drrreaming, \nGuard cat: but you\'rrrr not making sense.");
		}
		return player;
	}
	public static Character talkToSalesCow(Character player, Items items) {
		Item[] shopList = new Item[]{items.getItems().get(14),items.getItems().get(15),items.getItems().get(0)};
		Shop farmStall = new Shop(Locations.salesCow, shopList, false, null);
		player = farmStall.runShop(player);
		return player;
	}
	
	public static Character talkToFarmer(Character player, Items items) {
		System.out.println(Locations.farmer.getTalkTo());
		return player;
	}
}
