# Guaranteed End Ships

Every End city comes with an End ship. In vanilla only about one city in five has one, so finding an Elytra can take a long flight from city to city. With this mod, every new End city you find has its ship, its Elytra and its dragon head.

## How it works

- When an End city is generated without a ship, its layout is rolled again until one has a ship.
- Every city is still an ordinary vanilla city with vanilla loot, just one of the layouts that comes with a ship.
- Only End cities generated after you install the mod get a ship. Cities you have already found stay as they are.
- `/locate structure minecraft:end_city` finds the nearest city, and with this mod that city has a ship.

## Settings

| Setting | Default | What it does |
|---|---|---|
| enabled | true | Turns the mod on or off |
| shipChance | 100 | Percent of new End cities that get a ship. 100 means every city |

Change them with /mycel set guaranteedendships <key> <value>, or in config/guaranteedendships.json.

## Good to know

- Server side only. Players don't need to install anything, and vanilla players can join.
- In singleplayer, install it in your own game.
- Without Mycel the game still starts: the mod stays off and tells players in chat that Mycel is missing.

## Build

```
./gradlew build            # Minecraft 26.3
./gradlew build -Pmc=26.2
./gradlew build -Pmc=26.1
```

MIT licensed. Part of [MyCelium](https://mycelium-gg.org).
