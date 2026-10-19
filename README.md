# Inscryption TUI

A terminal reinterpretation of the card game *Inscryption*, written in plain Java with no runtime dependencies.

Face a mysterious opponent across three successive matches: play your creatures, sacrifice them to summon stronger ones, collect bones and tip the scales in your favor.

```
Another challenger... It has been ages.
Lancer la partie ? (y/n)
```

> **Note:** the game's interface (prompts, commands and card names) is in French. This README gives English translations where useful.

---

## Table of contents

- [Requirements](#requirements)
- [Installation and running](#installation-and-running)
- [How to play](#how-to-play)
- [Game rules](#game-rules)
- [Cards and sigils](#cards-and-sigils)
- [Tests](#tests)
- [Architecture](#architecture)
- [Authors and license](#authors-and-license)

---

## Requirements

- **Java 17 or newer** (the code uses arrow-style `switch` expressions and pattern matching for `instanceof`).
- A terminal wide enough (around **150 columns**) for the board and hand to display properly.

No build tool is needed: everything compiles with `javac`.

## Installation and running

```bash
git clone https://github.com/Guyomeuh/inscryption-tui.git
cd inscryption-tui

# Compile
javac -d out $(find src -name "*.java")

# Run
java -cp out Main
```

> On Windows (PowerShell), replace the `find` subcommand with:
> `javac -d out (Get-ChildItem -Recurse src -Filter *.java).FullName`

## How to play

Each turn, the screen shows the opponent's board (including the queued cards that will advance next turn), your own board, the damage scale, your hand, your deck and your resources.

### Commands during your turn

| Command | Effect |
|---|---|
| `piocher` | Draw a random card from your deck. **Required at the start of each turn** as long as your deck isn't empty. |
| `placer <position> <card>` | Play card number `<card>` from your hand onto slot `<position>` (1 to 4). |
| `fin` | End your turn: your creatures attack, then the opponent plays. |

### Contextual commands

| Command | When |
|---|---|
| `sacrifier <position>` | To pay a card's blood cost: sacrifices the creature on that slot. |
| `placer <position>` | After sacrificing, to choose where the summoned card goes. |
| `sacrifier <n>` / `transfert <n>` | Between matches, to remove a card from your deck and transfer its sigils. |
| `oui` / `non`, `y` / `n` | Yes/no answers to the game's questions. |

## Game rules

### The scale

There are no hit points: a **scale** keeps track of damage. Every point of damage dealt directly to the opponent tips it toward you, and vice versa. **The first side to reach a lead of 5 wins.**

An attack hits the card directly opposite. If the slot is empty (or the attacker is *Airborne*), the damage goes straight to the scale.

### Resources

- **Blood:** some cards require you to sacrifice one or more of your creatures on the board. Blood does not carry over between turns.
- **Bones:** you gain one for every sacrifice and every time one of your creatures dies in combat. They pay for bone-cost cards and are kept for the whole match.

Squirrels are free, which makes them perfect sacrifice fodder.

### Run progression

1. **Three matches** are played in a row against the opponent, each with its own enemy deck, scripted strategy and obstacles (tree, boulder, roots…) already placed on your board.
2. After winning the **second match**, you pick a new card among the Elk, the Adder and the Porcupine, then you may sacrifice a card from your deck and **transfer its sigils** to another type of animal.
3. A loss ends the run.

## Cards and sigils

### Starting deck

| Card (in game) | English | HP | Attack | Cost | Sigil | Count |
|---|---|---|---|---|---|---|
| Ecureuil | Squirrel | 1 | 0 | free | — | 8 |
| Chat | Cat | 1 | 1 | free | Many Lives | 2 |
| Coyote | Coyote | 1 | 2 | 4 bones | — | 1 |
| Loup | Wolf | 2 | 3 | 2 blood | — | 1 |
| Louveteau | Wolf Cub | 1 | 1 | 1 blood | Fledgling | 1 |
| Moineau | Sparrow | 2 | 1 | free | Airborne | 1 |
| Punaise | Stinkbug | 2 | 1 | 2 bones | Stinky | 1 |

### Other cards

| Card (in game) | English | HP | Attack | Cost | Sigil |
|---|---|---|---|---|---|
| Grizzly | Grizzly | 6 | 4 | 3 blood | — |
| Corbeau | Raven | 3 | 2 | 2 blood | Airborne |
| Hermine | Stoat | 3 | 1 | 1 blood | — |
| Elan | Elk | 4 | 2 | 2 blood | Sprinter |
| Vipère | Adder | 1 | 1 | 2 blood | Touch of Death |
| Porc-épic | Porcupine | 2 | 1 | 1 blood | Sharp Quills |

### Sigils

| Sigil (in game) | English | Effect |
|---|---|---|
| **Volant** | Airborne | Flies over opposing cards and strikes the scale directly. |
| **Nombreuses vies** | Many Lives | Can be sacrificed without dying (once per turn). |
| **Croissance** | Fledgling | Grows into a Wolf after spending one turn on the board. |
| **Puant** | Stinky | Reduces incoming damage by 1. |
| **Coureur** | Sprinter | Moves one slot to the right after attacking (to the left if blocked). |
| **Piques pointues** | Sharp Quills | Deals 1 damage back to any creature that attacks it. |
| **Contact mortel** | Touch of Death | Instantly kills any creature it strikes (no effect on objects). |

## Tests

Unit tests use **JUnit 4**; the JARs are bundled in `deps/`.

```bash
CP="out:deps/junit-4.13.2.jar:deps/hamcrest-core-1.3.jar"

# Compile sources and tests
javac -d out $(find src -name "*.java")
javac -d out -cp "$CP" $(find tests -name "*.java")

# Run
java -cp "$CP" org.junit.runner.JUnitCore \
  $(find tests -name "*Test.java" | sed 's|tests/||; s|\.java$||; s|/|.|g')
```

The tests cover cards, sigil decorators, the board, the player, the bot, combat and the overall game.

> On Windows, replace the `:` separators in the classpath with `;`.

## Architecture

The project follows an **MVC** architecture and applies several design patterns:

| Pattern | Usage |
|---|---|
| **Decorator** | Sigils (`AirborneAnimal`, `StinkyAnimal`…) wrap an `AnimalCard` and can be stacked. |
| **Factory** | `AliveCardFactory` and `ObjectCardFactory` create cards, copy decorated cards and apply transferred sigils. |
| **Strategy** | `FirstMatch`, `SecondMatch` and `ThirdMatch` implement `MatchStrategy`: the bot's deck, its moves each turn and the initial obstacles. |
| **Observer** | Models notify the text views (`GameTextObserver`, `PlayerTextObserver`, `BotTextObserver`) whenever their state changes. |

```
src/
├── Main.java                 # Entry point: starting deck and setup
├── controller/
│   └── GameController.java   # Game loop and command parsing
├── models/
│   ├── cards/                # Cards, factories and sigil decorators
│   ├── gameplay/             # Game, Combat, Board, Player, Bot, match strategies
│   └── observer/             # Observer interfaces
└── view/                     # Console rendering and text observers
tests/                        # JUnit tests (mirrors src/)
uml/                          # PlantUML diagrams (weekly iterations and final diagram)
deps/                         # JUnit 4.13.2 and Hamcrest 1.3
```

The class diagrams in `uml/` can be rendered with [PlantUML](https://plantuml.com/):

```bash
plantuml uml/diagramme_final.puml
```

## Authors and license

Made by **Guillaume Niederlaender** and **Eliott Wanner**.

Released under the [MIT](LICENSE) license.

*Inscryption* is a game by Daniel Mullins Games. This is an independent, educational project with no affiliation to its creators.
