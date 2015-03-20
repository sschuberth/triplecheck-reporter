# delete the publish folder
rm -rf ./publish
# create the folder to publish the files
mkdir ./publish

echo Creating the executable
java -jar ./docs/launch4j/launch4j.jar ./docs/launch4j-triplecheck-linux.xml

echo Copying the associated folders
cp -R ./run/plugins/ ./publish/
cp -R ./run/components/ ./publish/


mkdir ./publish/misc/
# Copying the icons
cp -R ./run/misc/icons/ ./publish/misc/
# Copying the java runtime to run on Windows
cp -R ../misc/java/ ./publish/misc/
# Copy the licenses and other related files
cp ./LICENSE.txt ./publish/
cp ./README.md ./publish/

# add the example report
mkdir ./publish/reports
echo This folder contains the generated reports > ./publish/reports/readme.txt
echo Copying the example report
cp ./run/reports/example.spdx ./publish/reports/

echo Create the zipped file
cd ./publish
zip -9 -r ../triplecheck.zip *


