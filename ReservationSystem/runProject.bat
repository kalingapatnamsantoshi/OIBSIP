
@echo off
cd src
javac -cp "../lib/*" *.java
java -cp ".;../lib/*" LoginForm
pause

