package net.swedz.convenient_cushions.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.Direction;
import net.minecraft.world.item.CushionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

/// Allows cushions to be placed on any Y level rounded to the nearest pixel (1/16th).
@Mixin(CushionItem.class)
public class PlaceCushionsAnywhereMixin
{
	@Definition(id = "clickedFace", local = @Local(type = Direction.class, name = "clickedFace"))
	@Definition(id = "UP", field = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;")
	@Expression("clickedFace != UP")
	@ModifyExpressionValue(
			method = "useOn",
			at = @At("MIXINEXTRAS:EXPRESSION")
	)
	private boolean allowAnyClickedFace(boolean original)
	{
		return false;
	}
	
	@ModifyArg(
			method = "useOn",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/phys/Vec3;atCenterOfWithY(Lnet/minecraft/core/Vec3i;D)Lnet/minecraft/world/phys/Vec3;"
			),
			index = 1
	)
	private double useRoundedYValue(double y)
	{
		return Math.floor(y * 16D) / 16D;
	}
}
