package co.edu.eafit.beans;

import co.edu.eafit.data.MemoryCRUD;



public class Memory {
	MemoryCRUD crud = new MemoryCRUD();
	private float memory;

	public float getMemory() {
		//crud.getMemory();
		return memory;
	}

	public void setMemory(float memory) {
		this.memory = memory;
		crud.setMemory(memory);
	}
}
