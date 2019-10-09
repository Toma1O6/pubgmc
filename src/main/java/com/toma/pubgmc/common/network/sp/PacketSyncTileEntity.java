package com.toma.pubgmc.common.network.sp;

import com.toma.pubgmc.util.helper.PacketHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSyncTileEntity implements IMessage {

    private NBTTagCompound nbt;
    private BlockPos pos;

    public PacketSyncTileEntity() {
    }

    public PacketSyncTileEntity(NBTTagCompound nbt, BlockPos pos) {
        this.nbt = nbt;
        this.pos = pos;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, nbt);
        PacketHelper.writeBlockPos(pos, buf);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        nbt = ByteBufUtils.readTag(buf);
        pos = PacketHelper.readBlockPos(buf);
    }

    public static class Handler implements IMessageHandler<PacketSyncTileEntity, IMessage> {

        @Override
        public IMessage onMessage(PacketSyncTileEntity message, MessageContext ctx) {
            if (ctx.side.isClient()) {
                Minecraft.getMinecraft().addScheduledTask(() -> {
                    TileEntity te = Minecraft.getMinecraft().player.world.getTileEntity(message.pos);
                    if (te != null) {
                        te.readFromNBT(message.nbt);
                    }
                });
            }
            return null;
        }
    }
}
