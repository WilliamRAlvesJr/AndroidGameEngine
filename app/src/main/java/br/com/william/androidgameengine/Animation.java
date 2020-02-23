package org.graphics;

import org.resource.ImageResource;

public class Animation {

	// Frames of the animation
	public ImageResource[] frames;
	
	// Current frame of the animation
	private int currentFrame = 0;
	
	// FPS
	public int fps = 8;
	private long lastFrameTime = 0;
	
	// Should we loop ?
	public boolean loop = true;
	
	public void play() {
		long currentTime = System.nanoTime();
		
		if (currentTime > lastFrameTime + 1000000000 / fps) {
			currentFrame++;
			
			if (currentFrame >= frames.length) {
				if (loop) {
					currentFrame = 0;
				} else {
					currentFrame--;
				}
			}
			
			lastFrameTime = currentTime;
		}
	}
	
	public ImageResource getImage() {
		return frames[currentFrame];
	}
}
