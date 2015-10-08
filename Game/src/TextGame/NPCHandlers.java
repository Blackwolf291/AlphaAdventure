package TextGame;

public class NPCHandlers {
	static int IceCounter = 0;
	static int IceSpellCounter = 0;
	static boolean helpQuest = false;
	public static Character talkToShark(Character player){
		System.out.println("Shark: " + Locations.realestateShark.getTalkTo());
		System.out.println("Shark: This beautiful little home can be yours for only 10.000 gold. Interrested?");
		System.out.println("Yes or No");
		boolean choice = Input.yesNo(player);
		if (choice){
			if (player.getGold() >= 10000)
			System.out.println("Shark: She's all yours pall.");
			Locations.l10.removeNPC(Locations.realestateShark);
			System.out.println("Set the village home as your base?");
			boolean confirm = Input.yesNo(player);
			if (confirm){
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
				System.out.println("The vacant home remains vacant.");
				Locations.l10.setLocDescription("It looks cozy and not very big, but I'll be a lot warmer than the beach, and a lot more comfortable too. \n There is a small pond in the front yard. You can MOVE in.");
			}
		}else{
			System.out.println("Maybe some other time then.");
		}
		return player;
	}
	public static Character talkToBlacksmith(Character player, Items items){
		System.out.println("Blacksmith: " + player.getCurrentLocation().getNPCs().get(0).getTalkTo());
		String shop = "";
		while (shop == "");
		System.out.println("Buy, Craft, Talk");
		shop = Input.getInput();
		switch (shop){
		case "buy": 
		case "b": 
			System.out.println("Blacksmith: What will it be?");
			System.out.println("You have " + player.getGold() + "gold.");
			System.out.println("Item	Price.");
			System.out.println(items.getItems().get(6).getName() + items.getItems().get(6).getValue());
			System.out.println(items.getItems().get(7).getName() + items.getItems().get(7).getValue());
			System.out.println(items.getItems().get(8).getName() + items.getItems().get(8).getValue());
			System.out.println(items.getItems().get(9).getName() + items.getItems().get(9).getValue());
			String buy = Input.getInput();
			switch (buy){
			case "copper sword":
				if (player.getGold() > items.getItems().get(6).getValue()){
					System.out.println("Blacksmith: Will that be all?");
					player.addItem(items.getItems().get(6));
					player.setGold(-items.getItems().get(6).getValue());
					boolean choice = Input.yesNo(player);
					if (choice){
						shop = "";
						} else{
						System.out.println("Blacksmith: Go chop some heads for me with that.");
					}
				}
				break;
			case "copper shield":
				if (player.getGold() > items.getItems().get(7).getValue()){
					System.out.println("Blacksmith: Will that be all?");
					player.addItem(items.getItems().get(7));
					player.setGold(-items.getItems().get(7).getValue());
					boolean choice = Input.yesNo(player);
					if (choice){
						shop = "";
					} else{
						System.out.println("Blacksmith: May it serve you well.");
					}
				}
				break;
			case "copper helmet":
				if (player.getGold() > items.getItems().get(8).getValue()){
					System.out.println("Blacksmith: Will that be all?");
					player.addItem(items.getItems().get(8));
					player.setGold(-items.getItems().get(8).getValue());
					boolean choice = Input.yesNo(player);
					if (choice){
						shop = "";
						} else{
						System.out.println("Blacksmith: Your hair looks much better this way.");
					}
				}
				break;
			case "copper armor":
				if (player.getGold() > items.getItems().get(9).getValue()){
					System.out.println("Blacksmith: Will that be all?");
					player.addItem(items.getItems().get(9));
					player.setGold(-items.getItems().get(9).getValue());
					boolean choice = Input.yesNo(player);
					if (choice){
						shop = "";
						} else{
						System.out.println("Blacksmith: That should catch a few blows for you.");
					}
				}
				break;
			case "back":
			case "exit":
				System.out.println("Blacksmith: Nothing you like? i would make better stuff if i had better material in this place.");
				break;
				default:
					System.out.println("Blacksmith: You think you're funny? You're wasting my time, and i don't like losing time.");
			}
		case "craft":
		case "c":
			System.out.println("Blacksmith: Ah, right. I can make you special armors if you bring me the right materials.\n If you get me five hides, I can make you a leather armor. \nIt's much lighter than the copper armor, but takes nearly as much damage."); 
		case "talk":
		case "t":
			System.out.println("Blacksmith: Well, I have one more set I could sell you. All made of iron, but... I really don't wanna get rid of it. Maybe I'll give it for a favor at a later date.");			
		default: 
			System.out.println("Blacksmith: Speak up, kid, I got no idea what you're saying?");
			shop = "";
		}
			
		return player;
	}
	public static Character talkToCoon(Character player, Items items){
		System.out.println("Coon: " + player.getCurrentLocation().getNPCs().get(0).getTalkTo());
		String shop = "";
		while (shop == "");
		System.out.println("Buy, Sell, Talk");
		shop = Input.getInput();
		switch (shop){
		case "buy": 
		case "b": 
			System.out.println("Coon: What will it be?");
			System.out.println("You have " + player.getGold() + "gold.");
			System.out.println("Item	Price.");
			System.out.println(items.getItems().get(3).getName() + items.getItems().get(3).getValue());
			System.out.println(items.getItems().get(4).getName() + items.getItems().get(4).getValue());
			System.out.println(items.getItems().get(5).getName() + items.getItems().get(5).getValue());
			String buy = Input.getInput();
			switch (buy){
			case "potion":
				if (player.getGold() > items.getItems().get(3).getValue()){
					System.out.println("Coon: sure. anything else?");
					player.addItem(items.getItems().get(3));
					player.setGold(-items.getItems().get(3).getValue());
					boolean choice = Input.yesNo(player);
					if (choice){
						shop = "";
						} else{
						System.out.println("Coon: Thanks for visiting.");
					}
				}
				break;
			case "ether":
				if (player.getGold() > items.getItems().get(4).getValue()){
					System.out.println("Coon: sure. anything else?");
					player.addItem(items.getItems().get(4));
					player.setGold(-items.getItems().get(4).getValue());
					boolean choice = Input.yesNo(player);
					if (choice){
						shop = "";
						}else{
						System.out.println("Coon: Thanks for visiting.");
					}
				}
				break;
			case "elixer":
				if (player.getGold() > items.getItems().get(5).getValue()){
					System.out.println("Coon: sure. anything else?");
					player.addItem(items.getItems().get(5));
					player.setGold(-items.getItems().get(5).getValue());
					boolean choice = Input.yesNo(player);
					if (choice){
						shop = "";
						}else{
						System.out.println("Coon: Thanks for visiting.");
					}
				}
				break;
			case "back":
			case "exit":
				System.out.println("Coon: Changed your mind, eh? well, fine by me.");
				break;
				default:
					System.out.println("Coon: Sorry, I don\'t have one of those.");
			}
			break;
		case "sell":
		case "s":
			if (player.getInventory().size() > 0){
			System.out.println("Coon: What will it be?");
			System.out.println("Count	Item	Goldvalue.");
			for (int i = 0;i < player.getInventory().size();i++){
				if (!player.getInventory().get(i).getKeyItem()){
				System.out.println(player.getInventory().get(i).getCount() + "  " + player.getInventory().get(i).getName() + "  " + player.getInventory().get(i).getValue()/2);
				}
			}
			String Sale = Input.getInput();
			for (int i = 0;i < player.getInventory().size();i++){
			if (Sale.equals(player.getInventory().get(i).getName())){
				System.out.println("You have " + player.getInventory().get(i).getCount() + ".\nHow many will you sell?");
				int number = -1;
				while (number == -1){
					number = Input.getInteger();
					if (number >= 0 && number <= player.getInventory().get(i).getCount()){
						System.out.println("Sold for " + player.getInventory().get(i).getValue()/2 + " Gold");
						player.setGold(player.getInventory().get(i).getValue()/2);
					} else{
						System.out.println("Coon: You don\'t have that many!");
						number = -1;
					}
					}
			} else {
				System.out.println("Coon: You don\'t have one of those and you know it.");
			}
				}
			}
			break;
		case "talk":
		case "t":
			System.out.println("Coon: just talk? That's not gonna put food on my shelves.");	
			break;
		default: 
			System.out.println("Coon: What are you saying?");
			shop = "";
		}
			
		return player;
	}
	public static Character talkToGuardDog(Character player, Items items) {
		if (LocHandlers.getBrotherQuest() == 2) {
			Locations.l4.addExit(new Exit(Exit.east, Locations.l6));
			Locations.l4.removeNPC(Locations.guardDog);
			System.out.println("So you found my brother, how is he? \nThat's good to hear. \nMy name is Luka, welcome to the village.");
			Locations.l4.addNPC(Locations.Luka);
		} else if (helpQuest){
			System.out.println("The guard seems lonely. \n Guard: Did you find him? \n Oh... maybe next time?");
		} else {
		System.out.println("Guard: " + player.getCurrentLocation().getNPCs().get(0).getTalkTo());
		System.out.println("You could try FIGHTing past him, TRICKing him, or CONvincing him to let you by.");
		String plan = Input.getInput();
		switch (plan) {
		case "fight":
			player.setEnemy(Locations.l0.getCreatures().get(1));
			Combat.combat(player, items);
			if (player.getWin()){
				Locations.l4.addExit(new Exit(Exit.east, Locations.l6));
				Locations.l4.removeNPC(Locations.guardDog);
				System.out.println("Guard: You fight well for an outsider. Please be welcome in our village.");
				System.out.println("Guard; My name is Luka, nice to meet you.");
				Locations.l4.addNPC(Locations.Luka);
			}
			break;
		case "trick":
			int trickcounter = 0;
			if (player.getInt() + player.getLvl() + Input.dice(1,10) > 25 + 5 * trickcounter){
			System.out.println("The guard looks at you unbelievingly, but you manage to distract him long enough to sneak past him.");
			trickcounter++;
			player.setCurrentLocation(Locations.l6);
			} else {
				System.out.println("He looks at you incredulously as you try convincing him to leave his post. \nGuard: Are you done yet?");
			}
			break;
		case "con":
			if (player.getCha() + player.getLvl() + Input.dice(1,10) >= 25){
				System.out.println("After a lot of talking, he relents, a little. \n guard: If you could do me a favor, I'll let you in. \n My little brother has gone to the Temple, but hasn't returned. Could you go investigate?"); 
				System.out.println("YES or NO.");
				boolean choice = Input.yesNo(player);
				if(choice){
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
		if(player.getCurrentLocation().equals(Locations.l2)||player.getCurrentLocation().equals(Locations.l1)){
		if(player.getHP() < player.getMaxHP()){
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
			if(player.getHP() < player.getMaxHP()){
				player.setHP(player.getMaxHP());
				System.out.println("A white glow envelops you.");
				System.out.println("Ice: There, all healed up.");
				if (IceCounter < 3) {
				++IceCounter;
				} else if (IceCounter == 3 && player.getBase() != player.getCurrentLocation()){
					System.out.println("Ice: Maybe it's time I moved out of this wreck.");
					System.out.println("Move Ice into your base?");
					boolean moveIn = Input.yesNo(player);
					if (moveIn){
						Locations.l2.removeNPC(Locations.Ice);
						if (player.getBase() == Locations.l1) {
							Locations.l1.addNPC(Locations.Ice);
						} else if (player.getBase() == Locations.l11){
							Locations.l12.getNPCs().add(Locations.Ice);
							Locations.l11.addExit(new Exit(Exit.north, Locations.l12));
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
		} else if (player.getCurrentLocation().equals(Locations.l12)){
			if(player.getHP() < player.getMaxHP()){
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
				if(player.getHP() < player.getMaxHP()){
					player.setHP(player.getMaxHP());
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
					player.getSpells().add(Locations.minorHeal);
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
		Locations.l2.removeNPC(Locations.IceUnknown);
		Locations.l2.addNPC(Locations.Ice);
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
					player.setEnemy(Locations.l0.getCreatures().get(2));
					player = Combat.combat(player, items);
					if (player.getWin()){
						System.out.println("Only a few minutes later, Luka walks back down the path, holding the paw of a hellhound. \nHe\'s not really looking anywhere but at the panicked looking hellhound.\nLuka: Easy Jake, it\'s not so bad. You're still my brother.\nLuka: I\'ll convince the village you\'re still you. And look " + player.getName() + " is here too. \nLuca: " + player.getName() + ", please, take him to my home." );
					Locations.l6.addExit(new Exit(Exit.north, Locations.l16));
					if (player.getBase() == Locations.l11){
						System.out.println("Luka: It\'s right next to yours.");
					}else{
						System.out.println("Luka: It\'s right next to the vacant house.");
					}
					player.setCurrentLocation(Locations.l16);
					}
					Locations.l3.addCreature(Locations.l0.getCreatures().get(2));
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
			boolean choice = Input.yesNo(player);
			if (choice){
				player.setEnemy(Locations.l0.getCreatures().get(1));
				player = Combat.combat(player, items);
				if (player.getWin()){
					System.out.println("It seems you are still the better warrior.");
				}
			}
		}
		return player;
	}
	public static Character talkToHellhound(Character player){
		if (player.getCurrentLocation() == Locations.l15){
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
				Locations.l15.removeNPC(Locations.kindHellhound);
				Locations.l6.addExit(new Exit(Exit.north, Locations.l16));
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
		boolean choice = Input.yesNo(player);
		if (choice){
			player.getSpells().add(Locations.fireball);
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
			player = Combat.combat(player, items);
			break;
			default:
				System.out.println("Guard cat: not surrrre who of us is drrreaming, \nGuard cat: but you\'rrrr not making sense.");
		}
		return player;
	}
	public static Character talkToSalesCow(Character player, Items items) {
		System.out.println(Locations.salesCow.getTalkTo());
		System.out.println("You have " + player.getGold() + "gold.");
		System.out.println("Item \tPrice.");
		System.out.println(items.getItems().get(14).getName() + "\t" + items.getItems().get(14).getValue());
		System.out.println(items.getItems().get(15).getName() + "\t" + items.getItems().get(15).getValue());
		System.out.println("nothing");
		String buy = Input.getInput();
		switch (buy){
		case "milk":
			if (player.getGold() >= items.getItems().get(14).getValue()){
				player.setGold(player.getGold() - items.getItems().get(14).getValue());
				player.addItem(items.getItems().get(14));
				System.out.println("You got a bottle of " + items.getItems().get(14).getName());
			} else {
				System.out.println("I\'m sorry hun, you don\'t have that kind of money");
			}
			break;
		case "cheese":
			if (player.getGold() >= items.getItems().get(15).getValue()){
				player.setGold(player.getGold() - items.getItems().get(15).getValue());
				player.addItem(items.getItems().get(15));
				System.out.println("You got a block of " + items.getItems().get(15).getName());
			} else {
				System.out.println("I\'m sorry hun, you don\'t have that kind of money");
			}
			break;
		case "nothing":
		case "n":
			break;
			default:
		}
		return player;
	}
	public static Character talkToFarmer(Character player, Items items) {
		System.out.println(Locations.farmer.getTalkTo());
		return player;
	}
}