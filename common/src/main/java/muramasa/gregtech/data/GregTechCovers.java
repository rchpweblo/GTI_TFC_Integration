package muramasa.gregtech.data;

import earth.terrarium.botarium.common.fluid.base.PlatformFluidItemHandler;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;
import muramasa.antimatter.Ref;
import muramasa.antimatter.blockentity.pipe.BlockEntityItemPipe;
import muramasa.antimatter.cover.CoverFactory;
import muramasa.antimatter.item.ItemCover;
import muramasa.antimatter.machine.Tier;
import muramasa.antimatter.texture.Texture;
import muramasa.gregtech.GTIRef;
import muramasa.gregtech.cover.*;
import muramasa.gregtech.cover.redstone.*;
import muramasa.gregtech.items.ItemCoverCustomTooltip;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;
import tesseract.FluidPlatformUtils;

public class GregTechCovers {
    public static final CoverFactory COVER_CONVEYOR = CoverFactory.builder(CoverConveyor::new).gui().item((a, b) ->
            new ItemCover(a.getDomain(), a.getId(), b).tip(String.format("1 Stack every %dt(%ss) (as Cover)", CoverConveyor.speeds.get(b), (float)CoverConveyor.speeds.get(b) / 20))
    ).addTextures(new Texture(GTIRef.ID, "block/cover/conveyor")).setTiers(Tier.getStandardWithIV()).build(GTIRef.ID, "conveyor");
    public static final CoverFactory COVER_ITEM_REGULATOR = CoverFactory.builder(CoverItemRegulator::new).gui().item((a, b) ->
            new ItemCover(a.getDomain(), a.getId(), b).tip(String.format("1 Stack every %dt(%ss), with configurable stack size limits (as Cover)", CoverConveyor.speeds.get(b), (float)CoverConveyor.speeds.get(b) / 20))
    ).addTextures(new Texture(GTIRef.ID, "block/cover/conveyor")).setTiers(Tier.getStandardWithIV()).build(GTIRef.ID, "item_regulator");
    public static final CoverFactory COVER_ITEM_RETRIEVER = CoverFactory.builder(CoverItemRetriever::new).item((a, b) -> {
        return new ItemCoverCustomTooltip(GTIRef.ID, "item_retriever", (stack, world, tooltip, flag) -> {
            CompoundTag nbt = stack.getTag();
            if (nbt != null && nbt.contains("coverInventories")){
                CompoundTag coverInventories = nbt.getCompound("coverInventories");
                if (coverInventories.contains("display_settable")){
                    CompoundTag displayManager = coverInventories.getCompound("display_settable");
                    if (displayManager.contains("Items")){
                        ListTag items = displayManager.getList("Items", Tag.TAG_COMPOUND);
                        if (!items.isEmpty()){
                            ItemStack contained = ItemStack.of(items.getCompound(0));
                            if (!contained.isEmpty()){
                                tooltip.add(contained.getHoverName());
                            }
                        }
                    }
                }
            }
        }).tip("Can be placed as cover");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/item_retriever")).setIsValid(b -> b instanceof BlockEntityItemPipe<?>).gui().build(GTIRef.ID, "item_retriever");
    public static final CoverFactory COVER_PUMP = CoverFactory.builder(CoverPump::new).gui().item((a, b) ->
            new ItemCover(a.getDomain(), a.getId(), b).tip(String.format("%d L/t (as Cover)", CoverPump.speeds.get(b))))
            .addTextures(new Texture(GTIRef.ID, "block/cover/pump")).setTiers(Tier.getStandardWithIV()).build(GTIRef.ID, "pump");
    public static final CoverFactory COVER_FLUID_REGULATOR = CoverFactory.builder(CoverFluidRegulator::new).gui().item((a, b) ->
                    new ItemCover(a.getDomain(), a.getId(), b).tip(String.format("Configurable up to %d L/t (as Cover)", CoverPump.speeds.get(b))))
            .addTextures(new Texture(GTIRef.ID, "block/cover/pump")).setTiers(Tier.getStandardWithIV()).build(GTIRef.ID, "fluid_regulator");
    public static final CoverFactory COVER_ROBOT_ARM = CoverFactory.builder(CoverRobotArm::new).gui().item((a, b) ->
                    new ItemCover(a.getDomain(), a.getId(), b).tip(String.format("1 Stack every %dt(%ss) (as Cover)", CoverConveyor.speeds.get(b), (float)CoverConveyor.speeds.get(b) / 20)))
            .addTextures(new Texture(GTIRef.ID, "block/cover/conveyor")).setTiers(Tier.getStandardWithIV()).build(GTIRef.ID, "robot_arm");
    public static final CoverFactory COVER_DRAIN = CoverFactory.builder(CoverDrain::new).item((a, b) ->
            new ItemCover(GTIRef.ID, "drain").tip("Can be placed on machines/pipes as a cover")).addTextures(new Texture(GTIRef.ID, "block/cover/drain")).build(GTIRef.ID, "drain");
    public static final CoverFactory COVER_AIR_VENT = CoverFactory.builder(CoverAirVent::new).item((a, b) ->
            new ItemCover(GTIRef.ID, "air_vent").tip("Can be placed on machines/pipes as a cover")).addTextures(new Texture(GTIRef.ID, "block/cover/air_vent")).build(GTIRef.ID, "air_vent");
    public static final CoverFactory COVER_ITEM_FILTER = CoverFactory.builder(CoverItemFilter::new).item((a, b) ->
            new ItemCoverCustomTooltip(GTIRef.ID, "item_filter", (stack, world, tooltip, flag) -> {
                CompoundTag nbt = stack.getTag();
                if (nbt != null && nbt.contains("coverInventories")){
                    CompoundTag coverInventories = nbt.getCompound("coverInventories");
                    if (coverInventories.contains("display_settable")){
                        CompoundTag displayManager = coverInventories.getCompound("display_settable");
                        if (displayManager.contains("Items")){
                            ListTag items = displayManager.getList("Items", Tag.TAG_COMPOUND);
                            if (!items.isEmpty()){
                                ItemStack contained = ItemStack.of(items.getCompound(0));
                                if (!contained.isEmpty()){
                                    tooltip.add(contained.getHoverName());
                                }
                            }
                        }
                    }
                }
            }).tip("Can be placed as cover")).addTextures(new Texture(GTIRef.ID, "block/cover/item_filter"), new Texture(GTIRef.ID, "block/cover/item_filter_inverted")).gui().build(GTIRef.ID, "item_filter");
    public static final CoverFactory COVER_FLUID_FILTER = CoverFactory.builder(CoverFluidFilter::new).item((a, b) ->
            new ItemCoverCustomTooltip(GTIRef.ID, "fluid_filter", (stack, world, tooltip, flag) -> {
                CompoundTag nbt = stack.getTag();
                if (nbt != null && nbt.contains("coverInventories")){
                    CompoundTag coverInventories = nbt.getCompound("coverInventories");
                    if (coverInventories.contains("fluid_display_settable")){
                        CompoundTag displayManager = coverInventories.getCompound("fluid_display_settable");
                        if (displayManager.contains("Items")){
                            ListTag items = displayManager.getList("Items", Tag.TAG_COMPOUND);
                            if (!items.isEmpty()){
                                ItemStack contained = ItemStack.of(items.getCompound(0));
                                PlatformFluidItemHandler fluidItemHandler = FluidHooks.safeGetItemFluidManager(contained).orElse(null);
                                if (fluidItemHandler != null && !fluidItemHandler.getFluidInTank(0).isEmpty()){
                                    tooltip.add(FluidPlatformUtils.INSTANCE.getFluidDisplayName(fluidItemHandler.getFluidInTank(0)));
                                }
                            }
                        }
                    }
                }
            }).tip("Can be placed as cover")).addTextures(new Texture(GTIRef.ID, "block/cover/fluid_filter"),new Texture(GTIRef.ID, "block/cover/fluid_filter_inverted")).gui().build(GTIRef.ID, "fluid_filter");
    public static final CoverFactory COVER_REDSTONE_MACHINE_CONTROLLER = CoverFactory.builder(CoverRedstoneMachineController::new).item((a, b) -> {
        return new ItemCover(GTIRef.ID, "redstone_machine_controller");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/redstone_machine_controller")).build(GTIRef.ID, "redstone_machine_controller");
    public static final CoverFactory COVER_REDSTONE_CONDUCTOR_ACCEPT = CoverFactory.builder(CoverRedstoneConductorAccept::new).item((a, b) -> {
        return new ItemCover(GTIRef.ID, "redstone_conductor_accept");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/redstone_conductor_accept")).build(GTIRef.ID, "redstone_conductor_accept");
    public static final CoverFactory COVER_REDSTONE_CONDUCTOR_EMIT = CoverFactory.builder(CoverRedstoneConductorEmit::new).item((a, b) -> {
        return new ItemCover(GTIRef.ID, "redstone_conductor_emit");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/redstone_conductor_emit")).build(GTIRef.ID, "redstone_conductor_emit");
    public static final CoverFactory COVER_NEEDS_MAINTENANCE_COVER = CoverFactory.builder(CoverNeedsMaintenance::new).item((a, b) -> {
        return new ItemCover(GTIRef.ID, "needs_maintenance_cover");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/needs_maintenance_cover")).build(GTIRef.ID, "needs_maintenance_cover");
    public static final CoverFactory COVER_PROGRESS_SENSOR = CoverFactory.builder(CoverProgressSensor::new).item((a, b) -> {
        return new ItemCover(GTIRef.ID, "progress_sensor");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/progress_sensor")).build(GTIRef.ID, "progress_sensor");
    public static final CoverFactory COVER_ACTIVITY_DETECTOR_PROCESSING = CoverFactory.builder(CoverActivityDetectorProcessing::new).item((a,b) -> {
        return new ItemCover(GTIRef.ID, "activity_detector_processing");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/activity_detector_processing")).build(GTIRef.ID, "activity_detector_processing");
    public static final CoverFactory COVER_ACTIVITY_DETECTOR_SUCCESSFUL = CoverFactory.builder(CoverActivityDetectorSuccessful::new).item((a,b) -> {
        return new ItemCover(GTIRef.ID, "activity_detector_successful");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/activity_detector_successful")).build(GTIRef.ID, "activity_detector_successful");
    public static final CoverFactory COVER_ACTIVITY_DETECTOR_POSSIBLE = CoverFactory.builder(CoverActivityDetectorPossible::new).item((a,b) -> {
        return new ItemCover(GTIRef.ID, "activity_detector_possible");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/activity_detector_possible")).build(GTIRef.ID, "activity_detector_possible");
    public static final CoverFactory COVER_ENERGY_DETECTOR = CoverFactory.builder(CoverEnergyDetector::new).item((a, b) -> {
        return new ItemCover(GTIRef.ID, "energy_detector");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/energy_detector")).build(GTIRef.ID, "energy_detector");
    public static final CoverFactory COVER_FLUID_DETECTOR = CoverFactory.builder(CoverFluidDetector::new).item((a, b) -> {
        return new ItemCover(GTIRef.ID, "fluid_detector");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/fluid_detector")).build(GTIRef.ID, "fluid_detector");
    public static final CoverFactory COVER_ITEM_DETECTOR = CoverFactory.builder(CoverItemDetector::new).gui().item((a, b) -> {
        return new ItemCover(GTIRef.ID, "item_detector");
    }).addTextures(new Texture(GTIRef.ID, "block/cover/item_detector")).build(GTIRef.ID, "item_detector");
    public static final CoverFactory COVER_STEAM_VENT = CoverFactory.builder(CoverSteamVent::new)
            .addTextures(new Texture(GTIRef.ID, "block/cover/output")).build(GTIRef.ID, "steam_vent");
    public static final CoverFactory COVER_REACTOR_OUTPUT = CoverFactory.builder(CoverReactorOutput::new)
            .addTextures(new Texture(GTIRef.ID, "block/cover/reactor_output")).build(GTIRef.ID, "reactor_output");
    public static final CoverFactory COVER_REACTOR_OUTPUT_SECONDARY = CoverFactory.builder(CoverReactorOutputSecondary::new)
            .addTextures(new Texture(GTIRef.ID, "block/cover/reactor_output_secondary")).build(GTIRef.ID, "reactor_output_secondary");
    public static final CoverFactory COVER_OUTPUT_SECONDARY = CoverFactory.builder(CoverSecondaryOutput::new)
            .addTextures(new Texture(GTIRef.ID, "block/cover/output_secondary")).build(GTIRef.ID, "output_secondary");
    public static CoverFactory COVER_DYNAMO_COLORED = CoverFactory.builder(CoverDynamoColored::new).addTextures(new Texture(Ref.ID, "block/cover/dynamo")).build(GTIRef.ID, "dynamo");
    public static CoverFactory COVER_ENERGY_COLORED = CoverFactory.builder(CoverEnergyColored::new).addTextures(new Texture(Ref.ID, "block/cover/energy")).build(GTIRef.ID, "energy");
    public static CoverFactory COVER_SHUTTER = CoverFactory.builder(CoverShutter::new).item((a, b) ->
            new ItemCover(GTIRef.ID, "shutter").tip("can be placed as a pipe cover")).addTextures(new Texture(GTIRef.ID, "block/cover/shutter")).build(GTIRef.ID, "shutter");

    public static void init(){

    }
}
