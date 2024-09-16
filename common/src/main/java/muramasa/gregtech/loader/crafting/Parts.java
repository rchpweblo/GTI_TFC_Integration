package muramasa.gregtech.loader.crafting;

import com.google.common.collect.ImmutableMap;
import io.github.gregtechintergalactical.gtcore.GTCore;
import io.github.gregtechintergalactical.gtcore.data.GTCoreCables;
import io.github.gregtechintergalactical.gtcore.data.GTCoreItems;
import io.github.gregtechintergalactical.gtcore.data.GTCoreTags;
import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.data.AntimatterMaterialTypes;
import muramasa.antimatter.data.ForgeCTags;
import muramasa.antimatter.datagen.providers.AntimatterRecipeProvider;
import muramasa.antimatter.item.ItemBasic;
import muramasa.antimatter.item.ItemCover;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialItem;
import muramasa.antimatter.pipe.PipeSize;
import muramasa.antimatter.recipe.ingredient.PropertyIngredient;
import muramasa.gregtech.GTIRef;
import muramasa.gregtech.GregTech;
import muramasa.gregtech.data.GregTechBlocks;
import muramasa.gregtech.data.GregTechCovers;
import muramasa.gregtech.data.GregTechItems;
import muramasa.gregtech.data.ToolTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.tags.TagKey;
import java.util.Arrays;
import java.util.function.Consumer;

import static com.google.common.collect.ImmutableMap.of;
import static io.github.gregtechintergalactical.gtcore.data.GTCoreItems.*;
import static io.github.gregtechintergalactical.gtcore.data.GTCoreTags.*;
import static muramasa.antimatter.data.AntimatterMaterials.*;
import static muramasa.antimatter.data.AntimatterMaterialTypes.*;
import static muramasa.antimatter.data.AntimatterDefaultTools.*;
import static muramasa.antimatter.machine.Tier.*;
import static muramasa.gregtech.data.GregTechItems.*;
import static muramasa.gregtech.data.Materials.*;
import static muramasa.gregtech.data.TierMaps.*;

