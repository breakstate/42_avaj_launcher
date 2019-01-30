find *.java > sources.txt
javac -sourcepath . @sources.txt
java Simulator scenario.txt
