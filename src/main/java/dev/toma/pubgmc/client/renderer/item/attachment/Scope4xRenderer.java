package dev.toma.pubgmc.client.renderer.item.attachment;

import dev.toma.pubgmc.client.models.atachments.ModelScope4x;
import dev.toma.pubgmc.common.items.attachment.ItemScope;
import net.minecraft.client.renderer.GlStateManager;

public class Scope4xRenderer extends AttachmentRenderer<ItemScope> {

    private final ModelScope4x model = new ModelScope4x();

    @Override
    public void preRenderCallback() {
        GlStateManager.translate(0.5, 1.15, 0.45);
        GlStateManager.scale(0.08F, 0.08F, 0.08F);
    }

    @Override
    public ModelScope4x getModel() {
        return model;
    }
}
