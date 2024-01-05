package muramasa.gregtech.datagen;


import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.Ref;
import muramasa.antimatter.datagen.providers.AntimatterLanguageProvider;
import muramasa.antimatter.fluid.AntimatterFluid;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.item.ItemBattery;
import muramasa.antimatter.item.ItemCover;
import muramasa.antimatter.util.Utils;
import muramasa.gregtech.GTIRef;
import muramasa.gregtech.block.*;
import muramasa.gregtech.data.GregTechData;
import muramasa.gregtech.items.ItemIntCircuit;
import muramasa.gregtech.items.ItemNuclearFuelRod;
import net.minecraft.Util;
import net.minecraft.world.item.Item;

import static muramasa.antimatter.util.Utils.*;

public class GregTechLocalizations {

    public static class en_US extends AntimatterLanguageProvider {

        public en_US() {
            super(GTIRef.ID, GTIRef.NAME + " en_us Localization", "en_us");
        }

        @Override
        protected void addTranslations() {
            super.addTranslations();
            add(GTIRef.ID + ".advancements.greg", "GregTech Intergalactical");
            add(GTIRef.ID + ".advancements.greg.desc", "Getting familiar with your surroundings");
            add(GTIRef.ID + ".rei.tooltip.ore.byproducts", "Ore Byproducts List");
            add(GTIRef.ID + ".rei.tooltip.material_tree", "Material Tree");
            add("machine.transformer.voltage_info", "%s -> %s (Use Soft Hammer to invert)");
            add("machine.gti.large_boiler.production", "Produces %sL of Steam with 1 Coal at %sL/s");
            add("machine.gti.large_boiler.circuit", "A programmed circuit in the main block throttles the boiler (-1000L/s per config)");
            add(GTIRef.ID + ".rotor.tooltip.efficiency", "Turbine Efficiency: %s");
            add(GTIRef.ID + ".rotor.tooltip.steam_flow", "Optimal Steam flow: %sL/sec");
            add(GTIRef.ID + ".rotor.tooltip.gas_flow", "Optimal Gas flow(EU burnvalue per tick): %sEU/t");
            add("tooltip.gti.redstone_mode.2", "Ignore Redstone");
            add("tooltip.gti.redstone_mode.1", "Invert Conditional");
            add("tooltip.gti.redstone_mode.0", "Conditional");
            add("tooltip.gti.redstone_mode.normal", "Normal");
            add("tooltip.gti.redstone_mode.inverted", "Inverted");
            add("tooltip.gti.export_mode.0", "Export");
            add("tooltip.gti.export_mode.1", "Import");
            add("tooltip.gti.export_mode.2", "Export allow Import");
            add("tooltip.gti.export_mode.3", "Import allow Export");
            add("tooltip.gti.whitelist", "Whitelist");
            add("tooltip.gti.blacklist", "Blacklist");
            add("tooltip.gti.nbt.on", "Don't ignore nbt");
            add("tooltip.gti.nbt.off", "Ignore nbt");
            add("tooltip.gti.data_stick.raw_prospection_data", "Raw Prospection Data");
            add("tooltip.gti.data_stick.analyzed_prospection_data", "Analyzed Prospection Data");
            add("tooltip.gti.data_stick.by", "By X: %s Z: %s Dim: %s");
            add("tooltip.gti.coil.percentage", "Pyrolysis oven processing speed percentage: %s");
            add("tooltip.gti.coil.maxSimultaneousRecipes", "Max simultaneous recipes in Multismelter: %s");
            add("tooltip.gti.nuclear_rod.emission", "Emission: %s %s");
            add("tooltip.gti.nuclear_rod.self", "Self: %s %s");
            add("tooltip.gti.nuclear_rod.maximum", "Maximum: %s %s");
            add("tooltip.gti.nuclear_rod.neutrons", "Neutrons/t");
            add("tooltip.gti.nuclear_rod.factor", "Factor: %s");
            add("tooltip.gti.nuclear_rod.critical.0", "This fuel is %s");
            add("tooltip.gti.nuclear_rod.critical.1", "Critical");
            add("tooltip.gti.nuclear_rod.moderated.0", "Fuel rods will be %s");
            add("tooltip.gti.nuclear_rod.moderated.1", "Moderated");
            add("tooltip.gti.nuclear_rod.heat", "%s the heat per Neutron");
            add("tooltip.gti.nuclear_rod.when_used.1", "When used with %s:");
            add("tooltip.gti.nuclear_rod.when_used.2", "When used with %s or %s:");

        }

