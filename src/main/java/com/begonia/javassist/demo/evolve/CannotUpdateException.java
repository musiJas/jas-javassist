package com.begonia.javassist.demo.evolve;

/**
 * Signals that VersionManager.update() fails.
 */
public class CannotUpdateException extends Exception {
    public CannotUpdateException(String msg) {
	super(msg);
    }

    public CannotUpdateException(Exception e) {
	super("by " + e.toString());
    }
}
