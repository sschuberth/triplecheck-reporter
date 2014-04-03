@echo off

set zipfile=triplecheck-0.5.zip
set build=reporter
set publish=publish

:: Deleting the old files
echo Deleting the publish folder
cd ..\publish
for /f "tokens=* delims=" %%i in ('dir /s/b') do (
  rd /s /q "%%i" > null
)
del /s /q *.*

echo Building the new executable
cd ..\%build%
"c:\Program Files (x86)\Launch4j\launch4jc.exe" .\docs\launch4j-triplecheck.xml


echo copying the needed folders
cd ..\%build%
xcopy /s/y run\plugins ..\%publish%\plugins\
xcopy /s/y run\icons ..\%publish%\icons\
xcopy /s/y run\extensions ..\%publish%\extensions\
xcopy /s/y run\triggers ..\%publish%\triggers\
xcopy /s/y run\java ..\%publish%\java\

:: creating the reports folder
cd ..\%publish%
mkdir reports
echo This folder contains the generated reports > .\reports\readme.txt

::pause

echo Creating a new zip file
del ..\%zipfile% 

::pause

cd ..\%publish%
..\%build%\tools\7z.exe a -r ..\%zipfile% 



echo opening explorer
explorer .

echo launching triplecheck
triplecheck.exe
