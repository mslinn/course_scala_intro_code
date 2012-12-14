package com.micronautics.scalaJava;

public class JavaClass implements MyInterface {
	public static final int CLASS_CONSTANT = 42;
	public final double instanceConstant = 43.0;
	private double doubleValue = 0.0;
	private int intValue = 0;
 
	public JavaClass() {
		this.doubleValue = instanceConstant;
		this.intValue = CLASS_CONSTANT;
	}
	
	public JavaClass(double doubleValue, int intValue) {
		this.doubleValue = doubleValue;
		this.intValue = intValue;
	}
	
	@Override public int getInt() { return intValue; }

	@Override public double getDouble() { return doubleValue; }

	@Override public void setDouble(double value) { doubleValue = value; }

	@Override public void setInt(int value) { intValue = value; }

	public static double compute(double factor) {
		JavaClass jc = new JavaClass();
		return (jc.getInt() + jc.getDouble()) * factor;
	}
}
