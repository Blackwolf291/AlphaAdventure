package TextGame;

import java.util.Enumeration;

public class Locations{
	static Location l0;
	static Location l1;
	static Location l2;
	static Location l3;
	static Location l4;
	static Location l5;
	static Location l6;
	static Location l7;
	static Location l8;
	static Location l9;
	static Location l10;
	static Location l11;
	static Location l12;
	static Location l13;
	static Location l14;
	static Location l15;
	static Location l16;
	static Location l17;
	static Location l18;
	static Location l19;
	static Location l20;
	static Location l21;
	static Location l22;
	static Location l23;
	static Location l24;
	static Location l25;
	static Location l26;
	static NPC IceUnknown;
	static NPC Ice;
	static NPC guardDog;
	static NPC Luka;
	static NPC blacksmith;
	static NPC Coon;
	static NPC realestateShark;
	static NPC kindHellhound;
	static NPC Jake;
	static NPC guardCat;
	static NPC farmer;
	static NPC salesCow;
	static Spell minorHeal;
	static Spell fireball;

	
	public Locations(Items items, Character player) {
	//set up locations
	l0 = new Location ("Extra Location", "Here I keep all special encounters. If you came here you found a bug.");	
	l1 = new Location ("Beach", "you are on the pearly white sands of an unknown beach.\nYou see the wreck of the ship to the East, \nand a dense forest to the North.");
	l2 = new Location ("Wreck", "You have reached the shipwreck.\nIt looks stable now but there seems to be no way through. \nA dazed white fox sits among the wreckage.");
	l3 = new Location ("Forest", "It looks bright and green and full of life.\nYou hear leaves rustle on the breeze.\nThere are passageways deeper into the forest, maybe wild trails.");
	l4 = new Location ("Forest Village West Gate", "In a section of the forest, surrounded by wooden poles, \nyou hear the sounds of children laughing, and adults working. \n A grim looking guard blocks the entrance.");
	l5 = new Location ("Forest Ascent", "As you follow the trail, it slopes up a hill, \nto where the woods start to thin out. On the top of the hill you can see a temple of sorts.");
	l6 = new Location ("Forest Village", "Two roads, two shops and a few homes. That's it, \nbut children are playing happily in this little sanctuary.");
	l7 = new Location ("Forest Temple Entrance", "A row of statues lines the front of a large marble structure at the top of the hill. \nAll around, the forest stretches almost entirely to the coast in the east, \nand to the mountains in the far west. You can see smoke trailing up from a nearby village.\nThe doors into the temple are wide open, and the place looks well kept.");
	l8 = new Location ("Blacksmith's", "Roaring fires fill the melting oven in the back of the only stone building in town,\n a puts a piece of metal into a cooling bath before walking up to the counter.");
	l9 = new Location ("Coons General Store", "In this old fashioned store, there are lines of shelves behind the counter. \nA young raccoon smiles");
	l10 = new Location ("Vacant Home", "It looks cozy and not very big, but I'll be a lot warmer than the beach, and a lot more comfortable too. In a small pond in the front yard lays a literal Real-Estate Shark.");
	l11 = new Location ("Living Room","It seems a bit bare but the couch seems comfy and the table is just the right height. It could use a rug or two. There are stairways up and down.");
	l12 = new Location ("Ice's Room","He's put a bed in the corner that's always made with white sheets. There is a desk with never a thing on it, an scattered tools for healing spells.");
	l13 = new Location ("Forest Temple Main", "Marble columns rise around you, the aisle leading up a large living three in the middle of the room. \nThere is a staircase leading down in an alcove to the east. By the tree stands an offer block.");
	l14 = new Location ("Forest Temple Basement", "It's dark and gloomy and you hear chanting in the distance. Do you wish to SEARCH the location?");
	l15 = new Location ("Abandoned Shelter", "There's a small stone shelter at the edge of the clearing, it looks to be a home. \nPawprints are burned into the grass of the plains everywhere.");
	l16 = new Location ("Luka's Place", "Luka's door is always open to you after what you did for him and his family. \nJake sits on a fireproofed couch, playing with the flames in his fur.");
	l17 = new Location ("Forest Village East Gate", "Beyond the gates, the forest starts thinning out. An old paved road leads east out of the forest.");
	l18 = new Location ("Great Plains West", "Wide open fields on a landcape of hills go as far as the eye can see, in the west flanked by forest, and in the east you see a farm.");
	l19 = new Location ("Great Plains North", "Wide open fields on a landcape of hills go as far as the eye can see, \n gradually sloping up into the mountains up north, \nand in the south you see a farm.");
	l20 = new Location ("Great Plains East", "Wide open fields on a landcape of hills go as far as the eye can see, \nbut it slowly flattens into large wastes of sand, a desert. \nin the west you see a farm.");
	l21 = new Location ("Great Plains South", "Wide open fields on a landcape of hills go as far as the eye can see. \nIn the distance you see tall structures and the ever lit sky of a city, \nand in the north you see a farm.");
	l22 = new Location ("Lon-Cow Farm", "A quaint farm in a valley between the grassy hills. \nTo the South East, you see a barn. To the North East is the farmhouse, and to the northwest is a simple stall selling farm goods.");
	l23 = new Location ("Barn", "As you walk up to a barn you see the door is open. \nA quick peek inside reveals loads of hay and not much else yet.");
	l24 = new Location ("Farmhouse", "The building is beautiful, straw roofs over stone, small windows with shutters, \nand the front door is locked.");
	l25 = new Location ("Farm Stall", "The stall is made of simple wood, and has bottles of milk and small cheeses sitting ready. \nBehind the stand stands a cow, trying to decide if you wanna buy.");
	l26 = new Location ("Farmhouse Inside", "you're not supposed to get here yet as the key is currently unobtainalbe.");
	//todo create a farmhouse interior
	
	Creature feralWolf = new Creature("Feral Wolf", "He leaps out of the bushes with a loud snarl", "He circles around, waiting to strike", 100, 14, 0, 25, "The wolf tries to lunge at you one last time,\n but his paws can no longer hold him and he collapses.", "You pass out as his's teeth close around your neck.", 10, 10, 5, items.items.get(0), 0, true, 0, player.getInput().dice(1, 10) + 1);
	Creature vines = new Creature("Vines", "You feel a tug around your ankle. \nYou rip loose, turning around to see a mass of tentacles.", "The tentacles weave and wither around.", 140, 17, 0, 15, "The vines dry up and wither away.", "You feel the vines wrap around your body, \nbefore one whaps around your throat and squeezes tight.", 25, 15, 7, items.items.get(2), 50, true, 0, 0);
	Creature giantPrayingManthis = new Creature("Giant Praying Manthis", "Before you stands a giant insect, on four hind legs and sharp front legs. He looks hungry.", "He rubs his sharp forearms together, licking his lips.", 90, 26, 0, 20, "With that final blow, it falls apart. Arms stuck in the earth.", "As you fall to the ground, it picks you up, and the last thing you see is his mouth closing around your head.", 15, 20, 10, items.items.get(0), 0, true, 5, 0);
	Creature Hellhound = new Creature("Hellhound", "He charges you with his fangs first.", "He starls, more than ready to bash your head in.", 250, 30, 10, 0, "He falls down, and keeps trashing on the floor. \nA blood curling screem rizes from him, before he passes out.", "He slams both his claws into your chest, and starts prying you apart. \nYou're too weak to move, and you register nothing else but pain.", 200, 150, 75, items.items.get(0), 0, false, 15, player.getInput().dice(3, 10) + 3);
	Creature GuardDog = new Creature("Guard Dog", "He draws his blade, a greatsword, and gets into a solid fighting stance.", "He eyes you wearily.", 150, 20, 5, 0, "He plants his sword in the ground.", "He knocks you down, and brings the flat of the sword down on your head with a heavy thud.", 150, 0, 0, items.items.get(0), 0, true, 0, 0);
	Creature alphaWolf = new Creature("Alpha Wolf", "He walks up to you with an air of superiority.", "He glares at you, looking for a way to break you.", 250, 20, 15, 35, "Realising he is not gonna win, he walks away with his tail tucked, not feeling very alpha.","He knocks you down with his claws, before huffing. \n Alpha: you're not worth my time. \nThen he snaps your neck.",200, 180, 90, items.items.get(0), 0, true, 10, player.getInput().dice(2, 10) + 2);
	Creature ragingBull = new Creature("Raging Bull", "He charges at you, horns first, with a loud moo.", "He sniffs and glares at you.", 130, 22, 4, 20, "He trips and falls down, head in the dirt, and not getting back up.", "He impales your gut before trampling over you as he runs off.", 100, 80, 40, items.items.get(0), 0, true, 0, 0);
	Creature GuardCat = new Creature("Guard Cat", "He gets up with a lazy yawn, unsheathing his claws.", "Guard cat: I wonder what you\'ll look like with clawmarks on your face.", 180, 35, 10, 0, "He lays back down in the gateway. \nGuard cat: So not worth the efford. Come back after my catnap.", "He lays back down in the gateway. \nGuard cat: now leave me to nap in peace!", 180, 0, 0, items.items.get(0), 0, true, 25, player.getInput().dice(4, 10) + 4);
	Creature bigHorse = new Creature("Big horse", "He comes running up, looking angry.", "He runs circles around you, looking for an opening", 210, 18, 5, 55, "He goes through his knees and collapses.", "He runs over you. \nThe last thing you see is a hoof coming down on your head.", 75, 60, 30, items.items.get(0), 0, true, 0, 0);
	Creature littleBlackFox = new Creature("Little Black Fox", "He appears before you, smiling a haunting smile.", "He lazily stretches his paws, but you never leave his sight.", 90, 18, 2, 25, "As sudden as he appeared, he vanished again.", "He pounces you one last time, teeth sinking into your throat.", 40, 30, 15, items.items.get(0), 0, true, 0, 0);
	Creature mentalSquirrel = new Creature("Mental Squirrel", "He raises an acorn, sitting near a hollow in a tree.", "He carefully aims for your eyes.", 60, 20, 0, 40, "He falls out of the tree, knocked out before he hits the ground.", "He hits you hard on the temple and you fall to the ground unconscious.", 10, 10, 5, items.items.get(12), 5, true, 0, 0);	
	
	Attack bite = new Attack ("bite", "He lashes out at you fangs first.", 15, player.getInput().dice(5, 10) + 5);
	Attack claws = new Attack ("claws", "He slashes at you with his claws.", 20, player.getInput().dice(4, 10) + 4);
	Attack vineWhip = new Attack ("vine whip", "A vine whacks you with an audible SMACK.", 15, player.getInput().dice(4, 10) + 4);
	Attack sharpArms = new Attack ("sharp arms", "it hacks at you with it's arms, trying to pierce into you.", 18, player.getInput().dice(8, 10) + 8);
	Attack slash = new Attack ("slash","He swings his sword with a mighty slash.", 25, player.getInput().dice(7, 10) + 7);
	Attack slam = new Attack ("slam","He brings the flat of his sword down on your head hard.", 20, player.getInput().dice(8, 10) + 8);
	Attack hoof = new Attack ("hoof", "He punches you hard with a hoof in the stomach.", 30, player.getInput().dice(5, 10) + 5);
	Attack horns = new Attack ("horns", "He charges at you, horns first, aiming god the gut.", 25, player.getInput().dice(7, 10) + 7);
	Attack stomp = new Attack ("stomp", "He runs over you, stomping you with his hooves", 20, player.getInput().dice(7, 10) + 7);
	Attack pounce = new Attack ("pounce", "He leaps onto your chest, nibbling at your throat.", 10, player.getInput().dice(3, 10) + 3);
	Attack scratch = new Attack ("scratch", "He scratches you with his claws.", 15, player.getInput().dice(2, 10) + 2);
	Attack throwNut = new Attack ("throw nut", "He throws an acorn, hitting you in the head.", 25, player.getInput().dice(2, 6) + 2);
	
	minorHeal = new Spell ("minor heal");
	fireball = new Spell ("fireball");
	
	IceUnknown = new NPC ("White Arctic Fox", "You see him looking dazed, sitting among the wreckage.", "Hey, glad to see I'm not the only survivor. my name is Ice.");
	Ice = new NPC("Ice", "He's a white arctic fox. the badge on the strap of his backpack says he's a medic.", "Can I help you with anything?");
	guardDog = new NPC ("Guard Dog", "He is a big and beefy German Shepherd, standing in the way with a heavy sword in his hands.\nMaybe messing with him is a bad idea.", "Sorry, I can't let you pass.");
	Luka = new NPC ("Luka", "He is a big and beefy German Shepherd, standing guard with his trusted blade.", "Whenever you wanna go another round, but this time, I won't hold back.");
	blacksmith = new NPC("Blacksmith","He's a big burly bull, whipping a hammer around as he moves.","Can I get you anything?");
	Coon = new NPC("Coon","He's a tiny raccoon, standing behind the counter with a big smile.","Hello and welcome to Coon's Buy & Sell. How can I help?");
	realestateShark = new NPC("Shark","Laying in the pond is a shark, wearing a suit, with a waterproof suitcase to boot.","Hello there, welcome to our latest sale. Would you happen to be interrested?");
	kindHellhound = new NPC("Hellhound", "In a small ring of burnt grass sits the hellhound, his back resting against the wall of the building. \nHis hair flaming, in a trail down his back all the way to the tail.","Hey, welcome to my little abode. It's great to see you again, is there anything I can do for my savior?");
	Jake = new NPC("Jake", "The hellhound seems a lot more relaxed. He's wearing fire and smoke as his clothing.", "Hey, nice to see you again.");
	guardCat = new NPC("Guard Cat", "He lays in the gate opening lazily, \nbut you got a feeling he knows exactly what\'s going on around him.", "Hey, will you get out of my shadow, or do I have to claw you out of it?");
	farmer = new NPC("farmer", "He is a brown horse in large overalls sitting in a rocking chair \nwith a straw in his mouth.", "Hey there, how can I help you, my friend?");
	salesCow = new NPC("Sales Cow", "She\'s a brown and white cow with blue eyes. \nShe\'s wearing a light pink dress.", "Healing milk and great cheeses here, would you like to buy something?");	
	
	Hellhound.addAttack(bite);
	Hellhound.addAttack(claws);
	feralWolf.addAttack(bite);
	feralWolf.addAttack(claws);
	vines.addAttack(vineWhip);
	giantPrayingManthis.addAttack(bite);
	giantPrayingManthis.addAttack(sharpArms);
	GuardDog.addAttack(slam);
	GuardDog.addAttack(slash);
	alphaWolf.addAttack(bite);
	alphaWolf.addAttack(claws);
	ragingBull.addAttack(horns);
	ragingBull.addAttack(hoof);
	GuardCat.addAttack(claws);
	mentalSquirrel.addAttack(throwNut);
	bigHorse.addAttack(hoof);
	bigHorse.addAttack(stomp);
	littleBlackFox.addAttack(scratch);
	littleBlackFox.addAttack(pounce);
	
	l0.addCreature(Hellhound);
	l0.addCreature(GuardDog);
	l0.addCreature(alphaWolf);
	l0.addCreature(GuardCat);
	l0.addExit(new Exit(Exit.special, l1));
	
	l1.addExit (new Exit(Exit.north, l2));
	l1.addExit (new Exit(Exit.east, l3));

	l2.addExit (new Exit(Exit.south, l1));
	l2.addNPC(IceUnknown);
	
	l3.addExit (new Exit(Exit.west, l1));
	l3.addExit (new Exit(Exit.southeast, l4));
	l3.addExit (new Exit(Exit.northeast, l5));	
	l3.addCreature(feralWolf);
	l3.addCreature(vines);
	l3.addCreature(mentalSquirrel);
	l3.addCreature(littleBlackFox);
	
	l4.addExit(new Exit(Exit.northwest, l3));
	l4.addNPC(guardDog);
	
	l5.addExit(new Exit(Exit.southwest, l3));
	l5.addCreature(feralWolf);
	l5.addCreature(giantPrayingManthis);
	l5.addExit(new Exit(Exit.north, l7));
	l5.addCreature(vines);
	
	l6.addExit(new Exit(Exit.west, l4));
	l6.addExit(new Exit(Exit.northeast, l8));
	l6.addExit(new Exit(Exit.southwest, l9));
	l6.addExit(new Exit(Exit.northwest, l10));
	l6.addExit(new Exit(Exit.east, l17));
	
	l7.addExit(new Exit(Exit.south, l5));
	l7.addCreature(giantPrayingManthis);
	l7.addExit(new Exit(Exit.in, l13));
	l7.addCreature(alphaWolf);
	l7.addCreature(feralWolf);
	
	l8.addExit(new Exit(Exit.southwest, l6));
	l8.addNPC(blacksmith);
	
	l9.addExit(new Exit(Exit.northeast, l6));
	l9.addNPC(Coon);
	
	l10.addExit(new Exit(Exit.southeast, l6));
	l10.addNPC(realestateShark);
	
	l11.addExit(new Exit(Exit.out, l10));
	
	l12.addExit(new Exit(Exit.south, l11));
	
	l13.addExit(new Exit(Exit.out, l7));
	l13.addExit(new Exit(Exit.down, l14));
	
	l14.addExit(new Exit(Exit.up, l13));
	
	l15.addExit(new Exit(Exit.north, l3));
	l15.addNPC(kindHellhound);
	
	l16.addExit(new Exit(Exit.out, l6));
	l16.addNPC(Jake);
	
	l17.addExit(new Exit(Exit.west, l6));
	l17.addExit(new Exit(Exit.east, l18));
	l17.addNPC(guardCat);
	
	l18.addExit(new Exit(Exit.west, l17));
	l18.addExit(new Exit (Exit.northeast, l18));
	l18.addExit(new Exit (Exit.east, l22));
	l18.addExit(new Exit (Exit.southeast, l21));
	l18.addCreature(alphaWolf);
	l18.addCreature(feralWolf);
	l18.addCreature(ragingBull);
	l18.addCreature(bigHorse);
	
	l19.addExit(new Exit (Exit.southwest, l18));
	l19.addExit(new Exit (Exit.south, l22));
	l19.addExit(new Exit (Exit.southeast, l20));
	l19.addCreature(ragingBull);
	l19.addCreature(bigHorse);
	
	l20.addExit(new Exit (Exit.northwest, l18));
	l20.addExit(new Exit (Exit.west, l22));
	l20.addExit(new Exit (Exit.southwest, l21));
	l20.addCreature(ragingBull);
	l20.addCreature(bigHorse);
	
	l21.addExit(new Exit (Exit.northwest, l18));
	l21.addExit(new Exit (Exit.north, l22));
	l21.addExit(new Exit (Exit.northeast, l20));
	l21.addCreature(ragingBull);
	l21.addCreature(bigHorse);
	
	l22.addExit(new Exit (Exit.north, l19));
	l22.addExit(new Exit (Exit.west, l18));
	l22.addExit(new Exit (Exit.east, l20));
	l22.addExit(new Exit (Exit.south, l21));
	l22.addExit(new Exit (Exit.southwest, l23));
	l22.addExit(new Exit (Exit.northwest, l24));
	l22.addExit(new Exit (Exit.northeast, l25));
	
	l23.addExit(new Exit (Exit.northeast, l22));
	
	l24.addExit(new Exit (Exit.southeast, l22));
	l24.addNPC(farmer);
	
	l25.addExit(new Exit (Exit.southwest, l22));
	l25.addNPC(salesCow);
	
	l26.addExit(new Exit (Exit.out, l24));
	
	player.setCurrentLocation(l1);
	player.setBase(l1);
	}
	
