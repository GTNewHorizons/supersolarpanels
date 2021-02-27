package com.Denfop.api.inv;

import ic2.api.recipe.RecipeOutput;

public interface IInvSlotProcessableMulti {

	public RecipeOutput process(int slotId);
	
	public void consume(int slotId);
	
	public boolean isEmpty(int slotId);
	
}
