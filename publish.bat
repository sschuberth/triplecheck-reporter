@echo off
echo deleting old plugin folder
for /f "tokens=* delims=" %%i in ('dir ..\publish\plugins /s/b') do (
  rd /s /q "%%i"
)



echo copying the new plugin files
xcopy /s/y run\plugins ..\publish\plugins


echo Creating a new zip file
cd ..\publish
..\reporter\tools\7z.exe a -r ..\test.zip 


echo deleting the test folder
cd..
rd /s /q test

echo extracting files for testing there
mkdir test
..\reporter\tools\7z.exe x 


pause