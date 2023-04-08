package muramasa.gregtech.gui.widgets;

import com.mojang.blaze3d.vertex.PoseStack;
import muramasa.antimatter.gui.GuiInstance;
import muramasa.antimatter.gui.ICanSyncData;
import muramasa.antimatter.gui.IGuiElement;
import muramasa.antimatter.gui.Widget;
import muramasa.antimatter.gui.widget.WidgetSupplier;
import muramasa.antimatter.integration.jeirei.AntimatterJEIREIPlugin;
import muramasa.antimatter.machine.MachineFlag;
import muramasa.gregtech.Ref;
import muramasa.gregtech.tile.multi.TileEntityFusionReactor;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FusionButtonWidget extends Widget {
    ResourceLocation middle = new ResourceLocation(Ref.ID, "textures/gui/machine/fusion_computer_middle_overlay.png");
    ResourceLocation top_bottom = new ResourceLocation(Ref.ID, "textures/gui/machine/fusion_computer_top_bottom_overlay.png");

    TileEntityFusionReactor.Display display = TileEntityFusionReactor.Display.REGULAR;
    Widget jei;

    protected FusionButtonWidget(@Nonnull GuiInstance gui, @Nullable IGuiElement parent) {
        super(gui, parent);
        setW(176);
        setH(182);
        jei = new BlankWidget(gui, this);
    }

    @Override
    public void init() {
        gui.syncInt(() -> getTile().getDisplay().ordinal(), i -> this.display = TileEntityFusionReactor.Display.values()[i], ICanSyncData.SyncDirection.SERVER_TO_CLIENT);
    }

    private TileEntityFusionReactor getTile() {
        return (TileEntityFusionReactor) gui.handler;
    }

    @Override
    public void onClick(double mouseX, double mouseY, int button) {
        super.onClick(mouseX, mouseY, button);
        jei.onClick(mouseX, mouseY, button);
    }

    @Override
    public void mouseOver(PoseStack stack, double mouseX, double mouseY, float partialTicks) {
        super.mouseOver(stack, mouseX, mouseY, partialTicks);
        jei.mouseOver(stack, mouseX, mouseY, partialTicks);
    }

    public static WidgetSupplier build() {
        return builder(FusionButtonWidget::new);
    }

    @Override
    public void render(PoseStack matrixStack, double mouseX, double mouseY, float partialTicks) {
        TileEntityFusionReactor tile = getTile();
        if (display == TileEntityFusionReactor.Display.REGULAR){
            drawTexture(matrixStack, gui.handler.getGuiTexture(), realX() + 154, realY() + 22, 176, 0, 18, 18);
        } else if (display == TileEntityFusionReactor.Display.MIDDLE){
            drawTexture(matrixStack, gui.handler.getGuiTexture(), realX() + 154, realY() + 40, 176, 18, 18, 18);
            drawTexture(matrixStack, middle, realX() + 6, realY() + 6, 0, 0, 145, 145);
        } else {
            drawTexture(matrixStack, gui.handler.getGuiTexture(), realX() + 154, realY() + 58, 176, 36, 18, 18);
            drawTexture(matrixStack, top_bottom, realX() + 6, realY() + 6, 0, 0, 145, 145);
        }
    }

    private class BlankWidget extends Widget {

        protected BlankWidget(@NotNull GuiInstance gui, @org.jetbrains.annotations.Nullable IGuiElement parent) {
            super(gui, parent);
            setX(154);
            setY(4);
            setW(18);
            setH(18);
        }

        @Override
        public void onClick(double mouseX, double mouseY, int button) {
            super.onClick(mouseX, mouseY, button);
            AntimatterJEIREIPlugin.showCategory(getTile().getMachineType());
        }

        @Override
        public void mouseOver(PoseStack stack, double mouseX, double mouseY, float partialTicks) {
            super.mouseOver(stack, mouseX, mouseY, partialTicks);
            if (isInside(mouseX, mouseY)) {
                renderTooltip(stack, new TranslatableComponent("antimatter.gui.show_recipes"), mouseX, mouseY);
            }
        }

        @Override
        public void render(PoseStack matrixStack, double mouseX, double mouseY, float partialTicks) {

        }
    }
}