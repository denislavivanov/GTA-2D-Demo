compile:
	javac -cp .:MapGeneration:Graphics:Graphics/LWJGL-linux/* Main.java

run:
	java -cp .:MapGeneration:Graphics:Graphics/LWJGL-linux/* Main

clean:
	rm *.class MapGeneration/*.class Graphics/*.class