        @Override
        protected void english(String domain, String locale) {
            super.english(domain, locale);
            AntimatterAPI.all(BlockCasing.class, domain).forEach(i -> {
                if (i.getId().startsWith("casing_") || i.getId().startsWith("hull_")){
                    add(i, lowerUnderscoreToUpperSpacedRotated(i.getId()));
                    return;
                }
                if (i.getId().contains("long_distance_cable")){
                    String tier = i.getId().replace("long_distance_cable_", "");
                    add(i, "Long Distance Cable (" + tier.toUpperCase() + ")");
                }
                add(i, lowerUnderscoreToUpperSpaced(i.getId()));
            });

            add(GregTechData.MINING_PIPE, "Mining Pipe");
            add(GregTechData.MINING_PIPE_THIN, "Mining Pipe");
            add(GregTechData.BRITTLE_CHARCOAL, "Brittle Charcoal");
            add(GregTechData.SOLID_SUPER_FUEL, "Solid Super Fuel");
            AntimatterAPI.all(BlockFakeCasing.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
            AntimatterAPI.all(BlockColoredWall.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
            AntimatterAPI.all(BlockAsphalt.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
            AntimatterAPI.all(BlockAsphaltSlab.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
            AntimatterAPI.all(BlockCoil.class, domain).forEach(i -> add(i, lowerUnderscoreToUpperSpaced(i.getId())));
            AntimatterAPI.all(ItemIntCircuit.class, domain).forEach(i -> override(i.getDescriptionId(), "Integrated Circuit (" + i.circuitId + ")"));
            AntimatterAPI.all(ItemNuclearFuelRod.class, domain).forEach(i -> override(i.getDescriptionId(), Utils.getLocalizedType(i.getMaterial()) + " Nuclear Rod"));
            AntimatterAPI.all(ItemBasic.class, domain).forEach(i -> override(i.getDescriptionId(), lowerUnderscoreToUpperSpaced(i.getId())
                    .replace("Lv", "(LV)")
                    .replace("Mv", "(MV)")
                    .replace("Hv", "(HV)")
                    .replace("Ev", "(EV)")
                    .replace("Iv", "(IV)")));
            String[] fluids = new String[]{"hot_molten_lithium_chloride", "hot_molten_tin", "hot_molten_sodium"};
            for (String s : fluids) {
                override("fluid_type.antimatter_shared.liquid_" + s, Utils.lowerUnderscoreToUpperSpaced(s));
                override("item.antimatter_shared.liquid_" + s + "_bucket", Utils.lowerUnderscoreToUpperSpaced(s));
            }
//            AntimatterAPI.all(ItemPowerUnit.class, domain).stream().filter(i -> i.getId().startsWith("power_unit") || i.getId().startsWith("small_power_unit")).forEach(i -> override(i.getDescriptionId(), lowerUnderscoreToUpperSpaced(i.getId())));
            override("machine.large_turbine.hv", "Large Steam Turbine");
            override("machine.large_turbine.ev", "Large Gas Turbine");
            override("machine.large_turbine.iv", "Large HP Steam Turbine");
            override("machine.large_boiler.lv", "Large Bronze Boiler");
            override("machine.large_boiler.mv", "Large Steel Boiler");
            override("machine.large_boiler.hv", "Large HP Titanium Boiler");
            override("machine.large_boiler.ev", "Large HP Tungstensteel Boiler");
        }
    }

}
