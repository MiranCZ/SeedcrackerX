package kaptainwutax.seedcrackerx;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;

public class ChunkPosUtil {

    public static BlockPos getStartPos(ChunkPos pos) {
        return new BlockPos(getStartX(pos), 0, getStartZ(pos));
    }

    public static int getStartX(ChunkPos pos) {
        return pos.x << 4;
    }

    public static int getStartZ(ChunkPos pos) {
        return pos.z << 4;
    }

}
