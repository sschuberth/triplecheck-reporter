@echo off

set zipfile=triplecheck-recent.zip
set cabfile=triplecheck-recent.cab
set build=reporter
set publish=publish

:: Deleting the old files
echo Deleting the publish folder
mkdir ..\publish
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
del ..\%cabfile% 

::pause

cd ..\%publish%
:: create the zip file
..\%build%\tools\7z.exe a -r ..\%zipfile%
:: create the cabinet file
cabarc -r -p n ..\%cabfile% * 


echo opening explorer
explorer .

echo launching triplecheck
triplecheck.exe
