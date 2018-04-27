package ladysnake.lightorbs.common.init;

import ladysnake.lightorbs.client.renders.entities.RenderFirefly;
import ladysnake.lightorbs.common.Reference;
import ladysnake.lightorbs.common.entities.EntityFirefly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ModEntities {

    private static int id = 0;

    @SubscribeEvent
    public static void register(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> reg = event.getRegistry();
        reg.register(createEntry(EntityFirefly::new, "firefly", 64, true)
                .spawn(EnumCreatureType.AMBIENT, 50, 1, 5, BiomeDictionary.getBiomes(BiomeDictionary.Type.WET))
                .spawn(EnumCreatureType.AMBIENT, 50, 1, 5, BiomeDictionary.getBiomes(BiomeDictionary.Type.FOREST))
                .build());
    }

    private static EntityEntryBuilder<Entity> createEntry(Function<World, Entity> entityFactory,
                                                          String name, int trackingRange, boolean sendsVelocityUpdates) {
        return EntityEntryBuilder.create()
                .entity(entityFactory.apply(null).getClass())
                .factory(entityFactory)
                .id(new ResourceLocation(Reference.MOD_ID, name), id++)
                .name(name)
                .tracker(trackingRange, 1, sendsVelocityUpdates);
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFirefly.class, RenderFirefly::new);
    }

}
