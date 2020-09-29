package dev.toma.pubgmc.games;

import dev.toma.pubgmc.games.args.ArgumentProvider;
import dev.toma.pubgmc.games.interfaces.IPlayerManager;
import dev.toma.pubgmc.games.util.Area;
import dev.toma.pubgmc.init.Games;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public final class DeathmatchGame extends Game {

    private final IPlayerManager.DefaultImpl playerManager;
    private boolean isRunning;
    private int ticksleft;

    public DeathmatchGame(World world) {
        super(Games.DEATHMATCH, world);
        this.playerManager = new IPlayerManager.DefaultImpl();
    }

    @Override
    public void onTick() {
        if(--ticksleft <= 0) {
            exec_GameStop();
        }
    }

    @Override
    public void onStop() {
        isRunning = false;
        BlockPos pos = getStorage().getLobby().getLocation();
        for(PlayerEntity player : playerManager.getPlayerList()) {
            player.setPositionAndUpdate(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
        }
    }

    @Override
    public void onStart() {
        isRunning = true;
        ticksleft = type.getArgumentValue(ArgumentProvider.DURATION_ARGUMENT);
        List<PlayerEntity> players = playerManager.getPlayerList();
        Area area = getStorage().getArena();
        for (PlayerEntity player : players) {
            BlockPos pos = area.getRandomPosition(world, true);
            player.setPositionAndUpdate(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
        }
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public IPlayerManager getPlayerManager() {
        return playerManager;
    }
}
