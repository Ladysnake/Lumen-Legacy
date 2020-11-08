package ladysnake.lumen.common.entities;

import com.zeitheron.hammercore.api.lighting.ColoredLight;
import com.zeitheron.hammercore.api.lighting.impl.IGlowingEntity;
import ladysnake.lumen.common.config.LumenConfig;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

@Optional.Interface(iface = "com.zeitheron.hammercore.api.lighting.impl.IGlowingEntity", modid = "hammercore")
public class EntityRadFlame extends EntityWillOWisp implements IGlowingEntity {

    // Constructors
    public EntityRadFlame(World world) {
        super(world);
        this.setSize(0.5f, 0.5f);
    }

    public EntityRadFlame(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x, y, z);
    }

    // Properties
    @Override
    public boolean getCanSpawnHere() {
        return LumenConfig.spawnWillOWisps;
    }

    // Behaviour
    @Override
    public ColoredLight produceColoredLight(float partialTicks) {
        return ColoredLight.builder().pos(this).radius(10.0f).color(1.0f, 0.0f, 0.2f, 1.0f).build();

    }

}
