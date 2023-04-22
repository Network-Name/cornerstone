<br/>
<p align="center">
  <a href="https://github.com/Network-Name/cornerstone">
    <img src="https://i.imgur.com/c9iUy1R.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Cornerstone</h3>

  <p align="center">
    Open source interactive Minecraft inventory designer with event hooks, minimal packet usage, smooth transitions between menus, and loads of easy-to-use features.
    <br/>
    <br/>
    <a href="https://github.com/Network-Name/cornerstone"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
  </p>
</p>

![Downloads](https://img.shields.io/github/downloads/Network-Name/cornerstone/total) ![Contributors](https://img.shields.io/github/contributors/Network-Name/cornerstone?color=dark-green) ![Issues](https://img.shields.io/github/issues/Network-Name/cornerstone) ![License](https://img.shields.io/github/license/Network-Name/cornerstone) 

## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
* [Usage](#usage)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Authors](#authors)

## About The Project

![Screen Shot](https://i.ytimg.com/vi/AeS0zzz38W0/maxresdefault.jpg)

Cornerstone is a developer resource to create interactive GUIs with multiple translations and lores with uniform line lengths. It was created originally for the Project X minigame network, but we are bringing it to the Minecraft community to help other developers kickstart their projects.

## Built With

This plugin is 100% built on Java, with minimal packets and event handlers. The only dependency required is org.json's JSON parsing library for configuration/custom API response integration.

* [org.json](https://json.org/json-en.html)

## Getting Started

There are no steps to install the sub-plugin, simply import the jar as library in your editor and make sure it is extracted to the final artifact. All dependencies are pre-installed in release jar.

## Usage

Each of the elements of the plugin have builders designed to make using and opening the GUIs a breeze. In order to create an Inventory instance you will need to have an `EndUser` object (PlayerBuilder) and a `CornerstoneInventory` (`InventoryBuilder`) [with `ItemTemplate` (`ItemBuilder`) templates in slots.]

Next, you can create an `InventoryModifier` (`InstanceBuilder`) with the template. Use ```.open(EndUser/PlayerBuilder)``` from the builder to execute the opening of a menu. It's really that simple.

**Example Usage**
```java
InstanceBuilder.with(InventoryBuilder
    .type(InventoryType.CHEST)
    .rows(3)
    .title("§a§lSuper Cool Inventory")
    .place(9, ItemBuilder
        .material(Material.GOLD_BLOCK)
        .name("§c§lSuper Cool Item")
        .lore("§4Place your lore with one line. Cornerstone will
            automatically generate your lore in the correct locale
            with uniformly-sized lines in the §cright color."))
    .open(PlayerBuilder
        .from(player)
        .variable("custom_variables", "Can go here!")
        .connectMap(connectLinkedHashMap.forExistingVariables)));
```

## Roadmap

See the [open issues](https://github.com/Network-Name/cornerstone/issues) for a list of proposed features (and known issues).

## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.
* If you have suggestions for adding or removing projects, feel free to [open an issue](https://github.com/Network-Name/cornerstone/issues/new) to discuss it, or directly create a pull request after you edit the *README.md* file with necessary changes.
* Please make sure you check your spelling and grammar.
* Create individual PR for each suggestion.
* Please also read through the [Code Of Conduct](https://github.com/Network-Name/cornerstone/blob/main/CODE_OF_CONDUCT.md) before posting your first idea as well.

### Creating A Pull Request

Pull requests are always accepted! Please submit your forks with ideas of features and/or fixes of bugs.

## License

This project is licensed under the Creative Commons' Attribution Share Alike 4.0 license. Read more about the abilities and limitations in the [license file](LICENSE) or at [choosealicense.com](https://choosealicense.com/licenses/cc-by-sa-4.0/)

## Authors

* **Annabella Proctor** - *CEO of Project X, LLC. and Lead Developer* - [Annabella Proctor](https://github.com/annabellaproctor)
* **Project X** - *The team that works on the Project X network.* - [Project X](https://github.com/Network-Name)