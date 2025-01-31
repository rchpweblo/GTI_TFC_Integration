package muramasa.gregtech.loader.machines;

import muramasa.antimatter.data.AntimatterMaterialTypes;
import muramasa.antimatter.data.AntimatterMaterials;
import muramasa.antimatter.material.Material;
import muramasa.antimatter.material.MaterialTags;
import muramasa.antimatter.recipe.ingredient.RecipeIngredient;
import muramasa.gregtech.data.GregTechMaterialTags;
import net.minecraft.world.item.ItemStack;

import static muramasa.gregtech.data.RecipeMaps.THERMAL_CENTRIFUGE;

public class ThermalCentrifugeLoader {
    public static void init() {
        AntimatterMaterialTypes.CRUSHED_PURIFIED.all().forEach(m -> {
            Material aOreByProduct1 = m.getByProducts().size() >= 1 ? m.getByProducts().get(0) : MaterialTags.MACERATE_INTO.getMapping(m);
            Material aOreByProduct2 = m.has(GregTechMaterialTags.THERMAL_CENTRIFUGE_EXPLICIT) ? GregTechMaterialTags.THERMAL_CENTRIFUGE_EXPLICIT.getMapping(m) : m.getByProducts().size() >= 2 ? m.getByProducts().get(1) : aOreByProduct1;
            ItemStack stoneDust = AntimatterMaterialTypes.DUST.get(AntimatterMaterials.Stone, 1);

            THERMAL_CENTRIFUGE.RB().ii(RecipeIngredient.of(AntimatterMaterialTypes.CRUSHED_PURIFIED.get(m),1)).io(AntimatterMaterialTypes.CRUSHED_REFINED.get(m, 1), AntimatterMaterialTypes.DUST_TINY.get(aOreByProduct2, 1)).add("purified_" + m.getId(),500, 48,0,2);
            THERMAL_CENTRIFUGE.RB().ii(RecipeIngredient.of(AntimatterMaterialTypes.CRUSHED.get(m),1)).io(AntimatterMaterialTypes.CRUSHED_REFINED.get(m, 1), AntimatterMaterialTypes.DUST_TINY.get(aOreByProduct2, 1), stoneDust).add("crushed_" + m.getId(),500, 48,0,2);
        });
    }
}