public class Parts {
  public static void loadRecipes(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider) {
      tieredItems(output, provider);
      molds(output, provider);
      provider.shapeless(output, "nether_quartz_from_milky_quartz","parts", new ItemStack(Items.QUARTZ), GEM.getMaterialTag(MilkyQuartz));
      provider.shapeless(output, "fire_clay_dust", "parts", AntimatterMaterialTypes.DUST.get(Fireclay, 2),
              AntimatterMaterialTypes.DUST.getMaterialTag(Brick), AntimatterMaterialTypes.DUST.getMaterialTag(Clay));

      provider.addStackRecipe(output, GTIRef.ID, "drain_expensive", "parts",
              new ItemStack(GregTech.get(ItemCover.class, "drain"), 1), of('A', PLATES_IRON_ALUMINIUM, 'B', Items.IRON_BARS), "ABA", "B B", "ABA");

      provider.addItemRecipe(output, "gtparts", SELECTOR_TAG_ITEMS.get(0),
              of('G', GEAR_SMALL.getMaterialTag(Iron), 'R', ROD.getMaterialTag(Iron), 'W', WRENCH.getTag(), 'H', HAMMER.getTag()), "GHG", "RRR", "GWG");

      provider.shapeless(output, GTIRef.ID, "", "carbon", new ItemStack(CarbonMesh), CarbonFibre, CarbonFibre);
      provider.addItemRecipe(output, GTIRef.ID, "", "carbon", CoalBall,
              of('F', Items.FLINT, 'C', DUST.getMaterialTag(Coal)), "CCC", "CFC", "CCC");
      provider.addItemRecipe(output, GTIRef.ID, "", "carbon", CoalChunk,
              of('F', Items.OBSIDIAN, 'C', CompressedCoalBall), "CCC", "CFC", "CCC");
      provider.addItemRecipe(output, GTIRef.ID, "","batteries", GTCoreItems.BatteryHullSmall, of(
              'P', PLATE.get(BatteryAlloy),
              'C', CABLE_GETTER.apply(PipeSize.VTINY, LV, false)
      ), "C", "P", "P");

      provider.addItemRecipe(output,  GTIRef.ID, "","batteries", GTCoreItems.BatteryHullMedium, of(
              'P', PLATE.get(BatteryAlloy),
              'C', CABLE_GETTER.apply(PipeSize.VTINY, MV, false)
      ), "C C", "PPP", "PPP");
      provider.addStackRecipe(output, GTIRef.ID, "", "batteries", DUST.get(Energium, 9),
              of('R', DUST.getMaterialTag(Redstone), 'r', DUST.getMaterialTag(Ruby)), "RrR", "rRr", "RrR");


      provider.addItemRecipe(output, GTIRef.ID, "diamondsaw_blade", "gtparts", DiamondSawBlade, of(
              'G', GEAR.get(CobaltBrass),
              'D', DUST_SMALL.get(Diamond)
      ), " D ", "DGD", " D ");

      provider.addItemRecipe(output, "mining_pipes", GregTechBlocks.MINING_PIPE_THIN,
              of('H', HAMMER.getTag(), 'P', GregTechBlocks.FLUID_PIPE_STEEL.getBlockItem(PipeSize.SMALL), 'F', FILE.getTag()), "HPF");
      provider.addStackRecipe(output, GTIRef.ID, "", "matches", new ItemStack(Match, 4), of('P', DUST.getMaterialTag(Phosphor), 'S', ROD.getMaterialTag(Wood)), "P", "S");
      provider.shapeless(output, GTIRef.ID, "tape_from_empty", "tapes", new ItemStack(Tape), TapeEmpty, TapeEmpty, TapeEmpty, TapeEmpty);
      provider.shapeless(output, GTIRef.ID, "duct_tape_from_empty", "tapes", new ItemStack(DuctTape), DuctTapeEmpty, DuctTapeEmpty, DuctTapeEmpty, DuctTapeEmpty);
      provider.shapeless(output, GTIRef.ID, "fal_duct_tape_from_empty", "tapes", new ItemStack(FALDuctTape), FALDuctTapeEmpty, FALDuctTapeEmpty, FALDuctTapeEmpty, FALDuctTapeEmpty);
      provider.addItemRecipe(output, GTIRef.ID, "", "tapes", Tape, of('P', Items.PAPER, 'G', Glue.getLiquid().getBucket()), "PPP", " G ");
      provider.addItemRecipe(output, GTIRef.ID, "", "tapes", DuctTape, of('P', FOIL.getMaterialTag(Plastic), 'G', Glue.getLiquid().getBucket()), "PPP", " G ");
      provider.addItemRecipe(output, GTIRef.ID, "", "tapes", FALDuctTape, of('P', FOIL.getMaterialTag(Tungsten), 'G', Glue.getLiquid().getBucket()), "PPP", " G ");
      provider.shapeless(output, GTIRef.ID, "data_stick_clearing", "data_sticks", new ItemStack(GregTechItems.DataStick), GregTechItems.DataStick);
      provider.shapeless(output, GTIRef.ID, "fluid_filter_reset", "filters", GregTechCovers.COVER_FLUID_FILTER.getItem(), GregTechCovers.COVER_FLUID_FILTER.getItem().getItem());
      provider.shapeless(output, GTIRef.ID, "item_filter_reset", "filters", GregTechCovers.COVER_ITEM_FILTER.getItem(), GregTechCovers.COVER_ITEM_FILTER.getItem().getItem());
      provider.shapeless(output, GTIRef.ID, "item_retriever_reset", "filters", GregTechCovers.COVER_ITEM_RETRIEVER.getItem(), GregTechCovers.COVER_ITEM_RETRIEVER.getItem().getItem());
      provider.addItemRecipe(output, "covers", GregTechCovers.COVER_PROGRESS_SENSOR.getItem().getItem(), of('W', CABLE_GETTER.apply(PipeSize.VTINY, LV, false), 'A', PLATE.getMaterialTag(Aluminium), 'G', GEAR_SMALL.getMaterialTag(Brass), 'C', CIRCUITS_GOOD), "WAW", "GCG");
      provider.addItemRecipe(output, "covers", GregTechCovers.COVER_REDSTONE_CONDUCTOR_ACCEPT.getItem().getItem(), of('W', GTCoreCables.WIRE_RED_ALLOY.getBlock(PipeSize.VTINY), 'A', PLATE.getMaterialTag(Aluminium)), "W", "A");
      provider.addItemRecipe(output, "covers", GregTechCovers.COVER_REDSTONE_CONDUCTOR_EMIT.getItem().getItem(), of('W', GTCoreCables.WIRE_RED_ALLOY.getBlock(PipeSize.VTINY), 'A', PLATE.getMaterialTag(Aluminium)), "A", "W");
      provider.shapeless(output, GTIRef.ID, "redstone_conductor_accept_conversion", "covers", GregTechCovers.COVER_REDSTONE_CONDUCTOR_EMIT.getItem(), GregTechCovers.COVER_REDSTONE_CONDUCTOR_ACCEPT.getItem().getItem());
      provider.shapeless(output, GTIRef.ID, "redstone_conductor_emit_conversion", "covers", GregTechCovers.COVER_REDSTONE_CONDUCTOR_ACCEPT.getItem(), GregTechCovers.COVER_REDSTONE_CONDUCTOR_EMIT.getItem().getItem());
      provider.addItemRecipe(output, "covers", GregTechCovers.COVER_ITEM_RETRIEVER.getItem().getItem(),
              of('C', CIRCUITS_ADVANCED, 'F', GregTechCovers.COVER_ITEM_FILTER.getItem().getItem(), 'E', PLATE.getMaterialTag(Electrum), 'P', PistonLV), "EPE", "CFC");
      provider.addItemRecipe(output, "misc", DiamondGrindHead, of('D', DUST.getMaterialTag(Diamond), 'G', GEM.getMaterialTag(Diamond), 'S', PLATE.getMaterialTag(Steel)), "DSD", "SGS", "DSD");
      provider.addItemRecipe(output, "misc", TungstenGrindHead, of('D', PLATE.getMaterialTag(Tungsten), 'G', GEM.getMaterialTag(Diamond), 'S', PLATE.getMaterialTag(Steel)), "DSD", "SGS", "DSD");
      provider.addItemRecipe(output, "hazmat", UniversalHazardSuitMask, of('L', PLATE.getMaterialTag(Lead), 'A', PLATE.getMaterialTag(Aluminium), 'C', Items.CHAINMAIL_HELMET, 'G', Items.GLASS_PANE), "ALA", "LCL", "AGA");
      provider.addItemRecipe(output, "hazmat", UniversalHazardSuitShirt, of('L', PLATE.getMaterialTag(Lead), 'A', PLATE.getMaterialTag(Aluminium), 'C', Items.CHAINMAIL_CHESTPLATE), "ALA", "LCL", "ALA");
      provider.addItemRecipe(output, "hazmat", UniversalHazardSuitPants, of('L', PLATE.getMaterialTag(Lead), 'A', PLATE.getMaterialTag(Aluminium), 'C', Items.CHAINMAIL_LEGGINGS), "ALA", "LCL", "ALA");
      provider.addItemRecipe(output, "hazmat", UniversalHazardSuitBoots, of('L', PLATE.getMaterialTag(Lead), 'A', PLATE.getMaterialTag(Aluminium), 'C', Items.CHAINMAIL_BOOTS), "ALA", "LCL", "ALA");
      provider.addItemRecipe(output, "misc", EmptyGeigerCounter,
              of('S', SCREW.getMaterialTag(Aluminium), 'P', PLATE.getMaterialTag(Aluminium), 'C', CellTin, 'c', TIER_CIRCUITS.apply(LV), 's', SCREWDRIVER.getTag()), "SCS", "PcP", "SsS");
      provider.addStackRecipe(/*ToolTypes.SCANNER_BUILDER.get("portable-scanner"), */output, GTIRef.ID, "scanner", "misc", new ItemStack(GregTechItems.PortableScanner),
              of('E', EmitterHV, 'A', PLATE.getMaterialTag(Aluminium), 'S', SensorHV, 'C', CIRCUITS_ADVANCED, 'c', ComputerMonitor, 'B',  BatteryMediumLithium/*PropertyIngredient.builder("battery").itemStacks(BatteryMediumLithium).build()*/), "EAS", "CcC", "ABA");
      provider.addItemRecipe(output, "misc", ComputerMonitor,
              of('A', PLATE.getMaterialTag(Aluminium), 'P', PLATE.getMaterialTag(Glass), 'g', ForgeCTags.DYES_GREEN, 'b', ForgeCTags.DYES_BLUE, 'r', ForgeCTags.DYES_RED, 'G', DUST.getMaterialTag(Glowstone)), "AgA", "rPb", "AGA");
  }

