@echo off

set zipfile=triplecheck-0.0.zip

echo building the new executable
"c:\Program Files (x86)\Launch4j\launch4jc.exe" .\docs\launch4j-triplecheck.xml


echo deleting old plugin folder
cd ..\publish
for /f "tokens=* delims=" %%i in ('dir plugins /s/b') do (
  rd /s /q "%%i"
)


echo copying the new plugin files
cd ..\reporter
xcopy /s/y run\plugins ..\publish\plugins


echo Creating a new zip file
del ..\%zipfile% 

::pause

cd ..\publish
..\reporter\tools\7z.exe a -r ..\%zipfile% 


echo deleting the test folder
cd..
rd /s /q test


echo extracting files for testing there
mkdir test
cd test
..\reporter\tools\7z.exe x ..\%zipfile%


echo opening explorer
explorer .

echo launching triplecheck
triplecheck.exe
