@echo off
if not exist out mkdir out
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt
del sources.txt
jar cfm lab2.jar manifest.mf -C out .
echo Сборка завершена: lab2.jar