  private static void tieredItems(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider){
      Arrays.stream(Tier.getStandardWithIV()).forEach(t -> {
          Material magnet = (t == Tier.ULV || t == LV) ? IronMagnetic
                  : (t == Tier.EV || t == Tier.IV ? NeodymiumMagnetic : SteelMagnetic);
          Object cable = CABLE_GETTER.apply(PipeSize.VTINY, t, false);
          Material mat = TIER_MATERIALS.get(t);
          // Item smallGear = GEAR_SMALL.get(mat);
          Item smallGear = GEAR.get(mat);
          TagKey<Item> plate = PLATE.getMaterialTag(mat);
          TagKey<Item> rod = ROD.getMaterialTag(mat);
          TagKey<Item> circuit = TIER_CIRCUITS.apply(t);

          Item motor = AntimatterAPI.get(ItemBasic.class, "motor_" + t.getId(), GTCore.ID);
          Item piston = GregTech.get(ItemBasic.class, "piston_" + t.getId());
          Item robotArm = GregTech.get(ItemCover.class, "robot_arm_" + t.getId());
          Item emitter = GregTech.get(ItemBasic.class, "emitter_" + t.getId());
          Item sensor = GregTech.get(ItemBasic.class, "sensor_" + t.getId());
          Item pump = GregTech.get(ItemCover.class, "pump_" + t.getId());
          Item conveyor = GregTech.get(ItemCover.class, "conveyor_" + t.getId());
          Item fieldGen = GregTech.get(ItemBasic.class, "field_gen_" + t.getId());
          Object emitterRod = ROD.getMaterialTag(EMITTER_RODS.get(t));
          Object wire = t == EV || t == IV ? GregTechBlocks.WIRE_ANNEALED_COPPER.getBlock(fromTier(t)) : WIRE_GETTER.apply(fromTier(t), LV);
          provider.addItemRecipe(output, "gtparts", motor,
                  of('M', ROD.get(magnet), 'C', cable, 'W', wire, 'R', rod), "CWR", "WMW", "RWC");
          provider.addItemRecipe(output, "gtparts", piston,
                  of('M', motor, 'C', cable, 'G', smallGear, 'P', plate, 'R', rod), "PPP", "CRR", "CMG");
          provider.addItemRecipe(output, "gtparts", conveyor,
                  of('M', motor, 'C', cable, 'P', PLATE.get(Rubber)), "PPP", "MCM", "PPP");
          provider.addItemRecipe(output, "gtparts", robotArm,
                  of('M', motor, 'C', cable, 'P', piston, 'I', circuit, 'R', rod), "CCC", "MRM", "PIR");
          provider.addItemRecipe(output, "gtparts", emitter,
                  of('R', emitterRod, 'G', ForgeCTags.GEMS_QUARTZ_ALL, 'L', cable, 'C', circuit), "RRC", "LGR", "CLR");
          provider.addItemRecipe(output, "gtparts", sensor,
                  of('R', emitterRod, 'G', ForgeCTags.GEMS_QUARTZ_ALL, 'C', circuit, 'P', plate), "P G", "PR ", "CPP");
          PipeSize osmium = t == IV ? PipeSize.HUGE : PipeSize.values()[t.getIntegerId() - 1];
          provider.addItemRecipe(output, "gtparts", fieldGen,
                  of('O', GregTechBlocks.WIRE_OSMIUM.getBlockItem(osmium), 'C', circuit, 'G', ROD_LONG.getMaterialTag(NeodymiumMagnetic)), "OCO", "CGC", "OCO");
          Material rotorMat = TIER_ROTORS.get(t);
          provider.addItemRecipe(output, "gtparts", pump,
                  ImmutableMap.<Character, Object>builder().put('M', motor).put('C', cable).put('W', WRENCH.getTag())
                          .put('S', SCREWDRIVER.getTag()).put('R', SCREW.getMaterialTag(rotorMat)).put('T', ROTOR.getMaterialTag(rotorMat))
                          .put('O', RING.get(Rubber)).put('P', TIER_PIPES.get(t).apply(PipeSize.NORMAL))
                          .build(),
                  "RTO", "SPW", "OMC");
      });
  }

