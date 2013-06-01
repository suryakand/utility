package com.thoughtworks.robot.demo;

public enum InteractiveOptions {
	NR("New Rebot"),
	SR("Select Robot"),
	MR("Move Robot"),
	RR("Reset Robot"),
	HELP("HELP"),
	Q("Exit application");

	private String optionDescription;

	InteractiveOptions(String optionDescription) {
		this.optionDescription = optionDescription;
	}

	public String getOptionDescription() {
		return optionDescription;
	}

	public void setOptionDescription(String optionDescription) {
		this.optionDescription = optionDescription;
	}
}