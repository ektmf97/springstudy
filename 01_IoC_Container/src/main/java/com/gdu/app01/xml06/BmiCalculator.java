package com.gdu.app01.xml06;

public class BmiCalculator {
	
	// field
	private double height;  // ���� m
	private double weight;	// ���� kg
	private double bmi;		// ������ / (Ű(m) * Ű(m))
	private String health;  // < 20(��ü��), < 25(����), >=25(��)
	private Calculator calc;
	
	// constructor
	public BmiCalculator(double heigth, double weight, Calculator calc) {
		this.height = heigth;
		this.weight = weight;
		this.calc = calc;
		bmi = calc.div(weight, calc.mul(height, height));
		health = (bmi < 20) ? "��ü��" : (bmi < 25) ? "����" : "��";
		
	}
	
	// method
	public void bmiInfo() {
		System.out.println("Ű: " + height + "m");
		System.out.println("������: " + weight + "kg");
		System.out.println("BMI: " + bmi);
		System.out.println("�ǰ�����: " + health);
	}
}