  private static void molds(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider){
      provider.addItemRecipe(output, GTIRef.ID, "empty_shape", "gtparts", EmptyShape, of(
              'P', PLATE.get(Steel),
              'H', HAMMER.getTag(),
              'F', FILE.getTag()
      ), "HF","PP", "PP");
      moldRecipe(output, provider, MoldPlate, "H", "P");
      moldRecipe(output, provider, MoldIngot, "P", "H");
      moldRecipe(output, provider, MoldCasing, " H", "P ");
      moldRecipe(output, provider, MoldGear, "PH");
      moldRecipe(output, provider, MoldCoinage, "H ", " P");
      moldRecipe(output, provider, MoldBottle, "P ", " H");
      moldRecipe(output, provider, MoldBall, " P", "H ");
      moldRecipe(output, provider, MoldBlock, "HP");
      moldRecipe(output, provider, MoldNugget, "P H");
      //moldRecipe(output, provider, MoldBuns, "P  ", "  H");
      //moldRecipe(output, provider, MoldBread, "P  ", "   ", "  H");
      //moldRecipe(output, provider, MoldBaguettes, "P ", "  ", " H");
      moldRecipe(output, provider, MoldAnvil, " P", "  ", "H ");
      moldRecipe(output, provider, MoldGearSmall, "H P");
      moldRecipe(output, provider, MoldLongRod, "  H", "P  ");

      shapeRecipe(output, provider, ShapeFoil, ShapePlate, "H ", " P");
      shapeRecipe(output, provider, ShapeRod, ShapeLongRod, " H", "P ");
      shapeRecipe(output, provider, ShapeRod, "PH");
      shapeRecipe(output, provider, ShapeRod, ShapeBolt, "H ", " P");
      shapeRecipe(output, provider, ShapeRing, "P", "H");
      shapeRecipe(output, provider, ShapeRing, ShapeCell, "PH");
      shapeRecipe(output, provider, ShapeIngot, "H ", " P");
      shapeRecipe(output, provider, ShapeRod, ShapeWire, "H", "P");
      shapeRecipe(output, provider, ShapeFoil, ShapeCasing, "H", "P");
      shapeRecipe(output, provider, ShapePipeTiny, " H", "  ", "P ");
      shapeRecipe(output, provider, ShapePipeSmall, "P  ", "  H");
      shapeRecipe(output, provider, ShapePipeNormal, "P ", "  ", " H");
      shapeRecipe(output, provider, ShapePipeLarge, "P  ", "   ", "  H");
      shapeRecipe(output, provider, ShapePipeHuge, "  H", "   ", "P  ");
      shapeRecipe(output, provider, ShapeIngot, ShapeBlock, "H ", " P");
      shapeRecipe(output, provider, ShapeTinyPlate, ShapeBladeSword, "PH");
      shapeRecipe(output, provider, ShapeIngot, ShapeHeadPickaxe, "H", "P");
      shapeRecipe(output, provider, ShapeTinyPlate, ShapeHeadShovel, "H", "P");
      shapeRecipe(output, provider, ShapeTinyPlate, ShapeHeadAxe, "H ", " P");
      shapeRecipe(output, provider, ShapeIngot, ShapeHeadHoe, "PH");
      shapeRecipe(output, provider, ShapeIngot, ShapeHeadHammer, " H", "P ");
      shapeRecipe(output, provider, ShapeTinyPlate, ShapeHeadFile, " H", "P ");
      shapeRecipe(output, provider, ShapeTinyPlate, ShapeBladeSaw, "P ", " H");
      shapeRecipe(output, provider, ShapeRing, ShapeGear, "H ", " P");
      shapeRecipe(output, provider, ShapeRing, ShapeBottle, " H", "P ");
      shapeRecipe(output, provider, ShapeRing, ShapeGearSmall, "H", "P");
      shapeRecipe(output, provider, ShapeFoil, "P ", " H");
      shapeRecipe(output, provider, ShapeTinyPlate, "H", "P");
      shapeRecipe(output, provider, ShapeRod, ShapeFineWire, "PH");
  }

  private static void moldRecipe(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider, Item mold, String... shapes){
      provider.addItemRecipe(output, GTIRef.ID, "", "gtparts", mold,
              of('P', EmptyShape, 'H', HAMMER.getTag()), shapes);
  }

    private static void shapeRecipe(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider, Item inputMold, Item mold, String... shapes){
        provider.addItemRecipe(output, GTIRef.ID, "", "gtparts", mold,
                of('P', inputMold, 'H', WIRE_CUTTER.getTag()), shapes);
    }

    private static void shapeRecipe(Consumer<FinishedRecipe> output, AntimatterRecipeProvider provider, Item mold, String... shapes){
        shapeRecipe(output, provider, EmptyShape, mold, shapes);
    }

  public static PipeSize fromTier(Tier tier){
      if (tier == LV) return PipeSize.VTINY;
      if (tier == MV) return PipeSize.TINY;
      if (tier == HV) return PipeSize.SMALL;
      if (tier == IV) return PipeSize.HUGE;
      return PipeSize.NORMAL;
  }
}
