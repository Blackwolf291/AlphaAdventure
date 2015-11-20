package TextGame;

public class Locations{
	static Location extraLocation;
	static Location beach;
	static Location wreck;
	static Location forest;
	static Location forestWestGate;
	static Location forestAscent;
	static Location forestVillage;
	static Location forestTempleEntrance;
	static Location forestBlacksmith;
	static Location forestGeneralStore;
	static Location vacantHome;
	static Location livingRoom;
	static Location IceRoom;
	static Location forestTempleMain;
	static Location forestTempleBasement;
	static Location abandonedShelter;
	static Location lukasPlace;
	static Location forestEastGate;
	static Location greatPlainsWest;
	static Location greatPlainsNorth;
	static Location greatPlainsEast;
	static Location greatPlainsSouth;
	static Location farm;
	static Location barn;
	static Location farmHouse;
	static Location stalls;
	static Location farmHouseInside;
	static Location mountainSlopes;
	static Location mountainPass;
	static Location mountainCaves;
	static Location oldRoad;
	static Location cityGate;
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
	static Spell light;

	
	public Locations(Items items, Character player) {
	//set up locations
	extraLocation = new Location ("Extra Location", "Here I keep all special encounters. If you came here you found a bug.");	
	beach = new Location ("Beach", "you are on the pearly white sands of an unknown beach.\nYou see the wreck of the ship to the East, \nand a dense forest to the North.");
	wreck = new Location ("Wreck", "You have reached the shipwreck.\nIt looks stable now but there seems to be no way through. \nA dazed white fox sits among the wreckage.");
	forest = new Location ("Forest", "It looks bright and green and full of life.\nYou hear leaves rustle on the breeze.\nThere are passageways deeper into the forest, maybe wild trails.");
	forestWestGate = new Location ("Forest Village West Gate", "In a section of the forest, surrounded by wooden poles, \nyou hear the sounds of children laughing, and adults working. \n A grim looking guard blocks the entrance.");
	forestAscent = new Location ("Forest Ascent", "As you follow the trail, it slopes up a hill, \nto where the woods start to thin out. On the top of the hill you can see a temple of sorts.");
	forestVillage = new Location ("Forest Village", "Two roads, two shops and a few homes. That's it, \nbut children are playing happily in this little sanctuary.");
	forestTempleEntrance = new Location ("Forest Temple Entrance", "A row of statues lines the front of a large marble structure at the top of the hill. \nAll around, the forest stretches almost entirely to the coast in the east, \nand to the mountains in the far west. You can see smoke trailing up from a nearby village.\nThe doors into the temple are wide open, and the place looks well kept.");
	forestBlacksmith = new Location ("Blacksmith's", "Roaring fires fill the melting oven in the back of the only stone building in town,\n a puts a piece of metal into a cooling bath before walking up to the counter.");
	forestGeneralStore = new Location ("Coons General Store", "In this old fashioned store, there are lines of shelves behind the counter. \nA young raccoon smiles");
	vacantHome = new Location ("Vacant Home", "It looks cozy and not very big, but I'll be a lot warmer than the beach, and a lot more comfortable too. In a small pond in the front yard lays a literal Real-Estate Shark.");
	livingRoom = new Location ("Living Room","It seems a bit bare but the couch seems comfy and the table is just the right height. It could use a rug or two. There are stairways up and down.");
	IceRoom = new Location ("Ice's Room","He's put a bed in the corner that's always made with white sheets. There is a desk with never a thing on it, an scattered tools for healing spells.");
	forestTempleMain = new Location ("Forest Temple Main", "Marble columns rise around you, the aisle leading up a large living three in the middle of the room. \nThere is a staircase leading down in an alcove to the east. By the tree stands an offer block.");
	forestTempleBasement = new Location ("Forest Temple Basement", "It's dark and gloomy and you hear chanting in the distance. Do you wish to SEARCH the location?");
	abandonedShelter = new Location ("Abandoned Shelter", "There's a small stone shelter at the edge of the clearing, it looks to be a home. \nPawprints are burned into the grass of the plains everywhere.");
	lukasPlace = new Location ("Luka's Place", "Luka's door is always open to you after what you did for him and his family. \nJake sits on a fireproofed couch, playing with the flames in his fur.");
	forestEastGate = new Location ("Forest Village East Gate", "Beyond the gates, the forest starts thinning out. An old paved road leads east out of the forest.");
	greatPlainsWest = new Location ("Great Plains West", "Wide open fields on a landcape of hills go as far as the eye can see, in the west flanked by forest, and in the east you see a farm.");
	greatPlainsNorth = new Location ("Great Plains North", "Wide open fields on a landcape of hills go as far as the eye can see, \n gradually sloping up into the mountains up north, \nand in the south you see a farm.");
	greatPlainsEast = new Location ("Great Plains East", "Wide open fields on a landcape of hills go as far as the eye can see, \nbut it slowly flattens into large wastes of sand, a desert. \nin the west you see a farm.");
	greatPlainsSouth = new Location ("Great Plains South", "Wide open fields on a landcape of hills go as far as the eye can see. \nIn the distance you see tall structures and the ever lit sky of a city, \nand in the north you see a farm.");
	farm = new Location ("Lon-Cow Farm", "A quaint farm in a valley between the grassy hills. \nTo the South East, you see a barn. To the North East is the farmhouse, and to the northwest is a simple stall selling farm goods.");
	barn = new Location ("Barn", "As you walk up to a barn you see the door is open. \nA quick peek inside reveals loads of hay and not much else yet.");
	farmHouse = new Location ("Farmhouse", "The building is beautiful, straw roofs over stone, small windows with shutters, \nand the front door is locked.");
	stalls = new Location ("Farm Stall", "The stall is made of simple wood, and has bottles of milk and small cheeses sitting ready. \nBehind the stand stands a cow, trying to decide if you wanna buy.");
	farmHouseInside = new Location ("Farmhouse Inside", "You're not supposed to get here yet as the key is currently unobtainalbe.");
	//TODO create a farmhouse interior
	mountainSlopes = new Location ("Mountain Slopes", "The hills grow steeper and the vegitation scarse as they turn into mountains. \nIt gets too steap to just roam \nbut you can either take a pass between the mountains, \nor a cave underneath the mountain.");
	mountainPass = new Location ("Mountain Pass", "A thick blanket of snow is blocking the pass. You cannot proceed");
	mountainCaves = new Location ("Mountain Caves", "It\'s damp and dark. You\'ll need a light to proceed.");
	oldRoad = new Location ("Old Road", "Trails of an old highway lead from the city \ninto the hills where they vanish. \nYou see a concrete wall topped with a barb wire fence.");
	cityGate = new Location ("City Gate", "As you walk up to an abandoned gatehouse. The gate is shut tight. \nYou'll need a Key Card to open it.");
	
	Creature feralWolf = new Creature("Feral Wolf", "He leaps out of the bushes with a loud snarl", "He circles around, waiting to strike", 100, 14, 0, 25, "The wolf tries to lunge at you one last time,\n but his paws can no longer hold him and he collapses.", "You pass out as his's teeth close around your neck.", 10, 10, 5, items.items.get(0), 0, true, 0, Input.dice(1, 10) + 1);
	Creature vines = new Creature("Vines", "You feel a tug around your ankle. \nYou rip loose, turning around to see a mass of tentacles.", "The tentacles weave and wither around.", 140, 17, 0, 15, "The vines dry up and wither away.", "You feel the vines wrap around your body, \nbefore one whaps around your throat and squeezes tight.", 25, 15, 7, items.items.get(2), 50, true, 0, 0);
	Creature giantPrayingManthis = new Creature("Giant Praying Manthis", "Before you stands a giant insect, on four hind legs and sharp front legs. He looks hungry.", "He rubs his sharp forearms together, licking his lips.", 90, 26, 0, 20, "With that final blow, it falls apart. Arms stuck in the earth.", "As you fall to the ground, it picks you up, and the last thing you see is his mouth closing around your head.", 15, 20, 10, items.items.get(0), 0, true, 5, 0);
	Creature Hellhound = new Creature("Hellhound", "He charges you with his fangs first.", "He starls, more than ready to bash your head in.", 250, 30, 10, 0, "He falls down, and keeps trashing on the floor. \nA blood curling screem rizes from him, before he passes out.", "He slams both his claws into your chest, and starts prying you apart. \nYou're too weak to move, and you register nothing else but pain.", 200, 150, 75, items.items.get(0), 0, false, 15, Input.dice(3, 10) + 3);
	Creature GuardDog = new Creature("Guard Dog", "He draws his blade, a greatsword, and gets into a solid fighting stance.", "He eyes you wearily.", 150, 20, 5, 0, "He plants his sword in the ground.", "He knocks you down, and brings the flat of the sword down on your head with a heavy thud.", 150, 0, 0, items.items.get(0), 0, true, 0, 0);
	Creature alphaWolf = new Creature("Alpha Wolf", "He walks up to you with an air of superiority.", "He glares at you, looking for a way to break you.", 250, 20, 15, 35, "Realising he is not gonna win, he walks away with his tail tucked, not feeling very alpha.","He knocks you down with his claws, before huffing. \n Alpha: you're not worth my time. \nThen he snaps your neck.",200, 180, 90, items.items.get(0), 0, true, 10, Input.dice(2, 10) + 2);
	Creature ragingBull = new Creature("Raging Bull", "He charges at you, horns first, with a loud moo.", "He sniffs and glares at you.", 130, 22, 4, 20, "He trips and falls down, head in the dirt, and not getting back up.", "He impales your gut before trampling over you as he runs off.", 100, 80, 40, items.items.get(0), 0, true, 0, 0);
	Creature GuardCat = new Creature("Guard Cat", "He gets up with a lazy yawn, unsheathing his claws.", "Guard cat: I wonder what you\'ll look like with clawmarks on your face.", 180, 35, 10, 0, "He lays back down in the gateway. \nGuard cat: So not worth the efford. Come back after my catnap.", "He lays back down in the gateway. \nGuard cat: now leave me to nap in peace!", 180, 0, 0, items.items.get(0), 0, true, 25, Input.dice(4, 10) + 4);
	Creature bigHorse = new Creature("Big horse", "He comes running up, looking angry.", "He runs circles around you, looking for an opening", 210, 18, 5, 55, "He goes through his knees and collapses.", "He runs over you. \nThe last thing you see is a hoof coming down on your head.", 75, 60, 30, items.items.get(0), 0, true, 0, 0);
	Creature littleBlackFox = new Creature("Little Black Fox", "He appears before you, smiling a haunting smile.", "He lazily stretches his paws, but you never leave his sight.", 90, 18, 2, 25, "As sudden as he appeared, he vanished again.", "He pounces you one last time, teeth sinking into your throat.", 40, 30, 15, items.items.get(0), 0, true, 0, 0);
	Creature mentalSquirrel = new Creature("Mental Squirrel", "He raises an acorn, sitting near a hollow in a tree.", "He carefully aims for your eyes.", 60, 20, 0, 40, "He falls out of the tree, knocked out before he hits the ground.", "He hits you hard on the temple and you fall to the ground unconscious.", 10, 10, 5, items.items.get(12), 5, true, 0, 0);	
	
	Attack bite = new Attack ("bite", "He lashes out at you fangs first.", 15, Input.dice(5, 10) + 5);
	Attack claws = new Attack ("claws", "He slashes at you with his claws.", 20, Input.dice(4, 10) + 4);
	Attack vineWhip = new Attack ("vine whip", "A vine whacks you with an audible SMACK.", 15, Input.dice(4, 10) + 4);
	Attack sharpArms = new Attack ("sharp arms", "it hacks at you with it's arms, trying to pierce into you.", 18, Input.dice(8, 10) + 8);
	Attack slash = new Attack ("slash","He swings his sword with a mighty slash.", 25, Input.dice(7, 10) + 7);
	Attack slam = new Attack ("slam","He brings the flat of his sword down on your head hard.", 20, Input.dice(8, 10) + 8);
	Attack hoof = new Attack ("hoof", "He punches you hard with a hoof in the stomach.", 30, Input.dice(5, 10) + 5);
	Attack horns = new Attack ("horns", "He charges at you, horns first, aiming god the gut.", 25, Input.dice(7, 10) + 7);
	Attack stomp = new Attack ("stomp", "He runs over you, stomping you with his hooves", 20, Input.dice(7, 10) + 7);
	Attack pounce = new Attack ("pounce", "He leaps onto your chest, nibbling at your throat.", 10, Input.dice(3, 10) + 3);
	Attack scratch = new Attack ("scratch", "He scratches you with his claws.", 15, Input.dice(2, 10) + 2);
	Attack throwNut = new Attack ("throw nut", "He throws an acorn, hitting you in the head.", 25, Input.dice(2, 6) + 2);
	
	minorHeal = new HealSpell ("minor heal", 75, "A white light washes over you.",100);
	fireball = new DamageSpell ("fireball", 100, "You throw a ball of fire.", Input.dice(10, 10));
	light = new UtilitySpell ("light", 35, "You glow brightly.");
	
	IceUnknown = new NPC ("White Arctic Fox", "You see him looking dazed, sitting among the wreckage.", "Hey, glad to see I'm not the only survivor. my name is Ice.");
	Ice = new NPC("Ice", "He's a white arctic fox. the badge on the strap of his backpack says he's a medic.", "Can I help you with anything?");
	guardDog = new NPC ("Guard Dog", "He is a big and beefy German Shepherd, standing in the way with a heavy sword in his hands.\nMaybe messing with him is a bad idea.", "Sorry, I can't let you pass.");
	Luka = new NPC ("Luka", "He is a big and beefy German Shepherd, standing guard with his trusted blade.", "Whenever you wanna go another round, but this time, I won't hold back.");
	blacksmith = new ShopNPC("Blacksmith","He's a big burly bull, whipping a hammer around as he moves.","Blacksmith: Can I get you anything?", "Blacksmith: Sure, whatcha selling?", "Blacksmith: No you don't.", "Blacksmith: How many do you have for me?", "Blacksmith: Talk? I got no time for that.", "Blacksmith: Anything catch your eye?", "Blacksmith: You got nothing I can work with. Bring me hides or metal.", "Blacksmith: Sorry, I cannot help you with that.", "Blacksmith: What are you even saying?");
	Coon = new ShopNPC("Coon","He's a tiny raccoon, standing behind the counter with a big smile.","Hello and welcome to Coon's General Store. How can I help?", "Coon: sure, what do you have for me?", "Coon: Actually, you kinda don't. Sorry.", "Coon: I can sell that. How many do you have?", "Coon: Sure, what do you wanna talk about?", "Coon: So, what do you want?", null, "Sorry, I don\'t do that.", "Wha?");
	realestateShark = new NPC("Shark","Laying in the pond is a shark, wearing a suit, with a waterproof suitcase to boot.","Hello there, welcome to our latest sale. Would you happen to be interrested?");
	kindHellhound = new NPC("Hellhound", "In a small ring of burnt grass sits the hellhound, his back resting against the wall of the building. \nHis hair flaming, in a trail down his back all the way to the tail.","Hey, welcome to my little abode. It's great to see you again, is there anything I can do for my savior?");
	Jake = new NPC("Jake", "The hellhound seems a lot more relaxed. He's wearing fire and smoke as his clothing.", "Hey, nice to see you again.");
	guardCat = new NPC("Guard Cat", "He lays in the gate opening lazily, \nbut you got a feeling he knows exactly what\'s going on around him.", "Hey, will you get out of my shadow, or do I have to claw you out of it?");
	farmer = new NPC("farmer", "He is a brown horse in large overalls sitting in a rocking chair \nwith a straw in his mouth.", "Hey there, how can I help you, my friend?");
	salesCow = new ShopNPC("Sales Cow", "She\'s a brown and white cow with blue eyes. \nShe\'s wearing a light pink dress.", "Healing milk and great cheeses here, would you like to buy something?", null, null, null, null, null, null, null, null);	
	//TODO add flavor to shop npcs
	
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
	
	extraLocation.addCreature(Hellhound);
	extraLocation.addCreature(GuardDog);
	extraLocation.addCreature(alphaWolf);
	extraLocation.addCreature(GuardCat);
	extraLocation.addExit(Exit.special, beach);
	
	beach.addExit (Exit.north, wreck);
	beach.addExit (Exit.east, forest);

	wreck.addExit (Exit.south, beach);
	wreck.addNPC(IceUnknown);
	
	forest.addExit (Exit.west, beach);
	forest.addExit (Exit.southeast, forestWestGate);
	forest.addExit (Exit.northeast, forestAscent);	
	forest.addCreature(feralWolf);
	forest.addCreature(vines);
	forest.addCreature(mentalSquirrel);
	forest.addCreature(littleBlackFox);
	
	forestWestGate.addExit(Exit.northwest, forest);
	forestWestGate.addNPC(guardDog);
	
	forestAscent.addExit(Exit.southwest, forest);
	forestAscent.addCreature(feralWolf);
	forestAscent.addCreature(giantPrayingManthis);
	forestAscent.addExit(Exit.north, forestTempleEntrance);
	forestAscent.addCreature(vines);
	
	forestVillage.addExit(Exit.west, forestWestGate);
	forestVillage.addExit(Exit.northeast, forestBlacksmith);
	forestVillage.addExit(Exit.southwest, forestGeneralStore);
	forestVillage.addExit(Exit.northwest, vacantHome);
	forestVillage.addExit(Exit.east, forestEastGate);
	
	forestTempleEntrance.addExit(Exit.south, forestAscent);
	forestTempleEntrance.addCreature(giantPrayingManthis);
	forestTempleEntrance.addExit(Exit.in, forestTempleMain);
	forestTempleEntrance.addCreature(alphaWolf);
	forestTempleEntrance.addCreature(feralWolf);
	
	forestBlacksmith.addExit(Exit.southwest, forestVillage);
	forestBlacksmith.addNPC(blacksmith);
	
	forestGeneralStore.addExit(Exit.northeast, forestVillage);
	forestGeneralStore.addNPC(Coon);
	
	vacantHome.addExit(Exit.southeast, forestVillage);
	vacantHome.addNPC(realestateShark);
	
	livingRoom.addExit(Exit.out, vacantHome);
	
	IceRoom.addExit(Exit.south, livingRoom);
	IceRoom.addNPC(Ice);
	
	forestTempleMain.addExit(Exit.out, forestTempleEntrance);
	forestTempleMain.addExit(Exit.down, forestTempleBasement);
	
	forestTempleBasement.addExit(Exit.up, forestTempleMain);
	
	abandonedShelter.addExit(Exit.north, forest);
	abandonedShelter.addNPC(kindHellhound);
	
	lukasPlace.addExit(Exit.out, forestVillage);
	lukasPlace.addNPC(Jake);
	
	forestEastGate.addExit(Exit.west, forestVillage);
	forestEastGate.addExit(Exit.east, greatPlainsWest);
	forestEastGate.addNPC(guardCat);
	
	greatPlainsWest.addExit(Exit.west, forestEastGate);
	greatPlainsWest.addExit(Exit.northeast, greatPlainsWest);
	greatPlainsWest.addExit(Exit.east, farm);
	greatPlainsWest.addExit(Exit.southeast, greatPlainsSouth);
	greatPlainsWest.addCreature(alphaWolf);
	greatPlainsWest.addCreature(feralWolf);
	greatPlainsWest.addCreature(ragingBull);
	greatPlainsWest.addCreature(bigHorse);
	
	greatPlainsNorth.addExit(Exit.north, mountainSlopes);
	greatPlainsNorth.addExit(Exit.southwest, greatPlainsWest);
	greatPlainsNorth.addExit(Exit.south, farm);
	greatPlainsNorth.addExit(Exit.southeast, greatPlainsEast);
	greatPlainsNorth.addCreature(ragingBull);
	greatPlainsNorth.addCreature(bigHorse);
	
	greatPlainsEast.addExit(Exit.northwest, greatPlainsWest);
	greatPlainsEast.addExit(Exit.west, farm);
	greatPlainsEast.addExit(Exit.southwest, greatPlainsSouth);
	greatPlainsEast.addCreature(ragingBull);
	greatPlainsEast.addCreature(bigHorse);
	
	greatPlainsSouth.addExit(Exit.south, oldRoad);
	greatPlainsSouth.addExit(Exit.northwest, greatPlainsWest);
	greatPlainsSouth.addExit(Exit.north, farm);
	greatPlainsSouth.addExit(Exit.northeast, greatPlainsEast);
	greatPlainsSouth.addCreature(ragingBull);
	greatPlainsSouth.addCreature(bigHorse);
	
	farm.addExit(Exit.north, greatPlainsNorth);
	farm.addExit(Exit.west, greatPlainsWest);
	farm.addExit(Exit.east, greatPlainsEast);
	farm.addExit(Exit.south, greatPlainsSouth);
	farm.addExit(Exit.southwest, barn);
	farm.addExit(Exit.northwest, farmHouse);
	farm.addExit(Exit.northeast, stalls);
	
	barn.addExit(Exit.northeast, farm);
	
	farmHouse.addExit(Exit.southeast, farm);
	farmHouse.addNPC(farmer);
	farmHouse.setLock(true);
	
	stalls.addExit(Exit.southwest, farm);
	stalls.addNPC(salesCow);
	
	farmHouseInside.addExit(Exit.out, farmHouse);
	
	mountainSlopes.addExit(Exit.south, greatPlainsNorth);
	mountainSlopes.addExit(Exit.north, mountainPass);
	mountainSlopes.addExit(Exit.in, mountainCaves);
	
	mountainPass.addExit(Exit.south, mountainSlopes);
	
	mountainCaves.addExit(Exit.out, mountainSlopes);
	
	oldRoad.addExit(Exit.north, greatPlainsSouth);
	oldRoad.addExit(Exit.south, cityGate);
	
	cityGate.addExit(Exit.north, oldRoad);
	
	player.setCurrentLocation(beach);
	player.setBase(beach);
	}
	
public static Character action (String command, Character player, Items items){
	
	for (Exit exit : player.getCurrentLocation().getExits()){
		if (command.equals(exit.toString())||command.equals(exit.getShortDirectionName())){
			if (Input.coin()){
				if (player.hasEnemy()){
					player.getEnemy(); 
					player = player.combat(items);
				}
				if (!player.getWin()){
					return player;
			}
			
			//change location
			player.setLocation(exit);
			}
		}				
	}
	// Event handled
	return player;
}
}