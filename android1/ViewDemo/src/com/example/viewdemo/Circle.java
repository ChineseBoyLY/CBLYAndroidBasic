package com.example.viewdemo;

public class Circle {
	int a;
	float x;
	float y;
	float radius;

	public Circle(int a, float x, float y, float radius) {
		super();
		this.a = a;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public Circle() {
	}

	public int changeA() {
		if (this.a <= 0) {
			this.a = 0;
		} else {
			this.a -= 5;
		}
		return this.a;
	}

	public float changeR() {
		this.radius += 3;
		return this.radius;
	}
}
