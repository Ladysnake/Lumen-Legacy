package ladysnake.lumen.common.entities;

import com.zeitheron.hammercore.api.lighting.ColoredLight;
import com.zeitheron.hammercore.api.lighting.impl.IGlowingEntity;
import ladysnake.lumen.common.config.LumenConfig;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface = "com.zeitheron.hammercore.api.lighting.impl.IGlowingEntity", modid = "hammercore")
public class EntityFaerie extends EntityWillOWisp implements IGlowingEntity {

    // Constructors
    public EntityFaerie(World world) {
        super(world);
        this.setSize(0.5f, 0.5f);
    }

    public EntityFaerie(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
    }

    // Properties
    @Override
    public boolean getCanSpawnHere() {
        return LumenConfig.spawnFaeries;
    }

    // Behaviour
    @Override
    public ColoredLight produceColoredLight(float partialTicks) {
        return ColoredLight.builder().pos(this).radius(6.0f).color(0.9f, 0.3f, 0.7f, 1.0f).build();

    }
}
