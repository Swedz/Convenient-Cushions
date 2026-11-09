package net.swedz.convenient_cushions.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.decoration.BlockAttachedEntity;
import net.minecraft.world.entity.decoration.Cushion;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

/// Still uses vanilla behavior of checking every 5 seconds for performance reasons.
///
/// However, if it does that normal check and sees that the cushion cannot survive anymore, it will check every 0.5
/// seconds. Once it has been unable to survive for a full 2 seconds (4 checks, plus the first intermittent one), only
/// then will it pop.
@Mixin(BlockAttachedEntity.class)
public class ConsistentCushionPopMixin
{
	@Unique
	private int checkTicks;
	@Unique
	private int shortCheckTicks;
	
	@Unique
	private boolean shouldCheck(
			BlockAttachedEntity instance,
			Operation<Integer> original
	)
	{
		return checkTicks++ >= 5 * 20 &&
			   shortCheckTicks++ % 10 == 0;
	}
	
	@WrapOperation(
			method = "tick",
			at = @At(
					value = "FIELD",
					target = "Lnet/minecraft/world/entity/decoration/BlockAttachedEntity;ticksSinceLastCheck:I",
					opcode = Opcodes.GETFIELD
			)
	)
	private int shouldCheckMixin(
			BlockAttachedEntity instance,
			Operation<Integer> original
	)
	{
		if(instance instanceof Cushion)
		{
			return this.shouldCheck(instance, original) ? 100 : 0;
		}
		return original.call(instance);
	}
	
	@Unique
	private boolean survives(
			BlockAttachedEntity instance,
			Operation<Boolean> original
	)
	{
		boolean survives = original.call(instance);
		if(!survives)
		{
			if(shortCheckTicks >= 2 * 20)
			{
				checkTicks = 0;
				shortCheckTicks = 0;
				return false;
			}
		}
		else
		{
			checkTicks = 0;
			shortCheckTicks = 0;
		}
		return true;
	}
	
	@WrapOperation(
			method = "tick",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/decoration/BlockAttachedEntity;survives()Z"
			)
	)
	private boolean survivesMixin(
			BlockAttachedEntity instance,
			Operation<Boolean> original
	)
	{
		if(instance instanceof Cushion)
		{
			return this.survives(instance, original);
		}
		return original.call(instance);
	}
}
