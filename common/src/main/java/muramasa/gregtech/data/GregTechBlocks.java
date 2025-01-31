package muramasa.gregtech.data;

import muramasa.antimatter.AntimatterAPI;
import muramasa.antimatter.block.BlockBasic;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.pipe.PipeSize;
import muramasa.antimatter.pipe.types.Cable;
import muramasa.antimatter.pipe.types.FluidPipe;
import muramasa.antimatter.pipe.types.ItemPipe;
import muramasa.antimatter.pipe.types.Wire;
import muramasa.antimatter.texture.Texture;
import muramasa.gregtech.GTIRef;
import muramasa.gregtech.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import static muramasa.gregtech.data.Materials.*;

public class GregTechBlocks {

    public static final LiquidBlock LAVA = AntimatterAPI.register(Block.class, "lava", GTIRef.ID, new LiquidBlock(Fluids.LAVA, BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.LAVA).noCollission().randomTicks().strength(100.0F).lightLevel((blockStatex) -> 15).noDrops()){
        @Override
        public ItemStack pickupBlock(LevelAccessor level, BlockPos pos, BlockState state) {
            return ItemStack.EMPTY;
        }
    });
    public static final BlockBasic BRITTLE_CHARCOAL = new BlockBasic(GTIRef.ID, "brittle_charcoal", BlockBehaviour.Properties.of(net.minecraft.world.level.material.Material.WOOD, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.0F, 6.0F)){
        @Override
        public Texture[] getTextures() {
            return new Texture[]{new Texture("minecraft:block/coal_block")};
        }
    };
    public static final BlockBasic SOLID_SUPER_FUEL = new BlockBasic(GTIRef.ID, "solid_super_fuel", BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.0F, 6.0F)){
        @Override
        public Texture[] getTextures() {
            return new Texture[]{new Texture("minecraft:block/coal_block")};
        }
    };

    public static final BlockBasic POWDER_BARREL = new BlockPowderBarrel();
    public static final BlockBasic MINING_PIPE_THIN = new BlockMiningPipe(GTIRef.ID, "mining_pipe_thin", BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(1.0f, 3.0f));
    public static final BlockBasic MINING_PIPE = new BlockMiningPipe(GTIRef.ID, "mining_pipe", BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GRAY).strength(1.0f, 3.0f));
    public static final BlockAsphalt WHITE_ASPHALT = new BlockAsphalt(GTIRef.ID, "white_asphalt", DyeColor.WHITE.getTextColor());
    public static final BlockAsphalt ORANGE_ASPHALT = new BlockAsphalt(GTIRef.ID, "orange_asphalt", DyeColor.ORANGE.getTextColor());
    public static final BlockAsphalt MAGENTA_ASPHALT = new BlockAsphalt(GTIRef.ID, "magenta_asphalt", DyeColor.MAGENTA.getTextColor());
    public static final BlockAsphalt LIGHT_BLUE_ASPHALT = new BlockAsphalt(GTIRef.ID, "light_blue_asphalt", DyeColor.LIGHT_BLUE.getTextColor());
    public static final BlockAsphalt YELLOW_ASPHALT = new BlockAsphalt(GTIRef.ID, "yellow_asphalt", DyeColor.YELLOW.getTextColor());
    public static final BlockAsphalt LIME_ASPHALT = new BlockAsphalt(GTIRef.ID, "lime_asphalt", DyeColor.LIME.getTextColor());
    public static final BlockAsphalt PINK_ASPHALT = new BlockAsphalt(GTIRef.ID, "pink_asphalt", DyeColor.PINK.getTextColor());
    public static final BlockAsphalt GRAY_ASPHALT = new BlockAsphalt(GTIRef.ID, "gray_asphalt", DyeColor.GRAY.getTextColor());
    public static final BlockAsphalt LIGHT_GRAY_ASPHALT = new BlockAsphalt(GTIRef.ID, "light_gray_asphalt", DyeColor.LIGHT_GRAY.getTextColor());
    public static final BlockAsphalt CYAN_ASPHALT = new BlockAsphalt(GTIRef.ID, "cyan_asphalt", DyeColor.CYAN.getTextColor());
    public static final BlockAsphalt PURPLE_ASPHALT = new BlockAsphalt(GTIRef.ID, "purple_asphalt", DyeColor.PURPLE.getTextColor());
    public static final BlockAsphalt BLUE_ASPHALT = new BlockAsphalt(GTIRef.ID, "blue_asphalt", DyeColor.BLUE.getTextColor());
    public static final BlockAsphalt BROWN_ASPHALT = new BlockAsphalt(GTIRef.ID, "brown_asphalt", DyeColor.BROWN.getTextColor());
    public static final BlockAsphalt GREEN_ASPHALT = new BlockAsphalt(GTIRef.ID, "green_asphalt", DyeColor.GREEN.getTextColor());
    public static final BlockAsphalt RED_ASPHALT = new BlockAsphalt(GTIRef.ID, "red_asphalt", DyeColor.RED.getTextColor());
    public static final BlockAsphalt BLACK_ASPHALT = new BlockAsphalt(GTIRef.ID, "black_asphalt", DyeColor.BLACK.getTextColor());
    public static final BlockAsphaltSlab WHITE_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "white_asphalt_slab", DyeColor.WHITE.getTextColor());
    public static final BlockAsphaltSlab ORANGE_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "orange_asphalt_slab", DyeColor.ORANGE.getTextColor());
    public static final BlockAsphaltSlab MAGENTA_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "magenta_asphalt_slab", DyeColor.MAGENTA.getTextColor());
    public static final BlockAsphaltSlab LIGHT_BLUE_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "light_blue_asphalt_slab", DyeColor.LIGHT_BLUE.getTextColor());
    public static final BlockAsphaltSlab YELLOW_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "yellow_asphalt_slab", DyeColor.YELLOW.getTextColor());
    public static final BlockAsphaltSlab LIME_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "lime_asphalt_slab", DyeColor.LIME.getTextColor());
    public static final BlockAsphaltSlab PINK_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "pink_asphalt_slab", DyeColor.PINK.getTextColor());
    public static final BlockAsphaltSlab GRAY_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "gray_asphalt_slab", DyeColor.GRAY.getTextColor());
    public static final BlockAsphaltSlab LIGHT_GRAY_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "light_gray_asphalt_slab", DyeColor.LIGHT_GRAY.getTextColor());
    public static final BlockAsphaltSlab CYAN_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "cyan_asphalt_slab", DyeColor.CYAN.getTextColor());
    public static final BlockAsphaltSlab PURPLE_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "purple_asphalt_slab", DyeColor.PURPLE.getTextColor());
    public static final BlockAsphaltSlab BLUE_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "blue_asphalt_slab", DyeColor.BLUE.getTextColor());
    public static final BlockAsphaltSlab BROWN_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "brown_asphalt_slab", DyeColor.BROWN.getTextColor());
    public static final BlockAsphaltSlab GREEN_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "green_asphalt_slab", DyeColor.GREEN.getTextColor());
    public static final BlockAsphaltSlab RED_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "red_asphalt_slab", DyeColor.RED.getTextColor());
    public static final BlockAsphaltSlab BLACK_ASPHALT_SLAB = new BlockAsphaltSlab(GTIRef.ID, "black_asphalt_slab", DyeColor.BLACK.getTextColor());

    public static final BlockAsphaltStair WHITE_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "white_asphalt_stairs", WHITE_ASPHALT, DyeColor.WHITE.getTextColor());
    public static final BlockAsphaltStair ORANGE_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "orange_asphalt_stairs", ORANGE_ASPHALT, DyeColor.ORANGE.getTextColor());
    public static final BlockAsphaltStair MAGENTA_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "magenta_asphalt_stairs", MAGENTA_ASPHALT, DyeColor.MAGENTA.getTextColor());
    public static final BlockAsphaltStair LIGHT_BLUE_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "light_blue_asphalt_stairs", LIGHT_BLUE_ASPHALT, DyeColor.LIGHT_BLUE.getTextColor());
    public static final BlockAsphaltStair YELLOW_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "yellow_asphalt_stairs", YELLOW_ASPHALT, DyeColor.YELLOW.getTextColor());
    public static final BlockAsphaltStair LIME_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "lime_asphalt_stairs", LIME_ASPHALT, DyeColor.LIME.getTextColor());
    public static final BlockAsphaltStair PINK_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "pink_asphalt_stairs", PINK_ASPHALT, DyeColor.PINK.getTextColor());
    public static final BlockAsphaltStair GRAY_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "gray_asphalt_stairs", GRAY_ASPHALT, DyeColor.GRAY.getTextColor());
    public static final BlockAsphaltStair LIGHT_GRAY_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "light_gray_asphalt_stairs", LIGHT_GRAY_ASPHALT, DyeColor.LIGHT_GRAY.getTextColor());
    public static final BlockAsphaltStair CYAN_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "cyan_asphalt_stairs", CYAN_ASPHALT, DyeColor.CYAN.getTextColor());
    public static final BlockAsphaltStair PURPLE_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "purple_asphalt_stairs", PURPLE_ASPHALT, DyeColor.PURPLE.getTextColor());
    public static final BlockAsphaltStair BLUE_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "blue_asphalt_stairs", BLUE_ASPHALT, DyeColor.BLUE.getTextColor());
    public static final BlockAsphaltStair BROWN_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "brown_asphalt_stairs", BROWN_ASPHALT, DyeColor.BROWN.getTextColor());
    public static final BlockAsphaltStair GREEN_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "green_asphalt_stairs", GREEN_ASPHALT, DyeColor.GREEN.getTextColor());
    public static final BlockAsphaltStair RED_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "red_asphalt_stairs", RED_ASPHALT, DyeColor.RED.getTextColor());
    public static final BlockAsphaltStair BLACK_ASPHALT_STAIR = new BlockAsphaltStair(GTIRef.ID, "black_asphalt_stairs", BLACK_ASPHALT, DyeColor.BLACK.getTextColor());
    public static final BlockCasing CASING_ULV = new BlockCasing(GTIRef.ID, "casing_ulv");
    public static final BlockCasing CASING_LV = new BlockCasing(GTIRef.ID, "casing_lv");
    public static final BlockCasing CASING_MV = new BlockCasing(GTIRef.ID, "casing_mv");
    public static final BlockCasing CASING_HV = new BlockCasing(GTIRef.ID, "casing_hv");
    public static final BlockCasing CASING_EV = new BlockCasing(GTIRef.ID, "casing_ev");
    public static final BlockCasing CASING_IV = new BlockCasing(GTIRef.ID, "casing_iv");
    public static final BlockCasing CASING_LUV = new BlockCasing(GTIRef.ID, "casing_luv");
    public static final BlockCasing CASING_ZPM = new BlockCasing(GTIRef.ID, "casing_zpm");
    public static final BlockCasing CASING_UV = new BlockCasing(GTIRef.ID, "casing_uv");
    public static final BlockCasing CASING_UHV = new BlockCasing(GTIRef.ID, "casing_uhv");
    public static final BlockColoredWall WOOD_WALL = new BlockColoredWall(GTIRef.ID, AntimatterMaterials.Wood, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final BlockColoredWall STEEL_WALL = new BlockColoredWall(GTIRef.ID, Steel);
    public static final BlockColoredWall INVAR_WALL = new BlockColoredWall(GTIRef.ID, Invar);
    public static final BlockColoredWall STAINLESS_STEEL_WALL = new BlockColoredWall(GTIRef.ID, StainlessSteel);
    public static final BlockColoredWall TITANIUM_WALL = new BlockColoredWall(GTIRef.ID, Titanium);
    public static final BlockColoredWall NETHERITE_WALL = new BlockColoredWall(GTIRef.ID, AntimatterMaterials.Netherite);
    public static final BlockColoredWall TUNGSTENSTEEL_WALL = new BlockColoredWall(GTIRef.ID, TungstenSteel);
    public static final BlockColoredWall TUNGSTEN_WALL = new BlockColoredWall(GTIRef.ID, Tungsten);
    public static final BlockCasing LONG_DIST_ITEM_PIPE = new BlockCasing(GTIRef.ID, "long_distance_item_pipe");
    public static final BlockCasing LONG_DIST_FLUID_PIPE = new BlockCasing(GTIRef.ID, "long_distance_fluid_pipe");
    public static final BlockCasing LONG_DIST_WIRE_EV = new BlockCasing(GTIRef.ID, "long_distance_wire_ev", Block.Properties.of(Material.WOOL).strength(1.0f, 10.0f).sound(SoundType.WOOL));
    public static final BlockCasing LONG_DIST_WIRE_IV = new BlockCasing(GTIRef.ID, "long_distance_wire_iv", Block.Properties.of(Material.WOOL).strength(1.0f, 10.0f).sound(SoundType.WOOL));
    public static final BlockCasing LONG_DIST_WIRE_LUV = new BlockCasing(GTIRef.ID, "long_distance_wire_luv", Block.Properties.of(Material.WOOL).strength(1.0f, 10.0f).sound(SoundType.WOOL));
    public static final BlockCasing LONG_DIST_WIRE_ZPM = new BlockCasing(GTIRef.ID, "long_distance_wire_zpm", Block.Properties.of(Material.WOOL).strength(1.0f, 10.0f).sound(SoundType.WOOL));
    public static final BlockCasing LONG_DIST_WIRE_UV = new BlockCasing(GTIRef.ID, "long_distance_wire_uv", Block.Properties.of(Material.WOOL).strength(1.0f, 10.0f).sound(SoundType.WOOL));
    public static final BlockFakeCasing CASING_FIRE_BRICK = new BlockFakeCasing(GTIRef.ID, "fire_bricks", BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT).strength(1.0f, 10.0f).sound(SoundType.STONE));
    public static final BlockCasing CASING_BRONZE = new BlockCasing(GTIRef.ID, "bronze_casing");
    public static final BlockCasing CASING_BRICKED_BRONZE = new BlockSidedCasing(GTIRef.ID, "bricked_bronze_casing", "brick", "bronze");
    public static final BlockCasing CASING_BRONZE_PLATED_BRICK = new BlockCasing(GTIRef.ID, "bronze_plated_brick_casing");
    public static final BlockCasing CASING_STEEL = new BlockCasing(GTIRef.ID, "steel_casing");
    public static final BlockCasing CASING_BRICKED_STEEL = new BlockSidedCasing(GTIRef.ID, "bricked_steel_casing", "brick", "steel");
    public static final BlockCasing CASING_SOLID_STEEL = new BlockCasing(GTIRef.ID, "solid_steel_casing");
    public static final BlockCasing CASING_STAINLESS_STEEL = new BlockCasing(GTIRef.ID, "stainless_steel_casing");
    public static final BlockCasing CASING_TITANIUM = new BlockCasing(GTIRef.ID, "titanium_casing");
    public static final BlockCasing CASING_TUNGSTENSTEEL = new BlockCasing(GTIRef.ID, "tungstensteel_casing");
    public static final BlockCasing CASING_BLACK_BRONZE = new BlockCasing(GTIRef.ID, "black_bronze_casing");
    public static final BlockCasing CASING_TUNGSTEN = new BlockCasing(GTIRef.ID, "tungsten_casing");
    public static final BlockCasing CASING_PLATINUM = new BlockCasing(GTIRef.ID, "platinum_casing");
    public static final BlockCasing CASING_HEAT_PROOF = new BlockCasing(GTIRef.ID, "heat_proof_casing");
    public static final BlockCasing CASING_FROST_PROOF = new BlockCasing(GTIRef.ID, "frost_proof_casing");
    public static final BlockCasing CASING_RADIATION_PROOF = new BlockCasing(GTIRef.ID, "radiation_proof_casing");
    public static final BlockCasing CASING_CHEMICALLY_INERT = new BlockCasing(GTIRef.ID, "chemically_inert_casing");
    public static final BlockCasing CASING_PLASTIC = new BlockCasing(GTIRef.ID, "plastic_casing");
    public static final BlockCasing CASING_DENSE_LEAD = new BlockCasing(GTIRef.ID, "dense_lead_casing");
    public static final BlockCasing CASING_FIREBOX_BRONZE = new BlockCasing(GTIRef.ID, "bronze_firebox_casing");
    public static final BlockCasing CASING_FIREBOX_STEEL = new BlockCasing(GTIRef.ID, "steel_firebox_casing");
    public static final BlockCasing CASING_FIREBOX_TITANIUM = new BlockCasing(GTIRef.ID, "titanium_firebox_casing");
    public static final BlockCasing CASING_FIREBOX_TUNGSTENSTEEL = new BlockCasing(GTIRef.ID, "tungstensteel_firebox_casing");
    public static final BlockCasing CASING_GEARBOX_BRONZE = new BlockCasing(GTIRef.ID, "bronze_gearbox_casing");
    public static final BlockCasing CASING_GEARBOX_STEEL = new BlockCasing(GTIRef.ID, "steel_gearbox_casing");
    public static final BlockCasing CASING_GEARBOX_TITANIUM = new BlockCasing(GTIRef.ID, "titanium_gearbox_casing");
    public static final BlockCasing CASING_GEARBOX_TUNGSTENSTEEL = new BlockCasing(GTIRef.ID, "tungstensteel_gearbox_casing");
    public static final BlockCasing CASING_PIPE_BRONZE = new BlockCasing(GTIRef.ID, "bronze_pipe_casing");
    public static final BlockCasing CASING_PIPE_STEEL = new BlockCasing(GTIRef.ID, "steel_pipe_casing");
    public static final BlockCasing CASING_PIPE_TITANIUM = new BlockCasing(GTIRef.ID, "titanium_pipe_casing");
    public static final BlockCasing CASING_PIPE_TUNGSTENSTEEL = new BlockCasing(GTIRef.ID, "tungstensteel_pipe_casing");
    public static final BlockCasing CASING_PIPE_PTFE = new BlockCasing(GTIRef.ID, "ptfe_pipe_casing");
    public static final BlockCasing CASING_ENGINE_INTAKE = new BlockCasing(GTIRef.ID, "engine_intake_casing");
    public static final BlockCasing CASING_FUSION = new BlockCasing(GTIRef.ID, "fusion_casing");
    public static final BlockCasing CASING_TURBINE_STEEL = new BlockCasing(GTIRef.ID, "steel_turbine_casing");
    public static final BlockCasing CASING_TURBINE_STAINLESS = new BlockCasing(GTIRef.ID, "stainless_steel_turbine_casing");
    public static final BlockCasing CASING_TURBINE_TITANIUM = new BlockCasing(GTIRef.ID, "titanium_turbine_casing");
    public static final BlockCasing CASING_TURBINE_TUNGSTENSTEEL = new BlockCasing(GTIRef.ID, "tungstensteel_turbine_casing");
    //todo make these active
    public static final BlockSidedCasing GRINDING_WHEELS = new BlockSidedCasing(GTIRef.ID, "grinding_wheels", "tungstensteel", "grinding_wheels_top");
    public static final BlockCasing ELECTROLYTIC_CELL = new BlockCasing(GTIRef.ID, "electrolytic_cell");
    public static final BlockSidedCasing ORE_WASHING_PARTS = new BlockSidedCasing(GTIRef.ID, "ore_washing_parts", "titanium", "ore_washing_parts_top");
    public static final BlockCoil COIL_CUPRONICKEL = new BlockCoil(GTIRef.ID, "cupronickel_coil", new BlockCoil.CoilData(1800, 0.5f, 8, 0));
    public static final BlockCoil COIL_KANTHAL = new BlockCoil(GTIRef.ID, "kanthal_coil", new BlockCoil.CoilData(2700, 1.0f, 16, 1));
    public static final BlockCoil COIL_NICHROME = new BlockCoil(GTIRef.ID, "nichrome_coil", new BlockCoil.CoilData(3600, 1.5f, 32, 2));
    public static final BlockCoil COIL_TUNGSTENSTEEL = new BlockCoil(GTIRef.ID, "tungstensteel_coil", new BlockCoil.CoilData(4500, 2.0f, 64,3));
    public static final BlockCoil COIL_HSSG = new BlockCoil(GTIRef.ID, "hssg_coil", new BlockCoil.CoilData(5400, 2.5f, 128,4));
    public static final BlockCoil COIL_NAQUADAH = new BlockCoil(GTIRef.ID, "naquadah_coil", new BlockCoil.CoilData(7200, 3.0f, 256,5));
    public static final BlockCoil COIL_NAQUADAH_ALLOY = new BlockCoil(GTIRef.ID, "naquadah_alloy_coil", new BlockCoil.CoilData(9001, 3.5f, 512,6));
    public static final BlockCoil COIL_FUSION = new BlockCoil(GTIRef.ID, "fusion_coil", new BlockCoil.CoilData(9001, 4.0f, 1024,7));
    public static final BlockCoil COIL_SUPERCONDUCTOR = new BlockCoil(GTIRef.ID, "superconductor_coil", new BlockCoil.CoilData(9001, 4.0f, 1024,7));
    public static final Cable<?> CABLE_SOLDERING_ALLOY = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, SolderingAlloy, 0.02, Tier.ULV).amps(1));
    public static final Cable<?> CABLE_COBALT = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Cobalt, 2, Tier.LV).amps(2)); //L);
    public static final Cable<?> CABLE_LEAD = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Lead, 2, Tier.LV).amps(2));
    public static final Cable<?> CABLE_TIN = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Tin, 1, Tier.LV).amps(1));
    public static final Cable<?> CABLE_ZINC = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Zinc, 1, Tier.LV).amps(1));
    public static final Cable<?> CABLE_IRON = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, AntimatterMaterials.Iron, 3, Tier.MV).amps(2)); //M);
    public static final Cable<?> CABLE_NICKEL = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Nickel, 3, Tier.MV).amps(3));
    public static final Cable<?> CABLE_CUPRONICKEL = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Cupronickel, 3, Tier.MV).amps(2));
    public static final Cable<?> CABLE_COPPER = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, AntimatterMaterials.Copper, 2, Tier.MV).amps(1));
    public static final Cable<?> CABLE_ANNEALED_COPPER = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, AnnealedCopper, 1, Tier.MV).amps(1));
    public static final Cable<?> CABLE_KANTHAL = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Kanthal, 3, Tier.HV).amps(4)); //H);
    public static final Cable<?> CABLE_GOLD = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, AntimatterMaterials.Gold, 2, Tier.HV).amps(3));
    public static final Cable<?> CABLE_ELECTRUM = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Electrum, 2, Tier.HV).amps(2));
    public static final Cable<?> CABLE_SILVER = AntimatterAPI.register(Cable.class,new Cable<>(GTIRef.ID, Silver, 1, Tier.HV).amps(1));
    public static final Cable<?> CABLE_NICHROME = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Nichrome, 4, Tier.EV).amps(3)); //E);
    public static final Cable<?> CABLE_STEEL = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Steel, 2, Tier.EV).amps(2));
    public static final Cable<?> CABLE_TITANIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Titanium, 2, Tier.EV).amps(4));
    public static final Cable<?> CABLE_ALUMINIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Aluminium, 1, Tier.EV).amps(1));
    public static final Cable<?> CABLE_GRAPHENE = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Graphene, 1, Tier.IV).amps(1)); //I);
    public static final Cable<?> CABLE_OSMIUM = AntimatterAPI.register(Cable.class,new Cable<>(GTIRef.ID, Osmium, 2, Tier.IV).amps(4));
    public static final Cable<?> CABLE_PLATINUM = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Platinum, 1, Tier.IV).amps(2));
    public static final Cable<?> CABLE_TUNGSTEN_STEEL = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, TungstenSteel, 2, Tier.IV).amps(3));
    public static final Cable<?> CABLE_TUNGSTEN = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Tungsten, 2, Tier.IV).amps(1));
    public static final Cable<?> CABLE_HSSG = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, HSSG, 2, Tier.LUV).amps(4)); //LU);
    public static final Cable<?> CABLE_NIOBIUM_TITANIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, NiobiumTitanium, 2, Tier.LUV).amps(4));
    public static final Cable<?> CABLE_VANADIUM_GALLIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, VanadiumGallium, 2, Tier.LUV).amps(4));
    public static final Cable<?> CABLE_YTTRIUM_BARIUM_CUPRATE = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, YttriumBariumCuprate, 4, Tier.LUV).amps(4));
    public static final Cable<?> CABLE_NAQUADAH = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Naquadah, 2, Tier.ZPM).amps(2)); //ZP);
    public static final Cable<?> CABLE_NAQUADAH_ALLOY = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, NaquadahAlloy, 4, Tier.ZPM).amps(2));
    public static final Cable<?> CABLE_DURANIUM = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Duranium, 8, Tier.ZPM).amps(1));
    public static final Cable<?> CABLE_SUPERCONDUCTOR = AntimatterAPI.register(Cable.class, new Cable<>(GTIRef.ID, Superconductor, 0.1, Tier.UHV).amps(4)).loss(0.1); //MA);
    public static final Wire<?> WIRE_SOLDERING_ALLOY = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, SolderingAlloy, 0.04, Tier.ULV).amps(1));
    public static final Wire<?> WIRE_COBALT = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Cobalt, 4, Tier.LV).amps(2)); //L);
    public static final Wire<?> WIRE_LEAD = AntimatterAPI.register(Wire.class,  new Wire<>(GTIRef.ID, Lead, 4, Tier.LV).amps(2));
    public static final Wire<?> WIRE_TIN = AntimatterAPI.register(Wire.class,  new Wire<>(GTIRef.ID, Tin, 2, Tier.LV).amps(1));
    public static final Wire<?> WIRE_ZINC = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Zinc, 2, Tier.LV).amps(1));
    public static final Wire<?> WIRE_IRON = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, AntimatterMaterials.Iron, 6, Tier.MV).amps(2)); //M);
    public static final Wire<?> WIRE_NICKEL = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Nickel, 6, Tier.MV).amps(3));
    public static final Wire<?> WIRE_CUPRONICKEL = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Cupronickel, 6, Tier.MV).amps(2));
    public static final Wire<?> WIRE_COPPER = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, AntimatterMaterials.Copper, 4, Tier.MV).amps(1));
    public static final Wire<?> WIRE_ANNEALED_COPPER = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, AnnealedCopper, 2, Tier.MV).amps(1));
    public static final Wire<?> WIRE_KANTHAL = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Kanthal, 6, Tier.HV).amps(4)); //H);
    public static final Wire<?> WIRE_GOLD = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, AntimatterMaterials.Gold, 4, Tier.HV).amps(3));
    public static final Wire<?> WIRE_ELECTRUM = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Electrum, 4, Tier.HV).amps(2));
    public static final Wire<?> WIRE_SILVER = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Silver, 2, Tier.HV).amps(1));
    public static final Wire<?> WIRE_NICHROME = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Nichrome, 8, Tier.EV).amps(3)); //E);
    public static final Wire<?> WIRE_STEEL = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Steel, 4, Tier.EV).amps(2));
    public static final Wire<?> WIRE_TITANIUM = AntimatterAPI.register(Wire.class,  new Wire<>(GTIRef.ID, Titanium, 4, Tier.EV).amps(4));
    public static final Wire<?> WIRE_ALUMINIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTIRef.ID, Aluminium, 2, Tier.EV).amps(1));
    public static final Wire<?> WIRE_GRAPHENE = AntimatterAPI.register(Wire.class,  new Wire<>(GTIRef.ID, Graphene, 2, Tier.IV).amps(1)); //I);
    public static final Wire<?> WIRE_OSMIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTIRef.ID, Osmium, 4, Tier.IV).amps(4));
    public static final Wire<?> WIRE_PLATINUM = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Platinum, 2, Tier.IV).amps(2));
    public static final Wire<?> WIRE_TUNGSTEN_STEEL = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, TungstenSteel, 2, Tier.IV).amps(3));
    public static final Wire<?> WIRE_TUNGSTEN = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, Tungsten, 2, Tier.IV).amps(1));
    public static final Wire<?> WIRE_HSSG = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, HSSG, 4, Tier.LUV).amps(4)); //LU);
    public static final Wire<?> WIRE_NIOBIUM_TITANIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTIRef.ID, NiobiumTitanium, 4, Tier.LUV).amps(4));
    public static final Wire<?> WIRE_VANADIUM_GALLIUM = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, VanadiumGallium, 4, Tier.LUV).amps(4));
    public static final Wire<?> WIRE_YTTRIUM_BARIUM_CUPRATE = AntimatterAPI.register(Wire.class, new Wire<>(GTIRef.ID, YttriumBariumCuprate, 8, Tier.LUV).amps(4));
    public static final Wire<?> WIRE_NAQUADAH = AntimatterAPI.register(Wire.class,new Wire<>(GTIRef.ID, Naquadah, 4, Tier.ZPM).amps(2)); //ZP);
    public static final Wire<?> WIRE_NAQUADAH_ALLOY = AntimatterAPI.register(Wire.class,new Wire<>(GTIRef.ID, NaquadahAlloy, 8, Tier.ZPM).amps(2));
    public static final Wire<?> WIRE_DURANIUM = AntimatterAPI.register(Wire.class,new Wire<>(GTIRef.ID, Duranium, 16, Tier.ZPM).amps(1));
    public static final Wire<?> WIRE_SUPERCONDUCTOR = (Wire<?>) AntimatterAPI.register(Wire.class,new Wire<>(GTIRef.ID, Superconductor, 1, Tier.UHV).amps(4)).loss(0.2); //MA);
    public static final FluidPipe<?> FLUID_PIPE_WOOD = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, AntimatterMaterials.Wood, 350, false).caps(1).pressures(getPressures(150)));
    public static final FluidPipe<?> FLUID_PIPE_COPPER = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, AntimatterMaterials.Copper, 1696, true).caps(1).pressures(getPressures(300)));
    public static final FluidPipe<?> FLUID_PIPE_BRONZE = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, Bronze, 1696, true).caps(1).pressures(getPressures(450)));
    // it's not in gt6, not sure whether to keep it or not
    //public static final FluidPipe<?> FLUID_PIPE_BISMUTH_BRONZE = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, BismuthBronze, 950, true).caps(1).pressures(800));
    //public static final FluidPipe<?> FLUID_PIPE_BLACK_STEEL = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, BlackSteel, 1200, true).caps(1).pressures(900));
    public static final FluidPipe<?> FLUID_PIPE_GOLD = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, AntimatterMaterials.Gold, 1671, true).acidProof(true).pressures(getPressures(300)));
    public static final FluidPipe<?> FLUID_PIPE_INVAR = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, Invar, 2395, true).caps(1).pressures(getPressures(600)).heatProof(true));
    public static final FluidPipe<?> FLUID_PIPE_STEEL = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, Steel, 2557, true).caps(1).pressures(getPressures(600)));
    public static final FluidPipe<?> FLUID_PIPE_CHROMIUM = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, Chromium, 2725, true).acidProof(true).pressures(getPressures(600)));
    public static final FluidPipe<?> FLUID_PIPE_STAINLESS_STEEL = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, StainlessSteel, 2428, true).acidProof(true).caps(1).pressures(getPressures(750)));
    public static final FluidPipe<?> FLUID_PIPE_NETHERRITE = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, AntimatterMaterials.Netherite, 2807, true).acidProof(true).caps(1).pressures(getPressures(900)));
    public static final FluidPipe<?> FLUID_PIPE_TUNGSTEN = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, Tungsten, 4618, true).acidProof(true).caps(1).pressures(getPressures(1050)));
    public static final FluidPipe<?> FLUID_PIPE_TITANIUM = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, Titanium, 1668, true).caps(1).pressures(getPressures(900)));
    public static final FluidPipe<?> FLUID_PIPE_TUNGSTEN_STEEL = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, TungstenSteel, 3587, true).caps(1).pressures(getPressures(1200)));
    public static final FluidPipe<?> FLUID_PIPE_TUNGSTEN_CARBIDE = AntimatterAPI.register(FluidPipe.class,new FluidPipe<>(GTIRef.ID, TungstenCarbide, 3837, true).caps(1).pressures(getPressures(1350)));
    public static final FluidPipe<?> FLUID_PIPE_VANADIUM_STEEL = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, VanadiumSteel, 2591, true).acidProof(true).pressures(getPressures(1200)));
    public static final FluidPipe<?> FLUID_PIPE_RUBBER = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, Rubber, 350, true).caps(1).pressures(getPressures(300)));
    public static final FluidPipe<?> FLUID_PIPE_PLASTIC = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, Plastic, 370, true).caps(1).pressures(getPressures(300)));
    public static final FluidPipe<?> FLUID_PIPE_PVC = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, PolyvinylChloride, 333, true).caps(1).pressures(getPressures(450)));
    public static final FluidPipe<?> FLUID_PIPE_HP = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, HighPressure, 3422, true).sizes(PipeSize.SMALL, PipeSize.NORMAL, PipeSize.LARGE).caps(1).pressures(10000));
    public static final FluidPipe<?> FLUID_PIPE_PLASMA = AntimatterAPI.register(FluidPipe.class, new FluidPipe<>(GTIRef.ID, PlasmaContainment, 100000, true).sizes(PipeSize.NORMAL).caps(1).pressures(100000));
    public static final ItemPipe<?> ITEM_PIPE_BRASS = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Brass).stepsize(32768).caps(0, 0, 0, 1, 2, 4));
    public static final ItemPipe<?> ITEM_PIPE_CUPRONICKEL = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Cupronickel).stepsize(32768).caps(0, 0, 0, 1, 2, 4));
    public static final ItemPipe<?> ITEM_PIPE_BLACK_BRONZE = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, BlackBronze).stepsize(16384).caps(0, 0, 0, 2, 4, 8));
    public static final ItemPipe<?> ITEM_PIPE_STERLING_SILVER = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, SterlingSilver).stepsize(16384).caps(0,0,0,2,4,8));
    public static final ItemPipe<?> ITEM_PIPE_ROSE_GOLD = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, RoseGold).stepsize(16384).caps(0,0,0,2,4,8));
    public static final ItemPipe<?> ITEM_PIPE_ELECTRUM = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Electrum).stepsize(16384).caps(0, 0, 0, 2, 4, 8));
    public static final ItemPipe<?> ITEM_PIPE_MAGNALIUM = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Magnalium).stepsize(16384).caps(0, 0, 0, 2, 4, 8));
    public static final ItemPipe<?> ITEM_PIPE_PLATINUM = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Platinum).stepsize(8192).caps(0, 0, 0, 4, 8, 16));
    public static final ItemPipe<?> ITEM_PIPE_OSMIUM = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Osmium).stepsize(4096).caps(0, 0, 0, 8, 16, 32));
    public static final ItemPipe<?> ITEM_PIPE_ULTIMET = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Ultimet).stepsize(2048).caps(0, 0, 0, 16, 32, 64));
    //public static final ItemPipe<?> ITEM_PIPE_HC = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, HighCapacity).stepsize(4096).caps(64));
    public static final ItemPipe<?> ITEM_PIPE_OSMIRIDIUM = AntimatterAPI.register(ItemPipe.class, new ItemPipe<>(GTIRef.ID, Osmiridium).stepsize(1024).caps(0, 0, 0, 32, 64, 128));

    public static void init(){
    }

    //public static final HeatPipe<?> HEAT_PIPE_COPPER = AntimatterAPI.register(HeatPipe.class, new HeatPipe<>(GTIRef.ID, Copper, 386).sizes(PipeSize.SMALL));
    private static int[] getPressures(int basePressure){
        basePressure *= 20;
        return new int[]{basePressure / 6, basePressure / 6, basePressure / 3, basePressure, basePressure * 2, basePressure * 4};
    }
}
