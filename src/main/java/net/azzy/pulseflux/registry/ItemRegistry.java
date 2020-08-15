package net.azzy.pulseflux.registry;

import net.azzy.pulseflux.PulseFlux;
import net.azzy.pulseflux.item.ThermometerItem;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.azzy.pulseflux.PulseFlux.MACHINE_MATERIALS;
import static net.azzy.pulseflux.PulseFlux.MOD_ID;

public class ItemRegistry extends Item {

    private ItemRegistry(Settings settings) {
        super(settings);
    }
    private static final Settings MATERIAL = new Settings().group(MACHINE_MATERIALS);
    private static final Settings TOOL = new Settings().group(PulseFlux.TOOLS);

    //Crafting
    public static Item STEEL_INGOT = register("hsla_steel_ingot", new Item(MATERIAL));
    public static Item TITANIUM_INGOT = register("titanium_ingot", new Item(MATERIAL));

    //Tools
    public static Item THERMOMETER = register("thermometer", new ThermometerItem(TOOL));

    public static void init(){}

    private static Item register(String name, Item item) {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
        return item;
    }

    public static Item registerBucket(String name, FlowableFluid item) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), new BucketItem(item, new Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(MACHINE_MATERIALS)));
    }
}

