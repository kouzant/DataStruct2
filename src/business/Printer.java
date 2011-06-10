package business;

public class Printer {
	public static String printMain(){
		StringBuilder mainBuild=new StringBuilder();
		mainBuild.append("Please make your choice:");
		mainBuild.append("\n");
		mainBuild.append("1 -- Add a flight");
		mainBuild.append("\n");
		mainBuild.append("2 -- List flights");
		mainBuild.append("\n");
		mainBuild.append("0 -- Exit");
		mainBuild.append("\n");
		
		return mainBuild.toString();
	}
	public static String printAddCode(){
		StringBuilder addBuildC=new StringBuilder();
		addBuildC.append("Enter the flight code:");
		addBuildC.append("\n");
		
		return addBuildC.toString();
	}
	public static String printaddDep(){
		StringBuilder addBuildD=new StringBuilder();
		addBuildD.append("Enter departure time: (YYYY:MM:DD:HH:MM)");
		addBuildD.append("\n");
		
		return addBuildD.toString();
	}
	public static String printaddArr(){
		StringBuilder addBuildA=new StringBuilder();
		addBuildA.append("Enter arrival time: (YYYY:MM:DD:HH:MM)");
		addBuildA.append("\n");
		
		return addBuildA.toString();
	}
}