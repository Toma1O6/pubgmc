package dev.toma.pubgmc.network.server;

import dev.toma.pubgmc.common.entity.EntityPlane;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketChooseLocation implements IMessage {
    int id;
    private BlockPos pos;

    public PacketChooseLocation() {
    }

    public PacketChooseLocation(BlockPos loc, int planeID) {
        pos = loc;
        id = planeID;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(pos.getX());
        buf.writeDouble(pos.getY());
        buf.writeDouble(pos.getZ());
        buf.writeInt(id);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = new BlockPos(buf.readDouble(), buf.readDouble(), buf.readDouble());
        id = buf.readInt();
    }

    public static class Handler implements IMessageHandler<PacketChooseLocation, IMessage> {
        @Override
        public IMessage onMessage(PacketChooseLocation message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().player;
            player.getServer().addScheduledTask(() -> {
                if (player.world.getEntityByID(message.id) instanceof EntityPlane) {
                    EntityPlane plane = (EntityPlane) player.world.getEntityByID(message.id);
                    plane.dropLoc.put(player, message.pos);
                }
            });
            return null;
        }
    }
}
