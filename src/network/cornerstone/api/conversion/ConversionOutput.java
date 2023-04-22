package network.cornerstone.api.conversion;

import network.cornerstone.system.factory.EndUser;
import network.cornerstone.system.factory.ItemTemplate;
import network.cornerstone.system.helpers.Placeholders;
import network.cornerstone.system.helpers.Translator;
import network.cornerstone.system.helpers.UnifiedUUID;
import network.cornerstone.system.helpers.types.AcceptDenyApplication;
import network.cornerstone.system.helpers.types.OwnedInventoryIdentifier;
import network.cornerstone.system.opener.CornerstoneInventory;
import network.cornerstone.system.opener.InventoryManagement;
import network.cornerstone.system.opener.InventoryModifier;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import java.util.LinkedHashMap;

public class ConversionOutput {
    public InventoryManagement inventoryManagement;
    public EndUser endUser;
    public CornerstoneInventory cornerstoneInventory;
    public Inventory inventory;
    public InventoryView inventoryView;
    public InventoryModifier inventoryModifier;
    public OwnedInventoryIdentifier ownedInventoryIdentifier;
    public LinkedHashMap<Integer, ItemTemplate> itemTemplateLinkedHashMap;
    public Placeholders placeholdersConvertor;
    public Translator translationHelper;
    public UnifiedUUID unifiedUUIDImplementation;
    public AcceptDenyApplication acceptDenyApplicationVersionAndCriteria;

    public ConversionOutput(InventoryManagement inventoryManagement, EndUser endUser, CornerstoneInventory cornerstoneInventory, Inventory inventory, InventoryView inventoryView, InventoryModifier inventoryModifier, OwnedInventoryIdentifier ownedInventoryIdentifier, LinkedHashMap<Integer, ItemTemplate> itemTemplateLinkedHashMap, Placeholders placeholdersConvertor, Translator translationHelper, UnifiedUUID unifiedUUIDImplementation, AcceptDenyApplication acceptDenyApplicationVersionAndCriteria) {
        this.inventoryManagement = inventoryManagement;
        this.endUser = endUser;
        this.cornerstoneInventory = cornerstoneInventory;
        this.inventory = inventory;
        this.inventoryView = inventoryView;
        this.inventoryModifier = inventoryModifier;
        this.ownedInventoryIdentifier = ownedInventoryIdentifier;
        this.itemTemplateLinkedHashMap = itemTemplateLinkedHashMap;
        this.placeholdersConvertor = placeholdersConvertor;
        this.translationHelper = translationHelper;
        this.unifiedUUIDImplementation = unifiedUUIDImplementation;
        this.acceptDenyApplicationVersionAndCriteria = acceptDenyApplicationVersionAndCriteria;
    }
}