	public Location getLocation(Exit an_exit) {
		Location location = an_exit.getLeadsTo();
		return location;
	}
	
public static Character action (String Command, Character player, Items items){
	
	// Search for an exit match
	for (@SuppressWarnings("rawtypes")
	Enumeration e = player.getCurrentLocation().getExits().elements(); e.hasMoreElements();)
	{
		Exit an_exit = (Exit) e.nextElement();

		if ( (an_exit.getDirectionName().compareTo(Command) == 0) || (an_exit.getShortDirectionName().compareTo(Command) == 0 )){
			if (Input.coin()){
				if (player.getCurrentLocation().getCreatures().size() > 0){
					player.setEnemy(player.getCurrentLocation().getCreatures().get(player.getInput().dice(1,player.getCurrentLocation().getCreatures().size()))); 
					player = Combat.combat(player, items);
				}
			} else{
			
			//change location
			player.setCurrentLocation(an_exit.getLeadsTo());

			// Show room description 
			System.out.println( player.getCurrentLocation().getDescription());

			// Show available exits
			System.out.println( "\nAvailable exits :" );
			for (e = player.getCurrentLocation().getExits().elements(); e.hasMoreElements();){
				an_exit = (Exit) e.nextElement();
				System.out.println(an_exit);
			}
				if (player.getCurrentLocation().getNPCs().size() != 0){
				System.out.println("You see " + player.getCurrentLocation().getNPCs().get(0).getName());
				System.out.println("You can LOOK or TALK");
				}
			}		

			// Event handled
			return player;
		}				
	}

	// Event handled
	return player;
}
}